package mechanics;

import javax.swing.ImageIcon;

// IMPORTANT!! all pieces must implement this interface
public interface Piece {

    public boolean getIsWhite();                        // black or white
    public String getName();                       // name of the piece
    public int getId();                                 // #id of piece (i.e. bishop0, bishop1, pawn0/1/2/3/etc.)
    public int[] getPos();
    public ImageIcon getSprite();
    public Space[] getValidMoves(Space[][] board);      // returns valid spaces, sets danger variables
    public int[] moveTo(int x, int y, Space[][] board); // returns null or coords of successful move
    public void remove(Space[][] board);

}