package de.uni_passau.fim.se.memory;
import de.uni_passau.fim.se.memory.controller.InputStreamMainMenue;
import de.uni_passau.fim.se.memory.view.OutputStream;
import de.uni_passau.fim.se.memory.view.OutputStreamMainMenue;

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
        OutputStreamMainMenue.showMainMenue();
        InputStreamMainMenue mainMenue = new InputStreamMainMenue();
        mainMenue.pickMainMenueOption();
    }
}
