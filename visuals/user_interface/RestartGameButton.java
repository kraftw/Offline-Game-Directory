package visuals.user_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import mechanics.Game;

public class RestartGameButton extends JButton {
    
    public RestartGameButton(String text) {

        setText(text);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Game.restartGame();

            }
        });

    }

}
