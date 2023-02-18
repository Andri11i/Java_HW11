package org.example;

import java.util.List;

public class Statistic {

    private final List<String> top10;
    private final int uniqWords;

    public Statistic(List<String> top10, int uniqWords) {
        this.top10 = top10;
        this.uniqWords = uniqWords;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "top10=" + top10 +
                ", uniqWords=" + uniqWords +
                '}';
    }
}
