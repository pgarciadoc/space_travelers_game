package entities;

import javax.swing.*;
import java.awt.*;

public class Placar extends JPanel {

    private Points points;

    public Placar(Points points){
        this.points = points;
        setSize(200, 60);
    }

    public Points getPoints() {
        return points;
    }

    public void updatePlacar() {
        repaint();
    }
}
