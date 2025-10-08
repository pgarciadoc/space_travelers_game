package entities;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.AWTEventMulticaster.add;

public class JogarNovamenteButton implements ActionListener {

    private Container container;

    public void botaoPlayAgain() {
        JButton jButton = new JButton("Jogar Novamente");
        jButton.setLayout(null);
        jButton.setBounds(385, 530, 250, 70);
        jButton.setFont(new Font("Pixely",Font.BOLD, 15));
        jButton.setForeground(new Color(255, 255, 255));
        jButton.setOpaque(false);
        jButton.setBorderPainted(false);

        jButton.addChangeListener((ChangeListener) this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            container = new Container();
        }
    }
