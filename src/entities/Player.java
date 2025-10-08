package entities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Player {

    private int x,y;
    private int dx,dy;
    private Image imagem;
    private int altura,largura;
    private List <Tiro> tiros;
    private boolean isVisible;
    private int points = 0;

    //spawn do player
    public Player() {
        this.x = 100;
        this.y = 100;
        isVisible = true;
        tiros = new ArrayList<Tiro>();

    }
    //carrega o player na tela
    public void load() {
        ImageIcon reference = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/spaceship02.png")));
        imagem = reference.getImage();
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
    }

    //faz a nave se mover nos eixos x e y
    public void Update() {
        x += dx;
        y += dy;
    }
    //Tiro
    public void tiroSimples() {
        this.tiros.add(new Tiro(x + largura, y + (altura/5)));
    }
    //colisão
    public Rectangle getBounds() {
        return new Rectangle(x, y, largura, altura);
    }

    // controles de teclas
    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_SPACE) {
            tiroSimples();
        }

        if (codigo == KeyEvent.VK_UP) {
            dy = -3;
        }

        if (codigo == KeyEvent.VK_DOWN) {
            dy = 3;
        }

        if (codigo == KeyEvent.VK_LEFT) {
            dx = -3;
        }

        if (codigo == KeyEvent.VK_RIGHT) {
            dx = 3;
        }
    }

    public void keyRelease(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (codigo == KeyEvent.VK_DOWN) {
            dy = 0;
        }

        if (codigo == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (codigo == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
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

    public void setY(int y) {
        this.y = y;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public List<Tiro> getTiros() {
        return tiros;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
