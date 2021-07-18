package de.uni_passau.fim.se.memory.controller;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 * Handles sound requirements for the game
 */
public class SoundPlayer {

    /**
     * Play specific sound on str
     *
     * Possible values for str: "Pair", "NoPair", "GameOST"
     *
     * If str is not in possible values then a click sound is played
     *
     * @param str
     */
    public static void playSound(String str) {
        URL url;

        try {
            url = switch (str) {
                case "Pair" -> Controller.class.getClassLoader().getResource("de/uni_passau/fim/se/memory/view/Sounds/Pair.wav");
                case "NoPair" -> Controller.class.getClassLoader().getResource("de/uni_passau/fim/se/memory/view/Sounds/NoPair.wav");
                case "GameOST" -> Controller.class.getClassLoader().getResource("de/uni_passau/fim/se/memory/view/Sounds/GameOST.wav");
                default -> Controller.class.getClassLoader().getResource("de/uni_passau/fim/se/memory/view/Sounds/Click.wav");
            };

            assert url != null;
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float range = volume.getMaximum() - volume.getMinimum();
            float gain = (range * 0.7f) + volume.getMinimum();
            volume.setValue(gain);
            if (str.equals("GameOST")) {
                clip.loop(999);
            } else {
                clip.start();
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
