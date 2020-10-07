package com.company;

public class TaskTime {
    private int taxiInd, passagerUd, baggageUd, brændstof, rengøring, baggageInd,passagerInd,
            taxiVenteplads;
    private int taxiUd = 10;
    private int personaleTilNabo = 0;
    private int personaleTilDenneTerminal = 5;
    private int personaleTilAndenTerminal= 10;

    public TaskTime(int taxiInd, int passagerUd, int baggageUd, int brændstof, int rengøring, int baggageInd,
                    int passagerInd, int taxiUd, int taxiVenteplads, int personaleTilNabo, int personaleTilDenneTerminal,
                    int personaleTilAndenTerminal) {

        this.taxiInd = taxiInd;
        this.passagerUd = passagerUd;
        this.baggageUd = baggageUd;
        this.brændstof = brændstof;
        this.rengøring = rengøring;
        this.baggageInd = baggageInd;
        this.passagerInd = passagerInd;
        this.taxiUd = taxiUd;
        this.taxiVenteplads = taxiVenteplads;
        this.personaleTilNabo = personaleTilNabo;
        this.personaleTilDenneTerminal = personaleTilDenneTerminal;
        this.personaleTilAndenTerminal = personaleTilAndenTerminal;
    }

    public int getTaxiInd() {
        return taxiInd;
    }

    public void setTaxiInd(int taxiInd) {
        this.taxiInd = taxiInd;
    }

    public int getPassagerUd() {
        return passagerUd;
    }

    public void setPassagerUd(int passagerUd) {
        this.passagerUd = passagerUd;
    }

    public int getBaggageUd() {
        return baggageUd;
    }

    public void setBaggageUd(int baggageUd) {
        this.baggageUd = baggageUd;
    }

    public int getBrændstof() {
        return brændstof;
    }

    public void setBrændstof(int brændstof) {
        this.brændstof = brændstof;
    }

    public int getRengøring() {
        return rengøring;
    }

    public void setRengøring(int rengøring) {
        this.rengøring = rengøring;
    }

    public int getBaggageInd() {
        return baggageInd;
    }

    public void setBaggageInd(int baggageInd) {
        this.baggageInd = baggageInd;
    }

    public int getPassagerInd() {
        return passagerInd;
    }

    public void setPassagerInd(int passagerInd) {
        this.passagerInd = passagerInd;
    }

    public int getTaxiUd() {
        return taxiUd;
    }

    public void setTaxiUd(int taxiUd) {
        this.taxiUd = taxiUd;
    }

    public int getTaxiVenteplads() {
        return taxiVenteplads;
    }

    public void setTaxiVenteplads(int taxiVenteplads) {
        this.taxiVenteplads = taxiVenteplads;
    }

    public int getPersonaleTilNabo() {
        return personaleTilNabo;
    }

    public void setPersonaleTilNabo(int personaleTilNabo) {
        this.personaleTilNabo = personaleTilNabo;
    }

    public int getPersonaleTilDenneTerminal() {
        return personaleTilDenneTerminal;
    }

    public void setPersonaleTilDenneTerminal(int personaleTilDenneTerminal) {
        this.personaleTilDenneTerminal = personaleTilDenneTerminal;
    }

    public int getPersonaleTilAndenTerminal() {
        return personaleTilAndenTerminal;
    }

    public void setPersonaleTilAndenTerminal(int personaleTilAndenTerminal) {
        this.personaleTilAndenTerminal = personaleTilAndenTerminal;
    }
}
