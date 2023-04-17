package galaxy.shooter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amar
 */import javax.swing.ImageIcon;

public class Bomb extends Sprite {

    public Bomb() {
    }

    public Bomb(int x, int y) {

        initBomb(x, y);
    }

    private void initBomb(int x, int y) {

        String shotImg = "src/images/player.png";
        ImageIcon ii = new ImageIcon(shotImg);
        setImage(ii.getImage());

        int H_SPACE = 66;
        setX(x + H_SPACE);

        int V_SPACE = 1;
        setY(y - V_SPACE);
    }
}