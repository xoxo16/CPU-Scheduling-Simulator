package com.example.sampleguiproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestJobFirst {

    public static Output Calc(List<Row> input_process) {

        List<Row> process = new ArrayList<>();
        List<Row> L = Utility.deepCopy(input_process);
        Collections.sort(input_process, new BurstTimeComparator());

        double ttd=0;
        double twt=0;
        int ct=0;


        for (Row i : input_process) {
            ct=Math.max(ct,i.getArrivalTime());
            ct +=i.getBurstTime();
            i.setTurnaroundTime(ct - i.getArrivalTime());
            i.setWaitingTime(i.getTurnaroundTime()-i.getBurstTime());
            ttd=ttd+i.getTurnaroundTime();
            twt=twt+i.getWaitingTime();


        }




        return new Output(process, Utility.FormatDouble(twt / input_process.size()),
                Utility.FormatDouble(ttd/ input_process.size()));


}
}
