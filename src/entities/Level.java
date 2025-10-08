package entities;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Objects;

public class Level extends JPanel implements ActionListener {
    private Image background;
    private Player player;
    private Timer timer;
    private java.util.List<Enemy1> enemy1;
    private boolean emJogo;
    private Points points;
    private Placar placar;
    private JogarNovamenteButton jogarNovamenteButton;

    Level(Points points, Placar placar) {

        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon reference = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/background.png")));
        background = reference.getImage();
        this.player = new Player();
        this.player.load();

        addKeyListener(new TecladoAdapter());

        timer = new Timer(5, this);
        timer.start();

        inicializaInimigos();
        emJogo = true;

        this.points = points;
        this.placar = placar;

    }


    //número de inimigos
    public void inicializaInimigos() {
        int coordenadas [] = new int[40];
        enemy1 = new ArrayList<Enemy1>();
    //respaw de inimigos aleatórios
        for (int i = 0; i < coordenadas.length; i++) {
            int x = (int)(Math.random() * 8000 + 1024);
            int y = (int)(Math.random() * 650 + 30);
            enemy1.add(new Enemy1(x, y));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (emJogo){
            g.drawImage(background, 0, 0, null);
            g.drawImage(player.getImagem(), player.getX(), player.getY(), this);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Pixely", Font.BOLD, 20));
            g.drawString("Score: " + points.getValor(), 20, 30);

            java.util.List<Tiro> tiros = player.getTiros();
            for (int i = 0; i < tiros.size(); i++) {
                Tiro m = tiros.get(i);
                m.load();
                g.drawImage(m.getImagem(), m.getX(), m.getY(), this);
            }

            for (int o = 0; o < enemy1.size(); o++) {
                Enemy1 in = enemy1.get(o);
                in.carregar();
                g.drawImage(in.getImage(), in.getX(), in.getY(), this);
            }
        }else {
            ImageIcon fimJogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/gameover.png")));
            g.drawImage(fimJogo.getImage(), 0, 0, null );
            g.setColor(Color.WHITE);
            g.setFont(new Font("Pixely", Font.BOLD, 20));
            g.drawString("Score Final: " + points.getValor(), 420, 514);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.Update();
        java.util.List<Tiro> tiros = player.getTiros();
        for (int i = 0; i < tiros.size(); i++) {
            Tiro m = tiros.get(i);
                if (m.isVisible()) {
                    m.update();
                }else {
                    tiros.remove(i);
                }
        }

        //assim como tiro, podemos criar um monte de inimigos
        for (int o = 0; o < enemy1.size(); o++) {
            Enemy1 in = enemy1.get(o);
                if (in.eVisivel()) {
                    in.atualizarEstado();
                }else {
                    enemy1.remove(o);
                }
        }

        checarColisoes();
        repaint();
    }

    public void checarColisoes() {
        Rectangle formaNave = player.getBounds();
        Rectangle formaEnemy1;
        Rectangle formaTiro;

        //colisão inimigo contra player
        for (int i = 0; i < enemy1.size(); i++) {
            Enemy1 tempEnemy1 = enemy1.get(i);
            formaEnemy1 = tempEnemy1.getBounds();
                if (formaNave.intersects(formaEnemy1)) {
                    player.setVisible(false);
                    tempEnemy1.setVisible(false);
                    emJogo = false;
                }
        }
        //sistema de destruição de inimigos através do tiro
        java.util.List<Tiro> tiros = player.getTiros();
        for (int j = 0; j < tiros.size(); j++) {
            Tiro tempTiro = tiros.get(j);
            formaTiro = tempTiro.getBounds();
            for (int o = 0; o < enemy1.size(); o++) {
                Enemy1 tempEnemy1 = enemy1.get(o);
                formaEnemy1 = tempEnemy1.getBounds();
                if (formaTiro.intersects(formaEnemy1)){
                    tempEnemy1.setVisible(false);
                    tempTiro.setVisible(false);
                    points.addValor(10);
                    placar.updatePlacar();
                }
            }
        }
    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyRelease(e);
        }
    }

    public java.util.List<Enemy1> getEnemy1() {
        return enemy1;
    }

    public void setEnemy1(java.util.List<Enemy1> enemy1) {
        this.enemy1 = enemy1;
    }

}
