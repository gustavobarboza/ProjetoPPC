/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Professor;
import entity.ProfessorComprovantes;
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
public class ProfessorComprovantesDao {
     private  Connection conexaoDb;
     public boolean Cria(Integer idProfessor, ProfessorComprovantes professor){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO PROFESSOR_COMPROVANTES(fk_id_professor, comprovante, data, local)"
                + " VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, idProfessor);
            stmt.setString(2, professor.getComprovante());
            stmt.setString(3, professor.getData());
            stmt.setString(4, professor.getLocal());
            
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
     
    public List<ProfessorComprovantes> getLista(Integer id){
        conexaoDb = new ConexaoDb().getConexao();
        List<ProfessorComprovantes> listaProfessores = new ArrayList<>();
            String sql ="SELECT comprovante, data, local FROM PROFESSOR_COMPROVANTES "
                    + "WHERE fk_id_professor=?";
           
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            ProfessorComprovantes professor = new ProfessorComprovantes();
            
            professor.setComprovante(rs.getString("comprovante"));
            professor.setData(rs.getString("data"));
            professor.setLocal(rs.getString("local"));
            
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
        String sql = "DELETE FROM PROFESSOR_COMPROVANTES WHERE fk_id_professor=?";
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
