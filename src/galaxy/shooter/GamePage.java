/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaxy.shooter;

import galaxy.shooter.PassWordDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import galaxy.shooter.GalaxyShooter;
import static galaxy.shooter.PassWordDialog.loginname;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.swing.UIManager.getString;
import javax.swing.text.html.HTML;
import static javax.swing.text.html.HTML.Attribute.ID;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author amar
 */
public class GamePage extends JFrame implements ActionListener {

    //declaration
    int x, y, width = 300, height = 300, playerw = 200, playerh = 200;
    JButton b1, b2, b3, b4, b5, b6, player1, player2, player3, player4;

    JLabel l1;
    Label l2, l3, l4, l5, l6, l7, l8, l9, l11, l10, l12, l13;
    JTextField text1;
    static int flag, id, level, tootalscore, NM, stopsound, Playerimg;
    String name;
    int game = 0;
    //final HTML.Attribute id=ID;
    String d = String.valueOf(ID);

    ;
    //initilazition
   
     public void my_update(String ID) {
        String a = ID;

    }

    public GamePage() throws IOException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Galaxyshooter", "gs", "gs");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from gs.register where id=" + LoginPage.id);

            while (rs.next()) {

                name = rs.getString(2);

                {
                    break;
                }
            }
        } catch (Exception ee) {
        }
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Galaxyshooter", "gs", "gs");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from gs.score where id=" + LoginPage.id);

            while (rs.next()) {

                level = rs.getInt(2);
                tootalscore = rs.getInt(3);
                {
                    break;
                }
            }

        } catch (Exception ee) {
        }

        setContentPane(new JLabel(new ImageIcon("src/images/space.png")));
        b1 = new JButton();
        b1.setBounds(600, 250, width, height);
        Image image = ImageIO.read(new File("src/images/animy1.png")).getScaledInstance(width, height, Image.SCALE_DEFAULT);
        b1.setIcon(new ImageIcon(image));
        b2 = new JButton();
        b2.setBounds(1000, 250, width, height);
        Image image1 = ImageIO.read(new File("src/images/animy3_1.png")).getScaledInstance(width, height, Image.SCALE_DEFAULT);
        b2.setIcon(new ImageIcon(image1));
        player1 = new JButton();
        player1.setBounds(400, 550, width, height);
        Image pimage1 = ImageIO.read(new File("src/images/plane5.png")).getScaledInstance(width, height, Image.SCALE_DEFAULT);
        player1.setIcon(new ImageIcon(pimage1));
        player2 = new JButton();
        player2.setBounds(700, 550, width, height);
        Image pimage2 = ImageIO.read(new File("src/images/plane6.png")).getScaledInstance(width, height, Image.SCALE_DEFAULT);
        player2.setIcon(new ImageIcon(pimage2));
        player3 = new JButton();
        player3.setBounds(1000, 550, width, height);
        Image pimage3 = ImageIO.read(new File("src/images/plane1.png")).getScaledInstance(width, height, Image.SCALE_DEFAULT);
        player3.setIcon(new ImageIcon(pimage3));
        player4 = new JButton();
        player4.setBounds(1300, 550, width, height);
        Image pimage4 = ImageIO.read(new File("src/images/Player2.png")).getScaledInstance(width, height, Image.SCALE_DEFAULT);
        player4.setIcon(new ImageIcon(pimage4));
        l2 = new Label("Choose your Enemy");
        l2.setBounds(780, 200, 300, 50);
        l2.setFont(new Font("serif", Font.BOLD, 32));
        l2.setForeground(Color.red);
        l3 = new Label("You won");
        l3.setBounds(200, 330, 200, 25);
        l3.setFont(new Font("serif", Font.BOLD, 22));
        l3.setForeground(Color.red);
        l4 = new Label("You lost");
        l4.setBounds(200, 300, 100, 50);
        l4.setFont(new Font("serif", Font.BOLD, 22));
        l4.setForeground(Color.red);
        l5 = new Label("You Lost a Galaxy");
        l5.setBounds(70, 30, 200, 25);
        l5.setFont(new Font("serif", Font.BOLD, 22));
        l5.setForeground(Color.red);
        b6 = new JButton("" + LoginPage.id);
        b6.setBounds(1700, 20, 100, 40);
        b6.setFont(new Font("serif", Font.BOLD, 22));
        b6.setForeground(Color.red);
        l9 = new Label("" + LoginPage.id);
        l9.setBounds(1700, 50, 100, 25);
        l9.setFont(new Font("serif", Font.BOLD, 22));
        l9.setForeground(Color.red);
        l6 = new Label("" + name);
        l6.setBounds(1700, 80, 100, 25);
        l6.setFont(new Font("serif", Font.BOLD, 22));
        l6.setForeground(Color.red);
        l7 = new Label("" + level);
        l7.setBounds(1700, 110, 100, 25);
        l7.setFont(new Font("serif", Font.BOLD, 22));
        l7.setForeground(Color.red);
        l8 = new Label("" + GamePage.tootalscore);
        l8.setBounds(1700, 140, 100, 25);
        l8.setFont(new Font("serif", Font.BOLD, 22));
        l8.setForeground(Color.red);
        b3 = new JButton("*" + Design.score);
        b3.setBounds(1750, 800, 100, 60);
        b3.setFont(new Font("serif", Font.BOLD, 22));
        b3.setForeground(Color.red);
        text1 = new JTextField(10);
        text1.setBounds(30, 0, 100, 60);
        text1.setFont(new Font("serif", Font.BOLD, 22));
        text1.setForeground(Color.red);
        String a = text1.getText();
        b4 = new JButton("Login");
        b4.setBounds(30, 80, 100, 60);
        b4.setFont(new Font("serif", Font.BOLD, 22));
        b4.setForeground(Color.red);
        b5 = new JButton("Logout");
        b5.setBounds(1170, 20, 200, 40);
        b5.setFont(new Font("serif", Font.BOLD, 22));
        b5.setForeground(Color.red);
        l10 = new Label("Level 1 to 10");
        l10.setBounds(400, 550, 200, 25);
        l10.setFont(new Font("serif", Font.BOLD, 22));
        l10.setForeground(Color.red);
        l11 = new Label("Level 11 to 30");
        l11.setBounds(700, 550, 200, 25);
        l11.setFont(new Font("serif", Font.BOLD, 22));
        l11.setForeground(Color.red);
        l12 = new Label("Level 31 to 70");
        l12.setBounds(1000, 550, 200, 25);
        l12.setFont(new Font("serif", Font.BOLD, 22));
        l12.setForeground(Color.red);
        l13 = new Label("level 71 ");
        l13.setBounds(1300, 550, 200, 25);
        l13.setFont(new Font("serif", Font.BOLD, 22));
        l13.setForeground(Color.red);
        if (text1.getText() == " ") {
            String aa = text1.getText();
            id = Integer.parseInt(aa);
        }

        //revwrse
        add(b1);

        //   else{add(text1);}
        add(b2);
        add(l2);
        add(b3);
        if (LoginPage.id == 0) {
            add(b4);
        } else {
            add(b5);
        }
        add(b6);
        add(l10);
        add(l11);
        add(l6);
        add(l12);
        add(l13);
        add(l7);
        add(l8);
        add(player1);
        add(player2);
        add(player3);
        add(player4);

        if (Design.gameEnd == 1) {
            add(l3);
        }
        if (Design.gameEnd == 2) {
            add(l4);
        }
        if (Design.gameEnd == 3) {
            add(l5);
        }

        setVisible(true);
        setSize(2000, 1000);
        setLayout(null);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b5.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) { //this.setVisible(false);
            flag = 1;
            dispose();
            new GalaxyShooter().setVisible(true);

        }
        if (ae.getSource() == b2) {
            flag = 0;

            new GalaxyShooter().setVisible(true);

        }
        if (ae.getSource() == b4) {
            new LoginPage();

        }
        if (ae.getSource() == b3) {

            String image = "src/images/space1.png";;
            Playerimg = Integer.parseInt(image);
        }
        if (ae.getSource() == b5) {
            dispose();
            LoginPage.id = 0;
            try {
                GamePage g = new GamePage();
            } catch (IOException ex) {
                Logger.getLogger(GamePage.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        GamePage g = new GamePage();
    }

}
