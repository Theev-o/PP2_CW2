package com.michal.kuc;

import java.util.ArrayList;

public class Zad2 {
    private final String str;

    public Zad2(String input) {
        str = input;
    }

    void search(String delim) {
        int occurrences = 0;
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < delim.length(); j++) {
                if (delim.charAt(j) != str.charAt(i)) break;
                else if (j == delim.length() - 1 && delim.charAt(j) == str.charAt(i)) {
                    occurrences++;
                    indices.add(i - j);
                }
                i++;
            }
        }
        System.out.println("Input: " + str);
        System.out.println("Phrase: " + delim);
        if (occurrences > 0) {
            System.out.print("Found " + occurrences + " occurrences of '" + delim + "' at indices: ");
            for (Integer index : indices) {
                System.out.print(index + " ");
            }
            System.out.println();
        } else {
            System.out.println("No occurrences of '" + delim + "' were found in string.");
        }
    }
}
