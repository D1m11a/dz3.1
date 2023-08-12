package dz3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberReader {
    public static void main(String[] args) {
        readAndPrintValidPhoneNumbers("file.txt");
    }

    public static void readAndPrintValidPhoneNumbers(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Pattern pattern = Pattern.compile("\\((\\d{3})\\) (\\d{3})-(\\d{4})|(\\d{3})-(\\d{3})-(\\d{4})");

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String phoneNumber = "";
                    if (matcher.group(1) != null) {
                        phoneNumber = "(" + matcher.group(1) + ") " + matcher.group(2) + "-" + matcher.group(3);
                    } else if (matcher.group(4) != null) {
                        phoneNumber = matcher.group(4) + "-" + matcher.group(5) + "-" + matcher.group(6);
                    }
                    System.out.println("Valid phone number: " + phoneNumber);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

