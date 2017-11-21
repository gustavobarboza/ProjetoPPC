
package dao;

import entity.AtaReuniao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AtaReuniaoDao {
    private Connection conexaoDb;
    
    public boolean Insere(AtaReuniao ataReuniao){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO ATA_REUNIAO(data, local, deliberacoes, identificador) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, ataReuniao.getData());
            stmt.setString(2, ataReuniao.getLocal());
            stmt.setString(3, ataReuniao.getDeliberacoes());
            stmt.setString(4, ataReuniao.getIdentificador());
          
            stmt.execute();
            stmt.close();
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
    
    public boolean Altera(Integer idAta, AtaReuniao ataReuniao){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "UPDATE ATA_REUNIAO SET data=?, local=?, deliberacoes=?, identificador=? WHERE id_ata_reuniao=? ";
        
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, ataReuniao.getData());
            stmt.setString(2, ataReuniao.getLocal());
            stmt.setString(3, ataReuniao.getDeliberacoes());
            stmt.setString(4, ataReuniao.getIdentificador());
            stmt.setInt(5,idAta);
                        
            stmt.executeUpdate();
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
    
    public boolean Remove(Integer idAta){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "DELETE FROM ATA_REUNIAO WHERE id_ata_reuniao=?";
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
    
    public List<AtaReuniao> getAtas(){
        conexaoDb = new ConexaoDb().getConexao();
        List<AtaReuniao> listaAtas = new ArrayList<>();
            String sql ="SELECT * FROM ATA_REUNIAO";
            
            PreparedStatement stmt;
        try {
            stmt = conexaoDb.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            AtaReuniao ataReuniao = new AtaReuniao();
            
            ataReuniao.setData(rs.getString("data"));
            ataReuniao.setLocal(rs.getString("local"));
            ataReuniao.setDeliberacoes(rs.getString("deliberacoes"));
            ataReuniao.setIdentificador(rs.getString("identificador"));
            
            listaAtas.add(ataReuniao);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(AtaReuniaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return listaAtas;
    }
    
    public AtaReuniao getAta(Integer idAtaReuniao){
        conexaoDb = new ConexaoDb().getConexao();
        AtaReuniao ataReuniao = new AtaReuniao();
    
        String sql= "SELECT * FROM ATA_REUNIAO WHERE id_ata_reuniao=?";

        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, idAtaReuniao);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
            ataReuniao.setData(rs.getString("data"));
            ataReuniao.setLocal(rs.getString("local"));
            ataReuniao.setDeliberacoes(rs.getString("deliberacoes"));
            ataReuniao.setIdentificador(rs.getString("identificador"));
            }


            rs.close();

            return ataReuniao;

        } catch (SQLException ex) {
            Logger.getLogger(AtaReuniaoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(AtaReuniaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
    public Integer getIdAta(String identificador){
        conexaoDb = new ConexaoDb().getConexao();
        
        String sql="SELECT id_ata_reuniao FROM ATA_REUNIAO WHERE identificador=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, identificador);

           ResultSet rs = stmt.executeQuery();
           int id = rs.getInt("id_ata_reuniao");
            return id;
            

        } catch (SQLException ex) {
            Logger.getLogger(AtaReuniaoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(AtaReuniaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
}
