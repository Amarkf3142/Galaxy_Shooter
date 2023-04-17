/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaxy.shooter;
/**
 *
 * @author amar
 */

import javax.swing.*;  
import java.awt.event.*;  
public class ID extends JFrame implements ActionListener   {  
JFrame f;  
JLabel l1,l2,l3;
JButton b1;
ID(){  setSize(300, 300);  
        setLayout(null);  
       
    
    f=new JFrame();  
        f.setSize(300, 300);  
        f.setLayout(null);  
        f. setExtendedState(JFrame.MAXIMIZED_BOTH);
    l1=new JLabel(""+GamePage.level);
    l2=new JLabel(""+GamePage.tootalscore);
    l3=new JLabel(""+LoginPage.id);
    b1=new JButton("Close");
    l1.setBounds(40, 30, 40, 30);  
    l2.setBounds(40, 60, 40, 30);  
    l3.setBounds(40, 90, 40, 30);  
    b1.setBounds(40, 110, 80, 40);  
    b1.addActionListener(this);
    
   add(l1);
   add(l2);
   add(l3);
   add(b1);
    
}  
 public void actionPerformed(ActionEvent e)   
    { 
         if (e.getSource() == b1)  
         {  
             dispose();
         }
    }

public static void main(String[] args) {  
    new  ID();
}     
}  