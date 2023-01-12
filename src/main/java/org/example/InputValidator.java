package org.example;

import java.io.*;
import java.util.*;

public class InputValidator {
    public String validateFilePath(ArrayList<String> args){
        String filePath;
        try {
            filePath = args.get(0);
        } catch (Exception var) {
            throw new RuntimeException("No file given");
        }
        if (!filePath.endsWith(".csv")){
            throw new RuntimeException("Invalid file type provided");
        }
        return filePath;
    }
    public String validateDate(ArrayList<String> args){
        String date;
        if (!args.get(1).equals("-d")){
            throw new RuntimeException("Arguments are not formatted properly. Should be example.csv -d YYYY-MM-DD ");
        }
        try {
            date = args.get(2);
        } catch (Exception e){
            throw new RuntimeException("No date was given");
        }
        if (args.get(2).length()!=10){
            throw new RuntimeException("Data is in wrong format. Please format it YYYY-MM-DD");
        }
        return date;
    }
}
