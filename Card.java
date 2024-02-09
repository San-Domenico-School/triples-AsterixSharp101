import greenfoot.*; 

/**
 * Card Class for Triples Game
 * 
 * @author Nathaniel de Marcellus 
 * @version 1/8/2024
 */

public class Card extends Actor
{
    /*
     * enumerator for card shape
     */
    public enum Shape
    {
       TRIANGLE, SQUARE, CIRCLE, NO_SHAPE
    }
    
    /*
     * enumerator for card color
     */
    public enum Color
    {
       RED, GREEN, BLUE, NO_COLOR
    }
    
    private Shape shape;
    private Color color;
    private boolean isSelected;
    private GreenfootImage cardImage, selectedCardImage;
    private int numberOfShapes, shading;
    
    /*
     * Constructor for card class
     */
    public Card(Shape shape, Color color, int numberOfShapes, int shading, GreenfootImage cardImage, GreenfootImage selectedCardImage)
    {
       this.shape = shape;
       this.color = color;
       this.numberOfShapes = numberOfShapes;
       this.shading = shading;
       this.cardImage = cardImage;
       this.selectedCardImage = selectedCardImage;
       setImage(cardImage);
    }
    
    /*
     * return shape enum of a card object
     */
    public Shape getShape()
    {
       return shape;
    }
    
    /*
     * return color enum of a card object
     */
    public Color getColor()
    {
       return color;
    }
    
    /*
     * return isSelected flag of a card object
     */
    public boolean getIsSelected()
    {
       return isSelected;
    }
    
    /*
     * return image of card object when not selected
     */
    public GreenfootImage getCardImage()
    {
       return cardImage;
    }
    
    /*
     * return image of card object when selected
     */
    public GreenfootImage getSelectedCardImage()
    {
       return selectedCardImage;
    }
    
    /*
     * return shape count of a card object
     */
    public int getNumberOfShapes()
    {
       return numberOfShapes;
    }
    
    /*
     * return shading of a card object as an integer from 0 - 2
     */
    public int getShading()
    {
       return shading;
    }
    
    /*
     * change the isSelected flag of a card object
     */
    public void setIsSelected(boolean isSelected)
    {
       this.isSelected = isSelected;
    }
}
