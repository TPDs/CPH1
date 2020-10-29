package com.company.AirPlane;

public class Rute {
    String date;
    String ruteNr;
    String time;
    String destination;
    String AC;

    public Rute() {
    }

    public Rute(String date, String ruteNr, String time, String destination, String AC) {
        this.date = date;
        this.ruteNr = ruteNr;
        this.time = time;
        this.destination = destination;
        this.AC = AC;
    }

    public String getDate() {
        return date;
    }

    public String getRuteNr() {
        return ruteNr;
    }

    public String getTime() {
        return time;
    }

    public String getDestination() {
        return destination;
    }

    public String getAC() {
        return AC;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRuteNr(String ruteNr) {
        this.ruteNr = ruteNr;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setAC(String AC) {
        this.AC = AC;
    }
}
