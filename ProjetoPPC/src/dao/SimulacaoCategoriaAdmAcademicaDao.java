/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.SimulacaoCategoriaAdmAcademica;
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
public class SimulacaoCategoriaAdmAcademicaDao {
    private  Connection conexaoDb;
   
    public boolean Cria(Integer idSimulacao){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO SIMULACAO_CATEGORIA_ADM_ACADEMICA(nota_composicao_nde, nota_titulacao_nde,"
                + " nota_experiencia, nota_regime, nota_titulacao, nota_formacao, nota_regime_coordenador,"
                + " nota_composicao, fk_id_simulacao_avaliacao_mec) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, 0);
            stmt.setInt(2, 0);
            stmt.setInt(3, 0);
            stmt.setInt(4, 0);
            stmt.setInt(5, 0);
            stmt.setInt(6, 0);
            stmt.setInt(7, 0);
            stmt.setInt(8, 0);
            stmt.setInt(9, idSimulacao);

            stmt.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoCategoriaAdmAcademicaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(SimulacaoCategoriaAdmAcademicaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean Altera(Integer idSimulacao, SimulacaoCategoriaAdmAcademica simulacaoCategoriaAdmAcademica){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "UPDATE SIMULACAO_CATEGORIA_ADM_ACADEMICA SET nota_composicao_nde=?, nota_titulacao_nde=?,"
                + " nota_experiencia=?, nota_regime=?, nota_titulacao=?, nota_formacao=?, nota_regime_coordenador=?,"
                + " nota_composicao=? WHERE fk_id_simulacao_avaliacao_mec=? ";
        
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, simulacaoCategoriaAdmAcademica.getNotaComposicaoNde());
            stmt.setInt(2, simulacaoCategoriaAdmAcademica.getNotaTitulacaoNde());
            stmt.setInt(3, simulacaoCategoriaAdmAcademica.getNotaExperiencia());
            stmt.setInt(4, simulacaoCategoriaAdmAcademica.getNotaRegima());
            stmt.setInt(5, simulacaoCategoriaAdmAcademica.getNotaTitulação());
            stmt.setInt(6, simulacaoCategoriaAdmAcademica.getNotaFormacao());
            stmt.setInt(7, simulacaoCategoriaAdmAcademica.getNotaRegimeCoordenador());
            stmt.setInt(7, simulacaoCategoriaAdmAcademica.getNotaRegimeCoordenador());
            stmt.setInt(8, simulacaoCategoriaAdmAcademica.getNotaComposição());

            stmt.setInt(9, idSimulacao);
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoCategoriaAdmAcademicaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(SimulacaoCategoriaAdmAcademicaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }  
    
    public SimulacaoCategoriaAdmAcademica getSimulacaoCategoriaAdmAcademica(Integer idSimulacao){
        conexaoDb = new ConexaoDb().getConexao();
        SimulacaoCategoriaAdmAcademica simulacaoCategoriaAdmAcademica = new SimulacaoCategoriaAdmAcademica();

        String sql= "SELECT * FROM SIMULACAO_CATEGORIA_ADM_ACADEMICA WHERE fk_id_simulacao_avaliacao_mec=?";
            try {
                PreparedStatement stmt = conexaoDb.prepareStatement(sql);
                stmt.setInt(1, idSimulacao);

                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    simulacaoCategoriaAdmAcademica.setNotaComposicaoNde(rs.getInt("nota_composicao_nde"));
                    simulacaoCategoriaAdmAcademica.setNotaTitulacaoNde(rs.getInt("nota_titulacao_nde"));
                    simulacaoCategoriaAdmAcademica.setNotaExperiencia(rs.getInt("nota_experiencia"));
                    simulacaoCategoriaAdmAcademica.setNotaRegima(rs.getInt("nota_regime"));
                    simulacaoCategoriaAdmAcademica.setNotaTitulação(rs.getInt("nota_titulacao"));
                    simulacaoCategoriaAdmAcademica.setNotaFormacao(rs.getInt("nota_formacao"));
                    simulacaoCategoriaAdmAcademica.setNotaRegimeCoordenador(rs.getInt("nota_regime_coordenador"));
                    simulacaoCategoriaAdmAcademica.setNotaComposição(rs.getInt("nota_composicao"));
                    
                    
                }


                rs.close();

                return simulacaoCategoriaAdmAcademica;
            } catch (SQLException ex) {
                Logger.getLogger(SimulacaoCategoriaAdmAcademicaDao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(SimulacaoCategoriaAdmAcademicaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
     
    public boolean Remove(Integer idSimulacao){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "DELETE FROM SIMULACAO_CATEGORIA_ADM_ACADEMICA WHERE fk_id_simulacao_avaliacao_mec=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, idSimulacao);
            
            stmt.execute();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SimulacaoCategoriaAdmAcademicaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(SimulacaoCategoriaAdmAcademicaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
}
