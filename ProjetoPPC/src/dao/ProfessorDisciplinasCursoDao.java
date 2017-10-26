/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class ProfessorDisciplinasCursoDao {
         private  Connection conexaoDb;
     public boolean Cria(Integer idProfessor){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO PROFESSOR_DISCIPLINAS_CURSO(fk_id_professor) VALUES(?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, idProfessor);

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
}
