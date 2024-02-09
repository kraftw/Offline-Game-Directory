package visuals.user_interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;

import mechanics.GameBoard;
import mechanics.HandleInput;
import mechanics.Pieces.Bishop;

public class Board extends JPanel {

    private static Color lightColor = new Color(177, 228, 185);
    private static Color darkColor = new Color(112, 162, 163);
    private static Color darkShadowColor = new Color(60, 70, 60);

    public static JButton[][] squares;
    
    public Board() {

        squares = new JButton[8][8];
        setBackground(new Color(132, 136, 132));
        
        createChessBoard();

    }


    private void createChessBoard() {

        setLayout(new GridLayout(8, 8));

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {

                JButton button = createChessButton(x, y);
                squares[x][y] = button;
                add(button);

            }
        }

        revalidate();
        repaint();

    }


    private JButton createChessButton(int x, int y) {

        JButton button = new JButton();
        
        if ((x + y) % 2 == 0) {
            button.setBackground(lightColor);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
        }
        else {
            button.setBackground(darkColor);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                HandleInput.handleButtonPress(x, y);

            }
        });

        return button;

    }


    public static void changeColor(Color newLightColor, Color newDarkColor) {

        lightColor = newLightColor;
        darkColor = newDarkColor;

        for(int y = 0; y < 8; y++) {
            for(int x = 0; x < 8; x++) {

                JButton square = squares[x][y];
                if ((x + y) % 2 == 0) {
                    square.setBackground(lightColor);
                }
                else {
                    square.setBackground(darkColor);
                }

            }
        }

    }

    public static void toggleCoordinates(Boolean isToggled) {



        if (isToggled) {
            for(int y = 0; y < 8; y++) {
                for(int x = 0; x < 8; x++) {
                    if (squares[x][y].getIcon() == null) {
                        JButton square = squares[x][y];
                        setButtonFont(square, "Roboto", Font.BOLD, 12);
                        square.setText(formatCoordinates(x, y));
                        square.setForeground(darkShadowColor);
                    }
                    else {
                        // pass
                    }
                }
            }
        }
        else {
            for(int y = 0; y < 8; y++) {
                for(int x = 0; x < 8; x++) {
    
                    JButton square = squares[x][y];
                    square.setText(""); 
    
                }
            }
        }

    }

    public static void updateBoard() {

        for(int y = 0; y < 8; y++) {
            for(int x = 0; x < 8; x++) {
                if (GameBoard.gameBoard[x][y].occupant != null) {

                    squares[x][y].setIcon(GameBoard.gameBoard[x][y].occupant.getSprite());

                }
            }
        }

    }

    private static String formatCoordinates(int x, int y) {

        String formattedCoords;
        String formattedXCoord = "";
        int formattedYCoord = 0;

        switch (x) {
            case 0:
                formattedXCoord = "A";
                break;
            case 1:
                formattedXCoord = "B";
                break;
            case 2:
                formattedXCoord = "C";
                break;
            case 3:
                formattedXCoord = "D";
                break;
            case 4:
                formattedXCoord = "E";
                break;
            case 5:
                formattedXCoord = "F";
                break;
            case 6:
                formattedXCoord = "G";
                break;
            case 7:
                formattedXCoord = "H";
                break;
            default:
                break;
        }

        switch (y) {
            case 0:
                formattedYCoord = 8;
                break;
            case 1:
                formattedYCoord = 7;
                break;
            case 2:
                formattedYCoord = 6;
                break;
            case 3:
                formattedYCoord = 5;
                break;
            case 4:
                formattedYCoord = 4;
                break;
            case 5:
                formattedYCoord = 3;
                break;
            case 6:
                formattedYCoord = 2;
                break;
            case 7:
                formattedYCoord = 1;
                break;
            default:
                break;
        }

        formattedCoords = formattedXCoord + formattedYCoord;
        return formattedCoords;

    }

    private static void setButtonFont(JButton button, String fontFamily, int fontStyle, int fontSize) {

        Font newFont = new Font(fontFamily, fontStyle, fontSize);
        button.setFont(newFont);

    }

}
