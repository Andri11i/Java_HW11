package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class BookParser {
    private static final String CHAR_TO_REMOVE = "!@#%&*_,./=+";

    public List<String> getWords(File file) throws FileNotFoundException {
        return new BufferedReader(new FileReader(file))
                .lines()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .map(word -> word.replaceAll(CHAR_TO_REMOVE, ""))
                .filter(word -> word.length() > 2)
                .toList();
    }
}
