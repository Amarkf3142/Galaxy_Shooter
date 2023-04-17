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
import java.util.Random;
import static galaxy.shooter.LoginPage.Level;

import static galaxy.shooter.Design.playerw;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import galaxy.shooter.GamePage;
import static galaxy.shooter.ScoreCard.nextlevel;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import javax.swing.*;
import java.awt.event.AWTEventListener.*;
import sun.audio.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//Game Level
public class Design extends JPanel {

    private Dimension d;
    private List<Enemy> enemyes;
    private List<Enemy1> enemyes1;
    private Player player;
    private GamePage gamePage;
    private GalaxyShooter galaxyShooter;

    private Bullet bullet;

    public static int playerw = 150;
    private static int playerh = 150;

    private static int animyw = 100;
    private static int animyh = 100;

    private static int bulletw = 20;
    private static int bulleth = 50;
    private static int bombw = 70;
    private static int bombh = 70;
    // int flag = GamePage.flag;
    private Image img;
    int BorderW = 1070;
    int BorderH = 1600;
    int BorderRight = 1;
    int BorderLeft = 1;
    int soundtime;
    static int returnGalaxy;
    // to store current position
    Long currentFrame;
    Clip clip;

    // current status of clip
    String status;

    AudioInputStream audioInputStream;
    static String filePath;

    int Ground = 1180;
    int BombH = 5;

    int EnemyH = 120;
    int EnemyW = 120;
    int EnemyStartX = 300;
    int EnemyStartY = -200;

    int GODown = 150;
   
    int ToDestroyEnemy =GamePage.level - 1;
    int Chance = 5;
    int Delay = 20;
    int PlayerW = 100;
    int PlayerH = 100;

    private int direction = -1;
    private int deaths = 1;

    private boolean inGame = true;
    private String explImg = "src/images/spark.png";
    private String message = "Game Over";
    int gameround = 0;
    private Timer timer;
    static int gameEnd, stopSound, score, level;

    public Design() {
         try {
             
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Galaxyshooter", "gs", "gs");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from gs.score where id=" + LoginPage.id);

            while (rs.next()) {
                level = rs.getInt(2);
                {
                    break;
                }
            }
        } catch (Exception ee) {
        }
StartAudio1();
        createDesign();

        //startGame();
    }

    private void createDesign() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        d = new Dimension(BorderW, BorderH);
        setBackground(Color.black);

        timer = new Timer(Delay, new GameCycle());
        timer.start();

        startGame();

        //startGame_1();
    }

    private void goHome() {

        try {
            stopSound = 1;
            
            setVisible(false);
            returnGalaxy = 1;
            gamePage = new GamePage();
            //galaxyShooter =new GalaxyShooter();
        } catch (IOException ex) {
        }
    }

    private void startGame() {
       
        if (GamePage.flag == 1) {
            enemyes = new ArrayList<>();
            Random objGenerator = new Random();
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j<level+1; j++) {
                    int randomNumberX = objGenerator.nextInt(5);
                    int randomNumberY = objGenerator.nextInt(5);
                    Enemy enemy = new Enemy(EnemyStartX + 140 * randomNumberX, EnemyStartY + 100 * randomNumberY);
                    enemyes.add(enemy);
                }

                playerandBullet();
            }
        }
        else {
            enemyes1 = new ArrayList<>();

            Random objGenerator = new Random();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < level+1; j++) {
                 int randomNumberX = objGenerator.nextInt(5);
                    int randomNumberY = objGenerator.nextInt(5);
                    Enemy1 enemy1 = new Enemy1(EnemyStartX + 140 * randomNumberX, EnemyStartY + 100 * randomNumberY);
                    enemyes1.add(enemy1);

                }

                playerandBullet();
            }
        }
    }

    private void drawAnimyes(Graphics g) {
        if (GamePage.flag == 1) {
            for (Enemy animy : enemyes) {

                if (animy.isVisible()) {

                    g.drawImage(animy.getImage(), animy.getX(), animy.getY(), animyw, animyh, this);

                }

                if (animy.isDying()) {

                    animy.die();

                }
            }
        } else {
            for (Enemy1 animy1 : enemyes1) {

                if (animy1.isVisible()) {

                    g.drawImage(animy1.getImage(), animy1.getX(), animy1.getY(), animyw, animyh, this);

                }

                if (animy1.isDying()) {

                    animy1.die();

                }
            }
        }
    }

    private void playerandBullet() {
        player = new Player();
        bullet = new Bullet();
    }

    private void drawPlayer(Graphics g) {

        if (player.isVisible()) {

            g.drawImage(player.getImage(), player.getX(), player.getY(), playerw, playerh, this);
        }

        if (player.isDying()) {

            player.die();
            inGame = false;
        }
    }

    private void drawBullet(Graphics g) {

        if (bullet.isVisible()) {

            g.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), bulletw, bulleth, this);
            // g.drawImage(bullet.getImage() , bullet.getX() + 140, bullet.getY(), this);
        }
    }

    private void drawBombing(Graphics g) {
        if (GamePage.flag == 1) {
            for (Enemy a : enemyes) {

                Enemy.Bullet b = a.getBomb();

                if (!b.isDestroyed()) {

                    g.drawImage(b.getImage(), b.getX(), b.getY(), bombw, bombh, this);
                }
            }
        } else {
            for (Enemy1 a : enemyes1) {

                Enemy1.Bullet b = a.getBomb();

                if (!b.isDestroyed()) {

                    g.drawImage(b.getImage(), b.getX(), b.getY(), bombw, bombh, this);
                }
            }
        }
    }

    //For play audio
    public void SimpleAudioPlayer() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        // create AudioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

        //clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void StartAudio() {
        try {

            if (soundtime == 1) {   //for bullet sound
                filePath = "E:/Projects/bullet.wav";
            }
            if (soundtime == 2) {    //for enemy blast
                filePath = "E:/Projects/fire.wav";
            }
            if (soundtime == 3) {   //for plane blast
                filePath = "E:/Projects/explosion.wav";
            }
            if (soundtime == 4) {   //for game over
                filePath = "E:/Projects/gameover.wav";
            }

            SimpleAudioPlayer();

            //audioPlayer.play();
            clip.start();
            status = "play";

        } catch (Exception ex) {
            // System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }

    public void StartAudio1() {
        try {

            filePath = "";

            SimpleAudioPlayer();

            //audioPlayer.play(); 
            if (stopSound == 1) {
                clip.stop();
            } else {
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                status = "play";
                // clip.stop();
            }
            if (stopSound == 1) {
                clip.stop();
            }

        } catch (Exception ex) {
            // System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.green);

        if (inGame) {
             String Img = "src/images/space.JPG";
            ImageIcon ii = new ImageIcon(Img);
            g.drawImage(ii.getImage(), 10, 10, 1180, 1400, this);
            // score
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Score: " + score, 880, 30);
            g.setColor(Color.pink);
            g.drawString("Level: " + level, 880, 50);
            g.drawLine(0, Ground, BorderW, Ground);

            drawAnimyes(g);
            drawPlayer(g);
            drawBullet(g);
            drawBombing(g);

        } else {

            if (timer.isRunning()) {
                timer.stop();
                gameOver();
            }

            //  gameOver();
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void gameOver() {
        gameEnd = 2;//you lost
        soundtime = 4;
        StartAudio();
        goHome();

    }

    private void update() {
        if (deaths == ToDestroyEnemy) {
            timer.stop();
            soundtime = 4;
            gameEnd = 1;//won
            StartAudio();
            level++;
            addScore s = new addScore();
        }
        player.act();
        if (bullet.isVisible()) {
            int bulletX = bullet.getX();
            int bulletY = bullet.getY();
            if (GamePage.flag == 1) {
                for (Enemy animy : enemyes) {
                    int animyX = animy.getX();
                    int animyY = animy.getY();
                    if (animy.isVisible() && bullet.isVisible()) {
                        if (bulletX >= (animyX) && bulletX <= (animyX + EnemyW) && bulletY >= (animyY) && bulletY <= (animyY + EnemyH)) {
                            soundtime = 2;
                            StartAudio();
                            ImageIcon ii = new ImageIcon(explImg);
                            animy.setImage(ii.getImage());
                            animy.setDying(true);
                            deaths++;
                            score = deaths * 5;
                            bullet.die();
                        }
                    }
                }
            } else {
                for (Enemy1 animy1 : enemyes1) {
                    int animyX = animy1.getX();
                    int animyY = animy1.getY();
                    if (animy1.isVisible() && bullet.isVisible()) {
                        if (bulletX >= (animyX) && bulletX <= (animyX + EnemyW)
                                && bulletY >= (animyY) && bulletY <= (animyY + EnemyH)) {
                            soundtime = 2;
                            StartAudio();
                            ImageIcon ii = new ImageIcon(explImg);
                            animy1.setImage(ii.getImage());
                            animy1.setDying(true);
                            deaths++;
                            score = deaths * 5;
                            bullet.die();
                        }
                    }
                }
            }
            int y = bullet.getY();
            y -= 13;
            if (y < 0) {
                bullet.die();
            } else {
                bullet.setY(y);
            }
        }
        // enemyes
        if (GamePage.flag == 1) {
            for (Enemy animy : enemyes) {
                int x = animy.getX();
                if (x >= BorderW - BorderRight && direction != -1) {
                    direction = -1;
                    Iterator<Enemy> i1 = enemyes.iterator();
                    while (i1.hasNext()) {
                        Enemy a2 = i1.next();
                        a2.setY(a2.getY() + GODown);
                    }
                }
                if (x <= BorderLeft && direction != 1) {
                    direction = 1;
                    Iterator<Enemy> i2 = enemyes.iterator();
                    while (i2.hasNext()) {
                        Enemy a = i2.next();
                        a.setY(a.getY() + GODown);
                    }
                }
            }
        } else {
            for (Enemy1 animy1 : enemyes1) {
                int x = animy1.getX();
                if (x >= BorderW - BorderRight && direction != -1) {
                    direction = -1;
                    Iterator<Enemy1> i1 = enemyes1.iterator();
                    while (i1.hasNext()) {
                        Enemy1 a2 = i1.next();
                        a2.setY(a2.getY() + GODown);
                    }
                }
                if (x <= BorderLeft && direction != 1) {
                    direction = 1;
                    Iterator<Enemy1> i2 = enemyes1.iterator();
                    while (i2.hasNext()) {
                        Enemy1 a = i2.next();
                        a.setY(a.getY() + GODown);
                    }
                }
            }
        }
        if (GamePage.flag == 1) {
            Iterator<Enemy> it = enemyes.iterator();

            while (it.hasNext()) {

                Enemy alien = it.next();

                if (alien.isVisible()) {

                    int y = alien.getY();

                    if (y > Ground - EnemyH) {
                        inGame = false;
                        soundtime = 4;
                        StartAudio();
                        message = "You Lost Galaxy!";
                    }

                    alien.act(direction);
                }
            }
        } else {
            Iterator<Enemy1> it = enemyes1.iterator();

            while (it.hasNext()) {

                Enemy1 alien = it.next();

                if (alien.isVisible()) {

                    int y = alien.getY();

                    if (y > Ground - EnemyH) {
                        inGame = false;
                        gameEnd = 3;//you lost galaxy
                        goHome();

                    }

                    alien.act(direction);
                }
            }
        }

        // bombs
        Random generator = new Random();
        if (GamePage.flag == 1) {
            for (Enemy animy : enemyes) {

                int bullet = generator.nextInt(15);
                Enemy.Bullet bomb = animy.getBomb();

                if (bullet == Chance && animy.isVisible() && bomb.isDestroyed()) {

                    bomb.setDestroyed(false);
                    bomb.setX(animy.getX());
                    bomb.setY(animy.getY());
                }

                int bombX = bomb.getX();
                int bombY = bomb.getY();
                int playerX = player.getX();
                int playerY = player.getY();

                if (player.isVisible() && !bomb.isDestroyed()) {

                    if (bombX >= (playerX) && bombX <= (playerX + PlayerW) && bombY >= (playerY) && bombY <= (playerY + PlayerH)) {
                        soundtime = 3;
                        StartAudio();
                        ImageIcon ii = new ImageIcon(explImg);
                        player.setImage(ii.getImage());
                        player.setDying(true);
                        bomb.setDestroyed(true);

                    }
                }

                if (!bomb.isDestroyed()) {

                    bomb.setY(bomb.getY() + 5);

                    if (bomb.getY() >= Ground - BombH) {

                        bomb.setDestroyed(true);

                    }

                }
            }
        } else {

            for (Enemy1 animy1 : enemyes1) {

                int bullet = generator.nextInt(15);
                Enemy1.Bullet bomb = animy1.getBomb();

                if (bullet == Chance && animy1.isVisible() && bomb.isDestroyed()) {

                    bomb.setDestroyed(false);
                    bomb.setX(animy1.getX());
                    bomb.setY(animy1.getY());
                }

                int bombX = bomb.getX();
                int bombY = bomb.getY();
                int playerX = player.getX();
                int playerY = player.getY();

                if (player.isVisible() && !bomb.isDestroyed()) {

                    if (bombX >= (playerX) && bombX <= (playerX + PlayerW) && bombY >= (playerY) && bombY <= (playerY + PlayerH)) {

                        ImageIcon ii = new ImageIcon(explImg);
                        player.setImage(ii.getImage());
                        player.setDying(true);
                        bomb.setDestroyed(true);

                    }
                }

                if (!bomb.isDestroyed()) {

                    bomb.setY(bomb.getY() + 5);

                    if (bomb.getY() >= Ground - BombH) {

                        bomb.setDestroyed(true);

                    }

                }
            }
        }
    }

    private void doGameCycle() {

        update();
        repaint();

    }

    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            doGameCycle();
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {

            player.keyPressed(e);

            int x = player.getX();
            int y = player.getY();

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_SPACE) {

                if (inGame) {

                    if (!bullet.isVisible()) {

                        bullet = new Bullet(x, y);
                        soundtime = 1;
                        StartAudio();
                    }
                }
            }
             if (key == KeyEvent.VK_S) {

                 timer.stop();
             }
             if (key == KeyEvent.VK_R) {

                 timer.start();
             }
        }
        

        public void keyPress(KeyEvent e) {

            player.keyPressed(e);

            int key = e.getKeyCode();
           
                    
                //createDesign();
            

        }
    }
}
