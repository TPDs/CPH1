package com.company.Personale;

public class Bagage extends Personale {

    //I denne procedure behandles arbejdet med at få bagage ud og ind i flyet.
    //Arbejdet afhænger af hvor stort flyet er

    enum bagage_arbejde_ud {
        ikke_Lavet_bagage_ud,                 //arbejdet er ikke påbegyndt
        igangMedAtBlive_Lavet_bagage_ud,      //arbejdet er igang med at blive lavet
        færdig_lavet_bagage_ud                //arbejdet er færdig lavet

    }

    enum bagage_arbejde_ind {
        ikke_Lavet_bagage_ind,                 //arbejdet er ikke påbegyndt
        igangMedAtBlive_Lavet_bagage_ind,      //arbejdet er igang med at blive lavet
        færdig_lavet_bagage_ind                //arbejdet er færdig lavet

    }
    enum bagage_arbejde_ud_i_minutter {
        bagage_tid_ud_lillefly_10,                 //Tid til at få bagage ud af lille fly      5 minutter
        bagage_tid_ud_standardfly_15,             //Tid til at få bagage ud af standard fly  10 minutter
        bagage_tid_ud_stortfly_20                 //Tid til at få bagage ud af stort fly     20 minutter

    }

    enum bagage_arbejde_ind_i_minutter {
        bagage_tid_ind_lillefly_15,                 //Tid til at få bagage ud af lille fly      15 minutter
        bagage_tid_ind_standardfly_25,             //Tid til at få bagage ud af standard fly    25 minutter
        bagage_tid_ind_stortfly_35                 //Tid til at få bagage ud af stort fly       35 minutter

    }

}
