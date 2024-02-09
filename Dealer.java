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
    
    /*
     * Constructor of the Dealer class
     */
    public Dealer(int numCardsInDeck)
    {
        this.numCardsInDeck = numCardsInDeck;
        triplesRemaining = numCardsInDeck / 3;
        deck = new Deck(numCardsInDeck);
        cardsSelected = new Card[3];
    }
    
    /*
     * finish initializing the dealer object once added to the world
     */
    public void addedToWorld(World world)
    {
        dealBoard();
        setUI();
    }
    
    /*
     * add all of the cards to the board
     */
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
    
    /*
     * update the game ui
     */
    public void setUI()
    {
        Integer cardsRemaining = new Integer(deck.getNumCardsInDeck());
        Integer score = new Integer(Scorekeeper.getScore());
        getWorld().showText(cardsRemaining.toString(), 300, 471);
        getWorld().showText(score.toString(), 300, 506);
    }
    
    /*
     * end the game and stop greenfoot
     */
    public void endGame()
    {
        getWorld().showText("Game Over", 200, 200);
        Greenfoot.stop();
    }
    
    /*
     * determine if a set is a triple
     */
    public void checkIfTriple()
    {
        Card card1 = cardsSelected[0];
        Card card2 = cardsSelected[1];
        Card card3 = cardsSelected[2];
        
        boolean color = (card1.getColor().ordinal() + card2.getColor().ordinal() + card3.getColor().ordinal()) % 3 == 0;
        boolean shape = (card1.getShape().ordinal() + card2.getShape().ordinal() + card3.getShape().ordinal()) % 3 == 0;
        boolean shade = (card1.getShading() + card2.getShading() + card3.getShading()) % 3 == 0;
        boolean count = (card1.getNumberOfShapes() + card2.getNumberOfShapes() + card3.getNumberOfShapes()) % 3 == 0;
        
        if(color && shape && count && shade)
        {
            actionIfTriple();
        }
        else
        {
            Animations.wobble(cardsSelected);
        }
    }
    
    /*
     * update the board and score if a triple is found by checkIfTriple()
     */
    public void actionIfTriple()
    {
        Animations.slideAndTurn(cardsSelected);
        
        for(int i = 0; i < 3; i++)
        {
            int x = cardsOnBoard.get(selectedCardsIndex.get(i)).getX();
            int y = cardsOnBoard.get(selectedCardsIndex.get(i)).getY();
            Card oldCard = cardsOnBoard.get(selectedCardsIndex.get(i));
            Card newCard = deck.getTopCard();
            if (newCard.getColor() != Card.Color.NO_COLOR)
            {
                cardsOnBoard.set(selectedCardsIndex.get(i), newCard);
                getWorld().addObject(cardsOnBoard.get(selectedCardsIndex.get(i)), x, y);
            }
            getWorld().removeObject(oldCard);
        }
        
        Scorekeeper.updateScore();
        triplesRemaining--;
        setUI();
        
        if (triplesRemaining == 0)
        {
            endGame();
        }
    }
    
    /*
     * used by the Player object to update the variables in Dealer to match the player
     */
    public void setCardsSelected(ArrayList<Card> cards, ArrayList<Integer> cardIndices, Card[] arrayOfCards)
    {
        cardsOnBoard = cards;
        selectedCardsIndex = cardIndices;
        cardsSelected = arrayOfCards;
    }
}
