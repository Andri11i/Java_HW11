package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class StatisticService {

    public List<String> popularWorld(List<String> world, int amount) {
        return world.stream()
                .distinct()
                .sorted(Comparator.comparingInt(s -> Collections.frequency(world, s)).reversed())
                .limit(amount)
                .toList();
    }

    public int uniqWords(List<String> words) {
        return new HashSet<>(words).size();
    }

    public void save(Statistic statistic, File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(statistic.toString());
        writer.close();
    }
}
