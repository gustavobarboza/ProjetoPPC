/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Professor;
import entity.SimulacaoAvaliacaoMec;
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
public class SimulacaoMecDao {
    public Connection conexaoDb;
    
    public boolean Cria(Integer idCurso, SimulacaoAvaliacaoMec simulacaoAvaliacaoMec){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO SIMULACAO_AVALIACAO_MEC(fk_id_curso, nota_final, identificador_simulacao, "
                + "sugestao_melhoria_dimensao1, sugestao_melhoria_dimensao2) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, idCurso);
            stmt.setInt(2, 0);
            stmt.setString(3, simulacaoAvaliacaoMec.getIdentificadorSimulacao());
            stmt.setString(4, "");
            stmt.setString(5, "");

            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoMecDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(SimulacaoMecDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean Altera(Integer idSimulacao, Integer idCurso, SimulacaoAvaliacaoMec simulacaoAvaliacaoMec){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "UPDATE SIMULACAO_AVALIACAO_MEC SET fk_id_curso=?, identificador_simulacao=? WHERE id_simulacao_avaliacao_mec=? ";
        
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, idCurso);
            stmt.setString(2, simulacaoAvaliacaoMec.getIdentificadorSimulacao());
            stmt.setInt(3, idSimulacao);
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoMecDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(SimulacaoMecDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public boolean Remove(Integer idSimulacao){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "DELETE FROM SIMULACAO_AVALIACAO_MEC WHERE id_simulacao_avaliacao_mec=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, idSimulacao);
            
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoMecDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(SimulacaoMecDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean InsereDadosSimulacao(Integer idSimulacao, SimulacaoAvaliacaoMec simulacaoAvaliacaoMec){
         conexaoDb = new ConexaoDb().getConexao();
        String sql="UPDATE SIMULACAO_AVALIACAO_MEC SET nota_final=?, sugestao_melhoria_dimensao1=?, "
                + " sugestao_melhoria_dimensao2=? WHERE id_simulacao_avaliacao_mec=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, simulacaoAvaliacaoMec.getNotaFinal());
            stmt.setString(2, simulacaoAvaliacaoMec.getSugestaoMelhoriaDimensao1());
            stmt.setString(3, simulacaoAvaliacaoMec.getSugestaoMelhoriaDimensao2());

            stmt.setInt(4, idSimulacao);

            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoMecDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(SimulacaoMecDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     }
    
    public Integer getIdSimulacao(String identificador){
        conexaoDb = new ConexaoDb().getConexao();
        
        String sql="SELECT id_simulacao_avaliacao_mec FROM SIMULACAO_AVALIACAO_MEC WHERE identificador_simulacao=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, identificador);

           ResultSet rs = stmt.executeQuery();
           int id = rs.getInt("id_simulacao_avaliacao_mec");
            return id;
            
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoMecDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(SimulacaoMecDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    public List<SimulacaoAvaliacaoMec> getSimulacoes(){
        conexaoDb = new ConexaoDb().getConexao();
        List<SimulacaoAvaliacaoMec> listaSimulacoes = new ArrayList<>();
            String sql ="SELECT identificador_simulacao FROM SIMULACAO_AVALIACAO_MEC";
            
            PreparedStatement stmt;
        try {
            stmt = conexaoDb.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            SimulacaoAvaliacaoMec simulacaoAvaliacaoMec = new SimulacaoAvaliacaoMec();
            
            simulacaoAvaliacaoMec.setIdentificadorSimulacao(rs.getString("identificador_simulacao"));

            
            listaSimulacoes.add(simulacaoAvaliacaoMec);
            
            }
            return listaSimulacoes;
        
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoMecDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public SimulacaoAvaliacaoMec getSimulacao(Integer idSimulacao){
        conexaoDb = new ConexaoDb().getConexao();
        SimulacaoAvaliacaoMec simulacaoAvaliacaoMec = new SimulacaoAvaliacaoMec();

        String sql= "SELECT * FROM SIMULACAO_AVALIACAO_MEC WHERE id_simulacao_avaliacao_mec=?";
            try {
                PreparedStatement stmt = conexaoDb.prepareStatement(sql);
                stmt.setInt(1, idSimulacao);

                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    simulacaoAvaliacaoMec.setFk_id_curso(rs.getInt("fk_id_curso"));
                    simulacaoAvaliacaoMec.setNotaFinal(rs.getString("nota_final"));
                    simulacaoAvaliacaoMec.setIdentificadorSimulacao(rs.getString("identificador_simulacao"));
                    simulacaoAvaliacaoMec.setSugestaoMelhoriaDimensao1(rs.getString("sugestao_melhoria_dimensao1"));
                    simulacaoAvaliacaoMec.setSugestaoMelhoriaDimensao2(rs.getString("sugestao_melhoria_dimensao2"));
                }


                rs.close();

                return simulacaoAvaliacaoMec;
            } catch (SQLException ex) {
                Logger.getLogger(SimulacaoMecDao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(SimulacaoMecDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
}
