import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class BackgroundImageJFrame extends JFrame
{
    JButton b1;
    JLabel l1;

    public BackgroundImageJFrame()
    {
        setTitle("Background Color for JFrame");
      //  setSize(800,800);
       //setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        /*
        One way
        -----------------
        setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("C:\\Users\\Computer\\Downloads\\colorful design.png"));
        add(background);
        background.setLayout(new FlowLayout());
        l1=new JLabel("Here is a button");
        b1=new JButton("I am a button");
        background.add(l1);
        background.add(b1);
        */

        // Another way
        //add(new ImagePanel());
        ImagePanel panel = new ImagePanel(
        new ImageIcon("src/images/animy3.png").getImage());
         add(panel);
        setSize(399,399);
        setSize(400,400);
        setSize(1800,800);
    }

    public static void main(String args[])
    {
        new BackgroundImageJFrame();
    }
} 