package com.company;

public class TaskTimeS extends TaskTime {

    public TaskTimeS() {
        this.setTaxiInd(12);
        this.setPassagerUd(5);
        this.setBaggageUd(10);
        this.setBrændstof(10);
        this.setRengøring(30);
        this.setBaggageInd(15);
        this.setPassagerInd(15);
        this.setTaxiVenteplads(8);
    }

    public TaskTimeS(int taxiInd, int passagerUd, int baggageUd, int brændstof, int rengøring, int baggageInd,
                     int passagerInd, int taxiUd, int taxiVenteplads, int personaleTilNabo, int personaleTilDenneTerminal,
                     int personaleTilAndenTerminal) {
        super(taxiInd, passagerUd, baggageUd, brændstof, rengøring, baggageInd, passagerInd, taxiUd, taxiVenteplads,
                personaleTilNabo, personaleTilDenneTerminal, personaleTilAndenTerminal);
        this.setTaxiInd(12);
        this.setPassagerUd(5);
        this.setBaggageUd(10);
        this.setBrændstof(10);
        this.setRengøring(30);
        this.setBaggageInd(15);
        this.setPassagerInd(15);
        this.setTaxiVenteplads(8);
    }

}
