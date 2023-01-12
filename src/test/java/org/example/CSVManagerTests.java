package org.example;
import org.junit.jupiter.api.*;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CSVManagerTests {
    @Test
    public void testReadCSV_CorrectFormat(){
        CSVManager testManager = new CSVManager();
        ArrayList<Cookie> testList = new ArrayList<>();
        Cookie testCookie1 = new Cookie("AtY0laUfhglK3lC7","2018-12-09");
        Cookie testCookie2 = new Cookie("SAZuXPGUrfbcn5UA","2018-12-09");
        Cookie testCookie3 = new Cookie("5UAVanZf6UtGyKVS","2018-12-09");
        testList.add(testCookie1);
        testList.add(testCookie2);
        testList.add(testCookie3);
        String filePath = "src/test/java/org/example/correctFormat.csv";
        ArrayList<Cookie> output = testManager.readCSV(filePath);
//        for (Cookie cookie:testList){
//            System.out.println(cookie.getHash()+cookie.getDate());
//        }
//        for (Cookie cookie:output){
//            System.out.println(cookie.getHash()+cookie.getDate());
//        }
        for (int i=0;i<output.size();i++) {
            if (!testList.get(i).getHash().equals(output.get(i).getHash())) {
                fail();
            }else if (!testList.get(i).getDate().equals(output.get(i).getDate())) {
                fail();
            }else {
                //filler values just to end test, outcome is determined by if statements.
                assertTrue("Test Passed".equals("Test Passed"));
            }
        }
    }
    @Test
    public void testReadCSV_FileLocationIsWrong(){
        CSVManager testManager = new CSVManager();
        String filePath = "";
        assertThrows(RuntimeException.class,() -> testManager.readCSV(filePath));
    }
    @Test
    public void testReadCSV_FileIsEmpty(){
        CSVManager testManager = new CSVManager();
        String filePath = "src/test/java/org/example/empty.csv";
        assertThrows(RuntimeException.class,() -> testManager.readCSV(filePath));
    }
}
