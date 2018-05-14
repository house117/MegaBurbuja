/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Gui.PrincipalFrame;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Random;
import javax.swing.SwingUtilities;
import objects.Generador;
import objects.MegaOrdenador;

/**
 *
 * @author House
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Integer[] array = Generador.generarArray(1000000);
        for(int i=0; i<array.length; i++){
            System.out.printf("%d\n", array[i]);
        }
        System.out.println("");
        MegaOrdenador.ordenarLista(array, 100);*/
        /*for(int i=0; i<array.length; i++){
            System.out.printf("%d ", array[i]);
        }*/
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                File controlEscolar = new File("control.ce");
                
                
                    
                    /*MainFrame ventana = new MainFrame("Control Escolar", 
                            GestionadorArchivoControlEscolar.abrirArchivo(controlEscolar));*/
                    PrincipalFrame ventana = new PrincipalFrame();
                    
                    
                
                
                
            }
        });
        
        
        
    }
    
}
