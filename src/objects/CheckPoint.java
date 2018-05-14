/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author House
 */
public class CheckPoint{
    private ArrayList<Ordenador> listaContadores;
    public CheckPoint(ArrayList<Ordenador> listaHilos){
        this.listaContadores = listaHilos;
    }
    public Boolean puedoContinuar(){
        for(int i=0; i<listaContadores.size(); i++){
            if(listaContadores.get(i).getState() != Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }
    
}
