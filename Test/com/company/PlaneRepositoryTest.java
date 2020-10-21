package com.company;

import com.company.Repository.PlaneRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneRepositoryTest {


    PlaneRepository planeRepository = new PlaneRepository();

    //Opretter et fly på flylisten, checker at den successfuldt bliver oprettet og derefter sletter flyet igen
    @Test
    void landPlane() {
        planeRepository.landplane("D8 3563");
        assertEquals(1, planeRepository.findPlaneIdFromRutenNr("D8 3563"));
        planeRepository.deletePlane(1);
    }

    //Modelnr. på rute D8 3563 er F100
    @Test
    void readModelFromRuteNr() {
        assertEquals("F100", planeRepository.readModelFromRuteNr( "D8 3563"));
    }

    //Size på F100 er M(medium)
    @Test
    void readSizeFromModel() {
        assertEquals('M', planeRepository.readSizeFromModel("F100"));
    }


}