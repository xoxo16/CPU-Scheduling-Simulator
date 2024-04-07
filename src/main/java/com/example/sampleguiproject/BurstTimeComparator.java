package com.example.sampleguiproject;

import java.util.Comparator;

public class BurstTimeComparator implements Comparator<Row> {

    @Override
    public int compare(Row o1, Row o2) {
        if (o1.getBurstTime() < o2.getBurstTime()) {
            return -1;
        } else if (o1.getBurstTime() > o2.getBurstTime()) {
            return 1;
        } else {
            return 0;
        }
    }
}

