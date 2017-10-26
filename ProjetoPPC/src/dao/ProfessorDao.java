/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import entity.Professor;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ProfessorDao {
     private  Connection conexaoDb;
     public boolean Cria(Professor professor){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO PROFESSOR(nome,cpf,maior_titulacao,area_formacao,curriculo_lattes, data_atualizacao,coordenador) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getCpf());
            stmt.setString(3, professor.getMaiorTitulacao());
            stmt.setString(4, professor.getAreaFormacao());
            stmt.setString(5, professor.getCurriculoLattes());
            stmt.setString(6, professor.getDataAtualizacao());
            stmt.setBoolean(7, professor.isCoordenador());

            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     public boolean InsereDadosGerais(Professor professor, Integer idProfessor){
         conexaoDb = new ConexaoDb().getConexao();
        String sql="UPDATE PROFESSOR SET matricula=?,data_admissao=?,horas_nde=?,orientacao_tcc=?,coordenacao_curso=?,"
                + "coordenacao_outros_cursos=?,pesquisa=?,atividade_extra_classe_curso=?, atividade_extra_classe_outros_cursos=?,"
                + "qtde_horas_curso=?,qtde_horas_outro_curso=? WHERE id_professor=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, professor.getMatricula());
            stmt.setString(2, professor.getDataAdmissao());
            stmt.setInt(3, professor.getHorasNde());
            stmt.setInt(4, professor.getOrientacaoTcc());
            stmt.setInt(5, professor.getCoordenacaoCurso());
            stmt.setInt(6, professor.getCoordenacaoOutrosCursos());
            stmt.setInt(7, professor.getPesquisa());
            stmt.setInt(8, professor.getAtividadeExtraClasseCurso());
            stmt.setInt(9, professor.getAtividadeExtraClasseOutrosCursos());
            stmt.setInt(10, professor.getQtdeHorasCurso());
            stmt.setInt(11, professor.getQtdeHorasOutroCurso());
            
            stmt.setInt(12, idProfessor);

            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     } 
     public Integer getIdProfessor(String cpf){
        conexaoDb = new ConexaoDb().getConexao();
        
        String sql="SELECT id_professor FROM PROFESSOR WHERE cpf=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, cpf);

           ResultSet rs = stmt.executeQuery();
           int id = rs.getInt("id_professor");
            return id;
            

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
     public List<Professor> getProfessores(){
        conexaoDb = new ConexaoDb().getConexao();
        List<Professor> listaProfessores = new ArrayList<Professor>();
            String sql ="SELECT nome,cpf,maior_titulacao FROM PROFESSOR";
            
            PreparedStatement stmt;
        try {
            stmt = conexaoDb.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            Professor professor = new Professor();
            
            professor.setNome(rs.getString("nome"));
            professor.setCpf(rs.getString("cpf"));
            professor.setMaiorTitulacao(rs.getString("maior_titulacao"));
            
            listaProfessores.add(professor);
            
            }
            return listaProfessores;
        
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        public Professor getProfessor(String cpf){
                 conexaoDb = new ConexaoDb().getConexao();
    Professor professor = new Professor();
    
    String sql= "SELECT * FROM PROFESSOR WHERE cpf=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, cpf);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                professor.setNome(rs.getString("nome"));
                professor.setCpf(cpf);
                professor.setMaiorTitulacao("maior_titulacao");
                professor.setAreaFormacao(rs.getString("area_formacao"));
                professor.setCurriculoLattes(rs.getString("curriculo_lattes"));
                professor.setDataAtualizacao(rs.getString("data_atualizacao"));
                professor.setCoordenador(rs.getBoolean("coordenador"));
            }

            
            rs.close();
            
            return professor;
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
        try {
            conexaoDb.close();
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
}


