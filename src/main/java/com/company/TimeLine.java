package com.company;

import com.company.Personale.Job;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TimeLine {

    // Køre i et loop uden slutning hvor i hvert loop finder den tidspunktet for nu
    // kalder worklist check om de er udført
    // venter et givent antal millisekunder
    public static void time(ArrayList<Job> workList) {
        int i = 0;
        while (i == 0) {
            LocalDateTime time = LocalDateTime.now();
            timeLine(time, workList);
            pause(5000);
        }
    }

    public static void timeLine(LocalDateTime time, ArrayList<Job> workList) {
        int i = 0;
        //System.out.println("The time is: " + time);
        while (i == 0) {
            if (workList.size() > 0) {
                LocalDateTime time1 = workList.get(0).getMust();
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