package dao;

import entity.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisciplinaDao {
    private  Connection conexaoDb;
    public DisciplinaDao(){
//        this.conexaoDb = new ConexaoDb().getConexao();
    }
    
    public boolean Insere(Disciplina disciplina){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO DISCIPLINAS(nome,descricao,codigo,semestre,carga_horaria) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, disciplina.getNome());
            stmt.setString(2, disciplina.getDescricao());
            stmt.setString(3, disciplina.getCodigo());
            stmt.setString(4, disciplina.getSemestre());
            stmt.setInt(5, disciplina.getCargaHoraria());
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
    public boolean Altera(Disciplina disciplina, String codigo){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "UPDATE DISCIPLINAS SET nome=?, descricao=?, codigo=?, semestre=?, carga_horaria=? WHERE codigo=? ";
        
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, disciplina.getNome());
            stmt.setString(2, disciplina.getDescricao());
            stmt.setString(3, disciplina.getCodigo());
            stmt.setString(4, disciplina.getSemestre());
            stmt.setInt(5, disciplina.getCargaHoraria());
            stmt.setString(6, codigo);
            
            stmt.executeUpdate();
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
    
    public boolean Remove(String codigo){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "DELETE FROM DISCIPLINAS WHERE codigo=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setString(1, codigo);
            
            stmt.execute();
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
    public List<Disciplina> getDisciplinas(){
        conexaoDb = new ConexaoDb().getConexao();
        List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
            String sql ="SELECT * FROM DISCIPLINAS";
            
            PreparedStatement stmt;
        try {
            stmt = conexaoDb.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            Disciplina disciplina = new Disciplina();
            
            disciplina.setNome(rs.getString("nome"));
            disciplina.setDescricao(rs.getString("descricao"));
            disciplina.setCodigo(rs.getString("codigo"));
            
            listaDisciplinas.add(disciplina);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return listaDisciplinas;
    }
    
    public Disciplina getDisciplina(String codigo){
        conexaoDb = new ConexaoDb().getConexao();
    Disciplina  disciplina = new Disciplina();
    
    String sql= "SELECT * FROM DISCIPLINAS WHERE codigo=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, codigo);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                disciplina.setNome(rs.getString("nome"));
                disciplina.setDescricao(rs.getString("descricao"));
                disciplina.setCodigo(rs.getString("codigo"));
                disciplina.setSemestre(rs.getString("semestre"));
                disciplina.setCargaHoraria(rs.getInt("carga_horaria"));
            }

            
            rs.close();
            
            return disciplina;
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
