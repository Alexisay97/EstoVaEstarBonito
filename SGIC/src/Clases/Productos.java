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
    public String cod, marca, tipo, cant, des, pU,id;
    public boolean band2;
    
   
    
    public String Ingresar(String txtCod, String txtCosto, String txtMarca,String txtCant, String txtDes, String cbxTipo){
        Conexion conn= new Conexion();
        Connection cn = conn.Conexion();
        
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
           
            cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error. No se han podido guardar los datos contacte al administrador"+ex); //"NO se han Guardados los datos. Revise que todos los campos esten llenos");
            Logger.getLogger(Formularios.NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
        
        return null;
    }
    
    public String Update(String valor, String txtCod, String txtCosto, String txtMarca,String txtCant, String txtDes, String cbxTipo){
        Conexion conn= new Conexion();
        Connection cn = conn.Conexion();
        
        try {
            
            PreparedStatement pps= cn.prepareStatement("UPDATE productos SET cod=? , marca=?,tipo =?,cant=?,descripcion=?,pUnitario=?,mFecha=?,idUser=? WHERE id=?");
            
            pps.setString (1, txtCod);
            pps.setString (2, txtMarca);
            pps.setString (3, cbxTipo);
            pps.setString (4, txtCant);
            pps.setString (5, txtDes);
            pps.setString (6, txtCosto);
            pps.setNull (7, 0);
            pps.setString (8, "10");
            pps.setString(9,valor);
                
            pps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos Guardados");
            cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error. No se han podido actualizar los datos contacte al administrador "+ex); //"NO se han Guardados los datos. Revise que todos los campos esten llenos");
            Logger.getLogger(Formularios.NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
        
        return null;
    }
    
    public String Busqueda(String valor){
        
        Conexion conn= new Conexion();
        Connection cn = conn.Conexion();
         
        String sql = "SELECT `id`, cod, marca, tipo, cant, descripcion, pUnitario  FROM productos WHERE cod='"+valor+"';";
        
        try {
             
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                cod = (rs.getString("cod"));
                marca = (rs.getString("marca"));
                tipo = (rs.getString("tipo"));
                cant = (rs.getString("cant"));
                des = (rs.getString("descripcion"));
                pU = (rs.getString("pUnitario"));     
            }else{
                
                JOptionPane.showMessageDialog(null, "Producto no Econtrado");
            }
                cerrarConexion();////JOptionPane.showMessageDialog(null, "Producto no Econtrado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
        
        
        return null;
    }
    
    public String Descargar(String valor){
        
        Conexion conn= new Conexion();
        Connection cn = conn.Conexion();
         
        String sql = "SELECT `id`, cod, tipo, cant, pUnitario  FROM productos WHERE cod='"+valor+"';";
        
        try {
             
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                id = (rs.getString("id"));
                cod = (rs.getString("cod"));
                tipo = (rs.getString("tipo"));
                cant = (rs.getString("cant"));
                pU = (rs.getString("pUnitario"));     
            }else{
                
                JOptionPane.showMessageDialog(null, "Producto no Econtrado");
            }
                ////JOptionPane.showMessageDialog(null, "Producto no Econtrado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
        
        try {
            
            PreparedStatement pps= cn.prepareStatement("INSERT INTO descargo (id, idP, cod, fDescargo, cant, pUnitario, tipo, idUser) VALUES (?,?,?,?,?,?,?,?)");
                      
            pps.setNull   (1, 0);
            pps.setString (2, id);
            pps.setString (3, cod);
            pps.setNull   (4, 0);
            pps.setString (5, cant);
            pps.setString (6, pU);
            pps.setString (7, tipo);
            pps.setString (8, "10");
          
            pps.executeUpdate();

            //cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error. No se han podido guardar los datos contacte al administrador "+ex); //"NO se han Guardados los datos. Revise que todos los campos esten llenos");
            Logger.getLogger(Formularios.NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
         
        try {
            
            PreparedStatement pps= cn.prepareStatement("UPDATE productos SET estado=?, idUser=? WHERE id=?");
            
            pps.setString (1, "Descargo");
            pps.setString (2, "10");
            pps.setString(3,id);
                
            pps.executeUpdate();

            JOptionPane.showMessageDialog(null, "El producto a sido descargado del inventario");
            cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error. No se han podido actualizar los datos contacte al administrador "+ex); //"NO se han Guardados los datos. Revise que todos los campos esten llenos");
            Logger.getLogger(Formularios.NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
        
        return null;
    }
    
    public String Comprobar(String valor){
        Conexion conn= new Conexion();
        Connection cn = conn.Conexion();
        
        String sql = "SELECT cod FROM productos WHERE cod = '"+valor+"'";
        
        try {
             
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                cod = (rs.getString("cod"));
                System.out.println(cod + "cod");
                System.out.println(valor + "valor"); 
            }
            
            if(cod.equals(valor)){
                band2 = false;
                System.out.println(band2 + " si");
            }else{
                band2 = true;
                System.out.println(band2 + " no");        
            }
                cerrarConexion();////JOptionPane.showMessageDialog(null, "Producto no Econtrado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
        return null;
    }
    
    
    
     public void cerrarConexion(){
        Conexion conn= new Conexion();
        Connection cn = conn.Conexion();
        
        if(cn != null){
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
