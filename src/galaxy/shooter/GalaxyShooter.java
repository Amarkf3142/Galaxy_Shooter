/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaxy.shooter;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GalaxyShooter extends JFrame  {
     int BorderW =1200;
    int BorderH =1600;
    private GamePage gamePage;
    JLabel label;
    public GalaxyShooter() {

        initUI();
    }

    private void initUI() {
       //Design panel=new Design(new ImageIcon("src/images/spark.png").getImage());
      // getContentPane();
     
        add(new Design());
        
        setTitle("Space Invaders");
        setSize(BorderW, BorderH);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);}
    

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

             GalaxyShooter ex = new GalaxyShooter();
            ex.setVisible(true);
        });
    }
}