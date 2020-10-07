package com.company;

public class Plane {

    private int id;
    private String size;
    private String ruteNr;
    private String ICAO;
    private String location;

    public Plane(int id, String size, String ruteNr, String ICAO, String location) {
        this.id = id;
        this.size = size;
        this.ruteNr = ruteNr;
        this.ICAO = ICAO;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public String getRuteNr() {
        return ruteNr;
    }

    public String getICAO() {
        return ICAO;
    }

    public String getLocation() {
        return location;
    }
}
