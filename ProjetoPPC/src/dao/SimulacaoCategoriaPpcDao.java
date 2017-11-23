/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.SimulacaoCategoriaPpc;
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
public class SimulacaoCategoriaPpcDao {
    private  Connection conexaoDb;
   
    public boolean Cria(Integer idSimulacao){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO SIMULACAO_CATEGORIA_PPC (nota_contexto_educacional, nota_autoavaliacao,"
                + " nota_objetivos_curso, nota_perfil_prof, nota_numero_vagas, fk_id_simulacao_avaliacao_mec)"
                + " VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, 0);
            stmt.setInt(2, 0);
            stmt.setInt(3, 0);
            stmt.setInt(4, 0);
            stmt.setInt(5, 0);
            stmt.setInt(6, idSimulacao);

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
    
    public boolean Altera(Integer idSimulacao, SimulacaoCategoriaPpc simulacaoCategoriaPpc){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "UPDATE SIMULACAO_CATEGORIA_PPC SET nota_contexto_educacional=?, nota_autoavaliacao=?,"
                + " nota_objetivos_curso=?, nota_perfil_prof=?, nota_numero_vagas=? "
                + " WHERE fk_id_simulacao_avaliacao_mec=? ";
        
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, simulacaoCategoriaPpc.getNotaContextoEducacional());
            stmt.setInt(2, simulacaoCategoriaPpc.getNotaAutoAvaliacao());
            stmt.setInt(3, simulacaoCategoriaPpc.getNotaObjetivosCurso());
            stmt.setInt(4, simulacaoCategoriaPpc.getNotaPerfilProf());
            stmt.setInt(5, simulacaoCategoriaPpc.getNotaNumeroVagas());
            stmt.setInt(6, idSimulacao);
            
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
    
    public SimulacaoCategoriaPpc getSimulacaoCategoriaPpc(Integer idSimulacao){
        conexaoDb = new ConexaoDb().getConexao();
        SimulacaoCategoriaPpc simulacaoCategoriaPpc = new SimulacaoCategoriaPpc();

        String sql= "SELECT * FROM SIMULACAO_CATEGORIA_PPC WHERE fk_id_simulacao_avaliacao_mec=?";
            try {
                PreparedStatement stmt = conexaoDb.prepareStatement(sql);
                stmt.setInt(1, idSimulacao);

                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    
                   simulacaoCategoriaPpc.setNotaContextoEducacional(rs.getInt("nota_contexto_educacional"));
                   simulacaoCategoriaPpc.setNotaAutoAvaliacao(rs.getInt("nota_autoavaliacao"));
                   simulacaoCategoriaPpc.setNotaObjetivosCurso(rs.getInt("nota_objetivos_curso"));
                   simulacaoCategoriaPpc.setNotaPerfilProf(rs.getInt("nota_perfil_prof"));
                   simulacaoCategoriaPpc.setNotaNumeroVagas(rs.getInt("nota_numero_vagas")); 
                }

                rs.close();

                return simulacaoCategoriaPpc;
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
        String sql = "DELETE FROM SIMULACAO_CATEGORIA_PPC WHERE fk_id_simulacao_avaliacao_mec=?";
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
