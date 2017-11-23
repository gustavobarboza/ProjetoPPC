/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.SimulacaoCategoriaPpcFormacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class SimulacaoCategoriaPpcFormacaoDao {
    private  Connection conexaoDb;
   
    public boolean Cria(Integer idSimulacao){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO SIMULACAO_CATEGORIA_PPC_FORMACAO (nota_estrutura_curricular, nota_conteudos_curriculares,"
                + " nota_metodologia, nota_atendimento_discente, fk_id_simulacao_avaliacao_mec)"
                + " VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, 0);
            stmt.setInt(2, 0);
            stmt.setInt(3, 0);
            stmt.setInt(4, 0);
            stmt.setInt(5, idSimulacao);

            stmt.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoCategoriaPerfilDocentesDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(SimulacaoCategoriaPerfilDocentesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean Altera(Integer idSimulacao, SimulacaoCategoriaPpcFormacao simulacaoCategoriaPpcFormacao){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "UPDATE SIMULACAO_CATEGORIA_PPC_FORMACAO SET nota_estrutura_curricular=?, nota_conteudos_curriculares=?,"
                + " nota_metodologia=?, nota_atendimento_discente=?"
                + " WHERE fk_id_simulacao_avaliacao_mec=? ";
        
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, simulacaoCategoriaPpcFormacao.getNotaEstruturaCurricular());
            stmt.setInt(2, simulacaoCategoriaPpcFormacao.getNotaConteudosCurriculares());
            stmt.setInt(3, simulacaoCategoriaPpcFormacao.getNotaMetodologia());
            stmt.setInt(4, simulacaoCategoriaPpcFormacao.getNotaAtendimentoDiscente());
            stmt.setInt(5, idSimulacao);
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoCategoriaPerfilDocentesDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(SimulacaoCategoriaPerfilDocentesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }  
    
    public SimulacaoCategoriaPpcFormacao getSimulacaoCategoriaPpcFormacao(Integer idSimulacao){
        conexaoDb = new ConexaoDb().getConexao();
        SimulacaoCategoriaPpcFormacao simulacaoCategoriaPpcFormacao = new SimulacaoCategoriaPpcFormacao();

        String sql= "SELECT * FROM SIMULACAO_CATEGORIA_PPC_FORMACAO WHERE fk_id_simulacao_avaliacao_mec=?";
            try {
                PreparedStatement stmt = conexaoDb.prepareStatement(sql);
                stmt.setInt(1, idSimulacao);

                ResultSet rs = stmt.executeQuery();
                while(rs.next()){

                    simulacaoCategoriaPpcFormacao.setNotaEstruturaCurricular(rs.getInt("nota_estrutura_curricular"));
                    simulacaoCategoriaPpcFormacao.setNotaConteudosCurriculares(rs.getInt("nota_conteudos_curriculares"));
                    simulacaoCategoriaPpcFormacao.setNotaMetodologia(rs.getInt("nota_metodologia"));
                    simulacaoCategoriaPpcFormacao.setNotaAtendimentoDiscente(rs.getInt("nota_atendimento_discente")); 
                }

                rs.close();

                return simulacaoCategoriaPpcFormacao;
            } catch (SQLException ex) {
                Logger.getLogger(SimulacaoCategoriaPerfilDocentesDao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }finally{
                try {
                    conexaoDb.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SimulacaoCategoriaPerfilDocentesDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
     
    public boolean Remove(Integer idSimulacao){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "DELETE FROM SIMULACAO_CATEGORIA_PPC_FORMACAO WHERE fk_id_simulacao_avaliacao_mec=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, idSimulacao);
            
            stmt.execute();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoCategoriaPerfilDocentesDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(SimulacaoCategoriaPerfilDocentesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}
