/**
 * Keeps track of game score
 * 
 * @author Nathaniel
 * @version 1/11/2024
 */
public class Scorekeeper  
{
    private static int deckSize, score;
    private static long startTime = System.currentTimeMillis();
    
    public static void setDeckSize(int deckSize)
    {
        Scorekeeper.deckSize = deckSize;
    }
    
    public static void updateScore()
    {
        //get the time in seconds that the player took to answer
        int timeTaken = (int) (System.currentTimeMillis() - startTime) / 500;
        
        //change score by a maximum of 20 and minimum of 5
        if (timeTaken < 15)
        {
            score += 20 - timeTaken;
        }
        else
        {
            score += 5;
        }
        
        //reset score timer
        
        startTime = System.currentTimeMillis();
    }
    
    public static int getScore()
    {
        return score;
    }
}
