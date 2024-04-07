package com.example.sampleguiproject;

import java.util.Comparator;




    public class ArrivalTimeComparator implements Comparator<Row> {

        @Override
        public int compare(Row o1, Row o2) {
            if (o1.getArrivalTime() < o2.getArrivalTime()) {
                return -1;
            } else if (o1.getArrivalTime() > o2.getArrivalTime()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

