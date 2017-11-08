/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.CronogramaAtividades;
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
public class CronogramaAtividadesDao {
     private  Connection conexaoDb;
     public boolean Cria(Integer idCronograma, CronogramaAtividades cronogramaAtividades){
        conexaoDb = new ConexaoDb().getConexao();
            String sql="INSERT INTO CRONOGRAMA_ATIVIDADES(fk_id_cronograma, aula, conteudo)"
                + " VALUES(?,?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, idCronograma);
            stmt.setString(2, cronogramaAtividades.getAula());
            stmt.setString(3, cronogramaAtividades.getConteudo());
            
            stmt.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(CronogramaAtividadesDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(CronogramaAtividadesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
    public List<CronogramaAtividades> getLista(Integer id){
        conexaoDb = new ConexaoDb().getConexao();
        List<CronogramaAtividades> listaCronogramaAtividades = new ArrayList<>();
            String sql ="SELECT * FROM CRONOGRAMA_ATIVIDADES WHERE fk_id_cronograma=?";
           
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            CronogramaAtividades cronogramaAtividades = new CronogramaAtividades();
            
            cronogramaAtividades.setAula(rs.getString("aula"));
            cronogramaAtividades.setConteudo(rs.getString("conteudo"));
            
            listaCronogramaAtividades.add(cronogramaAtividades);
            
            }
            return listaCronogramaAtividades;
        
        } catch (SQLException ex) {
            Logger.getLogger(CronogramaAtividadesDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }     
    public boolean Remove(Integer id){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "DELETE FROM CRONOGRAMA_ATIVIDADES WHERE fk_id_cronograma=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CronogramaAtividadesDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(CronogramaAtividadesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
}
