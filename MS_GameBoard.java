import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

abstract class MS_GameBoard extends JPanel {    
    int xcells = 30;    
    int ycells = 30;
    int szcell = 10;       
       
    public MS_GameBoard () {
        setPreferredSize(new Dimension(xcells * szcell, ycells * szcell));        
        setBackground(Color.black);
        setFocusable(true);        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    /**
     * Method boardvisible
     * this method is used to visible the board on screen
     */
    abstract void boardvisible();
    
    /**
     * Method boardminimize
     * this method is used to minimized the board
     */
    abstract void boardminimize();
    
    /**
     * Method boardmaximize
     * this method is used to maximized the board
     */
    abstract void boardmaximize();
    
    /**
     * Method boardresize
     * this method is used to resize the board
     */
    abstract void boardresize();
    
    /**
     * Method boardclose
     * this method is used to close the board
     */
    abstract void boardclose();
    
}
