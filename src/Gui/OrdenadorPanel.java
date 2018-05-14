/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import objects.Ordenador;

/**
 *
 * @author House
 */
public class OrdenadorPanel extends JPanel{
    private JLabel nombre;
    private JProgressBar avance;
    
    public OrdenadorPanel(String nombre, JProgressBar avance){
        super.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.nombre = new JLabel(nombre);
        this.avance = avance;
        super.add(this.nombre);
        super.add(avance);
        
    }
    
}
