package com.example.sampleguiproject;

import java.util.Collections;
import java.util.List;

public class FirstComeFirstServe {

    public static Output Calc(List<Row> process) {
        List<Row> processes = Utility.deepCopy(process);

        Collections.sort(processes, new ArrivalTimeComparator());


        double ttd=0;
        double twt=0;
        int ct=0;


        for (Row i : processes) {
            ct=Math.max(ct,i.getArrivalTime());
            ct +=i.getBurstTime();
            i.setTurnaroundTime(ct - i.getArrivalTime());
            i.setWaitingTime(i.getTurnaroundTime()-i.getBurstTime());
            ttd=ttd+i.getTurnaroundTime();
            twt=twt+i.getWaitingTime();


        }
        return new Output(processes, Utility.FormatDouble(twt/ processes.size()),
                Utility.FormatDouble( ttd/ processes.size()));
    }
}
