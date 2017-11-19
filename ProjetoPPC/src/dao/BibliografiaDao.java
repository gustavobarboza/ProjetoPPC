package dao;

import entity.Bibliografia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BibliografiaDao {
 private Connection conexaoDb;
    
    public boolean Insere(Integer idCurso, Integer idDisciplina, Bibliografia bibliografia){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO BIBLIOGRAFIA(fk_id_curso, fk_id_disciplina, titulo, autor, isbn, ano, editora)"
                + " VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, idCurso);
            stmt.setInt(2, idDisciplina);
            stmt.setString(3, bibliografia.getTitulo());
            stmt.setString(4, bibliografia.getAutor());
            stmt.setString(5, bibliografia.getIsbn());
            stmt.setString(6, bibliografia.getAno());
            stmt.setString(7, bibliografia.getEditora());
                     
          
            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(BibliografiaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(BibliografiaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean Altera(Integer idBibliografia, Integer idCurso, Integer idDisciplina, Bibliografia bibliografia){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "UPDATE BIBLIOGRAFIA SET fk_id_curso=?, fk_id_disciplina=?, titulo=?, autor=?, isbn=?, ano=?, editora=?"
                + " WHERE id_bibliografia=? ";
        
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, idCurso);
            stmt.setInt(2, idDisciplina);
            stmt.setString(3, bibliografia.getTitulo());
            stmt.setString(4, bibliografia.getAutor());
            stmt.setString(5, bibliografia.getIsbn());
            stmt.setString(6, bibliografia.getAno());
            stmt.setString(7, bibliografia.getEditora());
            stmt.setInt(8, idBibliografia);

            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(BibliografiaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(BibliografiaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public boolean Remove(Integer idBibliografia){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "DELETE FROM BIBLIOGRAFIA WHERE id_bibliografia=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, idBibliografia);
            
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BibliografiaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(BibliografiaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public List<Bibliografia> getBibliografias(){
        conexaoDb = new ConexaoDb().getConexao();
        List<Bibliografia> listaBibliografia = new ArrayList<>();
            String sql ="SELECT * FROM BIBLIOGRAFIA";
            
            PreparedStatement stmt;
        try {
            stmt = conexaoDb.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            Bibliografia bibliografia = new Bibliografia();
            
            bibliografia.setFk_id_curso(rs.getInt("fk_id_curso"));
            bibliografia.setFk_id_disciplina(rs.getInt("fk_id_disciplina"));
            bibliografia.setTitulo(rs.getString("titulo"));
            bibliografia.setAutor(rs.getString("autor"));
            bibliografia.setIsbn(rs.getString("isbn"));
            bibliografia.setAno(rs.getString("ano"));
            bibliografia.setEditora(rs.getString("editora"));
            
            listaBibliografia.add(bibliografia);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(BibliografiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return listaBibliografia;
    }
   
    public Bibliografia getBibliografia(Integer idBibliografia){
        conexaoDb = new ConexaoDb().getConexao();
        Bibliografia  bibliografia = new Bibliografia();
    
        String sql= "SELECT * FROM BIBLIOGRAFIA WHERE id_bibliografia=?";

        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, idBibliografia);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
            bibliografia.setFk_id_curso(rs.getInt("fk_id_curso"));
            bibliografia.setFk_id_disciplina(rs.getInt("fk_id_disciplina"));
            bibliografia.setTitulo(rs.getString("titulo"));
            bibliografia.setAutor(rs.getString("autor"));
            bibliografia.setIsbn(rs.getString("isbn"));
            bibliografia.setAno(rs.getString("ano"));
            bibliografia.setEditora(rs.getString("editora"));
            }


            rs.close();

            return bibliografia;

        } catch (SQLException ex) {
            Logger.getLogger(BibliografiaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(BibliografiaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
    public Integer getIdBibliografia(String titulo){
        conexaoDb = new ConexaoDb().getConexao();
        
        String sql="SELECT id_bibliografia FROM BIBLIOGRAFIA WHERE titulo=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, titulo);

           ResultSet rs = stmt.executeQuery();
           int id = rs.getInt("id_bibliografia");
            return id;
            

        } catch (SQLException ex) {
            Logger.getLogger(BibliografiaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(BibliografiaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }    
}
