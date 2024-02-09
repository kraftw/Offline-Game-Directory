package mechanics.Pieces;

import java.io.File;

import javax.swing.ImageIcon;

import mechanics.Piece;
import mechanics.Space;

public class Bishop implements Piece {

    private int[] position;         // [x][y]
    boolean isWhite;                // white or black
    String name;                    // "Bishop"
    int id;                         // #id of piece (i.e. bishop 0 or bishop 1)
    static ImageIcon sprite;
    String imagePath;               // IMPORTANT!! to get the URL use: Bishop.class.getResource(imagePath)

    public Bishop(boolean isWhite, int id, Space[][] pieceBoard) {

        // intialize variables
            position = new int[2];
            this.isWhite = isWhite;
            this.name = "Bishop";
            this.id = id;

            String whiteImagePath = "visuals" + File.separator + "piece_sprites" + File.separator + "bishopLight.png";
            String blackImagePath = "visuals" + File.separator + "piece_sprites" + File.separator + "bishopDark.png";
        //

        // determines y by isWhite
        if (isWhite){
            this.position[1] = 0;           // sets piece on the bottom row
            imagePath = whiteImagePath;
            sprite = new ImageIcon(Bishop.class.getResource(whiteImagePath));
        }
        else { // isBlack
            this.position[1] = 7;           // sets piece on the top row
            imagePath = blackImagePath;
            sprite = new ImageIcon(Bishop.class.getResource(blackImagePath));
        }

        // determines x by id
        if (id > 0) {
            this.position[0] = 5;           // sets piece to the right
        }
        else {
            this.position[0] = 2;           // sets piece to the left
        }

        pieceBoard[this.position[0]][this.position[1]].occupant = this;  // sets position on the gameBoard and identifies itself as an occupant

    }

    // interface methods
        public int[] getPos() {
            return this.position;
        }
        public int getId() {
            return this.id;
        }
        public boolean getIsWhite() {
            return this.isWhite;
        }
        public String getName() {
            return this.name;
        }
        public ImageIcon getSprite() {
            return sprite;
        }
    //

    // returns an array of spaces (the valid moves)
    public Space[] getValidMoves(Space[][] board) {

        int[] pos = this.position;                                      // grabs position initialized earlier
        Space[] validMoves = new Space[13];                             // intializes array with the size relating to the max amount of moves
        int moveCounter = 0;                                            // starts at 0 since no moves are made

        // checks up-right diagonal (/)
        for (
                int i = 1;                                              // starts at the next spot diagonally // doesn't need to check current spot
                pos[0] + i < 8 &&                                       // horizontal component // makes sure is not past bounds
                pos[1] + i < 8 &&                                       // vertical component // makes sure is not past bounds
                !board[pos[0]+i][pos[1]+i].containsAlly(this);          // checks diagonal for ally // returns true if theres no ally
                i++                                                     // iterates
            )
        {

            validMoves[moveCounter] = board[pos[0] + i][pos[1] + i];    // adds the valid move to validMoves
            moveCounter++;                                              // iterates

            if (this.isWhite) {
                board[pos[0]+i][pos[1]+i].whiteDanger = true;           // piece up-right diagonal (/) is in danger of current (white) piece
            }
            else {
                board[pos[0]+i][pos[1]+i].blackDanger = true;           // piece up-right diagonal (/) is in danger of current (black) piece
            }
            if (board[pos[0]+i][pos[1]+i].containsEnemy(this)) {        // if space contains an enemy, go no further
                i = 10;                                                 // ends loop
            }

        }

        // checks down-right diagonal (\)
        for (
                int i = 1;                                              // starts at next spot diagonally // doesn't need to check current spot
                pos[0] + i < 8 &&                                       // horizontal component // makes sure its not past bounds
                pos[1] - i > -1 &&                                      // vertical component // makes sure is not past bounds
                !board[pos[0]+i][pos[1]-i].containsAlly(this);          // checks diagonal for ally // returns true if theres no ally
                i++                                                     // iterates
            )
        {

            validMoves[moveCounter] = board[pos[0]+i][pos[1]-i];        // adds the valid move to validMoves
            moveCounter++;                                              // iterates

            if (this.isWhite) {
                board[pos[0]+i][pos[1]-i].whiteDanger = true;           // piece down-right diagonal (\) is in danger of current (black) piece
            }
            else {
                board[pos[0]+i][pos[1]-i].blackDanger = true;           // piece down-right diagonal (\) is in danger of current (black) piece
            }
            if (board[pos[0]+i][pos[1]-i].containsEnemy(this)) {        // if space contains an enemy, go no further
                i = 10;                                                 // ends loop
            }

        }

        // checks down-left diagonal (/)
        for (
                int i = 1;                                              // starts at next spot diagonally // doesn't need to check current spot
                pos[0] - i > -1 &&                                      // horizontal component // makes sure its not past bounds
                pos[1] - i > -1 &&                                      // vertical component // makes sure its not past bounds
                !board[pos[0]-i][pos[1]-i].containsAlly(this);          // checks diagonal for ally // returns true if theres no ally
                i++                                                     // iterates
            )
        { 

            validMoves[moveCounter] = board[pos[0]-i][pos[1]-i];        // adds the valid move to validMsoves
            moveCounter++;                                              // iterates

            if (this.isWhite) {
                board[pos[0]-i][pos[1]-i].whiteDanger = true;           // piece down-left diagonal (/) is in danger of current (white) piece
            }
            else {
                board[pos[0]-i][pos[1]-i].blackDanger = true;           // piece down-left diagonal (/) is in danger of current (black) piece
            }
            if (board[pos[0]-i][pos[1]-i].containsEnemy(this)) {        // if space contains an enemy, go no further
                i = 10;                                                 // ends loop                              
            }
        }

        // checks up-left diagonal (\)
        for (
                int i = 1;                                              // starts at next spot diagonally // doesn't need to check current spot
                pos[0] - i > -1 &&                                      // horizontal component // makes sure its not past bounds
                pos[1] + i < 8 &&                                       // vertical component // makes sure its not past bounds
                !board[pos[0]-i][pos[1]+i].containsAlly(this);          // checks diagonal for ally // returns true if theres no ally
                i++                                                     // iterates
            )
        { 

            validMoves[moveCounter] = board[pos[0]-i][pos[1]+i];        // adds the valid move to validMoves
            moveCounter++;                                              // iterates

            if (this.isWhite) {
                board[pos[0]-i][pos[1]+i].whiteDanger = true;           // piece up-left diagonal (\) is in danger of current (white) piece
            }
            else {
                board[pos[0]-i][pos[1]+i].blackDanger=true;             // piece up-left diagonal (\) is in danger of current (black) piece
            }
            if (board[pos[0]-i][pos[1]+i].containsEnemy(this)) {        // if space contains an enemy, go no further
                i = 10;                                                 // ends loop
            }

        }

        return validMoves;                                              // returns the array of valid moves

    }

    // moves piece to the coordinates
    public int[] moveTo(int x, int y, Space[][] board) {
        
        Space [] validMoves = this.getValidMoves(board);                                        // grabs valid moves defined earlier

        for (int i = 0; i < validMoves.length; i++) {                                           // iterates through the valid moves
            if (validMoves[i].xCoord == x & validMoves[i].yCoord == y) {                        // if the passed x and y match the coordinates of a valid move

                board[this.position[0]][this.position[1]].occupant = null;                      // removes piece in the current space

                if (board[validMoves[i].xCoord][validMoves[i].yCoord].containsEnemy(this)) {    // if the space contains an enemy

                    board[validMoves[i].xCoord][validMoves[i].yCoord].occupant.remove(board);   // remove the enemy from the board

                }

                board[validMoves[i].xCoord][validMoves[i].yCoord].occupant = this;              // adds piece at the valid coordinates
                
                int[] newCoords = new int[2];                           // intialize the new coordinates
                newCoords[0] = validMoves[i].xCoord;                    // update the x coordinate
                newCoords[1] = validMoves[i].yCoord;                    // update the y coordinate
                this.position = newCoords;                              // update the position

                //todo: figure out danger variables... Currently thinking they should be updated by the input handler compiling valid moves.

                return newCoords;                                       // return the new coordinates

            }
        }

        return null;                                                    // if the passed x and y are not valid moves, return null
        
    }

    public void remove(Space[][] board){

        board[this.position[0]][this.position[1]].occupant = null;      // removes piece
        this.position = null;                                           // removes position

    }

}
