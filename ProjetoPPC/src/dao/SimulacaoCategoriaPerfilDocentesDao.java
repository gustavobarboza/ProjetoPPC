/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.SimulacaoCategoriaPerfilDocentes;
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
public class SimulacaoCategoriaPerfilDocentesDao {
    private  Connection conexaoDb;
   
    public boolean Cria(Integer idSimulacao){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO SIMULACAO_CATEGORIA_PERFIL_DOCENTES (nota_titulacao, nota_regime,"
                + " nota_tempo_experiencia_magisterio, nota_tempo_experiencia_corpo_docente,"
                + " fk_id_simulacao_avaliacao_mec) VALUES(?,?,?,?,?)";
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
    
    public boolean Altera(Integer idSimulacao, SimulacaoCategoriaPerfilDocentes simulacaoCategoriaPerfilDocentes){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "UPDATE SIMULACAO_CATEGORIA_PERFIL_DOCENTES SET nota_titulacao=?, nota_regime=?,"
                + " nota_tempo_experiencia_magisterio=?, nota_tempo_experiencia_corpo_docente=?"
                + " WHERE fk_id_simulacao_avaliacao_mec=? ";
        
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, simulacaoCategoriaPerfilDocentes.getNotaTitulacao());
            stmt.setInt(2, simulacaoCategoriaPerfilDocentes.getNotaRegime());
            stmt.setInt(3, simulacaoCategoriaPerfilDocentes.getNotaTempoExperienciaMagisterio());
            stmt.setInt(4, simulacaoCategoriaPerfilDocentes.getNotaTempoExperienciaCorpoDocente());
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
    
    public SimulacaoCategoriaPerfilDocentes getSimulacaoCategoriaPerfilDocentes(Integer idSimulacao){
        conexaoDb = new ConexaoDb().getConexao();
        SimulacaoCategoriaPerfilDocentes simulacaoCategoriaPerfilDocentes = new SimulacaoCategoriaPerfilDocentes();

        String sql= "SELECT * FROM SIMULACAO_CATEGORIA_PERFIL_DOCENTES WHERE fk_id_simulacao_avaliacao_mec=?";
            try {
                PreparedStatement stmt = conexaoDb.prepareStatement(sql);
                stmt.setInt(1, idSimulacao);

                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    
                    simulacaoCategoriaPerfilDocentes.setNotaTitulacao(rs.getInt("nota_titulacao"));
                    simulacaoCategoriaPerfilDocentes.setNotaRegime(rs.getInt("nota_regime"));
                    simulacaoCategoriaPerfilDocentes.setNotaTempoExperienciaMagisterio(rs.getInt("nota_tempo_experiencia_magisterio"));
                    simulacaoCategoriaPerfilDocentes.setNotaTempoExperienciaCorpoDocente(rs.getInt("nota_tempo_experiencia_corpo_docente"));
                    
                }

                rs.close();

                return simulacaoCategoriaPerfilDocentes;
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
        String sql = "DELETE FROM SIMULACAO_CATEGORIA_PERFIL_DOCENTES WHERE fk_id_simulacao_avaliacao_mec=?";
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
