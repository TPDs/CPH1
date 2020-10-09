package com.company.Personale;

public class Rengøring extends Personale {

    public Rengøring(){};
    //i denne classe behandles rengøringsarbejdet
        //Hvad skal denne classe kunne:  Alle er velkommen til at skrive her ???
       //Måske skal den slettes
    String fly_størrelse;
    public int rengor_Fly(String fly_størrelse) {
        //Jeg kender nu flystørrelsen og ved at det skal rengøres
        this.fly_størrelse = fly_størrelse;
        switch(fly_størrelse) {
            case "LILLE": //LILLE:
                System.out.println("Kode for rengøring af lille fly skal indlægges her.");
                break;
            case "STANDARD": //STANDARD:
                System.out.println("Kode for rengøring af standard fly skal indlægges her.");
                break;
            case "STOR": //STOR:
                System.out.println("Kode for rengøring af stort fly skal indlægges her.");
                break;
            default:
                System.out.println("Jeg ved ikke hvilket fly det er og flystørrelsen er ukendt.");
                break;
        }

        int tid = 10;
        return tid;

    }


}
