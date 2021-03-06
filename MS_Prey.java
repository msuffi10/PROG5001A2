
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Class Prey represents any prey object.
 *
 * @author Muhammad Suffian
 * @version
 */
public class MS_Prey extends JPanel {
    
    public Image prey_image, prey_image2;
    
    
    public int apple_x,apple_x2; 
    public int apple_y,apple_y2;
    /**
     * Constructor for objects of class Prey
     */
    public MS_Prey()
    {
        prey_image = new ImageIcon("resources/apple.png").getImage();
        prey_image2 = new ImageIcon("resources/apple.png").getImage();
    }  
    
    public void locateApple(int RAND_POS, int DOT_SIZE) {

        int r = (int) (Math.random() * RAND_POS);
        apple_x= ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * DOT_SIZE));
    }
    
    public void locateApple2(int RAND_POS, int DOT_SIZE) {

        int r = (int) (Math.random() * RAND_POS);
        apple_x2= ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple_y2 = ((r * DOT_SIZE));
    }
    
    public void checkApple(int x, int y , int RAND_POS, int DOT_SIZE) {

        if ((x == apple_x) && (y == apple_y)) {

            MS_GameBoard.dots++;
            locateApple(RAND_POS,DOT_SIZE);
        }
    }
    public void checkApple2(int x, int y , int RAND_POS, int DOT_SIZE) {

        if ((x == apple_x2) && (y == apple_y2)) {

            MS_GameBoard.dots2++;
            locateApple2(RAND_POS,DOT_SIZE);
        }
    }
    
    /**
     * Method randomplacement
     * this method is used for random placement in frame
     */
    public void randomplacement(){
      
    }
}
