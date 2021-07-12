package de.uni_passau.fim.se.memory.model;

import java.io.*;

public class SavingStats {


    String directory = System.getProperty("user.home");
    String fileNameEasy = "statisticsEasy.txt";
    String fileNameMedium = "statisticsMedium.txt";
    String fileNameDifficult = "statisticsDifficult.txt";
    String absolutePathEasy = directory + File.separator + fileNameEasy;
    String absolutePathMedium = directory + File.separator + fileNameMedium;
    String absolutePathDifficult = directory + File.separator + fileNameDifficult;
    long maxLong = 999999999;

    private static SavingStats savingStats = new SavingStats();


    public static SavingStats getSavingStats() {
        return savingStats;
    }


    private SavingStats() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePathMedium))){
            String line = bufferedReader.readLine();
            long k = statsReaderEasy();
        }catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
        } catch (NumberFormatException e) {
            statsWriterEasy(maxLong);
            statsWriterDifficult(maxLong);
            statsWriterMedium(maxLong);
        }
    }

    public void statsWriterEasy(long newRecord) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePathEasy))) {
            String fileContent = "" + newRecord;
            bufferedWriter.write(fileContent);
        } catch (
                IOException e) {
            System.out.println("IOEXCEPTION");
        }
    }

    public void statsWriterMedium(long newRecord) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePathMedium))) {
            String fileContent = "" + newRecord;
            bufferedWriter.write(fileContent);
        } catch (
                IOException e) {
            System.out.println("IOEXCEPTION");
        }
    }

    public void statsWriterDifficult(long newRecord) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePathDifficult))) {
            String fileContent = "" + newRecord;
            bufferedWriter.write(fileContent);
        } catch (
                IOException e) {
            System.out.println("IOEXCEPTION");
        }
    }

    public long statsReaderEasy() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePathEasy))) {
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
    public long statsReaderMedium() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePathMedium))) {
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

    public long statsReaderDifficult() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePathDifficult))) {
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