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

public class MS_SnakeGame extends JFrame {

    private JLabel gameover;
    private JLabel topLayersScore;
    private JLabel currentPlayesScore;
    private JLabel idAndName;
    private JLabel clickToPlay; 
    private Image snake_image; 
    private JLabel snake_image_label;
    private JButton quit;
    private Graphics g;
    
    public MS_SnakeGame (String gameTille) {        
       super(gameTille);
        gameover = new JLabel("GAMEOVER");
        clickToPlay = new JLabel("CLICK TO PLAY");   
        topLayersScore = new JLabel("TOP LAYER'S SCORE");   
        currentPlayesScore = new JLabel("CURRENT PLAYER SCORE"); 
        idAndName = new JLabel("PROG5001:2021 Umer Jhangir");
        snake_image_label = new JLabel();
        quit = new JButton("Login");
        
        // Adding Panel 1
        JPanel gamePanel = new JPanel(new GridBagLayout());
        gamePanel.setBackground(Color.black);
        gamePanel.setSize(340, 380);
        gamePanel.setBounds(10, 10, 300, 340);
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
        // Adding label for gameover
        constraints.gridx = 0;
        constraints.gridy = 0;     
        gameover.setForeground(Color.white);
        gamePanel.add(gameover, constraints);
        
        // Adding label for click to play
        constraints.gridx = 0;
        constraints.gridy = 1;  
        clickToPlay.setForeground(Color.white);
        gamePanel.add(clickToPlay, constraints);
        
        // Adding Panel 2
        JPanel sidePanel = new JPanel(new GridBagLayout());
        sidePanel.setBackground(Color.white);
        
        GridBagConstraints constraint = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
        constraints.gridx = 0;
        constraints.gridy = 0;     
        //sidePanel.add(topLayersScore, constraints);
        
        constraints.gridx = 0;  
        constraints.gridy = 1;
        //sidePanel.add(currentPlayesScore, constraints);
        
        
        constraints.gridx = 0;  
        constraints.gridy = 2;
        //sidePanel.add(idAndName, constraints);
        
        constraints.gridx = 0;  
        constraints.gridy = 3;
        //sidePanel.add(quit, constraints);

        constraints.gridx = 0;  
        constraints.gridy = 4;
        sidePanel.add(snake_image_label, constraints);
        
        add(gamePanel);
        add(sidePanel);
        
        pack();       
    }
    
    public static void main(String[] args) {        
        EventQueue.invokeLater(() -> {
            //create the game with a game title as follow: The Snake Game (C) Your_Name
            JFrame sgame = new MS_SnakeGame ("My Game");
            sgame.setVisible(true);
        });
    }
}
