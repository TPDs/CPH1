package com.company;

import java.time.LocalTime;
import java.util.ArrayList;

public class TimeLine {

    //
    public static void time(ArrayList<Job> workList) {
        int i = 0;
        while (i == 0) {
            LocalTime time = LocalTime.now();
            timeLine(time, workList);
            pause(10000);
        }
    }

    public static void timeLine(LocalTime time, ArrayList<Job> workList) {
        int i = 0;
        //System.out.println("The time is: " + time);
        while (i == 0) {
            if (workList.size() > 0) {
                LocalTime time1 = workList.get(0).getMust();
                if (time1.isBefore(time)) {
                    System.out.println(workList.get(0));
                    workList.remove(0);
                    if (workList.size() == 0) {
                        System.out.println("All the jobs are done");
                        i++;
                    }
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
    }

    // Venter det givne antal millisekunder
    public static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("The thread could not be put to sleep zzzz!");
        }
    }
}