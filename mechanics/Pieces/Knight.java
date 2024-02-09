package mechanics.Pieces;

import java.io.File;

import javax.swing.ImageIcon;

import mechanics.Piece;
import mechanics.Space;

public class Knight implements Piece {

    private int[] position;         // [x][y]
    boolean isWhite;                // white or black
    String name;                    // "Knight"
    int id;                         // #id of piece (i.e. knight 0 or knight 1)
    ImageIcon sprite;
    String imagePath;               // IMPORTANT!! to get the URL use: Bishop.class.getResource(imagePath)

    public Knight(boolean isWhite, int id, Space[][] board) {

        // intialize variables
            position = new int[2];
            this.isWhite = isWhite;
            this.name = "Knight";
            this.id = id;

            String whiteImagePath = "visuals" + File.separator + "piece_sprites" + File.separator + "knightLight.png";
            String blackImagePath = "visuals" + File.separator + "piece_sprites" + File.separator + "knightDark.png";
        //

        // determines y by isWhite
        if (isWhite){
            this.position[1] = 0;           // sets piece on the bottom row
            imagePath = whiteImagePath;
            sprite = new ImageIcon(Knight.class.getResource(whiteImagePath));
        }
        else { // isBlack
            this.position[1] = 7;           // sets piece on the top row
            imagePath = blackImagePath;
            sprite = new ImageIcon(Knight.class.getResource(blackImagePath));
        }

        // determines x by id
        if (id > 0) {
            this.position[0] = 6;           // sets piece to the right
        }
        else {
            this.position[0] = 1;           // sets piece to the left
        }

        board[this.position[0]][this.position[1]].occupant = this;  // sets position on the gameBoard and identifies itself as an occupant

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
            return this.sprite;
        }
    //

    // returns an array of spaces (the valid moves)
    public Space[] getValidMoves(Space[][] board) {

        int[] pos = this.position;
        Space[] validMoves = new Space[8];
        int moveCounter = 0;

        // checks tall up-right (>^^)
        if (pos[0]+1 < 8 && pos[1]+2 < 8) {                             // makes sure the move is in bounds
            if (!board[pos[0]+1][pos[1]+2].containsAlly(this)) {        // checks for an ally // returns true if theres no ally

                validMoves[moveCounter] = board[pos[0]+1][pos[1]+2];    // valid move to validMoves
                moveCounter++;                                          // iterates

                if (this.isWhite) {
                    board[pos[0]+1][pos[1]+2].whiteDanger=true;         // piece tall up-right (>^^) is in danger of current (white) piece
                }
                else {
                    board[pos[0]+1][pos[1]+2].blackDanger=true;         // piece tall up-right (>^^) is in danger of current (black) piece
                }

            }
        }

        // checks short up-right (>>^)
        if (pos[0]+2 < 8 && pos[1]+1 < 8) {                             // makes sure the move is in bounds
            if (!board[pos[0]+2][pos[1]+1].containsAlly(this)) {        // checks for an ally // returns true if theres no ally

                validMoves[moveCounter] = board[pos[0]+2][pos[1]+1];    // valid move to validMoves
                moveCounter++;                                          // iterates

                if (this.isWhite) {
                    board[pos[0]+2][pos[1]+1].whiteDanger=true;         // piece short up-right (>>^) is in danger of current (white) piece
                }
                else {
                    board[pos[0]+2][pos[1]+1].blackDanger=true;         // piece short up-right (>>^) is in danger of current (black) piece
                }

            }
        }

        // checks short down-right (>>v)
        if (pos[0]+2 < 8 && pos[1]-1 > -1) {                            // makes sure the move is in bounds
            if (!board[pos[0]+2][pos[1]-1].containsAlly(this)) {        // checks for an ally // returns true if theres no ally

                validMoves[moveCounter] = board[pos[0]+2][pos[1]-1];    // valid move to validMoves
                moveCounter++;                                          // iterates

                if (this.isWhite) {
                    board[pos[0]+2][pos[1]-1].whiteDanger=true;         // piece short down-right (>>v) is in danger of current (white) piece
                }
                else {
                    board[pos[0]+2][pos[1]-1].blackDanger=true;         // piece short down-right (>>v) is in danger of current (black) piece
                }

            }
        }

        // checks tall down-right (>vv)
        if (pos[0]+1 < 8 && pos[1]-2 > -1) {                            // makes sure the move is in bounds
            if (!board[pos[0]+1][pos[1]-2].containsAlly(this)) {        // checks for an ally // returns true if theres no ally

                validMoves[moveCounter] = board[pos[0]+1][pos[1]-2];    // valid move to validMoves
                moveCounter++;                                          // iterates

                if (this.isWhite) {
                    board[pos[0]+1][pos[1]-2].whiteDanger=true;         // piece tall down-right (>vv) is in danger of current (white) piece
                }
                else {
                    board[pos[0]+1][pos[1]-2].blackDanger=true;         // piece tall down-right (>vv) is in danger of current (black) piece
                }

            }
        }

        // checks tall down-left (<vv)
        if (pos[0]-1 > -1 && pos[1]-2 > -1) {                           // makes sure the move is in bounds
            if (!board[pos[0]-1][pos[1]-2].containsAlly(this)) {        // checks for an ally // returns true if theres no ally

                validMoves[moveCounter] = board[pos[0]-1][pos[1]-2];    // valid move to validMoves
                moveCounter++;                                          // iterates

                if (this.isWhite) {
                    board[pos[0]-1][pos[1]-2].whiteDanger=true;         // piece tall down-left (<vv) is in danger of current (white) piece
                }
                else {
                    board[pos[0]-1][pos[1]-2].blackDanger=true;         // piece tall down-left (<vv) is in danger of current (black) piece
                }

            }
        }

        // checks short down-left (<<v)
        if (pos[0]-2 > -1 && pos[1]-1 > -1) {                           // makes sure the move is in bounds
            if (!board[pos[0]-2][pos[1]-1].containsAlly(this)) {        // checks for an ally // returns true if theres no ally

                validMoves[moveCounter] = board[pos[0]-2][pos[1]-1];    // valid move to validMoves
                moveCounter++;                                          // iterates

                if (this.isWhite) {
                    board[pos[0]-2][pos[1]-1].whiteDanger=true;         // piece short down-left (<<v) is in danger of current (white) piece
                }
                else {
                    board[pos[0]-2][pos[1]-1].blackDanger=true;         // piece short down-left (<<v) is in danger of current (black) piece
                }

            }
        }

        // checks short up-left (<<^)
        if (pos[0]-2 > -1 && pos[1]+1 < 8) {                            // makes sure the move is in bounds
            if (!board[pos[0]-2][pos[1]+1].containsAlly(this)) {        // checks for an ally // returns true if theres no ally

                validMoves[moveCounter] = board[pos[0]-2][pos[1]+1];    // valid move to validMoves
                moveCounter++;                                          // iterates

                if (this.isWhite) {
                    board[pos[0]-2][pos[1]+1].whiteDanger=true;         // piece short up-left (<<^) is in danger of current (white) piece
                }
                else {
                    board[pos[0]-2][pos[1]+1].blackDanger=true;         // piece short up-left (<<^) is in danger of current (black) piece
                }

            }
        }

        // checks tall up-left (<^^)
        if (pos[0]-1 > -1 && pos[1]+2 < 8) {                            // makes sure the move is in bounds
            if (!board[pos[0]-1][pos[1]+2].containsAlly(this)) {        // checks for an ally // returns true if theres no ally

                validMoves[moveCounter] = board[pos[0]-1][pos[1]+2];    // valid move to validMoves
                moveCounter++;                                          // iterates

                if (this.isWhite) {
                    board[pos[0]-1][pos[1]+2].whiteDanger=true;         // piece tall up-left (<^^) is in danger of current (white) piece
                }
                else {
                    board[pos[0]-1][pos[1]+2].blackDanger=true;         // piece tall up-left (<^^) is in danger of current (black) piece
                }

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
