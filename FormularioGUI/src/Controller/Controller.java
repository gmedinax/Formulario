/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//System.out.println("");

package Controller;

import Model.ListaSimple;
import Model.Nodo;
import View.MainView;
import View.SecondaryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author giselle
 */
public class Controller implements ActionListener, KeyListener, MouseListener {
    private ListaSimple Listita;
    private MainView Vistita;
    private Nodo Nodito =new Nodo();
    int Fila=0,Band=0;
    SecondaryView VistitaConsultas = new SecondaryView();
    String Botoncito=null;
    String Nombre=null, ApellidoP=null,ApellidoM=null,FechaNacimiento = null, Sexo = null,Direccion=null,Ciudad=null,Estado=null;
    String[] Data = new String[8];
    private DefaultTableModel Tablita;

    public Controller(ListaSimple Listita, MainView Vistita) {
        this.Listita = Listita;
        this.Vistita = Vistita;
        this.Vistita.cajitaTextoNombre.addActionListener(this);
        this.Vistita.cajitaTextoNombre.addKeyListener(this);
        this.Vistita.cajitaTextoAP.addActionListener(this);
        this.Vistita.cajitaTextoAP.addKeyListener(this);
        this.Vistita.cajitaTextoAM.addActionListener(this);
        this.Vistita.cajitaTextoAM.addKeyListener(this);
        //this.Vistita.Fechita.addActionListener(this);
        this.Vistita.cmbBxSexo.addActionListener(this);
        this.Vistita.cmbBxEstados.addActionListener(this);
        this.Vistita.cajitaTextoColonia.addActionListener(this);
        this.Vistita.cajitaTextoColonia.addKeyListener(this);
        this.Vistita.cajitaTextoCiudad.addActionListener(this);
        this.Vistita.cajitaTextoCiudad.addKeyListener(this);
        this.Vistita.btnConsultar.addActionListener(this);
        this.Vistita.btnRegistrar.addActionListener(this);
        this.Vistita.btnValidar.addActionListener(this);
        this.VistitaConsultas.btnEliminar.addActionListener(this);
        this.VistitaConsultas.btnModificar.addActionListener(this);
        
    }
    
    public void Iniciar() {
        this.Vistita.setResizable(false);
        this.Vistita.btnConsultar.setEnabled(false);
        this.Vistita.btnRegistrar.setEnabled(false);
        Tablita = new DefaultTableModel();
        this.crearTablita();
    }
    
    public void crearTablita() {
        this.Tablita.addColumn("Nombre");
        this.Tablita.addColumn("Apellido paterno");
         this.Tablita.addColumn("Apellido materno");
        this.Tablita.addColumn("Fecha de nacimiento");
        this.Tablita.addColumn("Sexo");
        this.Tablita.addColumn("Colonia");
        this.Tablita.addColumn("Ciudad");
        this.Tablita.addColumn("Estado");
    }
    
    private void Validacion() {
        if (this.Vistita.cmbBxSexo.isValid()) {
            Sexo = this.Vistita.cmbBxSexo.getSelectedItem().toString();
        } else {
            JOptionPane.showMessageDialog(null, "Favor de seleccionar sexo");
        }

        if (this.Vistita.cmbBxEstados.isValid()) {
            Estado=this.Vistita.cmbBxEstados.getSelectedItem().toString();
        }
        
        if(this.Vistita.Fechita.getDate().toString().isEmpty()){
        JOptionPane.showMessageDialog(null, "Favor de ingresar fecha de nacimiento");
        }else {
            Date d = this.Vistita.Fechita.getDate();
            DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
            FechaNacimiento = df.format(d);
        }
        

        if (!this.Vistita.cajitaTextoNombre.getText().isEmpty() && !this.Vistita.cajitaTextoAP.getText().isEmpty() 
                &&!this.Vistita.cajitaTextoAM.getText().isEmpty() && !this.Vistita.cajitaTextoColonia.getText().isEmpty() &&
                !this.Vistita.cajitaTextoCiudad.getText().isEmpty() && Sexo!="Sexo" && FechaNacimiento != null && Estado != "Estado") {
            this.Vistita.btnRegistrar.setEnabled(true);
            JOptionPane.showMessageDialog(null, "La validación de sus datos ha sido correcta");
        } else {
            JOptionPane.showMessageDialog(null, "La validación de sus datos ha sido inconclusa");
        }
    }
    
    public void Limpiar() {
        Sexo = null;
        Estado = null;
        this.Vistita.cajitaTextoNombre.setText("");
        this.Vistita.cajitaTextoAP.setText("");
        this.Vistita.cajitaTextoAM.setText("");
        this.Vistita.cajitaTextoColonia.setText("");
        this.Vistita.cajitaTextoCiudad.setText("");
        this.Vistita.Fechita.setCalendar(null);
        this.Vistita.cmbBxEstados.setSelectedItem("Estado");
        this.Vistita.cmbBxSexo.setSelectedItem("Sexo");
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        Botoncito = a.getActionCommand();
        if(Band==1){
            this.VistitaConsultas.TablitaConsultas.removeAll();
            Band=0;
        }
        if ("Validar".equals(Botoncito)) {
            this.Validacion();
        }
        if("Registrar".equals(Botoncito)){
            this.Listita.Agregar(this.Vistita.cajitaTextoNombre.getText(), this.Vistita.cajitaTextoAP.getText(),this.Vistita.cajitaTextoAM.getText(), 
                    FechaNacimiento, Sexo, this.Vistita.cajitaTextoColonia.getText(),this.Vistita.cajitaTextoCiudad.getText(),Estado);
                JOptionPane.showMessageDialog(null, "Sus datos han sido registrados");
                Limpiar();
                this.Vistita.btnConsultar.setEnabled(true);
                this.Vistita.btnRegistrar.setEnabled(false);            
        }
        if("Consultar".equals(Botoncito)){
            this.Listita.Actual = this.Listita.getInicio();                
                VistitaConsultas.setVisible(true);
                this.VistitaConsultas.TablitaConsultas.removeAll();
                this.Tablita.setNumRows(0);
                while (this.Listita.Actual != null) {
                    this.Nodito = this.Listita.MostrarRegistro();
                    Data [0] = Nodito.getNombre();
                    Data [1] = Nodito.getApellidoP();
                    Data [2] = Nodito.getApellidoM();
                    Data [3] = String.valueOf(Nodito.getFechaNacimiento());
                    Data [4] = String.valueOf(Nodito.getGenero());
                    Data [5] = Nodito.getDirección();
                    Data [6] = Nodito.getCiudad();
                    Data [7] = Nodito.getEstado();
                }
                this.Tablita.addRow(Data);
                VistitaConsultas.TablitaConsultas.setModel(Tablita);
                this.Band=1;
        }
        if("Eliminar".equals(Botoncito)){
            if(this.Listita.Vacio()!=true){
                this.Listita.Eliminar(Fila);
                this.Listita.Enumerar();
                Tablita=(DefaultTableModel) this.VistitaConsultas.TablitaConsultas.getModel();
                Tablita.removeRow(Fila);
                if(this.Listita.Vacio()==true){
                    this.VistitaConsultas.dispose();
                    this.Vistita.btnConsultar.setEnabled(false);
                    this.Fila=-1;
                }
                Band=1;
            }
        }
        if("Modificar".equals(Botoncito)){
            if(Fila>=0){
                Nombre=this.VistitaConsultas.TablitaConsultas.getValueAt(Fila, 0).toString();
                ApellidoP=this.VistitaConsultas.TablitaConsultas.getValueAt(Fila, 1).toString();
                ApellidoM=this.VistitaConsultas.TablitaConsultas.getValueAt(Fila, 2).toString();
                FechaNacimiento=this.VistitaConsultas.TablitaConsultas.getValueAt(Fila, 3).toString();
                Sexo=this.VistitaConsultas.TablitaConsultas.getValueAt(Fila, 4).toString();
                Direccion=this.VistitaConsultas.TablitaConsultas.getValueAt(Fila, 5).toString();
                Ciudad=this.VistitaConsultas.TablitaConsultas.getValueAt(Fila, 6).toString();
                Estado=this.VistitaConsultas.TablitaConsultas.getValueAt(Fila, 7).toString();
                this.Listita.ModificarRegistro(Nombre, ApellidoP, ApellidoM, Sexo, Sexo, Direccion, Ciudad, Estado, Fila);
                JOptionPane.showMessageDialog(null, "Sus datos han sido modificados");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char letrita = e.getKeyChar();
        if (Character.isDigit(letrita)) {
            e.consume();
            this.Vistita.getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Caracter inválido");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.Fila=this.VistitaConsultas.TablitaConsultas.getSelectedRow();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
