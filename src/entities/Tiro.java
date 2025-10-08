package entities;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Tiro {

    private Image imagem;
    private int x, y;
    private int largura, altura;
    private boolean isVisible;

    private static final int LARGURA = 938;
    private static int VELOCIDADE = 5;

    public Tiro(int x, int y) {
        this.x = x;
        this.y = y;
        isVisible = true;
    }

    public void load() {
        ImageIcon reference = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/tiro.png")));
        imagem = reference.getImage();

        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }

    public void update() {
        this.x += VELOCIDADE;
        if (this.x > LARGURA) {
            isVisible = false;
        }
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

    public Image getImagem() {
        return imagem;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int VELOCIDADE) {
        Tiro.VELOCIDADE = VELOCIDADE;
    }
}
