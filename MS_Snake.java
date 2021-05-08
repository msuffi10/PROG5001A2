import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Write a description of class Snake here.
 *
 * @author (MS_Snake)
 * @version (1.0.0)
 */
public class MS_Snake extends JPanel
{
    
    Image head;
    Image tail;
    /**
     * Constructor for objects of class Snake
     */
    public MS_Snake() {
        // initialise instance variables  
        
        head = new ImageIcon("images/head.png").getImage();
        tail = new ImageIcon("images/tail.png").getImage();
        //img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        Dimension size = new Dimension(400, 400);
        setPreferredSize(size);
    }
        
    public void paintComponent(Graphics g) {
        g.drawImage(head, 100, 100, null);
        repaint();
        
        int starty = 150;
        int startx = 166;
        for(int a=1; a<=3;a++)
        {
            g.drawImage(tail, 100, starty, null);
            repaint();
            
            starty = starty + 50;
        }
        
        for(int a=1; a<=2;a++)
        {
            g.drawImage(tail, startx, 250, null);
            repaint();
            
            startx = startx + 66;
        }
        g.drawImage(tail, 230, 200, null);
        
    }
    
    public static void main(String[] args) {        
       JFrame frame = new JFrame("Image demo");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       MS_Snake panel = new MS_Snake();
       
       frame.add(panel);
       frame.setSize(800, 600);
       frame.setVisible(true);
    }
    
    /**
     * Method directionchange
     * this method use to change direction of snake through arrow keys
     */
    public void directionchange()
    {
        
    }
     
    /**
     * Method eatapple
     * this method use for snake to eat apple 
     */
    public void eatapple()
    {
        
    }

     /**
     * Method Speedup
     * the method use to snake speed increases once eat apple
     */
    public void Speedup()
    {
        
    }
    
    /**
     * Method growsnake
     * the method use to grow snake when it eat apple
     */
    public void growsnake()
    {
        
    }
}
