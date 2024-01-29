import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * deals cards for the game.
 * 
 * @author Nathaniel de Marcellus
 * @version 1/19/2024
 */
public class Dealer extends Actor
{
    
    private Deck deck;
    private ArrayList<Card> cardsOnBoard;
    private ArrayList<Integer> selectedCardsIndex;
    private Card[] cardsSelected;
    private int numCardsInDeck, triplesRemaining;
    
    public Dealer(int numCardsInDeck)
    {
        this.numCardsInDeck = numCardsInDeck;
        triplesRemaining = numCardsInDeck / 3;
        deck = new Deck(numCardsInDeck);
        cardsSelected = new Card[3];
    }
    
    public void addedToWorld(World world)
    {
        dealBoard();
        setUI();
    }
    
    public void dealBoard()
    {
        Greenfoot.playSound("shuffle.wav");
        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 5; y++)
            {
                getWorld().addObject(deck.getTopCard(), x * 130 + 85, y * 80 + 60);
            }
        }
    }
    
    public void setUI()
    {
        Integer cardsRemaining = new Integer(deck.getNumCardsInDeck());
        Integer score = new Integer(Scorekeeper.getScore());
        getWorld().showText(cardsRemaining.toString(), 300, 471);
        getWorld().showText(score.toString(), 300, 506);
    }
    
    public void endGame()
    {
        
    }
    
    public void checkIfTriple()
    {
        
    }
    
    public void actionIfTriple()
    {
        
    }
    
    public void setCardsSelected(ArrayList<Card> cards, ArrayList<Integer> ints, Card[] arrayOfCards)
    {
        
    }
}
