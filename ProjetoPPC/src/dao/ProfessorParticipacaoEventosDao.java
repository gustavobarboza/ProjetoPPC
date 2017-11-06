/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.ProfessorParticipacaoEventos;
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
public class ProfessorParticipacaoEventosDao {
         private  Connection conexaoDb;
     public boolean Cria(Integer idProfessor, ProfessorParticipacaoEventos professor){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO PROFESSOR_PARTICIPACAO_EVENTOS(fk_id_professor, comprovantes) VALUES(?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, idProfessor);
            stmt.setString(2, professor.getComprovantes());

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
     
    public List<ProfessorParticipacaoEventos> getLista(Integer id){
        conexaoDb = new ConexaoDb().getConexao();
        List<ProfessorParticipacaoEventos> listaProfessores = new ArrayList<>();
            String sql ="SELECT comprovantes FROM PROFESSOR_PARTICIPACAO_EVENTOS "
                    + "WHERE fk_id_professor=?";
           
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            ProfessorParticipacaoEventos professor = new ProfessorParticipacaoEventos();
            
            professor.setComprovantes(rs.getString("comprovantes"));

            
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
        String sql = "DELETE FROM PROFESSOR_PARTICIPACAO_EVENTOS WHERE fk_id_professor=?";
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
