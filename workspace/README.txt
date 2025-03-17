When programming the legalMoves or controlledSquares methods always make sure that the square doesn't go out of bound
so create if statement that require the row or column to stay within a certain range
Max ranges should be start.get(row or column) + 1 < 8 and min ranges should be start.get(row or col) - 1 >= 0
Failure to make sure that these are in range will cause no squarres to be highlighted or and the piece to get stuck in the border while moving it
If this happens check TERMINAL and scroll up until you see the error in either legalMoves or controlledSquares and fix the code on that line
Before checking for any information about a piece at a certain square make sure the square has a piece on it 
or there will be a nullPointerExceptionError
both the Piece class and the Board class need to refrence themselves so when doing that use the this key word
After dragging a piece remove it from its original spot then add it to the selected spot so that you are cloning pieces
Only change the variable whiteTurn to !whiteTurn if the move made was successful
ensure this by putting it inside an if statement that checks if the move was legal

If the port isn't connecting refresh the tab the port is in