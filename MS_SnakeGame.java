import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MS_SnakeGame extends JFrame implements ActionListener{

    private JLabel mySnakeGame;
    private JLabel gameOver;
    private JButton clickToPlay;
    private JLabel topLayersScore;   
    private JLabel currentPlayerScore;
    private JLabel snakeImage;
    private JLabel idAndName;
    private JButton quit;
    private Graphics g;
    
    public MS_SnakeGame (String gameTille) {        
       super(gameTille);
        //setTitle(SnakeGameTille);
        //setResizable(true);
        //setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();    
        
        // Top Panel labels
        
        mySnakeGame = new JLabel("My Snake Game©");
        
        // Left panel labels        
        gameOver = new JLabel("GAME OVER");
        clickToPlay = new JButton("CLICK TO PLAY");  
        
        // right panel lables
        topLayersScore = new JLabel("TOP LAYER'S SCORE");   
        currentPlayerScore = new JLabel("CURRENT PLAYER SCORE"); 
        idAndName = new JLabel("PROG5001:2021 Suffian");
        snakeImage = new JLabel();
        quit = new JButton("QUIT");
        
        // creating Top Panel
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(Color.blue);
        topPanel.setBounds(10,10,1366,50);
        
        GridBagConstraints topPanelConst = new GridBagConstraints();
        topPanelConst.anchor = GridBagConstraints.NORTH;
        topPanelConst.insets = new Insets(10, 10, 10, 10);
        
        // changing foreground color of game label
        mySnakeGame.setForeground(Color.white);
        topPanel.add(mySnakeGame,topPanelConst);

        // Creating LeftPanel 
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(Color.black);
        leftPanel.setBounds(10,10,550,700);
        
        // creating GridBagConstraints layout with constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
        // gameOver Label
        constraints.gridx = 0;
        constraints.gridy = 0;     
        gameOver.setForeground(Color.white);
        leftPanel.add(gameOver,constraints);
        
        // clickToPlay label
        constraints.gridx = 0;
        constraints.gridy = 1;  
        clickToPlay.setBackground(Color.black);
        clickToPlay.addActionListener(this);
        leftPanel.add(clickToPlay, constraints);
        
        // right panel
        JPanel rightPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
        //top layer label
        constraints.gridx = 0;
        constraints.gridy = 0;  
        rightPanel.add(topLayersScore, constraints);
        
        // current player label
        constraints.gridx = 0;  
        constraints.gridy = 1;
        rightPanel.add(currentPlayerScore, constraints);
        
        
        //snake image added to jlabel icon
        constraints.gridx = 0;  
        constraints.gridy = 2;
        snakeImage.setIcon(new ImageIcon("images/snake_img.png"));
        rightPanel.add(snakeImage, constraints);
                
        //id and name label
        constraints.gridx = 0;  
        constraints.gridy = 3;
        rightPanel.add(idAndName, constraints);
        
        //quit button
        constraints.gridx = 0;  
        constraints.gridy = 4;
        rightPanel.add(quit, constraints);
        
        leftPanel.setBounds(10,10,550,700);
        rightPanel.setBackground(Color.white);
    
        
        // set button style
        quit.setBackground(Color.BLUE);
        quit.setForeground(Color.white);
        quit.setFont(new Font("Verdana", Font.PLAIN, 18));
        // adding panel to jframe
        add(topPanel);
        add(leftPanel);
        add(rightPanel);
        
        
        pack();       
    }
    
    public static void main(String[] args) {        
        EventQueue.invokeLater(() -> {
            //create the game with a game title as follow: The Snake Game (C) Your_Name
            JFrame sgame = new MS_SnakeGame ("My Game");
            sgame.setVisible(true);
        });
    }
    
    public void actionPerformed(ActionEvent e) {
          this.setVisible(false);
          
          MS_playGame game = new MS_playGame();
          game.setVisible(true);

    }
}
