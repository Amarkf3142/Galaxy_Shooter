/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaxy.shooter;



import static galaxy.shooter.GamePage.level;
import static galaxy.shooter.ScoreCard.level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author amar
 */
public class addScore {
    static int level,tootalscore,name;
    public addScore(){
    try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Galaxyshooter", "gs", "gs");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from gs.score where level=(select max(level) from score WHERE ID="+LoginPage.id+")");
                   
            while (rs.next()) {
               
                level= rs.getInt(2);
               tootalscore=rs.getInt(3);
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
            ResultSet rs = st.executeQuery("select * from gs.register where NAME="+LoginPage.id);
            while (rs.next()) {
               
               name=rs.getInt(5);
                {
                    break;
                }
            }
           } catch (Exception ee) {
        }
     score s=new score();
}}
