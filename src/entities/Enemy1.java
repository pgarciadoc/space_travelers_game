package entities;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Enemy1 {

    private Image enemyImage1;
    private int x, y;
    private int largura, altura;
    private boolean isVisible;
    private static final int LARGURA = 938;
    private static int VELOCIDADE = 2;

    public Enemy1(int x, int y) {
        this.x = x;
        this.y = y;
        isVisible = true;
    }


    public void carregar() {
        enemyImage1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/enemy1.png"))).getImage();

        this.largura = enemyImage1.getWidth(null);
        this.altura = enemyImage1.getHeight(null);
    }

    public void atualizarEstado() {
        this.x -= VELOCIDADE;
        if (this.x > LARGURA) {
            //isVisible = false;
        }
    }

    public int getPoints(int points) {
        return points;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, largura, altura);
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return enemyImage1;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean eVisivel() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int VELOCIDADE) {
        entities.Enemy1.VELOCIDADE = VELOCIDADE;
    }

}
