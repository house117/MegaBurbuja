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
public class MegaOrdenador {
    private ArrayList<Ordenador> listaHilos;
    private JProgressBar[] listaBarritas;
    public MegaOrdenador(JProgressBar[] listaBarritas){
        this.listaBarritas = listaBarritas;
    }
    public  Integer[] ordenarLista(Integer[] lista, Integer numeroDeSeparaciones,
             JProgressBar barritaUnificador){
        Integer maximo = lista[0];
        Integer minimo = lista[0];
        Integer maxTemp;
        Integer minTemp;
        SuperLista[] listaListas = new SuperLista[numeroDeSeparaciones];
        CheckPoint checkpoint;
        for(int i=0; i<lista.length; i++){
            if(lista[i] > maximo){
                maximo = lista[i];
            }
            if(lista[i] < minimo){
                minimo = lista[i];
            }
        }
        
        minTemp = minimo;
        Integer numeroDeElementos = maximo-minimo+1;
        Integer tamanioIntervalo = (numeroDeElementos/numeroDeSeparaciones)-1;
        for(int i=0; i<numeroDeSeparaciones; i++){
            if(i < numeroDeSeparaciones-1){
                maxTemp = minTemp+tamanioIntervalo;
                listaListas[i] = new SuperLista(maxTemp, minTemp);
                minTemp = maxTemp+1;
            }else{
                maxTemp = maximo;
                listaListas[i] = new SuperLista(maxTemp, minTemp);
            }
        }
        for(int i=0; i<lista.length; i++){
            for(int j=0; j<listaListas.length; j++){
                if(lista[i] >= listaListas[j].getMinimo() && lista[i] <= listaListas[j].getMaximo()){
                    listaListas[j].getLista().add(lista[i]);
                    
                }
            }
        }
        setListaHilos(new ArrayList<>());
        for(int i=0; i<listaListas.length; i++){
            
            getListaHilos().add(new Ordenador(listaListas[i].getLista(), listaBarritas[i]));
            getListaHilos().get(i).start();
        }
        checkpoint = new CheckPoint(getListaHilos());
        new Unificador(checkpoint, listaListas, lista, barritaUnificador).start();

            
        
        return lista;
    }

    /**
     * @return the listaHilos
     */
    public ArrayList<Ordenador> getListaHilos() {
        return listaHilos;
    }

    /**
     * @param listaHilos the listaHilos to set
     */
    public void setListaHilos(ArrayList<Ordenador> listaHilos) {
        this.listaHilos = listaHilos;
    }
}
