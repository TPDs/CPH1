package com.company;

public class Rengøring extends Personale {

    //i denne classe behandles rengøringsarbejdet




    enum rengøring_Arbejde {
        ikke_Lavet_Rengøring,                 //arbejdet er ikke påbegyndt
        igangMedAtBlive_Lavet_Rengøring,      //arbejdet er igang med at blive lavet
        færdig_lavet_Rengøring                //arbejdet er færdig lavet

    }
    enum rengøring_Arbejde_Tid {
        rengøring_tid_lillefly_30,           //Tid til at få rengjort og fyldt vara op:   lille fly     30 minutter
        rengøring_tid_standardfly_40,        //Tid til at få rengjort og fyldt vara op:   standard fly  40 minutter
        rengøring_tid_stortfly_60            //Tid til at få rengjort og fyldt vara op:   stort fly     60 minutter

    }

}
