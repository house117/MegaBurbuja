/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;
import javax.swing.JProgressBar;

/**
 *
 * @author House
 */
public class Ordenador extends Thread{
    private ArrayList<Integer> arreglo;
    private JProgressBar barritaProgreso;
    public Ordenador(ArrayList<Integer> lista, JProgressBar barritaProgreso){
        this.arreglo = lista;
        this.barritaProgreso = barritaProgreso;
        barritaProgreso.setMaximum(arreglo.size());
    }

    @Override
    public void run() {
        
            for(int i=1; i<arreglo.size(); i++){
                for(int j=0; j<arreglo.size()-i; j++){
                    if(arreglo.get(j)>arreglo.get(j+1)){
                        int temp = arreglo.get(j+1);
                        arreglo.set(j+1, arreglo.get(j));
                        arreglo.set(j, temp);
                    }
                }
                barritaProgreso.setValue(i);
            }
    }

    /**
     * @return the barritaProgreso
     */
    public JProgressBar getBarritaProgreso() {
        return barritaProgreso;
    }

    /**
     * @param barritaProgreso the barritaProgreso to set
     */
    public void setBarritaProgreso(JProgressBar barritaProgreso) {
        this.barritaProgreso = barritaProgreso;
    }
    
}
