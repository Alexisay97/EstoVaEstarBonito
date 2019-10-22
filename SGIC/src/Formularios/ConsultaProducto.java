/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;
import Clases.Consultas;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alex
 */
public class ConsultaProducto extends javax.swing.JFrame {
    String band;
    String fband;
    int f;
    String filtro;
    String sql;   
    Thread hilo;
    /**
     * Creates new form ConsultaProducto
     */
    public ConsultaProducto() {
        initComponents();
        TipoConsulta();  
        pbar.setVisible(false);
    }
/* Como hay niveles de usuario y yo ya tengo hueva con estas consultas, cada consulta osea busqueda() y consulta() 
    hay que personalizarla para cada una de las consultas por los datos que llama cada tabla debido a que son diferentes
    y ya con eso deberian quedar las consultas y solo hara falta crear lso reportes de modificar y usuarios y deberia quedar
    esto */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxF = new javax.swing.JComboBox<>();
        btnFiltro = new javax.swing.JButton();
        txtValor = new javax.swing.JTextField();
        btnImprimir = new javax.swing.JButton();
        pbar = new javax.swing.JProgressBar();
        tbl = new javax.swing.JScrollPane();
        tblInv = new javax.swing.JTable();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Filtrar");

        cbxF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "Codigo", "Marca", "Precio", "Cantidad" }));

        btnFiltro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFiltro.setText("Filtrar");
        btnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroActionPerformed(evt);
            }
        });

        txtValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnImprimir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnImprimir.setText("Imprimir Reporte");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        pbar.setToolTipText("Cargando Reporte...Espere.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxF, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pbar, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbxF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFiltro)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnImprimir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblInv.setAutoCreateRowSorter(true);
        tblInv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblInv.setToolTipText("");
        tblInv.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbl.setViewportView(tblInv);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tbl))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbl, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
        
        f = cbxF.getSelectedIndex();
        filtro = txtValor.getText();
        filtrar();
        
    }//GEN-LAST:event_btnFiltroActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        reportes();
    }//GEN-LAST:event_btnImprimirActionPerformed
    
    void filtrar(){
        Consultas c = new Consultas();
        System.out.println(fband);
        
        if(fband.equals("1")){
            filtrarProductos(); 
        }else if(fband.equals("2")){
            filtrarDescargo();
        }else if(fband.equals("3")){
            filtrarMod();
        }else if(fband.equals("4")){
            filtrarUsuarios();
        }else{
            JOptionPane.showMessageDialog(null, "A sucedido un error ...???");
        }
    }
    
    void filtrarProductos(){
        System.out.println(f+" "+filtro);
        
        if(f == 1|| f == 2 || f == 3 || f == 4){
            if(filtro.equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese un valor en campo de texto");
                //System.out.println("S "+ filtro);
            }else{
                consultaProductos(filtro);
                BusquedaProductos();
            }
        
        }else if(f == 0){
            TipoConsulta();
        }
        
    }
    void filtrarDescargo(){
        System.out.println(f+" "+filtro);
        
        if(f == 1|| f == 2 || f == 3 || f == 4){
            if(filtro.equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese un valor en campo de texto");
                //System.out.println("S "+ filtro);
            }else{
                consultaProductos(filtro);
                BusquedaProductos();
            }
        
        }else if(f == 0){
            TipoConsulta();
        }
        
    }
    void filtrarMod(){
        System.out.println(f+" "+filtro);
        
        if(f == 1|| f == 2 || f == 3 || f == 4){
            if(filtro.equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese un valor en campo de texto");
                //System.out.println("S "+ filtro);
            }else{
                consultaProductos(filtro);
                BusquedaProductos();
            }
        
        }else if(f == 0){
            TipoConsulta();
        }
        
    }
    void filtrarUsuarios(){
        System.out.println(f+" "+filtro);
        
        if(f == 1|| f == 2 || f == 3 || f == 4){
            if(filtro.equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese un valor en campo de texto");
                //System.out.println("S "+ filtro);
            }else{
                consultaProductos(filtro);
                BusquedaProductos();
            }
        
        }else if(f == 0){
            TipoConsulta();
        }
        
    }
    
    void reportes(){
        
        Consultas c = new Consultas();
        //Principal p = new Principal();
        System.out.println(fband);
        
        if(fband.equals("1")){
            c.consultaProductos(); 
        }else if(fband.equals("2")){
            c.consultaDescargo();
        }else if(fband.equals("3")){
            c.consultaModificaciones();
        }else if(fband.equals("4")){
            c.consultaUsuarios();
        }else{
            JOptionPane.showMessageDialog(null, "A sucedido un error ...???");
        }
        
        
    }
    
    void cargardatosdescargo(){
        Conexion conn= new Conexion();
        Connection cn = conn.Conexion();
        
        if(1==0){
        //Usuario Administrador    
            DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"id","CODIGO", "MARCA", "TIPO","DESCRIPCION"," P.UNITARIO","CANTIDAD", "ESTADO","FECHA", "FECHA MODIFICACION", "USUARIO"};
        tabla.setColumnIdentifiers(titulos);
        this.tblInv.setModel(tabla);
        String consulta= "SELECT * FROM productos WHERE estado='Descargo'";
        String []Datos = new String [11];
        try {
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(consulta);
            while(rs.next())
            {
                Datos[0]=rs.getString("id");
                Datos[1]=rs.getString("cod");
                Datos[2]=rs.getString("marca");
                Datos[3]=rs.getString("tipo");
                Datos[4]=rs.getString("descripcion");
                Datos[5]=rs.getString("pUnitario");
                Datos[6]=rs.getString("cant");
                Datos[7]=rs.getString("Estado");
                Datos[8]=rs.getString("cFecha");
                Datos[9]=rs.getString("mFecha");
                Datos[10]=rs.getString("idUser");
                
                tabla.addRow(Datos);
            }
            
            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
        }else if(2==2){
        //Uusario Normal    
            DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"id","CODIGO", "MARCA", "TIPO","DESCRIPCION"," P.UNITARIO","CANTIDAD", "ESTADO"};
        tabla.setColumnIdentifiers(titulos);
        this.tblInv.setModel(tabla);
        String consulta= "SELECT * FROM productos WHERE estado='Descargo'";
        String []Datos = new String [11];
        try {
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(consulta);
            while(rs.next())
            {
                Datos[0]=rs.getString("id");
                Datos[1]=rs.getString("cod");
                Datos[2]=rs.getString("marca");
                Datos[3]=rs.getString("tipo");
                Datos[4]=rs.getString("descripcion");
                Datos[5]=rs.getString("pUnitario");
                Datos[6]=rs.getString("cant");
                Datos[7]=rs.getString("Estado");
               
                tabla.addRow(Datos);
            }
            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
        }
    }
    
    void cargartodoslosdatos(){
        Conexion conn= new Conexion();
        Connection cn = conn.Conexion();
        
        if(1==0){
        //Usuario Administrador    
            DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"id","CODIGO", "MARCA", "TIPO","DESCRIPCION"," P.UNITARIO","CANTIDAD", "ESTADO","FECHA", "FECHA MODIFICACION", "USUARIO"};
        tabla.setColumnIdentifiers(titulos);
        this.tblInv.setModel(tabla);
        String consulta= "SELECT * FROM productos WHERE estado='Activo'";
        String []Datos = new String [11];
        try {
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(consulta);
            while(rs.next())
            {
                Datos[0]=rs.getString("id");
                Datos[1]=rs.getString("cod");
                Datos[2]=rs.getString("marca");
                Datos[3]=rs.getString("tipo");
                Datos[4]=rs.getString("descripcion");
                Datos[5]=rs.getString("pUnitario");
                Datos[6]=rs.getString("cant");
                Datos[7]=rs.getString("Estado");
                Datos[8]=rs.getString("cFecha");
                Datos[9]=rs.getString("mFecha");
                Datos[10]=rs.getString("idUser");
                
                tabla.addRow(Datos);
            }
            
            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
        }else if(2==2){
        //Uusario Normal    
            DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"id","CODIGO", "MARCA", "TIPO","CANTIDAD","DESCRIPCION","P.UNITARIO","ESTADO"};
        tabla.setColumnIdentifiers(titulos);
        this.tblInv.setModel(tabla);
        String consulta= "SELECT * FROM productos WHERE estado='Activo'";
        String []Datos = new String [11];
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
               
                tabla.addRow(Datos);
            }
            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
        }
        
    }    
    
    void cargarmodificados(){
        
        Conexion conn= new Conexion();
        Connection cn = conn.Conexion();
        
        DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"id","CODIGO", "MARCA", "TIPO","DESCRIPCION","CANTIDAD","P.UNITARIO","FECHA MODIFICADO"};
        tabla.setColumnIdentifiers(titulos);
        this.tblInv.setModel(tabla);
        
        String consulta= "SELECT * FROM productos  WHERE estado='Activo'";
        String []Datos = new String [11];
        try {
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(consulta);
            while(rs.next())
            {
                Datos[0]=rs.getString("id");
                Datos[1]=rs.getString("cod");
                Datos[2]=rs.getString("marca");
                Datos[3]=rs.getString("tipo");
                Datos[4]=rs.getString("descripcion");
                Datos[5]=rs.getString("cant");
                Datos[6]=rs.getString("pUnitario");
                Datos[7]=rs.getString("mFecha");
               
                tabla.addRow(Datos);
            }
            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
    }
    
    void cargarUsers(){
        
        Conexion conn= new Conexion();
        Connection cn = conn.Conexion();
        
        DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"id","USUARIO", "NOMBRE", "TIPO DE USUARIO","FECHA MOD"};
        tabla.setColumnIdentifiers(titulos);
        this.tblInv.setModel(tabla);
        
        String consulta= "SELECT * FROM usuarios";
        String []Datos = new String [11];
        try {
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(consulta);
            while(rs.next())
            {
                Datos[0]=rs.getString("id");
                Datos[1]=rs.getString("user");
                Datos[2]=rs.getString("nombre");
                Datos[3]=rs.getString("tipo");
                Datos[4]=rs.getString("cfecha");
               
                tabla.addRow(Datos);
            }
            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
    }
    
    void BusquedaProductos(){
        
        Conexion conn= new Conexion();
        Connection cn = conn.Conexion();
        DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"id","CODIGO", "MARCA", "TIPO","DESCRIPCION"," P.UNITARIO","CANTIDAD", "ESTADO","FECHA", "FECHA MODIFICACION", "USUARIO"};
        tabla.setColumnIdentifiers(titulos);
        this.tblInv.setModel(tabla);
        String []Datos = new String [11];
        
        try {
             
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs!=null){
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
            }else{
                
                JOptionPane.showMessageDialog(null, "Producto no Econtrado");
            }
                cerrarConexion();////JOptionPane.showMessageDialog(null, "Producto no Econtrado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
      
    }
    void BusquedaDescargo(){
        
        Conexion conn= new Conexion();
        Connection cn = conn.Conexion();
        DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"id","CODIGO", "MARCA", "TIPO","DESCRIPCION"," P.UNITARIO","CANTIDAD", "ESTADO","FECHA", "FECHA MODIFICACION", "USUARIO"};
        tabla.setColumnIdentifiers(titulos);
        this.tblInv.setModel(tabla);
        String []Datos = new String [11];
        
        try {
             
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs!=null){
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
            }else{
                
                JOptionPane.showMessageDialog(null, "Producto no Econtrado");
            }
                cerrarConexion();////JOptionPane.showMessageDialog(null, "Producto no Econtrado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
      
    }
    void BusquedaMod(){
        
        Conexion conn= new Conexion();
        Connection cn = conn.Conexion();
        DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"id","CODIGO", "MARCA", "TIPO","DESCRIPCION"," P.UNITARIO","CANTIDAD", "ESTADO","FECHA", "FECHA MODIFICACION", "USUARIO"};
        tabla.setColumnIdentifiers(titulos);
        this.tblInv.setModel(tabla);
        String []Datos = new String [11];
        
        try {
             
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs!=null){
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
            }else{
                
                JOptionPane.showMessageDialog(null, "Producto no Econtrado");
            }
                cerrarConexion();////JOptionPane.showMessageDialog(null, "Producto no Econtrado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
      
    }
    void BusquedaUsuarios(){
        
        Conexion conn= new Conexion();
        Connection cn = conn.Conexion();
        DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"id","CODIGO", "MARCA", "TIPO","DESCRIPCION"," P.UNITARIO","CANTIDAD", "ESTADO","FECHA", "FECHA MODIFICACION", "USUARIO"};
        tabla.setColumnIdentifiers(titulos);
        this.tblInv.setModel(tabla);
        String []Datos = new String [11];
        
        try {
             
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs!=null){
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
            }else{
                
                JOptionPane.showMessageDialog(null, "Producto no Econtrado");
            }
                cerrarConexion();////JOptionPane.showMessageDialog(null, "Producto no Econtrado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
            cerrarConexion();
        }
      
    }
   
   void consultaProductos(String valor){
       int se = cbxF.getSelectedIndex();
       
       switch(se){
           case 1:
              sql = "SELECT `id`, cod, marca, tipo, Estado,cant, descripcion, pUnitario, cFecha,mFecha,idUser  FROM productos WHERE cod='"+valor+"';";
           break;
           
           case 2:
               sql = "SELECT `id`, cod, marca, tipo, Estado,cant, descripcion, pUnitario, cFecha,mFecha,idUser  FROM productos WHERE marca='"+valor+"';";
           break;
           
           case 3:
               sql = "SELECT `id`, cod, marca, tipo, Estado,cant, descripcion, pUnitario, cFecha,mFecha,idUser  FROM productos WHERE pUnitario='"+valor+"';";
           break;
           
           case 4:
               sql = "SELECT `id`, cod, marca, tipo, Estado,cant, descripcion, pUnitario, cFecha,mFecha,idUser  FROM productos WHERE cant='"+valor+"';";
           break;
       }
   
   }
   void consultaDescargo(String valor){
       int se = cbxF.getSelectedIndex();
       
       switch(se){
           case 1:
              sql = "SELECT `id`, cod, marca, tipo, Estado,cant, descripcion, pUnitario, cFecha,mFecha,idUser  FROM productos WHERE cod='"+valor+"';";
           break;
           
           case 2:
               sql = "SELECT `id`, cod, marca, tipo, Estado,cant, descripcion, pUnitario, cFecha,mFecha,idUser  FROM productos WHERE marca='"+valor+"';";
           break;
           
           case 3:
               sql = "SELECT `id`, cod, marca, tipo, Estado,cant, descripcion, pUnitario, cFecha,mFecha,idUser  FROM productos WHERE pUnitario='"+valor+"';";
           break;
           
           case 4:
               sql = "SELECT `id`, cod, marca, tipo, Estado,cant, descripcion, pUnitario, cFecha,mFecha,idUser  FROM productos WHERE cant='"+valor+"';";
           break;
       }
   
   }
   void consultaMod(String valor){
       int se = cbxF.getSelectedIndex();
       
       switch(se){
           case 1:
              sql = "SELECT `id`, cod, marca, tipo, Estado,cant, descripcion, pUnitario, cFecha,mFecha,idUser  FROM productos WHERE cod='"+valor+"';";
           break;
           
           case 2:
               sql = "SELECT `id`, cod, marca, tipo, Estado,cant, descripcion, pUnitario, cFecha,mFecha,idUser  FROM productos WHERE marca='"+valor+"';";
           break;
           
           case 3:
               sql = "SELECT `id`, cod, marca, tipo, Estado,cant, descripcion, pUnitario, cFecha,mFecha,idUser  FROM productos WHERE pUnitario='"+valor+"';";
           break;
           
           case 4:
               sql = "SELECT `id`, cod, marca, tipo, Estado,cant, descripcion, pUnitario, cFecha,mFecha,idUser  FROM productos WHERE cant='"+valor+"';";
           break;
       }
   
   }  
   void consultaUsuarios(String valor){
       int se = cbxF.getSelectedIndex();
       
       switch(se){
           case 1:
              sql = "SELECT `id`, cod, marca, tipo, Estado,cant, descripcion, pUnitario, cFecha,mFecha,idUser  FROM productos WHERE cod='"+valor+"';";
           break;
           
           case 2:
               sql = "SELECT `id`, cod, marca, tipo, Estado,cant, descripcion, pUnitario, cFecha,mFecha,idUser  FROM productos WHERE marca='"+valor+"';";
           break;
           
           case 3:
               sql = "SELECT `id`, cod, marca, tipo, Estado,cant, descripcion, pUnitario, cFecha,mFecha,idUser  FROM productos WHERE pUnitario='"+valor+"';";
           break;
           
           case 4:
               sql = "SELECT `id`, cod, marca, tipo, Estado,cant, descripcion, pUnitario, cFecha,mFecha,idUser  FROM productos WHERE cant='"+valor+"';";
           break;
       }
   
   }
    public void cerrarConexion(){
        Conexion conn= new Conexion();
        Connection cn = conn.Conexion();
        
        if(cn != null){
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     
    void TipoConsulta(){
        Principal c = new Principal();
        
        if(c.band.equals("1")){
            cargartodoslosdatos();
            fband = "1";
            this.setTitle("Consulta de Productos");
        }else if(c.band.equals("2")){
            cargardatosdescargo();
            fband = "2";
            this.setTitle("Consulta de Productos Descargados");
        }else if(c.band.equals("3")){
            cargarmodificados();
            fband = "3";
            this.setTitle("Consulta de Modificiaciones");
        }else if(c.band.equals("4")){
            cargarUsers();
            fband = "4";
            this.setTitle("Consulta de Usuarios");
            
        }else{
            JOptionPane.showMessageDialog(null, "A sucedido un error ...???");
        }
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltro;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox<String> cbxF;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar pbar;
    private javax.swing.JScrollPane tbl;
    private javax.swing.JTable tblInv;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables

    
}
