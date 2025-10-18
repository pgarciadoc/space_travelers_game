package entities;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Objects;

public class GameSong {

    private static Clip clip;
    private static boolean running;
    private static Thread thread;

    public static void playMusic() {
        if (running) return;

        running = true;
        thread = new Thread(() -> {
            try {
                stopMusic(); // garante que nada antigo esteja tocando

                InputStream audioSrc = Objects.requireNonNull(
                        GameSong.class.getResourceAsStream("/resources/Scrub Slayer - Cody O'Quinn - 01 Scrub Slayer.wav"),
                        "Arquivo de áudio não encontrado!"
                );

                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                        new BufferedInputStream(audioSrc)
                );

                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erro ao tocar música");
                running = false;
            }
        });

        // 🔥 Roda em paralelo ao jogo
        thread.setDaemon(true);
        thread.start();
    }

    public static void stopMusic() {
        running = false;
        if (clip != null) {
            clip.stop();
            clip.close();
            clip = null;
        }
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
            thread = null;
        }
    }
}
