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
import java.awt.*;  
import java.awt.event.*;  
import java.sql.*;  
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Registration extends JFrame implements ActionListener   
{  Connection con;
    JLabel l1, l2, l3, l4, l5, l6, l7;  
    JTextField tf1, tf2,tf3, tf5, tf6;  
    JButton btn1, btn2,btn3;  
    JPasswordField p1, p2;  
    Registration()  
    {  
        setVisible(true);  
        setSize(700, 700);  
        setLayout(null);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setTitle("User Registration");  
        l1 = new JLabel("Registration");  
        l1.setForeground(Color.blue);  
        l1.setFont(new Font("Serif", Font.BOLD, 20));  
        l2 = new JLabel("Game ID:");  
        l3 = new JLabel("Email-ID:");  
        l4 = new JLabel("Create Passowrd:");  
        l5 = new JLabel("Confirm Password:");  
        l6 = new JLabel("Country:");  
        //l7 = new JLabel("State:");  
        l7 = new JLabel("Name:");   
        tf1 = new JTextField();  
        tf2 = new JTextField();
        tf3=new JTextField();
        p1 = new JPasswordField();  
        p2 = new JPasswordField();  
        tf5 = new JTextField();  
        //tf6 = new JTextField();  
        tf6 = new JTextField();  
        btn1 = new JButton("Submit");  
        btn2 = new JButton("Clear");  
         btn3 = new JButton("Cancel");  
        btn1.addActionListener(this);  
        btn2.addActionListener(this); 
        btn3.addActionListener(this); 
        l1.setBounds(100, 30, 400, 30);  
        l2.setBounds(80, 70, 200, 30);  
        l7.setBounds(80, 110, 200, 30);  
        l3.setBounds(80, 150, 200, 30);  
        l4.setBounds(80, 190, 200, 30);  
        l5.setBounds(80, 230, 200, 30);  
        //l7.setBounds(80, 270, 200, 30);  
        l6.setBounds(80, 270, 200, 30);  
        tf1.setBounds(300, 70, 200, 30);  
        tf2.setBounds(300, 110, 200, 30);  
        tf3.setBounds(300, 150, 200, 30);  
        p1.setBounds(300, 190, 200, 30);  
        p2.setBounds(300, 230, 200, 30);  
       // tf5.setBounds(300, 300, 200, 30);  
       // tf6.setBounds(300, 270, 200, 30);  
        tf6.setBounds(300, 270, 200, 30);  
        btn1.setBounds(50, 350, 100, 30);  
        btn2.setBounds(170, 350, 100, 30);  
         btn3.setBounds(300, 350, 100, 30);  
        add(l1);  
        add(l2);  
        add(tf1);  
        add(l3);  
        add(tf2);  
        add(l4);
        add(tf3);
        add(p1);  
        add(l5);  
        add(p2);  
        add(l6);  
        add(tf5);  
       // add(l7);  
        //add(tf6);  
        add(l7);  
        add(tf6);  
        add(btn1);  
        add(btn2);
        add(btn3);
    }  
    public void actionPerformed(ActionEvent e)   
    {  
        if (e.getSource() == btn1)  
         { 
            String PATTERN1="[0-9]+";
            Pattern patt1=Pattern.compile(PATTERN1);
            Matcher match1=patt1.matcher(tf1.getText());
            if(!match1.matches())
            {tf1.setText("");  
            JOptionPane.showMessageDialog(null,"Invalid ID","Display Message",JOptionPane.INFORMATION_MESSAGE);            
            }
            
            String PATTERN="^[(a-zA-Z1-9.+)@(.+)]{0,30}$";
            Pattern patt=Pattern.compile(PATTERN);
            Matcher match=patt.matcher(tf3.getText());
            if(!match.matches())
            {tf3.setText("");  
            JOptionPane.showMessageDialog(null,"Invalid email address","Display Message",JOptionPane.INFORMATION_MESSAGE);            
            }
           
            String PATTERN2="[A-Za-z_]+";
            Pattern patt2=Pattern.compile(PATTERN2);
            Matcher match2=patt2.matcher(tf2.getText());
            if(!match2.matches())
            {tf2.setText("");  
            JOptionPane.showMessageDialog(null,"Invalid Name","Display Message",JOptionPane.INFORMATION_MESSAGE);            
            }
          
             String PATTERN3="[A-Za-z_]+";
            Pattern patt3=Pattern.compile(PATTERN3);
            Matcher match3=patt3.matcher(tf6.getText());
            if(!match3.matches())
            {tf6.setText("");  
            JOptionPane.showMessageDialog(null,"Invalid Name","Display Message",JOptionPane.INFORMATION_MESSAGE);            
            }
            
            int x = 0;  
            String s1 = tf1.getText();  
            String s2 = tf2.getText();
            String s3 = tf3.getText();  
            char[] s4 = p1.getPassword();  
            char[] s5 = p2.getPassword();   
            String s8 = new String(s4);  
            String s9 = new String(s5);  
            String s6 = tf6.getText();  
            
           // String s7 = tf7.getText(); 
          if(tf1.getText().equals("") &tf2.getText().equals("")&tf3.getText().equals("")&p1.getText().equals("")&p2.getText().equals("")&tf6.getText().equals(""))
          {
            JOptionPane.showMessageDialog(null,"Please Enter Data","Display Message",JOptionPane.INFORMATION_MESSAGE);            
          }
            if (s8.equals(s9))  
            {  
                try  
                {  
                     Class.forName("org.apache.derby.jdbc.ClientDriver");
                     con=DriverManager.getConnection("jdbc:derby://localhost:1527/Galaxyshooter","gs","gs");
                     PreparedStatement ps=con.prepareStatement("insert into GS.register values(?,?,?,?,?)");
                    ps.setString(1, s1);  
                    ps.setString(2, s2);  
                    ps.setString(3, s3);  
                    ps.setString(4, s8);  
                    ps.setString(5, s6);  
                    ps.executeUpdate();
                   JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");  
                    ResultSet rs = ps.executeQuery();  con.close(); 
                     JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");  
                   
                }  
                catch (Exception ex)   
                    
                {  
                    System.out.println(ex);  
                }  }}
            
            else  
            {  
                JOptionPane.showMessageDialog(btn1, "Password Does Not Match");  
            }   
         
          if (e.getSource() == btn2)  
       
          {  
            tf1.setText("");  
            tf2.setText("");  
            p1.setText("");  
            p2.setText("");  
            tf5.setText("");  
            tf6.setText("");  
           
          }  
        if (e.getSource() == btn3)  
         { 
         dispose();}
    }   
   
}  