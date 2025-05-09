//David Sagoua Period: 2
//This class creates the board and hold all the methods for interacting with the board
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

//You will be implmenting a part of a function and a whole function in this document. Please follow the directions for the 
//suggested order of completion that should make testing easier.
@SuppressWarnings("serial")
public class Board extends JPanel implements MouseListener, MouseMotionListener {
	// Resource location constants for piece images
    private static final String RESOURCES_WBISHOP_PNG = "wbishop.png";
	private static final String RESOURCES_BBISHOP_PNG = "bbishop.png";
	private static final String RESOURCES_WKNIGHT_PNG = "wknight.png";
	private static final String RESOURCES_BKNIGHT_PNG = "bknight.png";
	private static final String RESOURCES_WROOK_PNG = "wrook.png";
	private static final String RESOURCES_BROOK_PNG = "brook.png";
	private static final String RESOURCES_WKING_PNG = "wking.png";
	private static final String RESOURCES_BKING_PNG = "bking.png";
	private static final String RESOURCES_BQUEEN_PNG = "bqueen.png";
	private static final String RESOURCES_WQUEEN_PNG = "wqueen.png";
	private static final String RESOURCES_WPAWN_PNG = "wpawn.png";
	private static final String RESOURCES_BPAWN_PNG = "bpawn.png";
	
	// Logical and graphical representations of board
	private final Square[][] board;
    private final GameWindow g;
 
    //contains true if it's white's turn.
    private boolean whiteTurn;

    //if the player is currently dragging a piece this variable contains it.
    private Piece currPiece;
    private Square fromMoveSquare;
    
    //used to keep track of the x/y coordinates of the mouse.
    private int currX;
    private int currY;
    

    
    public Board(GameWindow g) {
        this.g = g;
        board = new Square[8][8];
        setLayout(new GridLayout(8, 8, 0, 0));

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        //TO BE IMPLEMENTED FIRST
     
      //for (.....)  
//        	populate the board with squares here. Note that the board is composed of 64 squares alternating from 
//        	white to black.
        for (int i = 0; i < board.length; i++) 
        {
            for (int j = 0; j < board[i].length;j++) 
            {
                if ( i % 2 == 0) 
                {
                    if (j % 2 == 0 ) 
                    {
                        board[i][j] = new Square(this, true, i, j);
                        this.add(board[i][j]);
                    }
                    else 
                    {
                        board[i][j] = new Square(this, false, i, j);
                        this.add(board[i][j]);
                    }
                }
                if ( i % 2 == 1) 
                {
                    if (j % 2 == 0 ) 
                    {
                        board[i][j] = new Square(this, false, i, j);
                        this.add(board[i][j]);
                    }
                    else 
                    {
                        board[i][j] = new Square(this, true, i, j);
                        this.add(board[i][j]);
                    }
                
                }
            }
        }

        initializePieces();

        this.setPreferredSize(new Dimension(400, 400));
        this.setMaximumSize(new Dimension(400, 400));
        this.setMinimumSize(this.getPreferredSize());
        this.setSize(new Dimension(400, 400));

        whiteTurn = true;

    }

    
	//set up the board such that the black pieces are on one side and the white pieces are on the other.
	//since we only have one kind of piece for now you need only set the same number of pieces on either side.
	//it's up to you how you wish to arrange your pieces.
    private void initializePieces() {
    	
        board[6][0].put(new Pawn(true, RESOURCES_WPAWN_PNG));
        board[6][1].put(new Pawn(true, RESOURCES_WPAWN_PNG));
        board[6][2].put(new Pawn(true, RESOURCES_WPAWN_PNG));
        board[6][3].put(new Pawn(true, RESOURCES_WPAWN_PNG));
        board[6][4].put(new Pawn(true, RESOURCES_WPAWN_PNG));
        board[6][5].put(new Pawn(true, RESOURCES_WPAWN_PNG));
        board[6][6].put(new Pawn(true, RESOURCES_WPAWN_PNG));
        board[6][7].put(new Pawn(true, RESOURCES_WPAWN_PNG));

        board[7][0].put(new Rook(true, RESOURCES_WROOK_PNG));
        board[7][7].put(new Rook(true, RESOURCES_WROOK_PNG));

        board[7][2].put(new Bishop(true, RESOURCES_WBISHOP_PNG));
        board[7][5].put(new Bishop(true, RESOURCES_WBISHOP_PNG));

    	board[7][1].put(new Knight(true, RESOURCES_WKNIGHT_PNG));
        board[7][6].put(new Knight(true, RESOURCES_WKNIGHT_PNG));

        board[7][3].put(new King(true, RESOURCES_WKING_PNG));
        board[7][4].put(new Queen(true, RESOURCES_WQUEEN_PNG));

        board[1][0].put(new Pawn(false, RESOURCES_BPAWN_PNG));
        board[1][1].put(new Pawn(false, RESOURCES_BPAWN_PNG));
        board[1][2].put(new Pawn(false, RESOURCES_BPAWN_PNG));
        board[1][3].put(new Pawn(false, RESOURCES_BPAWN_PNG));
        board[1][4].put(new Pawn(false, RESOURCES_BPAWN_PNG));
        board[1][5].put(new Pawn(false, RESOURCES_BPAWN_PNG));
        board[1][6].put(new Pawn(false, RESOURCES_BPAWN_PNG));
        board[1][7].put(new Pawn(false, RESOURCES_BPAWN_PNG));
        

        board[0][0].put(new Rook(false, RESOURCES_BROOK_PNG));
        board[0][7].put(new Rook(false, RESOURCES_BROOK_PNG));

        board[0][2].put(new Bishop(false, RESOURCES_BBISHOP_PNG));
        board[0][5].put(new Bishop(false, RESOURCES_BBISHOP_PNG));
        
        

        board[0][1].put(new Knight(false, RESOURCES_BKNIGHT_PNG));
        
        board[0][6].put(new Knight(false, RESOURCES_BKNIGHT_PNG));

        board[0][4].put(new King(false, RESOURCES_BKING_PNG));
        board[0][3].put(new Queen(false, RESOURCES_BQUEEN_PNG));
        

    }

    public Square[][] getSquareArray() {
        return this.board;
    }

    public boolean getTurn() {
        return whiteTurn;
    }

    public void setCurrPiece(Piece p) {
        this.currPiece = p;
    }

    public Piece getCurrPiece() {
        return this.currPiece;
    }

    @Override
    public void paintComponent(Graphics g) {
     
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Square sq = board[x][y];
                if(sq == fromMoveSquare)
                	 sq.setBorder(BorderFactory.createLineBorder(Color.blue));
                sq.paintComponent(g);
                
            }
        }
    	if (currPiece != null) {
            if ((currPiece.getColor() && whiteTurn)
                    || (!currPiece.getColor()&& !whiteTurn)) {
                final Image img = currPiece.getImage();
                g.drawImage(img, currX, currY, null);
            }
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        currX = e.getX();
        currY = e.getY();

        Square sq = (Square) this.getComponentAt(new Point(e.getX(), e.getY()));

        if (sq.isOccupied()) {
            currPiece = sq.getOccupyingPiece();
            fromMoveSquare = sq;
            if (!currPiece.getColor() && whiteTurn)
                return;
            if (currPiece.getColor() && !whiteTurn)
                return;
            sq.setDisplay(false);
        }
        repaint();
    }

    //TO BE IMPLEMENTED!
    //should move the piece to the desired location only if this is a legal move.
    //use the pieces "legal move" function to determine if this move is legal, then complete it by
    //moving the new piece to it's new board location. 

    //pre-condition: none
    //post-condition: removes all highlighted colors and switches the turn
    @Override
    public void mouseReleased(MouseEvent e) {
        Square endSquare = (Square) this.getComponentAt(new Point(e.getX(), e.getY()));
        Piece sealedPiece = endSquare.getOccupyingPiece();
        
        //using currPiece
        //removes piece from orginal position to a new one
        if (currPiece != null && isInCheck(currPiece.getColor()) == true && currPiece.getLegalMoves(this, fromMoveSquare).contains(endSquare) && currPiece.getColor() == whiteTurn)
        {
            sealedPiece = endSquare.getOccupyingPiece();
            endSquare.put(currPiece);
            fromMoveSquare.put(null);
            if (!isInCheck(currPiece.getColor())){
                whiteTurn = !whiteTurn;
            }
            else {
                fromMoveSquare.put(currPiece);
                endSquare.put(sealedPiece);
            }
        }
        else if (currPiece != null && currPiece.getLegalMoves(this, fromMoveSquare).contains(endSquare) && currPiece.getColor() == whiteTurn && !isInCheck(currPiece.getColor()))
        {
            endSquare.put(currPiece);
            fromMoveSquare.put(null);
            if(isInCheck(currPiece.getColor()) == false)
            {
                whiteTurn = !whiteTurn;
            }
            else 
            {
                fromMoveSquare.put(currPiece);
                endSquare.put(sealedPiece);
            }
        }
            
        for (Square[] row: board)
        {
            for (Square s: row)
            {
                s.setBorder(null);
            }
        }

        if (currPiece != null){
            fromMoveSquare.setDisplay(true);
            currPiece = null;
            repaint();
        }
    }

    //pre-condition: non
    //post-condition: highlights the legal suare and controlled squares
    @Override
    public void mouseDragged(MouseEvent e) {
        currX = e.getX() - 24;
        currY = e.getY() - 24;
        //if the square clicked on has a piece
        if (currPiece != null) 
        {
            //if piece can attack highlight in yellow
            for (Square s: currPiece.getControlledSquares(board, fromMoveSquare)) 
            {
                s.setBorder(BorderFactory.createLineBorder(Color.yellow));
            }
            //if piece can be moved to highlight it in red
            for (Square s: currPiece.getLegalMoves(this, fromMoveSquare)) 
            {
                s.setBorder(BorderFactory.createLineBorder(Color.red));

            }
            
        }

        repaint();
    }
    public boolean isInCheck(boolean color)
    {
        int kingX = -1;
        int kingY = -1;
        for (int i = 0; i < board.length; i++) 
        {
            for (int j = 0; j < board[i].length;j++) 
            {
                if (board[i][j].getOccupyingPiece() != null)
                {
                    if (board[i][j].getOccupyingPiece() instanceof King && board[i][j].getOccupyingPiece().getColor() == color)
                    {
                        kingX = i;
                        kingY = j;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) 
        {
            for (int j = 0; j < board[i].length;j++) 
            {
                if (board[i][j].getOccupyingPiece() != null && board[i][j].getOccupyingPiece().getColor() != color){
                    if (board[i][j].getOccupyingPiece().getControlledSquares(board, board[i][j]) != null && kingX != -1 && kingY != -1){
                        if (board[i][j].getOccupyingPiece().getControlledSquares(board, board[i][j]).contains(board[kingX][kingY])){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}