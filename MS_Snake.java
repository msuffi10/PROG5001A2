/**
 * Write a description of class Snake here.
 *
 * @author (MS_Snake)
 * @version (1.0.0)
 */
abstract class MS_Snake
{
    /**
     * Constructor for objects of class Snake
     */
    public MS_Snake() {
        // initialise instance variables        
    }
        
    /**
     * Method directionchange
     * this method use to change direction of snake through arrow keys
     */
    abstract void directionchange();
     
    /**
     * Method eatapple
     * this method use for snake to eat apple 
     */
    abstract void eatapple();

     /**
     * Method Speedup
     * the method use to snake speed increases once eat apple
     */
    abstract void Speedup();
    
    /**
     * Method growsnake
     * the method use to grow snake when it eat apple
     */
    abstract void growsnake();
}
