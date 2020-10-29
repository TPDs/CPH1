package com.company.Personale;
import com.company.TaskTime.TaskTime;
import com.company.TaskTime.TaskTimeL;
import com.company.TaskTime.TaskTimeM;
import com.company.TaskTime.TaskTimeS;

import java.time.*;

// vi bruger comparable interface for at override en compareTo metode.
public class Job implements Comparable<Job>{

    private int id;
    private String name, jobType, gate, size, status;
    private LocalDateTime must, beginning, end;

    public Job() {
    }

    // 1. Vi bruger denne metode når jobbet bliver skabt af fly.
    public Job(String jobType, String gate, String size, LocalDateTime must, String status) {
        beginning = null;
        end = null;
        id = 0;
        this.jobType = jobType;
        this.gate = gate;
        this.size = size;
        this.status = status;

        name = name(jobType, gate, size);
        this.must = timeJob(jobType, size, must);
    }

    // 2. Vi bruger denne constructor når vi skal få jobs fra pending
    public Job(int id, String jobType, String gate, LocalDateTime must, String status) {
        beginning = null;
        end = null;
        this.id = id;
        this.jobType = jobType;
        this.gate = gate;
        this.must = must;
        this.size = null;
        this.status = status;

        name = name(jobType, gate);
    }

    // 3. Vi bruger denne constructor når vi skal få jobs fra worklog
    public Job(int id, String jobType, String gate, String size, LocalDateTime must, LocalDateTime beginning, LocalDateTime end, String status) {
        this.beginning = beginning;
        this.end = end;
        this.id = id;
        this.jobType = jobType;
        this.gate = gate;
        this.must = must;
        this.size = size;
        this.status = status;

        name = name(jobType, gate, size);
    }

    public Job(String name, LocalDateTime must) {
        this.name = name;
        this.must = must;
    }

    private String name(String job, String gate) {
        return job + ", " + gate + ".";
    }

    private String name(String job, String gate, String size) {
        return job + ", " + gate + ", " + size + ".";
    }

    private LocalDateTime timeJob(String job, String size, LocalDateTime time) {
        LocalDateTime newTime = time;
        switch (job) {
            case "Cleaning":
                newTime = timeCleaning(size, time);
                break;
            case "Fuel":
                newTime = timeFuel(size, time);
                break;
            case "BaggageIn":
                newTime = timeBaggageIn(size, time);
                break;
            case "BaggageOut":
                newTime = timeBaggageOut(size, time);
                break;
            case "PassengerIn":
                newTime = timePassengerIn(size, time);
                break;
            case "PassengerOut":
                newTime = timePassengerOut(size, time);
                break;
        }
        return newTime;
    }

    private LocalDateTime timeCleaning(String size, LocalDateTime time) {
        LocalDateTime newTime = time;
        switch (size) {
            case "Small":
                newTime = time.plusMinutes(-(10 + 8 + 15));
                break;
            case "Standard":
                newTime = time.plusMinutes(-(10 + 5 + 20));
                break;
            case "Large":
                newTime = time.plusMinutes(-(10 + 5 + 35));
                break;
        }
        return newTime;
    }

    private LocalDateTime timeBaggageIn(String size, LocalDateTime time) {
        LocalDateTime newTime = time;
        switch (size) {
            case "Small":
                newTime = time.plusMinutes(-(10 + 8));
                break;
            case "Standard":
                newTime = time.plusMinutes(-(10 + 5));
                break;
            case "Large":
                newTime = time.plusMinutes(-(10 + 5));
                break;
        }
        return newTime;
    }

    private LocalDateTime timeBaggageOut(String size, LocalDateTime time) {
        LocalDateTime newTime = time;
        switch (size) {
            case "Small":
                newTime = time.plusMinutes(-(10 + 8 + 10));
                break;
            case "Standard":
                newTime = time.plusMinutes(-(10 + 5 + 15));
                break;
            case "Large":
                newTime = time.plusMinutes(-(10 + 5 + 20));
                break;
        }
        return newTime;
    }

    private LocalDateTime timePassengerIn(String size, LocalDateTime time) {
        LocalDateTime newTime = time;

        switch (size) {
            case "Small":
                newTime = time.plusMinutes(-(10 + 8));
                break;
            case "Standard":
                newTime = time.plusMinutes(-(10 + 5));
                break;
            case "Large":
                newTime = time.plusMinutes(-(10 + 5));
                break;
        }
        return newTime;
    }

    private LocalDateTime timePassengerOut(String size, LocalDateTime time) {
        LocalDateTime newTime = time;
        switch (size) {
            case "Small":
                newTime = time.plusMinutes(-(10 + 8 + 15 + 30));
                break;
            case "Standard":
                newTime = time.plusMinutes(-(10 + 5 + 20 + 40));
                break;
            case "Large":
                newTime = time.plusMinutes(-(10 + 5 + 35 + 60));
                break;
        }
        return newTime;
    }

    private LocalDateTime timeFuel(String size, LocalDateTime time) {
        LocalDateTime newTime = time;
        switch (size) {
            case "Small":
                newTime = time.plusMinutes(-(10 + 8 + 15));
                break;
            case "Standard":
                newTime = time.plusMinutes(-(10 + 5 + 20));
                break;
            case "Large":
                newTime = time.plusMinutes(-(10 + 5 + 35));
                break;
        }
        return newTime;
    }

    public void takeJob(LocalDateTime beginning, String size) {
        TaskTime tasks = taskTime(size);
        double duration = duration(tasks);


        this.beginning = beginning;
        long value = Math.round(duration * 60);
        end = beginning.plusSeconds(value);
    }

    private double duration(TaskTime tasks) {

        if (jobType.equals("Cleaning")) {
            return (tasks.getRengøring() * (Math.random() * 1));
        } else if (jobType.equals("Fuel")) {
            return (tasks.getBaggageInd() * (Math.random() * 1));
        } else if (jobType.equals("BaggageIn")) {
            return (tasks.getBaggageUd() * (Math.random() * 1));
        } else if (jobType.equals("BaggageOut")) {
            return (tasks.getPassagerInd() * (Math.random() * 1));
        } else if (jobType.equals("PassengerIn")) {
            return (tasks.getPassagerUd() * (Math.random() * 1));
        } else if (jobType.equals("PassengerOut")) {
            return (tasks.getBrændstof() * (Math.random() * 1));
        }
        return 0;
    }

    private TaskTime taskTime(String size) {
        switch (size) {
            case "Small":
                return new TaskTimeS();
            case "Standard":
                return new TaskTimeM();
            case "Large":
                return new TaskTimeL();
        }
        return null;
    }

    @Override
    public int compareTo(Job o) {
        return getMust().compareTo(o.getMust());
    }

    @Override
    public String toString() {
        if (beginning != null) {
            return name + " was finished at: " + end;
        } else {
            return name + " must be done at: " + must;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getMust() {
        return must;
    }

    public void setMust(LocalDateTime must) {
        this.must = must;
    }

    public LocalDateTime getBeginning() {
        return beginning;
    }

    public void setBeginning(LocalDateTime beginning) {
        this.beginning = beginning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}