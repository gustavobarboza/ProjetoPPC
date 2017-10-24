/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class ConexaoDb {
    public Connection getConexao(){
            
        try {
            return DriverManager.getConnection("jdbc:sqlite:.\\database\\ppc_db.db");
        } catch (SQLException ex) {
           throw new RuntimeException(ex);
        }
    }
}
