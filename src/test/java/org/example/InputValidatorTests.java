package org.example;
import org.junit.jupiter.api.*;
import java.util.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InputValidatorTests {

    @Test
    public void testValidateFilePath_CorrectFormat(){
        ArrayList<String> test = new ArrayList<>();
        InputValidator testValidator = new InputValidator();
        test.add("test.csv");
        String correctFormat = "test.csv";
        String output = testValidator.validateFilePath(test);
        assertTrue(output.equals(correctFormat));
    }
    @Test
    public void testValidateFilePath_WrongFileFormat(){
        ArrayList<String> test = new ArrayList<>();
        InputValidator testValidator = new InputValidator();
        test.add("test.cs");
        assertThrows(RuntimeException.class,() -> testValidator.validateFilePath(test));
    }
    @Test
    public void testValidateFilePath_NoFileGiven(){
        ArrayList<String> test = new ArrayList<>();
        InputValidator testValidator = new InputValidator();
        assertThrows(RuntimeException.class,() -> testValidator.validateFilePath(test));
    }
    @Test
    public void testValidateDate_CorrectFormat(){
        ArrayList<String> test = new ArrayList<>();
        InputValidator testValidator = new InputValidator();
        test.add("test.csv");
        test.add("-d");
        test.add("2018-20-09");
        String correctFormat = "2018-20-09";
        String output = testValidator.validateDate(test);
        assertTrue(output.equals(correctFormat));
    }
    @Test
    public void testValidateDate_MissingDateIndicator(){
        ArrayList<String> test = new ArrayList<>();
        InputValidator testValidator = new InputValidator();
        test.add("test.csv");
        test.add("2018-20-09");
        assertThrows(RuntimeException.class,() -> testValidator.validateDate(test));
    }
    @Test
    public void testValidateDate_MissingNoDateGivenandNoDateIndicator(){
        ArrayList<String> test = new ArrayList<>();
        InputValidator testValidator = new InputValidator();
        test.add("test.csv");
        assertThrows(RuntimeException.class,() -> testValidator.validateDate(test));
    }
    @Test
    public void testValidateDate_MissingNoDateGiven(){
        ArrayList<String> test = new ArrayList<>();
        InputValidator testValidator = new InputValidator();
        test.add("test.csv");
        test.add("-d");
        assertThrows(RuntimeException.class,() -> testValidator.validateDate(test));
    }
    @Test
    public void testValidateDate_DateLengthOrWrongFormat(){
        ArrayList<String> test = new ArrayList<>();
        InputValidator testValidator = new InputValidator();
        test.add("test.csv");
        test.add("-d");
        test.add("20188790");
        assertThrows(RuntimeException.class,() -> testValidator.validateDate(test));
    }
}
