//David Sagoua Period: 2

//Knight
//Knights move in L shapes
//(two sqaures in one direction, then one square in a direction perpendicular to the original diretion) 
//and capture pieces by going to the square that piece is at.
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class Knight extends Piece{
    public Knight(boolean isWhite, String img_file) {
        super(isWhite, img_file);
    }

    //makes a list of all the legal moves that the piece can make
    //pre-condition: board must exist and have squares
    //post-condition: return an arraylist of legal moves for the knight which are every two sqaures in one direction, then one square in a direction perpendicular to the original diretion
    @Override
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
    //post-condition: return an arraylist of controlled squares which are every two sqaures in one direction, then one square in a direction perpendicular to the original diretion that is not occupied by a piece with the same color
    @Override
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
    public String toString()
    {
      return "A " + super.toString() + " Knight";
    }
}