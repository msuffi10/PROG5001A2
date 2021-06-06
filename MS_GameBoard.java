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
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MS_GameBoard extends JPanel implements ActionListener {    
    
    private final int B_WIDTH = 300;  // game board
    private final int B_HEIGHT = 300; // game board
    private final int DOT_SIZE = 10;  // snake
    private final int ALL_DOTS = 900; // snake
    private final int RAND_POS = 29; // Prey
    private final int DELAY = 140; // Snake

    private final int x[] = new int[ALL_DOTS]; // snake
    private final int y[] = new int[ALL_DOTS]; // snake
    public static int dots,dots2; // snake
    
    private final int x2[] = new int[ALL_DOTS]; // snake
    private final int y2[] = new int[ALL_DOTS]; // snake
  

    private boolean leftDirection = false; // snake
    private boolean rightDirection = true; // snake
    private boolean upDirection = false; // snake
    private boolean downDirection = false; // snake
    
    private boolean leftDirection2 = false; // snake
    private boolean rightDirection2 = true; // snake
    private boolean upDirection2 = false; // snake
    private boolean downDirection2 = false; // snake
    
     private boolean inGame = true; // gameboard

    private Timer timer; // gameboard
    private Image ball,ball2; // snake tail
    private Image apple,apple2; // prey
    private Image head,head2; // snake head
    
    private MS_Prey prey;
    private MS_Snake snake;
    
    public MS_GameBoard () {
        prey = new MS_Prey();
        snake = new MS_Snake();
        
        initBoard();      
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }

    // gameboard
    private void loadImages() {

        ball = snake.tail;
        apple = prey.prey_image;
        head = snake.head;
        
         ball2 = snake.tail2;
        apple2 = prey.prey_image2;
        head2 = snake.head2;
    }

    // gameboard
    private void initGame() {

        dots = 3;
        dots2 = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }
        
        for (int z = 0; z < dots2; z++) {
            x2[z] = 200 - z * 10;
            y2[z] = 50;
        }
        
        prey.locateApple(RAND_POS,DOT_SIZE);
        prey.locateApple2(RAND_POS,DOT_SIZE);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    // gameboard
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    // gameboard
    private void doDrawing(Graphics g) {
        
        if (inGame) {

            g.drawImage(apple, prey.apple_x, prey.apple_y, this);
            g.drawImage(apple2, prey.apple_x2, prey.apple_y2, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }
            
            for (int z = 0; z < dots2; z++) {
                if (z == 0) {
                    g.drawImage(head2, x2[z], y2[z], this);
                } else {
                    g.drawImage(ball2, x2[z], y2[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }        
    }

    private void gameOver(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }

    private void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
        
        for (int z = dots2; z > 0; z--) {
            x2[z] = x2[(z - 1)];
            y2[z] = y2[(z - 1)];
        }

        if (leftDirection2) {
            x2[0] -= DOT_SIZE;
        }

        if (rightDirection2) {
            x2[0] += DOT_SIZE;
        }

        if (upDirection2) {
            y2[0] -= DOT_SIZE;
        }

        if (downDirection2) {
            y2[0] += DOT_SIZE;
        }
    }

    private void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
        
        if (!inGame) {
            timer.stop();
        }
    }

    // gameboard
    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            prey.checkApple(x[0],y[0],RAND_POS,DOT_SIZE);
            prey.checkApple(x2[0],y2[0],RAND_POS,DOT_SIZE);
            checkCollision();
            move();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
            public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            
            if(key == KeyEvent.VK_SPACE)
            {
                timer.stop();
            }else{
                timer.start();
            }


            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
            
            if ((key == KeyEvent.VK_A) && (!rightDirection)) {
                leftDirection2 = true;
                upDirection2 = false;
                downDirection2 = false;
            }

            if ((key == KeyEvent.VK_D) && (!leftDirection)) {
                rightDirection2 = true;
                upDirection2 = false;
                downDirection2 = false;
            }

            if ((key == KeyEvent.VK_W) && (!downDirection)) {
                upDirection2 = true;
                rightDirection2 = false;
                leftDirection2 = false;
            }

            if ((key == KeyEvent.VK_Z) && (!upDirection)) {
                downDirection2 = true;
                rightDirection2 = false;
                leftDirection2 = false;
            }
        }
    }
    
         /**
     * Method boardvisible
     * this method is used to visible the board on screen
     */
    public void boardvisible()
    {
        
    }
    
    /**
     * Method boardminimize
     * this method is used to minimized the board
     */
    public void boardminimize()
    {
        
    }
    
    /**
     * Method boardmaximize
     * this method is used to maximized the board
     */
    public void boardmaximize()
    {
        
    }
    
    /**
     * Method boardresize
     * this method is used to resize the board
     */
    public void boardresize()
    {
        
    }
    
    /**
     * Method boardclose
     * this method is used to close the board
     */
    public void boardclose()
    {
        
    }
}
    
   

