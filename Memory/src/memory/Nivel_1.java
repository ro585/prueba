/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package memory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodri585
 */
public class Nivel_1 extends javax.swing.JFrame {

    /**
     * Creates new form Nivel_1
     */
    
    Memory INC;
    private boolean caraUp = false;
    private ImageIcon im1;
    private ImageIcon im2;
    private JButton[] pbtn = new JButton[2];
    private boolean primerc = false;
    private int puntos = 0;
    boolean cambiado = false; 
    boolean first1 = false;
    Thread hiloTempo;
    int segundos, segReinicio; 
    
    public Nivel_1(Memory inc) {
        initComponents();
        INC = inc;
        GImg();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        Runnable tempo = new Runnable() {
                @Override
                    public void run() {
                        while (true) {
                            try {     
                                writeTempo();
                                segundos--;
                                Thread.sleep(1000); 
                                writeTempo();
                                if(segundos == 0) 
                                {
                                    pierdo();
                                    reiniciar();
                                }                               
                            } catch (InterruptedException ex) {
                            } 
                        }   
                    }    
                };
                hiloTempo = new Thread(tempo);
                hiloTempo.start();
	
    }
   
    private void GImg() {
        int[] numbers = INC.cargaTablero();
        B1.setDisabledIcon(new ImageIcon(getClass().getResource("../Imgs/L"+numbers[0]+".jpg")));
        B2.setDisabledIcon(new ImageIcon(getClass().getResource("../Imgs/L"+numbers[1]+".jpg")));
        B3.setDisabledIcon(new ImageIcon(getClass().getResource("../Imgs/L"+numbers[2]+".jpg")));
        B4.setDisabledIcon(new ImageIcon(getClass().getResource("../Imgs/L"+numbers[3]+".jpg")));
        B5.setDisabledIcon(new ImageIcon(getClass().getResource("../Imgs/L"+numbers[4]+".jpg")));
        B6.setDisabledIcon(new ImageIcon(getClass().getResource("../Imgs/L"+numbers[5]+".jpg")));
        B7.setDisabledIcon(new ImageIcon(getClass().getResource("../Imgs/L"+numbers[6]+".jpg")));
        B8.setDisabledIcon(new ImageIcon(getClass().getResource("../Imgs/L"+numbers[7]+".jpg")));
        B9.setDisabledIcon(new ImageIcon(getClass().getResource("../Imgs/L"+numbers[8]+".jpg")));
        B10.setDisabledIcon(new ImageIcon(getClass().getResource("../Imgs/L"+numbers[9]+".jpg")));
        B11.setDisabledIcon(new ImageIcon(getClass().getResource("../Imgs/L"+numbers[10]+".jpg")));
        B12.setDisabledIcon(new ImageIcon(getClass().getResource("../Imgs/L"+numbers[11]+".jpg")));
        B13.setDisabledIcon(new ImageIcon(getClass().getResource("../Imgs/L"+numbers[12]+".jpg")));
        B14.setDisabledIcon(new ImageIcon(getClass().getResource("../Imgs/L"+numbers[13]+".jpg")));
        B15.setDisabledIcon(new ImageIcon(getClass().getResource("../Imgs/L"+numbers[14]+".jpg")));
        B16.setDisabledIcon(new ImageIcon(getClass().getResource("../Imgs/L"+numbers[15]+".jpg")));
    } //End GImg
    
    private void pulso(JButton btn) {
        
        if(!caraUp) {
            btn.setEnabled(false);
            im1 = (ImageIcon) btn.getDisabledIcon();
            pbtn[0] = btn;
            caraUp = true;
            primerc = false;
        }
        else {
            btn.setEnabled(false);
            im2 = (ImageIcon) btn.getDisabledIcon();
            pbtn[1] = btn;
            primerc = true;
            puntos += 20;
            gano();
        }
    }//pulso
    
    private void gano() {
        if(!B1.isEnabled() && !B2.isEnabled() && !B3.isEnabled() && !B4.isEnabled() && !B5.isEnabled() && !B6.isEnabled() && 
            !B7.isEnabled() && !B8.isEnabled() && !B9.isEnabled() && !B10.isEnabled() && !B11.isEnabled() && 
            !B12.isEnabled() && !B13.isEnabled() && !B14.isEnabled() && !B15.isEnabled() && !B16.isEnabled()) {
            JOptionPane.showMessageDialog(this, "Felicidades, usted ha ganado. Su puntaje es: "+puntos, "Win!!", JOptionPane.INFORMATION_MESSAGE);
            reiniciar();
        }
    }//gano
        
    private void pierdo()
    {
        JOptionPane.showMessageDialog(this, "Perdiste " + puntos, "You Lose!!!", JOptionPane.INFORMATION_MESSAGE);    
        reiniciar();
    }//pierdo
    
    private void compCartas() {
        if(caraUp && primerc) {
            
            if(im1.getDescription().compareTo(im2.getDescription()) != 0) {
                pbtn[0].setEnabled(true);
                pbtn[1].setEnabled(true);
                if(puntos > 10 ) puntos -= 10;
            }
            caraUp = false;
        }
    }//compCartas
        
        private void writeTempo()
        {
            int aux = (int) segundos;
	Tiempo.setText("Tiempo: " + aux);
        }//End writeTempo
        
    private void reiniciar() {        
        B1.setEnabled(true);
        B2.setEnabled(true);
        B3.setEnabled(true);
        B4.setEnabled(true);
        B5.setEnabled(true);
        B6.setEnabled(true);
        B7.setEnabled(true);
        B8.setEnabled(true);
        B9.setEnabled(true);
        B10.setEnabled(true);
        B11.setEnabled(true);
        B12.setEnabled(true);
        B13.setEnabled(true);
        B14.setEnabled(true);
        B15.setEnabled(true);
        B16.setEnabled(true);
        
        first1 = false;
        cambiado = false;
        GImg();        
        segundos = segReinicio; 
    }//reiniciar

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        B1 = new javax.swing.JButton();
        B2 = new javax.swing.JButton();
        B3 = new javax.swing.JButton();
        B4 = new javax.swing.JButton();
        B5 = new javax.swing.JButton();
        B6 = new javax.swing.JButton();
        B7 = new javax.swing.JButton();
        B8 = new javax.swing.JButton();
        B9 = new javax.swing.JButton();
        B10 = new javax.swing.JButton();
        B11 = new javax.swing.JButton();
        B12 = new javax.swing.JButton();
        B13 = new javax.swing.JButton();
        B14 = new javax.swing.JButton();
        B15 = new javax.swing.JButton();
        B16 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Tiempo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        B1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Anverso.jpg"))); // NOI18N
        B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B1MouseExited(evt);
            }
        });
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });
        jPanel1.add(B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 116, 180, 110));

        B2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Anverso.jpg"))); // NOI18N
        B2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B2MouseExited(evt);
            }
        });
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });
        jPanel1.add(B2, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 116, 180, 110));

        B3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Anverso.jpg"))); // NOI18N
        B3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B3MouseExited(evt);
            }
        });
        B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3ActionPerformed(evt);
            }
        });
        jPanel1.add(B3, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 116, 180, 110));

        B4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Anverso.jpg"))); // NOI18N
        B4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B4MouseExited(evt);
            }
        });
        B4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4ActionPerformed(evt);
            }
        });
        jPanel1.add(B4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 116, 180, 110));

        B5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Anverso.jpg"))); // NOI18N
        B5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B5MouseExited(evt);
            }
        });
        B5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5ActionPerformed(evt);
            }
        });
        jPanel1.add(B5, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 244, 180, 110));

        B6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Anverso.jpg"))); // NOI18N
        B6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B6MouseExited(evt);
            }
        });
        B6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B6ActionPerformed(evt);
            }
        });
        jPanel1.add(B6, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 244, 180, 110));

        B7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Anverso.jpg"))); // NOI18N
        B7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B7MouseExited(evt);
            }
        });
        B7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B7ActionPerformed(evt);
            }
        });
        jPanel1.add(B7, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 244, 180, 110));

        B8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Anverso.jpg"))); // NOI18N
        B8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B8MouseExited(evt);
            }
        });
        B8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B8ActionPerformed(evt);
            }
        });
        jPanel1.add(B8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 244, 180, 110));

        B9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Anverso.jpg"))); // NOI18N
        B9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B9MouseExited(evt);
            }
        });
        B9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B9ActionPerformed(evt);
            }
        });
        jPanel1.add(B9, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 372, 180, 110));

        B10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Anverso.jpg"))); // NOI18N
        B10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B10MouseExited(evt);
            }
        });
        B10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B10ActionPerformed(evt);
            }
        });
        jPanel1.add(B10, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 372, 180, 110));

        B11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Anverso.jpg"))); // NOI18N
        B11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B11MouseExited(evt);
            }
        });
        B11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B11ActionPerformed(evt);
            }
        });
        jPanel1.add(B11, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 372, 180, 110));

        B12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Anverso.jpg"))); // NOI18N
        B12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B12MouseExited(evt);
            }
        });
        B12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B12ActionPerformed(evt);
            }
        });
        jPanel1.add(B12, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 372, 180, 110));

        B13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Anverso.jpg"))); // NOI18N
        B13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B13MouseExited(evt);
            }
        });
        B13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B13ActionPerformed(evt);
            }
        });
        jPanel1.add(B13, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 500, 180, 110));

        B14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Anverso.jpg"))); // NOI18N
        B14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B14MouseExited(evt);
            }
        });
        B14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B14ActionPerformed(evt);
            }
        });
        jPanel1.add(B14, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 500, 180, 110));

        B15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Anverso.jpg"))); // NOI18N
        B15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B15MouseExited(evt);
            }
        });
        B15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B15ActionPerformed(evt);
            }
        });
        jPanel1.add(B15, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 500, 180, 110));

        B16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Anverso.jpg"))); // NOI18N
        B16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B16MouseExited(evt);
            }
        });
        B16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B16ActionPerformed(evt);
            }
        });
        jPanel1.add(B16, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, 180, 110));

        jButton1.setText("Reiniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        Tiempo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Tiempo.setForeground(new java.awt.Color(0, 0, 0));
        Tiempo.setText("Tiempo: 30");
        jPanel1.add(Tiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 120, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 630));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B9ActionPerformed
        // TODO add your handling code here:
        pulso(B9);
    }//GEN-LAST:event_B9ActionPerformed

    private void B8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B8ActionPerformed
        // TODO add your handling code here:
        pulso(B8);
    }//GEN-LAST:event_B8ActionPerformed

    private void B7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B7ActionPerformed
        // TODO add your handling code here:
        pulso(B7);
    }//GEN-LAST:event_B7ActionPerformed

    private void B6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B6ActionPerformed
        // TODO add your handling code here:
        pulso(B6);
    }//GEN-LAST:event_B6ActionPerformed

    private void B16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B16ActionPerformed
        // TODO add your handling code here:
        pulso(B16);
    }//GEN-LAST:event_B16ActionPerformed

    private void B5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5ActionPerformed
        // TODO add your handling code here:
        pulso(B5);
    }//GEN-LAST:event_B5ActionPerformed

    private void B15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B15ActionPerformed
        // TODO add your handling code here:
        pulso(B15);
    }//GEN-LAST:event_B15ActionPerformed

    private void B4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4ActionPerformed
        // TODO add your handling code here:
        pulso(B4);
    }//GEN-LAST:event_B4ActionPerformed

    private void B14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B14ActionPerformed
        // TODO add your handling code here:
        pulso(B14);
    }//GEN-LAST:event_B14ActionPerformed

    private void B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3ActionPerformed
        // TODO add your handling code here:
        pulso(B3);
    }//GEN-LAST:event_B3ActionPerformed

    private void B13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B13ActionPerformed
        // TODO add your handling code here:
        pulso(B13);
    }//GEN-LAST:event_B13ActionPerformed

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed
        // TODO add your handling code here:
        pulso(B2);
    }//GEN-LAST:event_B2ActionPerformed

    private void B12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B12ActionPerformed
        // TODO add your handling code here:
        pulso(B12);
    }//GEN-LAST:event_B12ActionPerformed

    private void B11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B11ActionPerformed
        // TODO add your handling code here:
        pulso(B11);
    }//GEN-LAST:event_B11ActionPerformed

    private void B10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B10ActionPerformed
        // TODO add your handling code here:
        pulso(B10);
    }//GEN-LAST:event_B10ActionPerformed

    private void B11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B11MouseExited
        // TODO add your handling code here:
        compCartas();
    }//GEN-LAST:event_B11MouseExited

    private void B2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B2MouseExited
        // TODO add your handling code here:
        compCartas();
    }//GEN-LAST:event_B2MouseExited

    private void B3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B3MouseExited
        // TODO add your handling code here:
        compCartas();
    }//GEN-LAST:event_B3MouseExited

    private void B4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B4MouseExited
        // TODO add your handling code here:
        compCartas();
    }//GEN-LAST:event_B4MouseExited

    private void B7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B7MouseExited
        // TODO add your handling code here:
        compCartas();
    }//GEN-LAST:event_B7MouseExited

    private void B6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B6MouseExited
        // TODO add your handling code here:
        compCartas();
    }//GEN-LAST:event_B6MouseExited

    private void B5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B5MouseExited
        // TODO add your handling code here:
        compCartas();
    }//GEN-LAST:event_B5MouseExited

    private void B1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B1MouseExited
        // TODO add your handling code here:
        compCartas();
    }//GEN-LAST:event_B1MouseExited

    private void B8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B8MouseExited
        // TODO add your handling code here:
        compCartas();
    }//GEN-LAST:event_B8MouseExited

    private void B9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B9MouseExited
        // TODO add your handling code here:
        compCartas();
    }//GEN-LAST:event_B9MouseExited

    private void B12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B12MouseExited
        // TODO add your handling code here:
        compCartas();
    }//GEN-LAST:event_B12MouseExited

    private void B10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B10MouseExited
        // TODO add your handling code here:
        compCartas();
    }//GEN-LAST:event_B10MouseExited

    private void B13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B13MouseExited
        // TODO add your handling code here:
        compCartas();
    }//GEN-LAST:event_B13MouseExited

    private void B14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B14MouseExited
        // TODO add your handling code here:
        compCartas();
    }//GEN-LAST:event_B14MouseExited

    private void B15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B15MouseExited
        // TODO add your handling code here:
        compCartas();
    }//GEN-LAST:event_B15MouseExited

    private void B16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B16MouseExited
        // TODO add your handling code here:
        compCartas();
    }//GEN-LAST:event_B16MouseExited

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed
        // TODO add your handling code here:
        pulso(B1);
    }//GEN-LAST:event_B1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        reiniciar();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B1;
    private javax.swing.JButton B10;
    private javax.swing.JButton B11;
    private javax.swing.JButton B12;
    private javax.swing.JButton B13;
    private javax.swing.JButton B14;
    private javax.swing.JButton B15;
    private javax.swing.JButton B16;
    private javax.swing.JButton B2;
    private javax.swing.JButton B3;
    private javax.swing.JButton B4;
    private javax.swing.JButton B5;
    private javax.swing.JButton B6;
    private javax.swing.JButton B7;
    private javax.swing.JButton B8;
    private javax.swing.JButton B9;
    private javax.swing.JLabel Tiempo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
