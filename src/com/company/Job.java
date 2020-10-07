package com.company;
import java.time.*;
import java.util.Random;

// vi bruger comparable interface for at override en compareTo metode.
public class Job implements Comparable<Job>{

    private String name;
    private LocalTime must;
    private LocalTime beginning;
    private LocalTime end;
    private double duration;

    // vi bruger denne constructor til når vi skal have skabt et job og vi kender gate, size og tiden flyet skal være klar.
    public Job(String job, String gate, String size, LocalTime must) {
        TaskTime tasks = taskTime(size);
        name = name(job, gate, size);
        this.must = timeJob(job, size, must, tasks);
        beginning = null;
    }

    public Job(String name, LocalTime must) {
        this.name = name;
        this.must = must;
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

    private String name(String job, String gate, String size) {
        return job + ", " + gate + ", " + size + ".";
    }

    private LocalTime timeJob(String job, String size, LocalTime time, TaskTime tasks) {
        LocalTime newTime = time;
        switch (job) {
            case "Cleaning":
                newTime = timeCleaning(size, time, tasks);
                break;
            case "Fuel":
                newTime = timeFuel(size, time, tasks);
                break;
            case "BaggageIn":
                newTime = timeBaggageIn(size, time, tasks);
                break;
            case "BaggageOut":
                newTime = timeBaggageOut(size, time, tasks);
                break;
            case "PassengerIn":
                newTime = timePassengerIn(size, time, tasks);
                break;
            case "PassengerOut":
                newTime = timePassengerOut(size, time, tasks);
                break;
        }
        return newTime;
    }

    private LocalTime timeCleaning(String size, LocalTime time, TaskTime tasks) {
        LocalTime newTime = time;
        double value = Math.random() * 1;
        duration = (tasks.getRengøring() * value);
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

    private LocalTime timeBaggageIn(String size, LocalTime time, TaskTime tasks) {
        LocalTime newTime = time;
        duration = (tasks.getBaggageInd() * Math.random() * 1);
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

    private LocalTime timeBaggageOut(String size, LocalTime time, TaskTime tasks) {
        LocalTime newTime = time;
        duration = (tasks.getBaggageUd() * Math.random() * 1);
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

    private LocalTime timePassengerIn(String size, LocalTime time, TaskTime tasks) {
        LocalTime newTime = time;
        duration = (tasks.getPassagerInd() * Math.random() * 1);
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

    private LocalTime timePassengerOut(String size, LocalTime time, TaskTime tasks) {
        LocalTime newTime = time;
        duration = (tasks.getPassagerUd() * Math.random() * 1);
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

    private LocalTime timeFuel(String size, LocalTime time, TaskTime tasks) {
        LocalTime newTime = time;
        duration = (tasks.getBrændstof() * Math.random() * 1);
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

    public void ending(LocalTime beginning) {
        this.beginning = beginning;
        long value = Math.round(duration * 60);
        end = beginning.plusSeconds(value);
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

    private void setName(String name) {
        this.name = name;
    }

    public LocalTime getMust() {
        return must;
    }

    private void setMust(LocalTime must) {
        this.must = must;
    }

    public LocalTime getBeginning() {
        return beginning;
    }

    private void setBeginning(LocalTime beginning) {
        this.beginning = beginning;
    }

    public double getDuration() {
        return duration;
    }

    private void setDuration(double duration) {
        this.duration = duration;
    }
}
