/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.AtaParticipantes;
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
public class AtaParticipantesDao {
    private Connection conexaoDb;
    
    public boolean Cria(Integer idAta, AtaParticipantes ataParticipantes){
        conexaoDb = new ConexaoDb().getConexao();
            String sql="INSERT INTO ATA_PARTICIPANTES(fk_id_ata_reuniao, participante)"
                + " VALUES(?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, idAta);
            stmt.setString(2, ataParticipantes.getParticipante());
            
            stmt.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(AtaParticipantesDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(CronogramaAtividadesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
    public List<AtaParticipantes> getLista(Integer idAta){
        conexaoDb = new ConexaoDb().getConexao();
        List<AtaParticipantes> listaAtaParticipantes = new ArrayList<>();
            String sql ="SELECT * FROM ATA_PARTICIPANTES WHERE fk_id_ata_reuniao=?";
           
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, idAta);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            AtaParticipantes ataParticipantes = new AtaParticipantes();
            
            ataParticipantes.setParticipante(rs.getString("participante"));
            
            listaAtaParticipantes.add(ataParticipantes);
            
            }
            return listaAtaParticipantes;
        
        } catch (SQLException ex) {
            Logger.getLogger(AtaReuniaoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }     
    
    public boolean Remove(Integer idAta){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "DELETE FROM ATA_PARTICIPANTES WHERE fk_id_ata_reuniao=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, idAta);
            
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AtaReuniaoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(AtaReuniaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}
