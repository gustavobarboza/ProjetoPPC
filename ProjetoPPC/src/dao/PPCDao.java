/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.PPC;
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
public class PPCDao {
    Connection conexaoDb;
    public boolean Insere(Integer idCurso, PPC ppc){
        conexaoDb = new ConexaoDb().getConexao();
            String sql="INSERT INTO PPC(identificador, perfil_curso, perfil_egresso, forma_acesso_curso, representacao_perfil_formacao,"
                    + "sistema_avaliacao_processo_ensino, sistema_avaliacao_projeto_curso, trabalho_conclusao_curso, "
                    + "estagio_curricular, politica_atendimento_deficientes, fk_id_curso)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setString(1, ppc.getIdentificador());
            stmt.setString(2, ppc.getPerfilCurso());
            stmt.setString(3, ppc.getPerfilEgresso());
            stmt.setString(4, ppc.getFormaAcessoCurso());
            stmt.setString(5, ppc.getRepresentacaoPerfilFormacao());
            stmt.setString(6, ppc.getSistemaAvaliacaoProcessoEnsinoAprendizagem());
            stmt.setString(7, ppc.getSistemaAvaliacaoProjetoCurso());
            stmt.setString(8, ppc.getTrabalhoConclusaoCurso());
            stmt.setString(9, ppc.getEstagioCurricular());
            stmt.setString(10, ppc.getPoliticaAtendimentoDeficientes());
            stmt.setInt(11, idCurso);
          
            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(PPCDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(PPCDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean Altera(Integer idPPC, Integer idCurso, PPC ppc){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "UPDATE PPC SET identificador=?, perfil_curso=?, perfil_egresso=?, forma_acesso_curso=?, representacao_perfil_formacao=?,"
                    + "sistema_avaliacao_processo_ensino=?, sistema_avaliacao_projeto_curso=?, trabalho_conclusao_curso=?, "
                    + "estagio_curricular=?, politica_atendimento_deficientes=?, fk_id_curso=? WHERE id_ppc=?";
        
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
           stmt.setString(1, ppc.getIdentificador());
            stmt.setString(2, ppc.getPerfilCurso());
            stmt.setString(3, ppc.getPerfilEgresso());
            stmt.setString(4, ppc.getFormaAcessoCurso());
            stmt.setString(5, ppc.getRepresentacaoPerfilFormacao());
            stmt.setString(6, ppc.getSistemaAvaliacaoProcessoEnsinoAprendizagem());
            stmt.setString(7, ppc.getSistemaAvaliacaoProjetoCurso());
            stmt.setString(8, ppc.getTrabalhoConclusaoCurso());
            stmt.setString(9, ppc.getEstagioCurricular());
            stmt.setString(10, ppc.getPoliticaAtendimentoDeficientes());
            stmt.setInt(11, idCurso);
            stmt.setInt(12, idPPC);
                      
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(PPCDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(PPCDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public boolean Remove(Integer idPPC){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "DELETE FROM PPC WHERE id_ppc=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, idPPC);
            
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PPCDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(PPCDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public List<PPC> getPPCs(){
        conexaoDb = new ConexaoDb().getConexao();
        List<PPC> listaPPC = new ArrayList<>();
            String sql ="SELECT * FROM PPC";
            
            PreparedStatement stmt;
        try {
            stmt = conexaoDb.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            PPC ppc = new PPC();
            
            ppc.setIdentificador(rs.getString("identificador"));
            ppc.setPerfilCurso(rs.getString("perfil_curso"));
            ppc.setPerfilEgresso(rs.getString("perfil_egresso"));
            ppc.setFormaAcessoCurso(rs.getString("forma_acesso_curso"));
            ppc.setRepresentacaoPerfilFormacao(rs.getString("representacao_perfil_formacao"));
            ppc.setSistemaAvaliacaoProcessoEnsinoAprendizagem(rs.getString("sistema_avaliacao_processo_ensino"));
            ppc.setSistemaAvaliacaoProjetoCurso(rs.getString("sistema_avaliacao_projeto_curso"));
            ppc.setTrabalhoConclusaoCurso(rs.getString("trabalho_conclusao_curso"));
            ppc.setEstagioCurricular(rs.getString("estagio_curricular"));
            ppc.setPoliticaAtendimentoDeficientes(rs.getString("politica_atendimento_deficientes"));
            ppc.setFk_id_curso(rs.getInt("fk_id_curso"));            
            
            listaPPC.add(ppc);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(PPCDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return listaPPC;
    }
    
    public PPC getPPC(Integer idPPC){
        conexaoDb = new ConexaoDb().getConexao();
        PPC  ppc = new PPC();
    
        String sql= "SELECT * FROM PPC WHERE id_ppc=?";

        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, idPPC);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
            ppc.setIdentificador(rs.getString("identificador"));
            ppc.setPerfilCurso(rs.getString("perfil_curso"));
            ppc.setPerfilEgresso(rs.getString("perfil_egresso"));
            ppc.setFormaAcessoCurso(rs.getString("forma_acesso_curso"));
            ppc.setRepresentacaoPerfilFormacao(rs.getString("representacao_perfil_formacao"));
            ppc.setSistemaAvaliacaoProcessoEnsinoAprendizagem(rs.getString("sistema_avaliacao_processo_ensino"));
            ppc.setSistemaAvaliacaoProjetoCurso(rs.getString("sistema_avaliacao_projeto_curso"));
            ppc.setTrabalhoConclusaoCurso(rs.getString("trabalho_conclusao_curso"));
            ppc.setEstagioCurricular(rs.getString("estagio_curricular"));
            ppc.setPoliticaAtendimentoDeficientes(rs.getString("politica_atendimento_deficientes"));
            ppc.setFk_id_curso(rs.getInt("fk_id_curso")); 
            
            }
            rs.close();

            return ppc;

        } catch (SQLException ex) {
            Logger.getLogger(PPCDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(PPCDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Integer getIdPPC(String identificador){
        conexaoDb = new ConexaoDb().getConexao();
        
        String sql="SELECT id_ppc FROM PPC WHERE identificador=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, identificador);

           ResultSet rs = stmt.executeQuery();
           int id = rs.getInt("id_ppc");
            return id;
            

        } catch (SQLException ex) {
            Logger.getLogger(PPCDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(PPCDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
}
