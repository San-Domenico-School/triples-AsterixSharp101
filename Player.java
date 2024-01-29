import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Gets player input and sends triples to dealer
 * 
 * @author Nathaniel de Marcellus
 * @version 1/29/2024
 */
public class Player extends Actor
{
    Dealer dealer;
    Card[] cardsSelected;
    ArrayList<Card> cardsOnBoard;
    ArrayList<Integer> selectedCardsIndex;
    
    public Player(Dealer dealer)
    {
        this.dealer = dealer;
        cardsSelected = new Card[3];
        cardsOnBoard = new ArrayList<Card>();
        selectedCardsIndex = new ArrayList<Integer>();
    }
    
    // update clicked cards, then send 3 selected cards to dealer if applicable
    public void act()
    {
        selectCards();
        boolean threeCardsHaveBeenSelected = setCardsSelected();
        if (threeCardsHaveBeenSelected)
        {
            dealer.setCardsSelected(cardsOnBoard, selectedCardsIndex, cardsSelected);
            dealer.checkIfTriple();
            resetCardsSelected();
        }
    }
    
    // initialize cardsOnBoard from world
    public void addedToWorld(World world)
    {
        cardsOnBoard = (ArrayList) getWorld().getObjects(Card.class);
    }
    
    // toggle clicked cards between selected and selected
    private void selectCards()
    {
        for(int i = 0; i < cardsOnBoard.size(); i++)
        {
            if(Greenfoot.mouseClicked(cardsOnBoard.get(i)))
            {
                if(cardsOnBoard.get(i).getIsSelected())
                {
                    cardsOnBoard.get(i).setIsSelected(false);
                    cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getCardImage());
                    selectedCardsIndex.remove(selectedCardsIndex.indexOf(i));
                }
                else
                {
                    if(selectedCardsIndex.size() < 3)
                    {
                        cardsOnBoard.get(i).setIsSelected(true);
                        cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getSelectedCardImage());
                        selectedCardsIndex.add(i);
                    }
                }
            }
        }
    }
    
    // set all selected cards to be unselected, then remove them from selectedCardsIndex
    private void resetCardsSelected()
    {
        for(int i = 0; i < cardsOnBoard.size(); i++)
        {
            cardsOnBoard.get(i).setIsSelected(false);
            cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getCardImage());
        }
        selectedCardsIndex.clear();
    }
    
    // if total cards selected is 3, return true and set cardsSelected to values of board at selectedCardsIndex
    private boolean setCardsSelected()
    {
        if(selectedCardsIndex.size() == 3)
        {
            for(int i = 0; i < 3; i++)
            {
                cardsSelected[i] = cardsOnBoard.get(selectedCardsIndex.get(i));
            }
            return true;
        }
        else
        {
            return false;
        }
    }
}
