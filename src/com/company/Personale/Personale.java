package com.company.Personale;

//import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import com.company.Pending;

import java.util.ArrayList;

public class Personale {

    //I denne procedure behandles Personaleobjektet.
    //Hvad skal personaleclassen kunne.  Hvad er kravet til denne classe

    
    //Foreløbig skal classen kunne:
    // skal se på pending task  ( eller en liste med arbejdsopgaver )
    // Jeg forventer at modtager et opgavenummer og en lokaliserin af hvor opgaven er
    // Jeg skal finde den tid det tager at komme hen til det sted hvor opgaven er
    // skal kunne opdatere i en opgave liste.

    private int id;
    private String role;
    private String name;
    private int phone;
    private int taskId;
    private int time;

    public Personale(String role, String name) {
        this.id = 0;
        this.role = role;
        this.name = name;
        this.taskId = 0;
        this.time = 0;
    }

    public Personale(int id, String role, String name, int taskId, int time) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.taskId = taskId;
        this.time = time;
    }

    public void checkTask(Pending pending) {
        if (taskId == 0) {
            findTask(pending);
        }
    }

    private void findTask(Pending pending) {
        switch (role) {
            case "Cleaning":
                setCleaningTask(pending);
                break;
            case "Fuel":
                setFuel(pending);
                break;
            case "BaggageIn":
                setBaggageIn(pending);
                break;
            case "BaggageOut":
                setBaggageOut(pending);
                break;
            case "PassengerIn":
                setPassengerIn(pending);
                break;
            case "PassengerOut":
                setPassengerOut(pending);
                break;
        }
    }

    private void setCleaningTask(Pending pending) {
        ArrayList<Job> jobList = pending.fetchAll();
        for (int i = 0; i < jobList.size(); i++) {
            if ((jobList.get(i).getJobType().equals("Cleaning")) && (jobList.get(i).getStatus().equals("Ok"))) {
                taskId = jobList.get(i).getId();
                pending.delete(jobList.get(i).getId(), jobList);
            }
        }
    }

    private void setFuel(Pending pending) {
        ArrayList<Job> jobList = pending.fetchAll();
        for (int i = 0; i < jobList.size(); i++) {
            if ((jobList.get(i).getJobType().equals("Fuel")) && (jobList.get(i).getStatus().equals("Ok"))) {
                taskId = jobList.get(i).getId();
                pending.delete(jobList.get(i).getId(), jobList);
            }
        }
    }

    private void setBaggageIn(Pending pending) {
        ArrayList<Job> jobList = pending.fetchAll();
        for (int i = 0; i < jobList.size(); i++) {
            if ((jobList.get(i).getJobType().equals("BaggageIn")) && (jobList.get(i).getStatus().equals("Ok"))) {
                taskId = jobList.get(i).getId();
                pending.delete(jobList.get(i).getId(), jobList);
            }
        }
    }

    private void setBaggageOut(Pending pending) {
        ArrayList<Job> jobList = pending.fetchAll();
        for (int i = 0; i < jobList.size(); i++) {
            if ((jobList.get(i).getJobType().equals("BaggageOut")) && (jobList.get(i).getStatus().equals("Ok"))) {
                taskId = jobList.get(i).getId();
                pending.delete(jobList.get(i).getId(), jobList);
            }
        }
    }

    private void setPassengerIn(Pending pending) {
        ArrayList<Job> jobList = pending.fetchAll();
        for (int i = 0; i < jobList.size(); i++) {
            if ((jobList.get(i).getJobType().equals("PassengerIn")) && (jobList.get(i).getStatus().equals("Ok"))) {
                taskId = jobList.get(i).getId();
                pending.delete(jobList.get(i).getId(), jobList);
            }
        }
    }

    private void setPassengerOut(Pending pending) {
        ArrayList<Job> jobList = pending.fetchAll();
        for (int i = 0; i < jobList.size(); i++) {
            if ((jobList.get(i).getJobType().equals("PassengerOut")) && (jobList.get(i).getStatus().equals("Ok"))) {
                taskId = jobList.get(i).getId();
                pending.delete(jobList.get(i).getId(), jobList);
            }
        }
    }

    //------------------------------------set-----------------------------------------------

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setTime(int time) {
        this.time = time;
    }

    //------------------------------------get-----------------------------------------------

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getTime() {
        return time;
    }


    //----------------------------------------------------------------------------------------




}
