/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaxy.shooter;

import javax.swing.*;

/**
 *
 * @author amar
 */
//import static galaxy.shooter.GamePage;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class score extends JFrame {

    static int loginname;
    static int LEVEL,SCORE;
    // private Registration  registration;
    private ScoreCard scoreCard;
    

    public score() {
        scoreCard = new ScoreCard(this, false);
        scoreCard.setVisible(true);
    }

    public void run() {
        JFrame frame = new LoginPage();
        frame.getContentPane().setBackground(Color.white);
        frame.setTitle("Score");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}

class ScoreCard extends JDialog {
   static int level, tootalscore,nextlevel;
     int l=addScore.level + 1;
     int s=addScore.tootalscore + Design.score ;
    static int loginname;
    private  JLabel l1 = new JLabel("Well Done");
    private  JLabel l2 = new JLabel("Level " + l + " completed");
    private  JLabel l3 = new JLabel("Game Score: " + s);
    private  JLabel l4 = new JLabel("Score: " + Design.score);
   
    private final JButton b1 = new JButton("Home");
     private final JLabel jlblStatus = new JLabel(" ");
    public String id;
   

    public ScoreCard() {
        this(null, true);
    }

    public ScoreCard(final JFrame parent, boolean modal) {
        super(parent, modal);

        JPanel p3 = new JPanel(new GridLayout(4, 1));
        p3.add(l1);
        p3.add(l2);
        p3.add(l3);
        p3.add(l4);

        JPanel p1 = new JPanel();
        p1.add(p3);

        JPanel p2 = new JPanel();
        p2.add(b1);
        

        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(p2, BorderLayout.CENTER);
        p5.add(jlblStatus, BorderLayout.NORTH);
        jlblStatus.setForeground(Color.RED);
        jlblStatus.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER);
        add(p5, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        int ID = LoginPage.id;
        int a =  addScore.level+1;
        int b = addScore.tootalscore+Design.score;
        int id1=0;
        
         try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Galaxyshooter", "gs", "gs");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from gs.score where id="+ID);
           while (rs.next()) {

                id1 = rs.getInt(1);

                {
                    break;
                }
            }
        } catch (Exception ex) {
        }
        if (id1==ID){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Galaxyshooter", "gs", "gs");
            PreparedStatement ps = con.prepareStatement("update gs.score set level=?,tootalscore=? where id="+ID);
            ps.setInt(1, a);
            ps.setInt(2, b);
            ps.executeUpdate();
           // ResultSet rs = ps.executeQuery();
            con.close();
        } catch (Exception ex) {
        }
         }
         else{
             try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Galaxyshooter", "gs", "gs");
            PreparedStatement ps = con.prepareStatement("insert into gs.score (id,level,tootalscore) values(?,?,?)");
            ps.setInt(1, ID);
            ps.setInt(2, a);
            ps.setInt(3, b);
            ps.executeUpdate();
           // ResultSet rs = ps.executeQuery();
            con.close();
        } catch (Exception ex) {
        }
}
          
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //System.exit(0);  
            }
        });

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {dispose();
                    GamePage g = new GamePage();
                } catch (IOException ex) {
                    Logger.getLogger(ScoreCard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        

    }
}
