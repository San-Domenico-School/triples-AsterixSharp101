/**
 * Keeps track of game score
 * 
 * @author Nathaniel
 * @version 1/11/2024
 */
public class Scorekeeper  
{
    private static int score;
    private static long startTime = System.currentTimeMillis();
    
    //removed decksize variable and setter in scorekeeper as they are not used
    
    /*
     * update the score based on the time taken since last update, then reset the timer
     */
    public static void updateScore()
    {
        //get the time in seconds that the player took to answer
        int timeTaken = (int) (System.currentTimeMillis() - startTime) / 1000;
        
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
    
    /*
     * return the current score
     */
    public static int getScore()
    {
        return score;
    }
}
