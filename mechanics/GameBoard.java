package mechanics;

import mechanics.Pieces.*;

import visuals.user_interface.Board;

public class GameBoard {

    public static Space[][] gameBoard;                                      // main board
    Space[][] pieceBoard = new Space[8][8];                                 // intializes the board the pieces access
    
    public GameBoard() {

        for (int i=0; i<8; i++) {                                           // iterates throught the main board
            for (int j=0; j<8; j++) {

                gameBoard[i][j].xCoord = i;                                 // resets x
                gameBoard[i][j].yCoord = j;                                 // resets y
                gameBoard[i][j].blackDanger = false;                        // resets blackDanger
                gameBoard[i][j].whiteDanger = false;                        // resets whiteDanger
                gameBoard[i][j].occupant = null;                            // removes all the pieces

            }
        }

        intializePieces();

        gameBoard = pieceBoard;                                             // merges the board the pieces use with the main board

    }

    public void intializePieces() {

        // BISHOP
            new Bishop(true, 0, pieceBoard);
            new Bishop(true, 1, pieceBoard);
            new Bishop(false, 0, pieceBoard);
            new Bishop(false, 1, pieceBoard);
        //

        // KNIGHT
            new Knight(true, 0, pieceBoard);
            new Knight(true, 1, pieceBoard);
            new Knight(false, 0, pieceBoard);
            new Knight(false, 1, pieceBoard);
        //

        Board.updateBoard();

    }

    //to be called after each turn
    public void updateGameBoard() {

        for (int i=0; i<8; i++) {                                           // iterates through the gameboard
            for (int j=0; j<8; j++) {

                gameBoard[i][j].blackDanger = false;                        // resets blackDanger
                gameBoard[i][j].whiteDanger = false;                        // resets whiteDanger

            }
        }

        for (int i=0; i<8; i++) {                                           // iterates through the gameboard
            for (int j=0; j<8; j++) {

                if (gameBoard[i][j].occupant != null) {                     // checks for a piece in that spot

                    gameBoard[i][j].occupant.getValidMoves(gameBoard);      // grabs its valid moves

                }

            }
        }
        
    }
    
}