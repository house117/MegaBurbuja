/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.Random;

/**
 *
 * @author House
 */
public class Generador {
    public Generador(){
        
    }
    public static Integer[] generarArray(Integer tamanio){
        Integer[] array = new Integer[tamanio];
        Random temp = new Random();
        System.out.println("LISTA DESORDENADA:");
        for(int i=0; i<array.length; i++){
            array[i] = temp.nextInt(tamanio+1);
            System.out.printf("%d\n", array[i]);
        }
        System.out.println("\n");
        return array;
    }
}
