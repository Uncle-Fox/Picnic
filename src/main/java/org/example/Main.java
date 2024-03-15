package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static String dataFileName = "GoodsForPicnic.txt";

    public static void main(String[] args) {
        Reader reader = new Reader(dataFileName);
        String data = reader.readAll();
        data = normalize(data);
        System.out.println("\nВ файле " + dataFileName + " " + (countSpaces(data) + 1) + " слова\n");
        System.out.println("Самые длинные слова: " + longestWords(data));
        System.out.println("\nПопулярность продуктов:");
        printSorted(countWords(data));
    }
    private static void printSorted(HashMap<String, Integer> source) {
        source.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }

    private static HashMap<String, Integer> countWords(String s) {
        HashMap<String, Integer> result = new HashMap<>();
        String[] words = s.split(" ");
        for (String word : words) {
            if (result.containsKey(word)) {
                result.put(word, result.get(word) + 1);
            } else {
                result.put(word, 1);
            }
        }
        return result;
    }

    private static ArrayList<String> longestWords(String s) {
        String[] words = s.split(" ");
        int longestLen = 0;
        ArrayList<String> longestWords = new ArrayList<>();
        for (String word : words) {
            if (word.length() > longestLen) {
                longestLen = word.length();
                longestWords = new ArrayList<>();
                longestWords.add(word);
            } else if (word.length() == longestLen) {
                if (!longestWords.contains(word)) {
                    longestWords.add(word);
                }
            }
        }
        return longestWords;
    }

    private static int countSpaces(String s) {
        int spaceCount = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        return spaceCount;
    }

    private static String normalize(String s) {
        return s.trim().replaceAll(" +", " ");
    }
}