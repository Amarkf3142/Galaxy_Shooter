/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaxy.shooter;

/**
 *
 * @author amar
 */import javax.swing.ImageIcon;

public class Enemy extends Sprite {

    private Bullet bullet;

    public Enemy(int x, int y) {

        initAnimy(x, y);
    }

    private void initAnimy(int x, int y) {

        this.x = x;
        this.y = y;

        bullet = new Bullet(x, y);

        String animyImg = "src/images/animy1.png";
        ImageIcon ii = new ImageIcon(animyImg);

        setImage(ii.getImage());
    }

    public void act(int direction) {

        this.x += direction;
    }

    public Bullet getBomb() {

        return bullet;
    }

    public class Bullet extends Sprite{

        private boolean destroyed;

        public Bullet(int x, int y) {

            initBullet(x, y);
        }

        private void initBullet(int x, int y) {

            setDestroyed(true);

            this.x = x;
            this.y = y;

            String bulletImg = "src/images/Bullet1.png";
            ImageIcon ii = new ImageIcon(bulletImg);
            setImage(ii.getImage());
        }

        public void setDestroyed(boolean destroyed) {

            this.destroyed = destroyed;
        }

        public boolean isDestroyed() {

            return destroyed;
        }
    }
}