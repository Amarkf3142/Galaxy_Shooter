package galaxy.shooter;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import static galaxy.shooter.GamePage.level;
import static galaxy.shooter.LoginPage.id;
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

public class LoginPage extends JFrame {
 static int tootalscore,Level;

    static int loginname,id;
    // private Registration  registration;
    private PassWordDialog passDialog;
    

    public LoginPage() {
        passDialog = new PassWordDialog(this, false);
        passDialog.setVisible(true);
    }

   
            public void run() {
                JFrame frame = new LoginPage();
                frame.getContentPane().setBackground(Color.BLACK);
                frame.setTitle("Logged In");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                
              //  frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        
    }

class PassWordDialog extends JDialog {
     static int loginname;

    private final JLabel jlblUsername = new JLabel("Game ID");
    private final JLabel jlblPassword = new JLabel("Password");

    private final JTextField jtfUsername = new JTextField(15);
    private final JPasswordField jpfPassword = new JPasswordField();

    private final JButton jbtOk = new JButton("Login");
    private final JButton jbtCancel = new JButton("Cancel");
    private final JButton jbtSignup = new JButton("SignUp");

    private final JLabel jlblStatus = new JLabel(" ");
     
    GamePage m;
    public PassWordDialog() {
        this(null, true);
    }
   
   
    
    public PassWordDialog(final JFrame parent, boolean modal) {
        super(parent, modal);
       
        String ID=jtfUsername.getText();
        JPanel p3 = new JPanel(new GridLayout(2, 1));
        p3.add(jlblUsername);
        p3.add(jlblPassword);

        JPanel p4 = new JPanel(new GridLayout(2, 1));
        p4.add(jtfUsername);
        p4.add(jpfPassword);

        JPanel p1 = new JPanel();
        p1.add(p3);
        p1.add(p4);

        JPanel p2 = new JPanel();
        p2.add(jbtOk);
        p2.add(jbtCancel);
        p2.add(jbtSignup);

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

        addWindowListener(new WindowAdapter() {  
            @Override
            public void windowClosing(WindowEvent e) {  
                //System.exit(0);  
            }  
        });


        jbtOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
               
                String a=jtfUsername.getText(); id=Integer.parseInt(a);
                String b=jpfPassword.getText();
        try
        {
            int f=0;
            
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Galaxyshooter","gs","gs");
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select * from GS.register");
                while(rs.next())
                {if(rs.getString(1).equals(a) && rs.getString(4).equals(b))
                {f=1;
                break;
                
                }
                 }
                    
                if (f==1){
                   loginname=1;
                    EventQueue.invokeLater(new Runnable() {
                       @Override
                       public void run() {
                           try {
                              m=new GamePage();
                             // m.GamePage();
                             
                               dispose();
                           } catch (IOException ex) {
                           }
                       }
                   });
                   }
                else{
                   JOptionPane.showMessageDialog(null,"Invalid password","Message",JOptionPane.INFORMATION_MESSAGE);
                }
               
        }catch(Exception ee){}
            }
             });
                
               
        jbtCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                parent.dispose();
               // System.exit(0);
            }
        });
        jbtSignup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setVisible(false);
              new Registration().setVisible(true);                // System.exit(0);
            }
        });
        
    }
}
