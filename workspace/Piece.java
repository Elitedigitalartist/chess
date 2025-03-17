
//David Sagoua Period: 2
//This class store the informantio for the piece like it's color, image, and the way it can move
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
        
        try {
            if (this.img == null) {
              this.img = ImageIO.read(getClass().getResource(img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    //makes a list of all the legal moves that the piece can make
    //pre-condition: board must exist and have squares
    //post-condition: return an arraylist of legal moves
    public ArrayList<Square> getLegalMoves(Board b, Square start){
       ArrayList<Square> legalMoves = new ArrayList<Square>();
      int firstAxis = 2;
      int secondAxis = 1;
      if (start.getRow() + 2 < 8) 
      {
        //Standard L shaped move
        if (start.getCol() + 1 < 8) 
        {
          if (b.getSquareArray()[start.getRow() + firstAxis][start.getCol() + secondAxis].isOccupied() == true)
          {
            if (b.getSquareArray()[start.getRow() + firstAxis][start.getCol() + secondAxis].getOccupyingPiece().getColor() != this.getColor())
            {
              legalMoves.add(b.getSquareArray()[start.getRow() + firstAxis][start.getCol() + secondAxis]);//row +2 col +1
            }
          }
          else 
          {
            legalMoves.add(b.getSquareArray()[start.getRow() + firstAxis][start.getCol() + secondAxis]);//row +2 col +1
          }
        }
        //Standard backwards L shaped move
        if (start.getCol() - 1 >= 0) 
        {
          if (b.getSquareArray()[start.getRow() + firstAxis][start.getCol() - secondAxis].isOccupied() == true)
          {
            if (b.getSquareArray()[start.getRow() + firstAxis][start.getCol() - secondAxis].getOccupyingPiece().getColor() != this.getColor())
            {
              legalMoves.add(b.getSquareArray()[start.getRow() + firstAxis][start.getCol() - secondAxis]);//row +2 col -1
            }
          }
          else 
          {
            legalMoves.add(b.getSquareArray()[start.getRow() + firstAxis][start.getCol() - secondAxis]);//row +2 col -1
          }
        }
      }
      if(start.getRow() + 1 < 8)
      {
        //Standard backwards L shaped rotated 90 degrees clockwise move
        if (start.getCol() + 2 < 8) 
        {
          if (b.getSquareArray()[start.getRow() + secondAxis][start.getCol() + firstAxis].isOccupied() == true)
          {
            if (b.getSquareArray()[start.getRow() + secondAxis][start.getCol() + firstAxis].getOccupyingPiece().getColor() != this.getColor())
            {
              legalMoves.add(b.getSquareArray()[start.getRow() + secondAxis][start.getCol() + firstAxis]);//row +1 col +2
            }
          }
          else 
          {
            legalMoves.add(b.getSquareArray()[start.getRow() + secondAxis][start.getCol() + firstAxis]);//row +1 col +2
          }
        }
        //Standard L shaped rotated 90 degrees counterclockwise move
        if (start.getCol() - 2 >= 0) 
        {
          if (b.getSquareArray()[start.getRow() + secondAxis][start.getCol() - firstAxis].isOccupied() == true)
          {
            if (b.getSquareArray()[start.getRow() + secondAxis][start.getCol() - firstAxis].getOccupyingPiece().getColor() != this.getColor())
            {
              legalMoves.add(b.getSquareArray()[start.getRow() + secondAxis][start.getCol() - firstAxis]);//row +1 col -2
            }
          }
          else 
          {
            legalMoves.add(b.getSquareArray()[start.getRow() + secondAxis][start.getCol() - firstAxis]);//row +1 col -2
          }
        }                    
      }

      if (start.getRow() - 1 >= 0) 
      {
        //Standard L shaped rotated 90 degrees clockwise move
        if (start.getCol() + 2 < 8) 
        {
          if (b.getSquareArray()[start.getRow() - secondAxis][start.getCol() + firstAxis].isOccupied() == true)
          {
            if (b.getSquareArray()[start.getRow() - secondAxis][start.getCol() + firstAxis].getOccupyingPiece().getColor() != this.getColor())
            {
              legalMoves.add(b.getSquareArray()[start.getRow() - secondAxis][start.getCol() + firstAxis]);//row -1 col +2
            }
          }
          else 
          {
            legalMoves.add(b.getSquareArray()[start.getRow() - secondAxis][start.getCol() + firstAxis]);//row -1 col +2
          }
        }
        //Standard backwards L shaped rotated 90 degrees counterclockwise move
        if (start.getCol() - 2 >= 0) 
        {
          if (b.getSquareArray()[start.getRow() - secondAxis][start.getCol() - firstAxis].isOccupied() == true)
          {
            if (b.getSquareArray()[start.getRow() - secondAxis][start.getCol() - firstAxis].getOccupyingPiece().getColor() != this.getColor())
            {
              legalMoves.add(b.getSquareArray()[start.getRow() - secondAxis][start.getCol() - firstAxis]);//row -1 col -2
            }
          }
          else 
          {
            legalMoves.add(b.getSquareArray()[start.getRow() - secondAxis][start.getCol() - firstAxis]);//row -1 col -2
          }
        }
      }

      if (start.getRow() - 2 >= 0) 
      {
        //Standard L shaped flipped upside down move
        if (start.getCol() + 1 < 8) 
        {
          if (b.getSquareArray()[start.getRow() - firstAxis][start.getCol() + secondAxis].isOccupied() == true)
          {
            if (b.getSquareArray()[start.getRow() - firstAxis][start.getCol() + secondAxis].getOccupyingPiece().getColor() != this.getColor())
            {
              legalMoves.add(b.getSquareArray()[start.getRow() - firstAxis][start.getCol() + secondAxis]);//row -2 col +1
            }
          }
          else 
          {
            legalMoves.add(b.getSquareArray()[start.getRow() - firstAxis][start.getCol() + secondAxis]);//row -2 col +1
          }
        }
        //Standard backwards L shaped flipped upside down move
        if (start.getCol() - 1 >= 0) 
        {
          if (b.getSquareArray()[start.getRow() - firstAxis][start.getCol() - secondAxis].isOccupied() == true)
          {
            if (b.getSquareArray()[start.getRow() - firstAxis][start.getCol() - secondAxis].getOccupyingPiece().getColor() != this.getColor())
            {
              legalMoves.add(b.getSquareArray()[start.getRow() - firstAxis][start.getCol() - secondAxis]);//row -2 col -1
            }
          }
          else 
          {
            legalMoves.add(b.getSquareArray()[start.getRow() - firstAxis][start.getCol() - secondAxis]);//row -2 col -1
          }
        }
      }

    	return legalMoves;
    }



    //pre-condition: board must exist and have squares
    //post-condition: return an arraylist of legal moves
    public ArrayList<Square> getControlledSquares(Board b, Square start){
      ArrayList<Square> controlledSquares = new ArrayList<Square>();
      int firstAxis = 2;
      int secondAxis = 1;
      if (start.getRow() + 2 < 8) 
      {
        //Standard L shaped move
        if (start.getCol() + 1 < 8) 
        {
          controlledSquares.add(b.getSquareArray()[start.getRow() + firstAxis][start.getCol() + secondAxis]);//row +2 col +1
        }
        //Standard backwards L shaped move
        if (start.getCol() - 1 >= 0) 
        {
          controlledSquares.add(b.getSquareArray()[start.getRow() + firstAxis][start.getCol() - secondAxis]);//row +2 col -1
        }
      }

      if(start.getRow() + 1 < 8)
      {
        //Standard backwards L shaped rotated 90 degrees clockwise move
        if (start.getCol() + 2 < 8) 
        {
          controlledSquares.add(b.getSquareArray()[start.getRow() + secondAxis][start.getCol() + firstAxis]);//row +1 col +2
        }
        //Standard L shaped rotated 90 degrees counterclockwise move
        if (start.getCol() - 2 >= 0) 
        {
          controlledSquares.add(b.getSquareArray()[start.getRow() + secondAxis][start.getCol() - firstAxis]);//row +1 col -2
        }                    
      }

      if (start.getRow() - 1 >= 0) 
      {
        //Standard L shaped rotated 90 degrees clockwise move
        if (start.getCol() + 2 < 8) 
        {
          controlledSquares.add(b.getSquareArray()[start.getRow() - secondAxis][start.getCol() + firstAxis]);//row -1 col +2
        }
        //Standard backwards L shaped rotated 90 degrees counterclockwise move
        if (start.getCol() - 2 >= 0) 
        {
          controlledSquares.add(b.getSquareArray()[start.getRow() - secondAxis][start.getCol() - firstAxis]);//row -1 col -2
        }
      }

      if (start.getRow() - 2 >= 0) 
      {
        //Standard L shaped flipped upside down move
        if (start.getCol() + 1 < 8) 
        {
          controlledSquares.add(b.getSquareArray()[start.getRow() - firstAxis][start.getCol() + secondAxis]);//row -2 col +1
        }
        //Standard backwards L shaped flipped upside down move
        if (start.getCol() - 1 >= 0) 
        {
          controlledSquares.add(b.getSquareArray()[start.getRow() - firstAxis][start.getCol() - secondAxis]);//row -2 col -1
        }
      }
      return controlledSquares;
    }
}