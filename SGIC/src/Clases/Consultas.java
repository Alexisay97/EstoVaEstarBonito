/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import Formularios.ConsultaProducto;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Alex
 */
public class Consultas {
    
   public void consultaProductos(){
       try {
            Conexion conn= new Conexion();
            Connection cn = conn.Conexion();
        
            JasperReport reporte = null;
            String path = "src\\Reportes\\ConsultaProductos.jasper";
            
            Map parametro = new HashMap();
            //parametro.put("filtroClta", f1);
            //parametro.put("valorClta", valor);
              
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer view = new JasperViewer(jprint, false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setTitle("Reporte");
            view.setVisible(true);
            
            
        } catch (JRException ex) {
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
   } 
   
   public void consultaDescargo(){
       try {
            Conexion conn= new Conexion();
            Connection cn = conn.Conexion();
        
            JasperReport reporte = null;
            String path = "src\\Reportes\\Consultas.jasper";
            
            Map parametro = new HashMap();
            //parametro.put("filtroClta", f1);
            //parametro.put("valorClta", valor);
              
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer view = new JasperViewer(jprint, false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setTitle("Reporte");
            view.setVisible(true);
            
            
        } catch (JRException ex) {
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   public void consultaModificaciones(){
       try {
            Conexion conn= new Conexion();
            Connection cn = conn.Conexion();
        
            JasperReport reporte = null;
            String path = "src\\Reportes\\ConsultaMod.jasper";
            
            Map parametro = new HashMap();
            //parametro.put("filtroClta", f1);
            //parametro.put("valorClta", valor);
              
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer view = new JasperViewer(jprint, false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setTitle("Reporte");
            view.setVisible(true);
            
            
        } catch (JRException ex) {
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   public void consultaUsuarios(){
       try {
            Conexion conn= new Conexion();
            Connection cn = conn.Conexion();
        
            JasperReport reporte = null;
            String path = "src\\Reportes\\ConsultaUsers.jasper";
            
            Map parametro = new HashMap();
            //parametro.put("filtroClta", f1);
            //parametro.put("valorClta", valor);
              
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer view = new JasperViewer(jprint, false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setTitle("Reporte");
            view.setVisible(true);
            
            
        } catch (JRException ex) {
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   
}
