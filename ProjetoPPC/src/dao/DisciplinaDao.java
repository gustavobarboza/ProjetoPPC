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
    private final Connection conexaoDb;
    public DisciplinaDao(){
        this.conexaoDb = new ConexaoDb().getConexao();
    }
    
    public boolean cria(Disciplina disciplina){
     
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
    public List<Disciplina> getDisciplinas(){
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
    
}
