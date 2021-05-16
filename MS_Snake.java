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
        
        Dimension size = new Dimension(10, 10);
        setPreferredSize(size);
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
