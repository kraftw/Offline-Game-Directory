package mechanics;

// spaces are only created by the GameBoard
// coord variables are set by the GameBoard
// other variables are set by Piece initializations
public class Space {

    public Piece occupant;              // piece in that space // pieces should only be accessed by input handling via occupants of a space
    public boolean whiteDanger;         // is in danger of a white piece
    public boolean blackDanger;         // is in danger of a black piece
    public int xCoord;                  
    public int yCoord;

    public boolean containsAlly(Piece piece) {

        if (this.occupant != null) {                                    // if theres no piece occupying this space
            return (piece.getIsWhite() == this.occupant.getIsWhite());  // returns true if its the same color as the current piece
        }

        return false;

    }

    public boolean containsEnemy(Piece piece) {

        if (this.occupant != null) {                                    // if theres no piece occupying this space
            return (piece.getIsWhite() != this.occupant.getIsWhite());  // returns true if its the opposite color as the current piece
        }

        return false;

    }

    // public boolean isEqual(Space space) {
    //     return this.xcoord == space.xcoord && this.ycoord == space.ycoord;
    // }

}