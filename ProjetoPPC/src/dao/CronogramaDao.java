/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cronograma;
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
public class CronogramaDao {
    private Connection conexaoDb;
    
    public boolean Insere(Cronograma cronograma){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO CRONOGRAMA(identificador) VALUES(?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, cronograma.getIdentificador());
          
            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(CronogramaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(CronogramaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public boolean Altera(Integer idCronograma, Cronograma cronograma){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "UPDATE CRONOGRAMA SET identificador=? WHERE id_cronograma=? ";
        
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, cronograma.getIdentificador());
            stmt.setInt(2, idCronograma);
                        
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(CronogramaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(CronogramaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public boolean Remove(Integer idCronograma){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "DELETE FROM CRONOGRAMA WHERE id_cronograma=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, idCronograma);
            
            stmt.execute();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CronogramaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(CronogramaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public List<Cronograma> getCronogramas(){
        conexaoDb = new ConexaoDb().getConexao();
        List<Cronograma> listaCronogramas = new ArrayList<>();
            String sql ="SELECT * FROM CRONOGRAMA";
            
            PreparedStatement stmt;
        try {
            stmt = conexaoDb.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            Cronograma cronograma = new Cronograma();
            
            cronograma.setIdentificador(rs.getString("identificador"));
            
            listaCronogramas.add(cronograma);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(CronogramaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return listaCronogramas;
    }
    public Cronograma getCronograma(Integer idCronograma){
        conexaoDb = new ConexaoDb().getConexao();
        Cronograma  cronograma = new Cronograma();
    
        String sql= "SELECT * FROM CRONOGRAMA WHERE id_cronograma=?";

        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, idCronograma);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
            cronograma.setIdentificador(rs.getString("identificador"));
            }


            rs.close();

            return cronograma;

        } catch (SQLException ex) {
            Logger.getLogger(CronogramaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(CronogramaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public Integer getIdCronograma(String cronograma){
        conexaoDb = new ConexaoDb().getConexao();
        
        String sql="SELECT id_cronograma FROM CRONOGRAMA WHERE identificador=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, cronograma);

           ResultSet rs = stmt.executeQuery();
           int id = rs.getInt("id_cronograma");
            return id;
            

        } catch (SQLException ex) {
            Logger.getLogger(CronogramaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(CronogramaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
}
