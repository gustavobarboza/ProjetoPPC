/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.ProfessorDisciplinasOutrosCursos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class ProfessorDisciplinasOutrosCursosDao {
         private  Connection conexaoDb;
         public boolean Cria(Integer idProfessor, ProfessorDisciplinasOutrosCursos professor){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO PROFESSOR_DISCIPLINAS_OUTROS_CURSOS(fk_id_professor, disciplina, carga_horaria) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, idProfessor);
            stmt.setString(2, professor.getDisciplina());
            stmt.setInt(3, professor.getCargaHoraria());

            stmt.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
         public List<ProfessorDisciplinasOutrosCursos> getLista(Integer id){
        conexaoDb = new ConexaoDb().getConexao();
        List<ProfessorDisciplinasOutrosCursos> listaProfessores = new ArrayList<>();
            String sql ="SELECT disciplina, carga_horaria FROM PROFESSOR_DISCIPLINAS_OUTROS_CURSOS "
                    + "WHERE fk_id_professor=?";
           
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            ProfessorDisciplinasOutrosCursos professor = new ProfessorDisciplinasOutrosCursos();
            
            professor.setDisciplina(rs.getString("disciplina"));
            professor.setCargaHoraria(rs.getInt("carga_horaria"));
            
            listaProfessores.add(professor);
            
            }
            return listaProfessores;
        
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public boolean Remove(Integer id){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "DELETE FROM PROFESSOR_DISCIPLINAS_OUTROS_CURSOS WHERE fk_id_professor=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }     
}
