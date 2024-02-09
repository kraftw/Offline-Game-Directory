package visuals.border_panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import visuals.user_interface.RestartGameButton;
import visuals.user_interface.ReturnToMainMenuButton;

public class SouthPanel extends JPanel {
    
    private static JPanel returnToMainMenuPanel;
    private static JPanel turnIndicatorPanel;
    private static JPanel restartGameButtonPanel;
    private static JPanel returnToMainMenuShadow;
    private static JPanel turnIndicatorShadow;
    private static JPanel restartGameButtonShadow;

    public static JPanel whitePanelTop;
    public static JPanel whitePanelBottom;
    public static JPanel blackPanelTop;
    public static JPanel blackPanelBottom;

    private static Color backgroundColor = new Color(132, 136, 132);
    private static Color shadowColor = new Color(90, 100, 90);
    private static Color lightShadowColor = new Color(140, 170, 140);
    private static Color darkShadowColor = new Color(60, 70, 60);
    private static Color textColor = new Color(255, 240, 240);

    public SouthPanel() {

        setBackground(backgroundColor);
        setLayout(new BorderLayout(25, 25));

        returnToMainMenuPanel = new JPanel(); // WEST
        turnIndicatorPanel = new JPanel(); // CENTER
        restartGameButtonPanel = new JPanel(); // EAST

        // RETURN TO MAIN MENU PANEL
            // RTMM PANEL SETTINGS
            returnToMainMenuPanel.setBackground(shadowColor);
            returnToMainMenuPanel.setLayout(new BorderLayout());
            returnToMainMenuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            returnToMainMenuPanel.setPreferredSize(new Dimension(225, 150));

            // RTMM SHADOW SETTINGS
            returnToMainMenuShadow = new JPanel();
            returnToMainMenuShadow.setBackground(darkShadowColor);
            returnToMainMenuShadow.setLayout(new BorderLayout());
            returnToMainMenuShadow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // RTMM BUTTON
            ReturnToMainMenuButton returnToMainMenuButton = new ReturnToMainMenuButton("<html><center>Return to<br>Main Menu</center></html>");
            returnToMainMenuButton.setBackground(lightShadowColor);
            returnToMainMenuButton.setForeground(textColor);
            returnToMainMenuButton.setBorderPainted(false);
            returnToMainMenuButton.setFocusPainted(false);
            setTextFont(returnToMainMenuButton, "Roboto", Font.BOLD, 20);

            // .ADD CALLS
            returnToMainMenuShadow.add(returnToMainMenuButton);
            returnToMainMenuPanel.add(returnToMainMenuShadow);
            add(returnToMainMenuPanel, BorderLayout.WEST);
        // -------------

        // TURN INDICATOR PANEL
            // TURN INDICATOR PANEL SETTINGS
            turnIndicatorPanel.setSize(new Dimension(800, 50));
            turnIndicatorPanel.setBackground(shadowColor);

            turnIndicatorPanel.setLayout(new BorderLayout());
            turnIndicatorPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // TURN INDICATOR SHADOW SETTINGS
            turnIndicatorShadow = new JPanel();
            turnIndicatorShadow.setBackground(darkShadowColor);
            turnIndicatorShadow.setLayout(new GridLayout(3, 2, 10, 0));
            turnIndicatorShadow.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

            // LABEL PANELS
            JLabel whiteLabel = new JLabel("White", SwingConstants.CENTER);
            whiteLabel.setForeground(textColor);
            setTextFont(whiteLabel, "Roboto", Font.BOLD, 16);

            JLabel blackLabel = new JLabel("Black", SwingConstants.CENTER);
            blackLabel.setForeground(textColor);
            setTextFont(blackLabel, "Roboto", Font.BOLD, 16);

            // WHITE PANEL
            whitePanelTop = new JPanel();
            whitePanelTop.setSize(new Dimension(350, 50));
            whitePanelTop.setBackground(lightShadowColor);
            whitePanelTop.setLayout(new GridLayout(1, 8, 5, 5));

            whitePanelBottom = new JPanel();
            whitePanelBottom.setSize(new Dimension(350, 50));
            whitePanelBottom.setBackground(lightShadowColor);
            whitePanelBottom.setLayout(new GridLayout(1, 8, 5, 5));

            // BLACK PANEL
            blackPanelTop = new JPanel();
            blackPanelTop.setSize(new Dimension(350, 50));
            blackPanelTop.setBackground(lightShadowColor);
            blackPanelTop.setLayout(new GridLayout(1, 8, 5, 5));

            blackPanelBottom = new JPanel();
            blackPanelBottom.setSize(new Dimension(350, 50));
            blackPanelBottom.setBackground(lightShadowColor);
            blackPanelBottom.setLayout(new GridLayout(1, 8, 5, 5));

            // .ADD CALLS
            turnIndicatorShadow.add(whiteLabel);
            turnIndicatorShadow.add(blackLabel);
            turnIndicatorShadow.add(whitePanelTop);
            turnIndicatorShadow.add(blackPanelTop);
            turnIndicatorShadow.add(whitePanelBottom);
            turnIndicatorShadow.add(blackPanelBottom);
            turnIndicatorPanel.add(turnIndicatorShadow);
            add(turnIndicatorPanel, BorderLayout.CENTER);
        // -------------

        // RESTART GAME BUTTON PANEL
            // RESTART GAME BUTTON PANEL SETTINGS
            restartGameButtonPanel.setBackground(shadowColor);
            restartGameButtonPanel.setLayout(new BorderLayout());
            restartGameButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            restartGameButtonPanel.setPreferredSize(new Dimension(225, 150));

            // RESTART GAME BUTTON SHADOW SETTINGS
            restartGameButtonShadow = new JPanel();
            restartGameButtonShadow.setBackground(darkShadowColor);
            restartGameButtonShadow.setLayout(new BorderLayout());
            restartGameButtonShadow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // RESTART GAME BUTTON
            RestartGameButton restartGameButton = new RestartGameButton("<html><center>Restart<br>Game</center></html>");
            restartGameButton.setBackground(lightShadowColor);
            restartGameButton.setForeground(textColor);
            restartGameButton.setBorderPainted(false);
            restartGameButton.setFocusPainted(false);
            setTextFont(restartGameButton, "Roboto", Font.BOLD, 20);

            // .ADD CALLS
            restartGameButtonShadow.add(restartGameButton);
            restartGameButtonPanel.add(restartGameButtonShadow);
            add(restartGameButtonPanel, BorderLayout.EAST);
        // -------------

    }

    private static void setTextFont(JLabel label, String fontFamily, int fontStyle, int fontSize) {

        Font newFont = new Font(fontFamily, fontStyle, fontSize);
        label.setFont(newFont);

    }

    private static void setTextFont(JButton button, String fontFamily, int fontStyle, int fontSize) {

        Font newFont = new Font(fontFamily, fontStyle, fontSize);
        button.setFont(newFont);

    }

    public static boolean isGridLayoutFull(JPanel panel, int rows, int cols) {

        return panel.getComponentCount() == (rows * cols);

    }
    
}
