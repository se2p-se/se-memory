package de.uni_passau.fim.se.memory.model;

import java.io.*;

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

    public void statsWriter(long newRecord) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))) {
            String fileContent = "" + newRecord;
            bufferedWriter.write(fileContent);
        } catch (
                IOException e) {
            System.out.println("IOEXCEPTION");
        }
    }

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