/*
 Code adapted from: https://zetcode.com/javagames/snake/
 */
import java.awt.EventQueue;
import javax.swing.JFrame;

public class MS_playGame extends JFrame {

    public MS_playGame() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new MS_GameBoard());
               
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            JFrame ex = new MS_playGame();
            ex.setVisible(true);
        });
    }
}


