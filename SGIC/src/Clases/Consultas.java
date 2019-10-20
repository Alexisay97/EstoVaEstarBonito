/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Formularios.ConsultaProducto;
import java.sql.Connection;
/**
 *
 * @author Alex
 */
public class Consultas extends ConsultaProducto{
    
    
    
    public void cargartodoslosdatos(){
        Conexion conn= new Conexion();
        Connection cn = conn.Conexion();
        //ConsultaProducto c = new ConsultaProducto();
        DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"id","CODIGO", "MARCA", "TIPO","DESCRIPCION"," P.UNITARIO","CANTIDAD", "FECHA", "FECHA MOD","ESTADO", "USUARIO"};
        tabla.setColumnIdentifiers(titulos);
        this.tblInv.setModel(tabla);
        String consulta= "SELECT * FROM productos WHERE estado='Activo'";
        String []Datos= new String [11];
        try {
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(consulta);
            while(rs.next())
            {
                Datos[0]=rs.getString("id");
                Datos[1]=rs.getString("cod");
                Datos[2]=rs.getString("marca");
                Datos[3]=rs.getString("tipo");
                Datos[4]=rs.getString("cant");
                Datos[5]=rs.getString("descripcion");
                Datos[6]=rs.getString("pUnitario");
                Datos[7]=rs.getString("Estado");
                Datos[8]=rs.getString("cFecha");
                Datos[9]=rs.getString("mFecha");
                Datos[10]=rs.getString("idUser");
                
                tabla.addRow(Datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
}
