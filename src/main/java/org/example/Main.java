package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
        private static final String path = "src/main/resources/";
    private static final String fileName = "%s_statistic.txt ";
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.next();
        BookParser parser = new BookParser();

        while (!command.equals("exit")) {

            File book = new File(path + command);
            List<String> text = parser.getText(book);
            List<String> top = parser.popularWorld(text, 3);
            int uniqWords = parser.uniqWords(text);
            Statistic statistic = new Statistic(top, uniqWords);

            new StatisticService().save(statistic, new File(String.format(fileName, book.getName())));
            System.out.println(statistic);
            System.out.println(" type exit ot exit :-)");
            command = scanner.next();
        }
    }
}