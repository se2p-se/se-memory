package de.uni_passau.fim.se.memory.model;
import java.io.*;

/**
 * SavingStats takes care of saving a highscore file on the user's machine on path "user.home"
 * Saved text file is called "statistics.txt"
 */
public class SavingStats {

    String directory = System.getProperty("user.home");
    String fileName = "statistics.txt";
    String absolutePath = directory + File.separator + fileName;
    long maxLong = 999999999;

    private static SavingStats savingStats = new SavingStats();

    public static SavingStats getSavingStats() {
        return savingStats;
    }

    private SavingStats() {
    }

    /**
     * Creates a new entry in "statistics.txt" if the user accomplishes a new highscore
     * Saves the time in milliseconds
     * @param newRecord is the time the player needed to finish the game
     */
    public void statsWriter(long newRecord) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))) {
            String fileContent = "" + newRecord;
            bufferedWriter.write(fileContent);
        } catch (
                IOException e) {
            System.out.println("IOEXCEPTION");
        }
    }

    /**
     * Accesses the "statistics.txt" file on the user's machine
     * @return time of "statistics.txt" file
     */
    public long statsReader() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
            String line = bufferedReader.readLine();
            return Integer.parseInt(line);
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            return maxLong;
        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
            return maxLong;
        }
    }
}