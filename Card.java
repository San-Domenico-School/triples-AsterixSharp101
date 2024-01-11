import greenfoot.*; 

/**
 * Card Class for Triples Game
 * 
 * @author Nathaniel de Marcellus 
 * @version 1/8/2024
 */

public class Card extends Actor
{
    
   public enum Shape
   {
       TRIANGLE, SQUARE, CIRCLE, NO_SHAPE
   }
   
   public enum Color
   {
       RED, GREEN, BLUE, NO_COLOR
   }
   
   private Shape shape;
   private Color color;
   private boolean isSelected;
   private GreenfootImage cardImage, selectedCardImage;
   private int numberOfShapes, shading;

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
   
   public Shape getShape()
   {
       return shape;
   }
   
   public Color getColor()
   {
       return color;
   }
   
   public boolean getIsSelected()
   {
       return isSelected;
   }
   
   public GreenfootImage getCardImage()
   {
       return cardImage;
   }
   
   public GreenfootImage getSelectedCardImage()
   {
       return selectedCardImage;
   }
   
   public int getNumberOfShapes()
   {
       return numberOfShapes;
   }
   
   public int getShading()
   {
       return shading;
   }
   
   public void setIsSelected(boolean isSelected)
   {
       this.isSelected = isSelected;
   }
}

