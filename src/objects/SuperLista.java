/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;

/**
 *
 * @author House
 */
public class SuperLista {
    private Integer maximo; 
    private Integer minimo;
    private ArrayList<Integer> lista;
    
    public SuperLista(Integer maximo, Integer minimo){
        this.maximo = maximo;
        this.minimo = minimo;
        lista = new ArrayList<>();
    }

    public Integer getMaximo() {
        return maximo;
    }

    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }

    public Integer getMinimo() {
        return minimo;
    }

    public void setMinimo(Integer minimo) {
        this.minimo = minimo;
    }

    /**
     * @return the lista
     */
    public ArrayList<Integer> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ArrayList<Integer> lista) {
        this.lista = lista;
    }


}
