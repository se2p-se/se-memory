package de.uni_passau.fim.se.memory;
import de.uni_passau.fim.se.memory.controller.InputStreamPlayer;
import de.uni_passau.fim.se.memory.view.OutputStream;

/**
 * Main class and main entry point. The program starts within this.
 */
public final class Main {

    /**
     * Utility class constructor preventing instantiation.
     */
    private Main() { }

    /**
     * Main sub. This is the entry point of this program to be executed by
     * the OS.
     *
     * @param args command line arguments passed to the program
     */
    public static void main(String[] args) {
        OutputStream.printIntro();
        InputStreamPlayer player = new InputStreamPlayer();
        player.gameLoop();
    }
}
