package entities;

import javax.swing.*;
import java.awt.*;

public class Container extends JFrame {

    private Placar placar;
    private boolean emJogo;
    private Level level;
    private Points points;
    private JogarNovamenteButton jogarNovamenteButton;

    public Container() throws Exception {
        setTitle("Space Travelers");
        setSize(1024, 728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);

        points = new Points();
        placar = new Placar(points);
        level = new Level(points, placar);
        jogarNovamenteButton = new JogarNovamenteButton(placar, points);
        setLayout(new BorderLayout());
        add(level, BorderLayout.CENTER);
        add(placar, BorderLayout.NORTH);

        setVisible(true);

        SwingUtilities.invokeLater(() -> {
            level.requestFocusInWindow();
        });
    }

}
