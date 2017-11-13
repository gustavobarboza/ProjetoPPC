/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.PlanoEnsino;
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
public class PlanoEnsinoDao {
    private Connection conexaoDb;
        public boolean Insere(Integer idCurso, Integer idDisciplina,Integer idCronograma, PlanoEnsino planoEnsino){
        conexaoDb = new ConexaoDb().getConexao();
            String sql="INSERT INTO PLANO_ENSINO(fk_id_curso, ano, semestre, fk_id_disciplina, carga_horaria, periodo,"
                + " ementa, competencias, metodologia, avaliacao, bibliografia, fk_id_cronograma, identificador)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, idCurso);
            stmt.setString(2, planoEnsino.getAno());
            stmt.setString(3, planoEnsino.getSemestre());
            stmt.setInt(4, idDisciplina);
            stmt.setInt(5, planoEnsino.getCargaHoraria());
            stmt.setString(6, planoEnsino.getPeriodo());
            stmt.setString(7, planoEnsino.getEmenta());
            stmt.setString(8, planoEnsino.getCompetencias());
            stmt.setString(9, planoEnsino.getMetodologia());
            stmt.setString(10, planoEnsino.getAvaliacao());
            stmt.setString(11, planoEnsino.getBibliografia());
            stmt.setInt(12, idCronograma);
            stmt.setString(13, planoEnsino.getIdentificador());
          
            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(PlanoEnsinoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(PlanoEnsinoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public boolean Altera(Integer idPlanoEnsino, Integer idCurso, Integer idDisciplina,Integer idCronograma, PlanoEnsino planoEnsino){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "UPDATE PLANO_ENSINO SET fk_id_curso=?, ano=?, semestre=?, fk_id_disciplina=?, carga_horaria=?,"
                + " periodo=?, ementa=?, competencias=?, metodologia=?, avaliacao=?, bibliografia=?, fk_id_cronograma=?,"
                + " identificador=? WHERE id_plano_ensino=? ";
        
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, idCurso);
            stmt.setString(2, planoEnsino.getAno());
            stmt.setString(3, planoEnsino.getSemestre());
            stmt.setInt(4, idDisciplina);
            stmt.setInt(5, planoEnsino.getCargaHoraria());
            stmt.setString(6, planoEnsino.getPeriodo());
            stmt.setString(7, planoEnsino.getEmenta());
            stmt.setString(8, planoEnsino.getCompetencias());
            stmt.setString(9, planoEnsino.getMetodologia());
            stmt.setString(10, planoEnsino.getAvaliacao());
            stmt.setString(11, planoEnsino.getBibliografia());
            stmt.setInt(12, idCronograma);
            stmt.setString(13, planoEnsino.getIdentificador());
            
            stmt.setInt(14, idPlanoEnsino);
                      
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(PlanoEnsinoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(PlanoEnsinoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public boolean Remove(Integer idPlanoEnsino){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "DELETE FROM PLANO_ENSINO WHERE id_plano_ensino=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, idPlanoEnsino);
            
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PlanoEnsinoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(PlanoEnsinoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public List<PlanoEnsino> getPlanosEnsino(){
        conexaoDb = new ConexaoDb().getConexao();
        List<PlanoEnsino> listaPlanos = new ArrayList<>();
            String sql ="SELECT * FROM PLANO_ENSINO";
            
            PreparedStatement stmt;
        try {
            stmt = conexaoDb.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            PlanoEnsino planoEnsino = new PlanoEnsino();
            
            planoEnsino.setAno(rs.getString("ano"));
            planoEnsino.setSemestre(rs.getString("semestre"));
            planoEnsino.setCargaHoraria(rs.getInt("carga_horaria"));
            planoEnsino.setPeriodo(rs.getString("periodo"));
            planoEnsino.setEmenta(rs.getString("ementa"));
            planoEnsino.setCompetencias(rs.getString("competencias"));
            planoEnsino.setMetodologia(rs.getString("metodologia"));
            planoEnsino.setAvaliacao(rs.getString("avaliacao"));
            planoEnsino.setBibliografia(rs.getString("bibliografia"));
            planoEnsino.setIdentificador(rs.getString("identificador"));            
            
            listaPlanos.add(planoEnsino);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlanoEnsinoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return listaPlanos;
    }
    public PlanoEnsino getPlanoEnsino(Integer idPlanoEnsino){
        conexaoDb = new ConexaoDb().getConexao();
        PlanoEnsino  planoEnsino = new PlanoEnsino();
    
        String sql= "SELECT * FROM PLANO_ENSINO WHERE id_plano_ensino=?";

        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, idPlanoEnsino);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
            planoEnsino.setAno(rs.getString("ano"));
            planoEnsino.setSemestre(rs.getString("semestre"));
            planoEnsino.setCargaHoraria(rs.getInt("carga_horaria"));
            planoEnsino.setPeriodo(rs.getString("periodo"));
            planoEnsino.setEmenta(rs.getString("ementa"));
            planoEnsino.setCompetencias(rs.getString("competencias"));
            planoEnsino.setMetodologia(rs.getString("metodologia"));
            planoEnsino.setAvaliacao(rs.getString("avaliacao"));
            planoEnsino.setBibliografia(rs.getString("bibliografia"));
            planoEnsino.setIdentificador(rs.getString("identificador"));
            planoEnsino.setFk_id_curso(rs.getInt("fk_id_curso"));
            planoEnsino.setFk_id_disciplina(rs.getInt("fk_id_disciplina"));
            planoEnsino.setFk_id_cronograma(rs.getInt("fk_id_cronograma"));
            
            }


            rs.close();

            return planoEnsino;

        } catch (SQLException ex) {
            Logger.getLogger(PlanoEnsinoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(PlanoEnsinoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public Integer getIdPlanoEnsino(String identificador){
        conexaoDb = new ConexaoDb().getConexao();
        
        String sql="SELECT id_plano_ensino FROM PLANO_ENSINO WHERE identificador=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, identificador);

           ResultSet rs = stmt.executeQuery();
           int id = rs.getInt("id_plano_ensino");
            return id;
            

        } catch (SQLException ex) {
            Logger.getLogger(PlanoEnsinoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(PlanoEnsinoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
}

