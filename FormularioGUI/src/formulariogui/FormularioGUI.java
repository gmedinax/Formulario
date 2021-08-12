/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulariogui;

import Controller.Controller;
import Model.ListaSimple;
import View.MainView;

/**
 *
 * @author giselle
 */
public class FormularioGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaSimple Modelo= new ListaSimple();
        MainView VistaPrincipal = new MainView();
        Controller Controlador = new Controller(Modelo, VistaPrincipal);
        Controlador.Iniciar();
        VistaPrincipal.setVisible(true);
    }
    
}

//"Icon made by Freepik from www.flaticon.com"
//"Icon made by Alfredo Hernandez from www.flaticon.com" 