package mechanics;

import java.awt.Color;

import visuals.user_interface.Board;

public class HandleInput {

    public static boolean isMoving = false;                                             // whether or not the handleButtonPress is on the first part
    public static Piece movingPiece = null;                                             // the piece that is moving
    public static Color[] original_colors = null;                                       // array of the original colors of the squares that are highlighted

    // makes sure the move is valid and moves the piece
    public static void handleButtonPress(int x, int y){

        if (isMoving == false) {                                                        // part one of moving the clicked piece // !isMoving = isSelecting

            Space clickedSpace = GameBoard.gameBoard[x][y];                             // get the space at the clicked coordinates

            if (clickedSpace.occupant != null){                                         // initiates part one if theres an occupant in the clicked space
                if (clickedSpace.occupant.getIsWhite() == Game.isWhiteTurn) {           // checks that the piece selected is a valid color

                    Piece clickedPiece = clickedSpace.occupant;                             // assigns clickedPiece as the one in the clicked space
                    movingPiece = clickedPiece;                                             // assigns movingPiece as the clicked piece

                    // retrieve piece info
                        // boolean isWhite = clickedPiece.getIsWhite();
                        // int[] position = clickedPiece.getPos();
                        // int id = clickedPiece.getId();
                    //

                    Space[] validMoves = clickedPiece.getValidMoves(GameBoard.gameBoard);   // creates an array of valid moves specific to the clicked piece

                    highlightValidMoves(validMoves);                                        // highlights the valid moves on the board
          
                    isMoving = true;                                                        // begins part two of moving the clicked piece

                }
                else {

                    System.out.println("Invalid Piece Selected!");                        // tells user its the wrong color

                }
            }   
        }

        if (isMoving == true) {                                         

            if (movingPiece.moveTo(x, y, GameBoard.gameBoard) == null) {               // checks if the move is on the board

                System.out.println("Invalid Move Selected!");                         // tells user its null

                isMoving = false;                                                       // return to part one
                movingPiece = null;                                                     // no moving piece since user returns to part one

                int count = 0;                                                                              // starts with the beginning of original_colors
                for (Space space: movingPiece.getValidMoves(GameBoard.gameBoard)){                          // iterates through the valid moves
                    if (space != null) {                                                                    // checks to make sure space is there
                                                                                   
                        Board.squares[space.xCoord][space.yCoord].setBackground(original_colors[count]);    // sets the square to its original color
                        count++;                                                                            // iterates

                    }
                }

                original_colors = null;                                                 // resets the original colors back to null

                return;                                                                 // breaks the if statement

            }
            
            else {                                                                      // moveTo returns new coordinates

                System.out.println("Input Handled");                                  // tells user input is handled

                isMoving = false;                                                       // return to part one
                movingPiece = null;                                                     // no moving piece since user returns to part one

                int count = 0;                                                                              // starts with the beginning of original_colors
                for (Space space: movingPiece.getValidMoves(GameBoard.gameBoard)){                          // iterates through the valid moves
                    if (space != null) {                                                                    // checks to make sure space is there
                                                                                   
                        Board.squares[space.xCoord][space.yCoord].setBackground(original_colors[count]);    // sets the square to its original color
                        count++;                                                                            // iterates

                    }
                }

                original_colors = null;                                                 // resets the original colors back to null

                GameBoard.updateGameBoard();                                            // updates the game board
                Game.isWhiteTurn = !Game.isWhiteTurn;                                   // changes turn 

            }

        }

    }

    // highlights the squares that are valid
    public static void highlightValidMoves(Space[] validMoves) {                        

        original_colors = new Color[validMoves.length];                                             // intializes the size equal to the amount of moves

        int count = 0;

        for (Space space: validMoves){                                                              // iterates through each of the valid moves
            if (space != null) {                                                                    // checks that there is a space there

                original_colors[count] = Board.squares[space.xCoord][space.yCoord].getBackground(); // adds the original color to original colors
                Board.squares[space.xCoord][space.yCoord].setBackground(Color.YELLOW);              // changes the background to yellow
                count++;                                                                            // iterates
                
            }
            
        }
    }


}


