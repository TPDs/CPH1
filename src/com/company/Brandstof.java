package com.company;

public class Brandstof extends Personale {

    enum Brandstof_påfyldning {
        ikke_Lavet_Brandstof,                 //arbejdet er ikke påbegyndt
        igangMedAtBlive_Lavet_Brandstof,      //arbejdet er igang med at blive lavet
        færdig_lavet_Brandstof                //arbejdet er færdig lavet

    }

    enum Brandstof_påfyldning_tid {
        passager_tid_ud_lillefly_10,                 //Tid til at få tanket lille fly    10 minutter
        passager_tid_ud_standardfly_20,             //Tid til at få tanket standard fly  20 minutter
        passager_tid_ud_stortfly_30                 //Tid til at få tanket stort fly     30 minutter

    }
}
