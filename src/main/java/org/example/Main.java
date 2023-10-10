package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String dirLocation = "src/main/resources/";
    private static final String namePrefix = "%s_statistic.txt";
    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);
        boolean exit  = false;

        BookParser parser = new BookParser();
        StatisticService statisticService = new StatisticService();

        while (!exit) {

            System.out.println(Messages.PLEASE_ENTER_FILE_NAME);
            File book = new File(dirLocation + scanner.next());
            List<String> text = null;
            try {
                text = parser.getWords(book);
            } catch (FileNotFoundException e) {
               System.err.println(Messages.FILE_NOT_FOUND);
               continue;
            }

            List<String> top = statisticService.popularWorld(text, 3); // TODO: 11.10.2023  hardcoded var
            int uniqWords = statisticService.uniqWords(text);
            Statistic statistic = new Statistic(top, uniqWords);

            try {
                new StatisticService().save(statistic, new File(String.format(dirLocation + namePrefix, book.getName())));
            } catch (IOException e) {
                System.err.println(Messages.INTERNAL_ERROR);
                break;
            }
            System.out.println(statistic);
            System.out.println(Messages.EXIT);
            exit = !scanner.next().equals("n"); // TODO: 11.10.2023  hardcoded var
        }
        scanner.close();
    }
}