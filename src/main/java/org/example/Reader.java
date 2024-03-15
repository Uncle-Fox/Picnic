package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private final String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public String readAll(){ StringBuilder stringBuilder = null;

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fileReader)) {

            stringBuilder = new StringBuilder();
            String line;
            String ls = System.lineSeparator();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (stringBuilder == null) {
            return "";
        }
        return stringBuilder.toString();
    }
}