/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;        
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author CES
 */

public class Memory extends JFrame{

Toolkit to = Toolkit.getDefaultToolkit();
Dimension dPantalla = to.getScreenSize();
int wScreen = (int) ((int) dPantalla.getWidth() * 1.2);
int hScreen = (int) ((int) dPantalla.getHeight() * 0.7);
    
    /**
     * @param args the command line arguments
     */
    
    Inicio P1;
    Nivel_1 P2;
               
    public static void main(String[] args) {
        // TODO code application logic here
        Memory MC = new Memory(); 
        MC.inicio();
    }
    
    void inicio()
    {
        P1 = new Inicio(this); 
        P1.setTitle("Memory");
        P1.setBounds(wScreen/3, hScreen/3, 370, 500);
        P1.setVisible(true);
        
        P2 = new Nivel_1(this);
        P2.setVisible(false);
        P2.segundos = 9999999;
        
    }
    
    void CambioPan1()
    {        
        P1.setVisible(false);
        P2.setVisible(true);
        P2.setTitle("Memory");
        P2.setBounds(wScreen/5, hScreen/3, 900, 655);
        P1.nivelT();
    }
    
    public void tiempo(int tempo)
    {
        P2.segundos = tempo;
        P2.segReinicio = tempo;
    }
    
    int[] cargaTablero()
    {
        int[] numbers = new int[16];
        int count = 0;
        
        while(count < 16) {
            Random r = new Random();
            int na = r.nextInt(8) + 1;
            int nvr = 0;
            
            for (int i = 0; i < 16; i++) {
                if(numbers[i] == na) {
                    nvr++;
                }
            }
            if(nvr < 2) {
                numbers[count] = na;
                count++;
            }//fin 
        } 
        return numbers;
    }//End cargaTablero
    
    
}
