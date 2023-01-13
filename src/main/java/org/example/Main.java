package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        CSVManager reader = new CSVManager();
        InputValidator validator = new InputValidator();
        ArrayList<String> formattedArguments = new ArrayList<>();
        //Reformating argument array for testing purposes.
        for (int i=0;i<args.length;i++){
            formattedArguments.add(args[i]);
        }
        String filePath = validator.validateFilePath(formattedArguments);
        String date = validator.validateDate(formattedArguments);
        ArrayList<Cookie> CSV = reader.readCSV(filePath);
        ArrayList<Cookie> filteredCSV = reader.filterByDate(CSV, date);
        ArrayList<String> output = reader.filterMostActive(filteredCSV);
        for (String s : output) {
            System.out.println(s);
        }
    }
}