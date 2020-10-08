package com.company;

import com.company.Personale.TaxiRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    TaxiRepository taxiRepository = new TaxiRepository();
    @Test
    void testTaxiToGate(){
        taxiRepository.registerGateInPlane(1, 22);
    }



    Gate gate;
    /* Gate.side side;

    @Test
    void gateTest(){

        ArrayList<Gate> gateList = new ArrayList<>();
        for (int i = 1; i <=6; i++) {
            //if(Personale allerede er tildelt en plads) {
            gateList.add(new Gate("TestLeft" + i, i, side.LEFT));
            //}
        }
        for(int j = 7; j<=12; j++){
            gateList.add(new Gate("TestRight" + j, j, side.RIGHT));
        }
        System.out.println(gateList);
    } */
}

