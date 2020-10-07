package com.company.TaskTime;

public class TaskTimeL extends TaskTime {

    public TaskTimeL() {
        this.setTaxiInd(15);
        this.setPassagerUd(15);
        this.setBaggageUd(20);
        this.setBrændstof(30);
        this.setRengøring(60);
        this.setBaggageInd(35);
        this.setPassagerInd(35);
        this.setTaxiVenteplads(5);
    }

    public TaskTimeL(int taxiInd, int passagerUd, int baggageUd, int brændstof, int rengøring, int baggageInd,
                     int passagerInd, int taxiUd, int taxiVenteplads, int personaleTilNabo, int personaleTilDenneTerminal,
                     int personaleTilAndenTerminal) {
        super(taxiInd, passagerUd, baggageUd, brændstof, rengøring, baggageInd, passagerInd, taxiUd, taxiVenteplads,
                personaleTilNabo, personaleTilDenneTerminal, personaleTilAndenTerminal);
        this.setTaxiInd(15);
        this.setPassagerUd(15);
        this.setBaggageUd(20);
        this.setBrændstof(30);
        this.setRengøring(60);
        this.setBaggageInd(35);
        this.setPassagerInd(35);
        this.setTaxiVenteplads(5);
    }
}