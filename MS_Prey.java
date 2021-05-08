
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
 * @author 
 * @version
 */
public class MS_Prey extends JPanel {
    
    Image img;
    /**
     * Constructor for objects of class Prey
     */
    public MS_Prey(String img_path, int width, int height)
    {
        img = new ImageIcon(img_path).getImage();
        //img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        Dimension size = new Dimension(width, height);
        setPreferredSize(size);
    }  
    
    public void paintComponent(Graphics g) {
        g.drawImage(img, 200, 200, null);
        repaint();
               
    }
    
    public static void main(String[] args) {        
       JFrame frame = new JFrame("Image demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MS_Prey panel = new MS_Prey("images/smile.png", 100, 100);
        
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
    
    /**
     * Method randomplacement
     * this method is used for random placement in frame
     */
    public void randomplacement(){
      
    }
}
