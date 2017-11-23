/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.SimulacaoCondicoesTrabalho;
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
public class SimulacaoCondicoesTrabalhoDao {
        private  Connection conexaoDb;
   
    public boolean Cria(Integer idSimulacao){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO SIMULACAO_CONDICOES_TRABALHO (nota_numero_alunos_docente, nota_numero_alunos_turma,"
                + " nota_numero_disciplinas_docente, nota_pesquisa,nota_producao, fk_id_simulacao_avaliacao_mec)"
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
    
    public boolean Altera(Integer idSimulacao, SimulacaoCondicoesTrabalho simulacaoCondicoesTrabalho){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "UPDATE SIMULACAO_CONDICOES_TRABALHO SET nota_numero_alunos_docente=?, nota_numero_alunos_turma=?,"
                + " nota_numero_disciplinas_docente=?, nota_pesquisa=?,nota_producao=? "
                + " WHERE fk_id_simulacao_avaliacao_mec=? ";
        
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
             stmt.setInt(1,simulacaoCondicoesTrabalho.getNotaNumeroAlunosDocente());
            stmt.setInt(2, simulacaoCondicoesTrabalho.getNotaNumeroAlunosTurma());
            stmt.setInt(3, simulacaoCondicoesTrabalho.getNotaNumeroDisciplinasDocente());
            stmt.setInt(4, simulacaoCondicoesTrabalho.getNotaPesquisa());
            stmt.setInt(5, simulacaoCondicoesTrabalho.getNotaProdução());
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
    
    public SimulacaoCondicoesTrabalho getSimulacaoCondicoesTrabalho(Integer idSimulacao){
        conexaoDb = new ConexaoDb().getConexao();
        SimulacaoCondicoesTrabalho simulacaoCondicoesTrabalho = new SimulacaoCondicoesTrabalho();

        String sql= "SELECT * FROM SIMULACAO_CONDICOES_TRABALHO WHERE fk_id_simulacao_avaliacao_mec=?";
            try {
                PreparedStatement stmt = conexaoDb.prepareStatement(sql);
                stmt.setInt(1, idSimulacao);

                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    simulacaoCondicoesTrabalho.setNotaNumeroAlunosDocente(rs.getInt("nota_numero_alunos_docente"));
                    simulacaoCondicoesTrabalho.setNotaNumeroAlunosTurma(rs.getInt("nota_numero_alunos_turma"));
                    simulacaoCondicoesTrabalho.setNotaNumeroDisciplinasDocente(rs.getInt("nota_numero_disciplinas_docente"));
                    simulacaoCondicoesTrabalho.setNotaPesquisa(rs.getInt("nota_pesquisa"));
                    simulacaoCondicoesTrabalho.setNotaProdução(rs.getInt("nota_producao"));
                }

                rs.close();

                return simulacaoCondicoesTrabalho;
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
        String sql = "DELETE FROM SIMULACAO_CONDICOES_TRABALHO WHERE fk_id_simulacao_avaliacao_mec=?";
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
