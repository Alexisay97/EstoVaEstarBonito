/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexis
 */
public class Conexion {
    
    public Connection conn;
    
    public Conexion() {
        this.conn = null;
    }
    public Connection Conexion(){
        try {
        Class.forName("com.mysql.jdbc.Driver");
        conn =DriverManager.getConnection("jdbc:mysql://localhost/sgic","root", "");
        //JOptionPane.showMessageDialog(null, "Conectado");
        }catch (Exception ex){
        //JOptionPane.showMessageDialog(null, "No se ha podido establecer una conexion a la BD "+ex);
    }
    return conn ;
    }
    
   
    
    
}
