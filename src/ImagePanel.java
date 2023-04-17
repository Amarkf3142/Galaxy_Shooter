import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Sachi
 */
class ImagePanel extends JPanel {
  JButton b1=new JButton("bnfghjkj");
  int size=50;
  private Image img;
  public ImagePanel(String img) {
    this(new ImageIcon(img).getImage());
  }
  public ImagePanel(Image img) {
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
      add(b1);
  }
  
    ImagePanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  @Override
  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
  }
}