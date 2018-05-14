/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import javafx.scene.control.ProgressBar;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import objects.Generador;
import objects.MegaOrdenador;

/**
 *
 * @author House
 */
public class PrincipalFrame extends JFrame{
    private JButton btnStart;
    private JPanel pnlContadores;
    private JScrollPane scrollPane;
    private JProgressBar[] pbProcesos;
    Integer numeroSegmentos;
    Integer cantidadNumeros;
    private JProgressBar[] arrayBarritas;
    private OrdenadorPanel[] listaOrdenador;
    private MegaOrdenador superOrdenador;
    public PrincipalFrame(){
        super("Procesos ordenadores");
        
        super.setJMenuBar(createMenu());
        super.setLayout(new FlowLayout(FlowLayout.CENTER));
        super.setSize(800, 600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
       
        
        
        
        
        
        super.setVisible(true);
        
    }
    private JMenuBar createMenu(){
        JMenuBar menu = new JMenuBar();
        JMenu mmArchivo = new JMenu("Archivo");
        //solo un submenu
        JMenuItem nnElegirParametros = new JMenuItem("Elegir Parámetros...");
        nnElegirParametros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JPanel myPanel = new JPanel();
                myPanel.setLayout(new BoxLayout(myPanel, WIDTH));
                JTextField noElementos = new JTextField(5);
                JTextField noSegmentos = new JTextField(5);
                myPanel.add(new JLabel("Cantidad de números:"));
                myPanel.add(noElementos);
                myPanel.add(Box.createVerticalStrut(15)); //espaciador
                myPanel.add(new JLabel("Cantidad de procesos:"));
                myPanel.add(noSegmentos);
                int result = JOptionPane.showConfirmDialog(null, myPanel, "Ingresa datos para ordenamiento",
                JOptionPane.OK_CANCEL_OPTION);
                if(result == JOptionPane.OK_OPTION){
                    System.out.println("ENTRO AL IF AL MENOS");
                    PrincipalFrame.this.cantidadNumeros = Integer.parseInt(noElementos.getText());
                    PrincipalFrame.this.numeroSegmentos = Integer.parseInt(noSegmentos.getText());
                    arrayBarritas = new JProgressBar[numeroSegmentos];
                    PrincipalFrame.this.pnlContadores = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    scrollPane = new JScrollPane(pnlContadores);
                    
                    for(int i=0; i<numeroSegmentos; i++){
                        arrayBarritas[i] = new JProgressBar(0, cantidadNumeros/numeroSegmentos);
                        arrayBarritas[i].setStringPainted(true);
                        OrdenadorPanel temp = new OrdenadorPanel(String.format("Proceso %d", i+1), arrayBarritas[i]);
                        PrincipalFrame.this.add(temp);
                        
                        
                    }
                    
                    
                    
                    
                    btnStart = new JButton("Iniciar");
                    btnStart.addActionListener(new ActionListener() {
                    @Override
                        public void actionPerformed(ActionEvent ae) {
                          JProgressBar unificadorBar = new JProgressBar();
                          unificadorBar.setStringPainted(true);
                        OrdenadorPanel unificador = new OrdenadorPanel("UNIENDO SEGMENTOS", unificadorBar);
                        superOrdenador.ordenarLista(Generador.generarArray(cantidadNumeros), 
                                    numeroSegmentos, unificadorBar);
                        PrincipalFrame.this.add(unificador);
                        PrincipalFrame.this.repaint();
                        PrincipalFrame.this.setVisible(false);
                        PrincipalFrame.this.setVisible(true);
                        }
                    });
                    PrincipalFrame.this.add(btnStart);
                    superOrdenador = new MegaOrdenador(arrayBarritas);
                    PrincipalFrame.this.repaint();
                    PrincipalFrame.this.setVisible(false);
                    PrincipalFrame.this.setVisible(true);
                
                }
            }
            
        });
        mmArchivo.add(nnElegirParametros);
        menu.add(mmArchivo);
        
        return menu;
    }
}
