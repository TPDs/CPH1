package com.company;

public class Plane {

    private int id;
    private char size;
    private String ruteNr;
    private String ICAO;
    private String location;

    public Plane() {
    }

    public Plane(int id, char size, String ruteNr, String ICAO, String location) {
        this.id = id;
        this.size = size;
        this.ruteNr = ruteNr;
        this.ICAO = ICAO;
        this.location = location;
    }

    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", size=" + size +
                ", ruteNr='" + ruteNr + '\'' +
                ", ICAO='" + ICAO + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public char getSize() {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public void setRuteNr(String ruteNr) {
        this.ruteNr = ruteNr;
    }

    public void setICAO(String ICAO) {
        this.ICAO = ICAO;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
