package entities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.ConstructorProperties;

import static java.awt.AWTEventMulticaster.add;

public class JogarNovamenteButton extends JButton implements ActionListener {

    private Container container;
    private boolean emJogo;
    private Points points;
    private Placar placar;
    private GameSong gameSong;

    public JogarNovamenteButton(Placar placar, Points points) {
        super("Jogar Novamente");
        this.placar = placar;
        this.points = points;

        setBounds(385, 530, 250, 70);
        setFont(new Font("Pixely", Font.BOLD, 15));
        setForeground(Color.WHITE);
        setOpaque(false);
        setBorderPainted(false);
        addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.getWindowAncestor(this).dispose();
        GameSong.stopMusic();
        try {
            container = new Container();
            GameSong.playMusic();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
