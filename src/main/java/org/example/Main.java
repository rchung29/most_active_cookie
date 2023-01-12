package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        CSVManager reader = new CSVManager();
        String filePath;
        String date;
        try {
            filePath = args[0];
        } catch (Exception var) {
            throw new RuntimeException("No file given");
        }
        try {
            date = args[1];
        } catch (Exception e){
            throw new RuntimeException("No date was given");
        }
        if (!filePath.endsWith(".csv")){
            throw new RuntimeException("Invalid file type provided");
        }
        if (args[1].length()!=10){
            throw new RuntimeException("Data is in wrong format. Please format it YYYY-MM-DD");
        }
        ArrayList<Cookie> CSV = reader.readCSV(filePath);
        ArrayList<Cookie> filteredCSV = reader.filterByDate(CSV, date);
        ArrayList<String> output = reader.filterMostActive(filteredCSV);
        for (String s : output) {
            System.out.println(s);
        }
    }
}