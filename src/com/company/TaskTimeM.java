package com.company;

public class TaskTimeM extends TaskTime {

    public TaskTimeM(int taxiInd, int passagerUd, int baggageUd, int brændstof, int rengøring, int baggageInd,
                     int passagerInd, int taxiUd, int taxiVenteplads, int personaleTilNabo, int personaleTilDenneTerminal,
                     int personaleTilAndenTerminal) {
        super(taxiInd, passagerUd, baggageUd, brændstof, rengøring, baggageInd, passagerInd, taxiUd, taxiVenteplads,
                personaleTilNabo, personaleTilDenneTerminal, personaleTilAndenTerminal);
        this.setTaxiInd(10);
        this.setPassagerUd(10);
        this.setBaggageUd(15);
        this.setBrændstof(20);
        this.setRengøring(40);
        this.setBaggageInd(25);
        this.setPassagerInd(20);
        this.setTaxiVenteplads(5);
    }

}
