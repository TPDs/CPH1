package com.company.Personale;

public class GatePassagerer extends Personale {

    //I denne procedure behandles arbejdet med at få passagere ud og ind i flyet.
    //Arbejdet afhænger af hvor stort flyet er

    enum Gate_arbejde_ud {
        ikke_Lavet_Passagere_Ud,                 //arbejdet er ikke påbegyndt
        igangMedAtBlive_Lavet_Passagere_ud,      //arbejdet er igang med at blive lavet
        færdig_lavet_passagere_ud                //arbejdet er færdig lavet

    }

    enum Gate_arbejde_ud_i_minutter {
         passager_tid_ud_lillefly_5,                 //Tid til at få passagere ud af lille fly      5 minutter
         passager_tid_ud_standardfly_10,             //Tid til at få passagere ud af standard fly  10 minutter
         passager_tid_ud_stortfly_15                 //Tid til at få passagere ud af stort fly     15 minutter

    }

    enum Gate_arbejde_ind {
        ikke_Lavet_Passagere_ind,                 //arbejdet er ikke påbegyndt
        igangMedAtBlive_Lavet_Passagere_ind,      //arbejdet er igang med at blive lavet
        færdig_lavet_Passagere_ind                //arbejdet er færdig lavet

    }
    enum Gate_arbejde_ind_i_minutter {
        passager_tid_ind_lillefly_15,                 //Tid til at få passagere ind af lille fly    : 15 minutter
        passager_tid_ind_standardfly_20,              //Tid til at få passagere ind af standard fly : 20 minutter
        passager_tid_ind_stortfly_35                 //Tid til at få passagere ind af stort fly     : 35 minutter
    }

}
