package com.example.sampleguiproject;

import java.util.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class ShortestRemainingTime {

    private static List<Row> filter(List<Row> process, int arrival_time) {
        List<Row> processes_out = new ArrayList<>();
        for (Row i : process) {
            if (i.getArrivalTime() <= arrival_time) {
                processes_out.add(i);
            }
        }
        processes_out.removeIf(i -> i.getBurstTime() == 0); // Remove processes with zero burst time
        Utility.sortBrust(processes_out);
        return processes_out;
    }

    private static int getBurstByName(String name, List<Row> input_process) {
        for (Row i : input_process) {
            if (i.getProcessName().equals(name)) {
                return i.getBurstTime();
            }
        }
        return 0;
    }

    private static List<Row> removeDuplicateList(List<Row> input_process) {
        Collection<Row> hs = new HashSet<>(input_process);
        List<Row> process = new ArrayList<>(hs);
        Utility.sortName(process);
        return process;
    }

    public static Output Calc(List<Row> input_process) {
        List<Row> process = new ArrayList<>();
        List<Row> L = Utility.deepCopy(input_process);
        int sum_burst = Utility.sumBurst(L);
        int timeline = 0;
        double avg_waiting = 0;
        double avg_turnaround = 0;
        List<Row> x;
        while (!L.isEmpty()) { // Iterate until all processes have finished executing
            x = filter(L, timeline);
            if (!x.isEmpty()) {
                Row i = x.get(0);
                i.setStartTime(timeline);
                i.setBurstTime(i.getBurstTime() - 1);
                timeline++;
                i.setFinishTime(timeline);
                i.setTurnaroundTime(i.getFinishTime() - i.getArrivalTime());
                i.setWaitingTime(i.getTurnaroundTime() - getBurstByName(i.getProcessName(), input_process));
                process.add(i);
            } else {
                timeline++; // If no process is available, increment timeline
            }
            L.removeIf(row -> row.getBurstTime() == 0); // Remove completed processes from L
        }
        process = removeDuplicateList(process);
        for (Row i : process) {
            avg_waiting += i.getWaitingTime();
            avg_turnaround += i.getTurnaroundTime();
        }
        return new Output(process, Utility.FormatDouble(avg_waiting / input_process.size()),
                Utility.FormatDouble(avg_turnaround / input_process.size()));
    }
}
