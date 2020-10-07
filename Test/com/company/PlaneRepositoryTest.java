package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneRepositoryTest {
    PlaneRepository planeRepository = new PlaneRepository();
    Plane plane = new Plane(1, 'm', "D8 3563", "A345", "Runway 1" );

    @Test
    void addPlane() {
        planeRepository.landplane("D8 3563");
    }

    //Modelnr. på rute D8 3563 er F100
    @Test
    void readModelFromRuteNr() {
        assertEquals("F100", planeRepository.readModelFromRuteNr( "D8 3563"));
    }

    //Size på F100 er M(medium)
    @Test
    void readSizeFromModel() {
        assertEquals('H', planeRepository.readSizeFromModel("F100"));
    }


}