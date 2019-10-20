/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import Formularios.NuevoProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class Productos {
    public int flag;
    Conexion conn= new Conexion();
    Connection cn = conn.Conexion();
    
    public String Ingresar(String txtCod, String txtCosto, String txtMarca,String txtCant, String txtDes, String cbxTipo){
        
         try {
            
            PreparedStatement pps= cn.prepareStatement("INSERT INTO productos (id,cod,marca,tipo,cant,descripcion,pUnitario,Estado,cFecha,mFecha,idUser) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fecha2 = new java.util.Date();
            String fechaformateada =formato.format(fecha2);  
            
            pps.setNull(1, 0);
            pps.setString (7, txtCosto);
            pps.setString (2, txtCod);
            pps.setString (3, txtMarca);
            pps.setString (5, txtCant);
            pps.setString (6, txtDes);
            pps.setString (4, cbxTipo);
            pps.setString (8, "Activo");
            pps.setString (11, "10");
            pps.setNull (10, 0);
            pps.setString(9, fechaformateada);
            
                    
            pps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos Guardados");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error"+ex); //"NO se han Guardados los datos. Revise que todos los campos esten llenos");
            Logger.getLogger(Formularios.NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public String Update(String txtCod, String txtCosto, String txtMarca,String txtCant, String txtDes, String cbxTipo){
        
         try {
            
            PreparedStatement pps= cn.prepareStatement("Update productos (id,cod,marca,tipo,cant,descripcion,pUnitario,Estado,cFecha,mFecha,idUser) WHERE(id)");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fecha2 = new java.util.Date();
            String fechaformateada =formato.format(fecha2);  
            
            pps.setNull(1, 0);
            pps.setString (7, txtCosto);
            pps.setString (2, txtCod);
            pps.setString (3, txtMarca);
            pps.setString (5, txtCant);
            pps.setString (6, txtDes);
            pps.setString (4, cbxTipo);
            pps.setString (8, "Activo");
            pps.setString (11, "10");
            pps.setNull (10, 0);
            pps.setString(9, fechaformateada);
            
                    
            pps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos Guardados");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error"+ex); //"NO se han Guardados los datos. Revise que todos los campos esten llenos");
            Logger.getLogger(Formularios.NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public String Busqueda(){
        NuevoProducto p = new NuevoProducto();
        p.txtCod.setText("hik");
        String valor = "3";
        System.out.println(p.txtCod.getText());
        
        String sql = "SELECT `id`, cod, marca, tipo, cant, descripcion, pUnitario  FROM productos WHERE id='"+valor+"';";
         try {
             
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            
            while(rs.next()) {
                p.txtCod.setText(rs.getString("cod"));
                System.out.println(rs.getString("cod"));
                p.txtMarca.setText(rs.getString("marca"));
                System.out.println(rs.getString("marca"));
                p.cbxTipo.addItem(rs.getString("tipo"));
                System.out.println(rs.getString("tipo"));
                p.txtCant.setText(rs.getString("cant"));
                p.txtDes.setText(rs.getString("descripcion"));
                p.txtCosto.setText(rs.getString("pUnitario"));
                
            }
          
        
        } catch (SQLException ex) {
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
