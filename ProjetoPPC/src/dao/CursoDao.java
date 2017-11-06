/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Curso;
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
 * @author gbarboza
 */
public class CursoDao {
    private Connection conexaoDb;
    
    public boolean Insere(Integer idProfessor, Curso curso){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO CURSOS(tipo_curso, modalidade, denominacao, habilitacao, local_oferta,"
                + " turnos_funcionamento, numero_vagas, carga_horaria, regime, periodos, fk_id_professor)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, curso.getTipoCurso());
            stmt.setString(2, curso.getModalidade());
            stmt.setString(3, curso.getDenominacao());
            stmt.setString(4, curso.getHabilitacao());
            stmt.setString(5, curso.getLocalOferta());
            stmt.setString(6, curso.getTurnosFuncionamento());
            stmt.setString(7, curso.getNumeroVagas());
            stmt.setString(8, curso.getCargaHoraria());
            stmt.setString(9, curso.getRegime());
            stmt.setString(10, curso.getPeriodos());
            stmt.setInt(11, idProfessor);
          
          
            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public boolean Altera(Integer idCurso, Curso curso){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "UPDATE CURSOS SET tipo_curso=?, modalidade=?, denominacao=?, habilitacao=?, local_oferta=?,"
                + " turnos_funcionamento=?, numero_vagas=?, carga_horaria=?, regime=?, periodos=?"
                + " WHERE id_curso=? ";
        
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, curso.getTipoCurso());
            stmt.setString(2, curso.getModalidade());
            stmt.setString(3, curso.getDenominacao());
            stmt.setString(4, curso.getHabilitacao());
            stmt.setString(5, curso.getLocalOferta());
            stmt.setString(6, curso.getTurnosFuncionamento());
            stmt.setString(7, curso.getNumeroVagas());
            stmt.setString(8, curso.getCargaHoraria());
            stmt.setString(9, curso.getRegime());
            stmt.setString(10, curso.getPeriodos());
            
            stmt.setInt(11, idCurso);
                        
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public boolean Remove(Integer idCurso){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "DELETE FROM CURSOS WHERE id_curso=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, idCurso);
            
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public List<Curso> getCursos(){
        conexaoDb = new ConexaoDb().getConexao();
        List<Curso> listaCursos = new ArrayList<>();
            String sql ="SELECT * FROM CURSOS";
            
            PreparedStatement stmt;
        try {
            stmt = conexaoDb.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            Curso curso = new Curso();
            
            curso.setTipoCurso(rs.getString("tipo_curso"));
            curso.setModalidade(rs.getString("modalidade"));
            curso.setDenominacao(rs.getString("denominacao"));
            curso.setHabilitacao(rs.getString("habilitacao"));
            curso.setLocalOferta(rs.getString("local_oferta"));
            curso.setTurnosFuncionamento(rs.getString("turnos_funcionamento"));
            curso.setNumeroVagas(rs.getString("numero_vagas"));
            curso.setCargaHoraria(rs.getString("carga_horaria"));
            curso.setRegime(rs.getString("regime"));
            curso.setPeriodos(rs.getString("periodos"));            
            
            listaCursos.add(curso);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return listaCursos;
    }
    public Curso getCurso(String idCurso){
        conexaoDb = new ConexaoDb().getConexao();
        Curso  curso = new Curso();
    
        String sql= "SELECT * FROM CURSOS WHERE id_curso=?";

        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, idCurso);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
            curso.setTipoCurso(rs.getString("tipo_curso"));
            curso.setModalidade(rs.getString("modalidade"));
            curso.setDenominacao(rs.getString("denominacao"));
            curso.setHabilitacao(rs.getString("habilitacao"));
            curso.setLocalOferta(rs.getString("local_oferta"));
            curso.setTurnosFuncionamento(rs.getString("turnos_funcionamento"));
            curso.setNumeroVagas(rs.getString("numero_vagas"));
            curso.setCargaHoraria(rs.getString("carga_horaria"));
            curso.setRegime(rs.getString("regime"));
            curso.setPeriodos(rs.getString("periodos")); 
            }


            rs.close();

            return curso;

        } catch (SQLException ex) {
            Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public Integer getIdCurso(String denominacao){
        conexaoDb = new ConexaoDb().getConexao();
        
        String sql="SELECT id_curso FROM CURSOS WHERE denominacao=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, denominacao);

           ResultSet rs = stmt.executeQuery();
           int id = rs.getInt("id_curso");
            return id;
            

        } catch (SQLException ex) {
            Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
}
