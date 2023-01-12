package org.example;

import java.io.*;
import java.util.*;

public class CSVManager {
    public ArrayList<Cookie> readCSV(String path) {
        ArrayList<Cookie> CSV = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                try {
                    String[] values = line.split(",");
                    String dayOnly = values[1].substring(0,10);
                    Cookie newCookie = new Cookie(values[0], dayOnly);
                    CSV.add(newCookie);
                } catch (Exception e) {
                    System.out.println("Bad line skipped: " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Check that you are submitting the right file.");
        }

        if (CSV.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        return CSV;
    }
    public ArrayList<Cookie> filterByDate(ArrayList<Cookie> list,String date){
        ArrayList<Cookie> filteredCSV = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            if (Objects.equals(list.get(i).getDate(), date)){
                filteredCSV.add(list.get(i));
            }
        }
        return filteredCSV;
    }

    public ArrayList<String> filterMostActive(ArrayList<Cookie> filtered){
        ArrayList<String> filteredCSV = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        Map<String, Integer> tempHash = new HashMap<>();
        for (int i=0;i<filtered.size();i++){
            temp.add(filtered.get(i).getHash());
        }
        for (String s : temp) {
            if (tempHash.containsKey(s)) {
                tempHash.put(s, tempHash.get(s) + 1);
            } else {
                tempHash.put(s, 1);
            }
        }
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : tempHash.entrySet()) {
            int count = entry.getValue();
            if (count > maxCount) {
                maxCount = count;
                filteredCSV.clear();
                filteredCSV.add(entry.getKey());
            } else if (count == maxCount) {
                filteredCSV.add(entry.getKey());
            }
        }
        return filteredCSV;
    }
}
