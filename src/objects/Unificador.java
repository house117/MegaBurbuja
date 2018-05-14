/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author House
 */
public class Unificador extends Thread{
    private CheckPoint checkpoint;
    private SuperLista[] listaListas;
    private Integer[] lista;
    private JProgressBar barritaProgreso;
    public Unificador(CheckPoint checkpoint, SuperLista[] listaListas, Integer[] listaOriginal,
                        JProgressBar barritaProgreso) {
        this.checkpoint = checkpoint;
        this.listaListas = listaListas;
        this.lista = listaOriginal;
        this.barritaProgreso = barritaProgreso;
    }

    @Override
    public void run() {
        Boolean listo = false;
        while(!listo){
            synchronized(checkpoint){
                if(checkpoint.puedoContinuar()){
                    barritaProgreso.setMaximum(listaListas.length-1);
                    barritaProgreso.setMinimum(0);
                    System.out.printf("\n\nLista Principal Ordenada: \n");
                    Integer sig = 0;
                    for(int i=0; i<listaListas.length; i++){
                        for(int j=0; j<listaListas[i].getLista().size(); j++){
                                System.out.printf("%d\n", listaListas[i].getLista().get(j));
                                lista[sig] = listaListas[i].getLista().get(j);
                                sig++;
                        }
                        barritaProgreso.setValue(i);
                    }
                    System.out.printf("\n\n");
                    listo = true;
                    }
            }
        }
        
    }
    
    
}
