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

import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

public class Player extends Sprite {

    private int width;

    public Player() {

        initPlayer();
    }

    private void initPlayer() {
        
if(GamePage.level<11){
       String playerImg = "src/images/plane5.png";
        ImageIcon ii = new ImageIcon(playerImg);

        width = 530;
        setImage(ii.getImage());

        int START_X = 550;
        setX(START_X);

        int START_Y = 780;
        setY(START_Y);
} 
else if(GamePage.level>10 && GamePage.level<31){
    String playerImg = "src/images/plane6.png";
        ImageIcon ii = new ImageIcon(playerImg);

        width = 500;
        setImage(ii.getImage());

        int START_X = 550;
        setX(START_X);

        int START_Y = 780;
        setY(START_Y);
}
else if(GamePage.level>30 && GamePage.level<71){
    String playerImg = "src/images/plane1.png";
        ImageIcon ii = new ImageIcon(playerImg);

        width = 500;
        setImage(ii.getImage());

        int START_X = 550;
        setX(START_X);

        int START_Y = 780;
        setY(START_Y);
}
 else{
    String playerImg = "src/images/Player2.png";
        ImageIcon ii = new ImageIcon(playerImg);

        width = 500;
        setImage(ii.getImage());

        int START_X = 550;
        setX(START_X);

        int START_Y = 780;
        setY(START_Y);
}
    
    
    }
      
    public void act() {

        x += dx;
        

        if (x <= 1) {

            x = 1;
        }

        if (x >= 2065 - 2 * width) {

            x = 2065 - 2 * width;
        }
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = -5;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 5;
        }
         if (key == KeyEvent.VK_UP) {

            dx= -5;
        }
          if (key == KeyEvent.VK_DOWN) {

            dx = 5;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 0;
        }
         if (key == KeyEvent.VK_UP) {

            dx = 0;
    }
          if (key == KeyEvent.VK_DOWN) {

            dx = 0;
}
    }}