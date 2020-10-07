package com.company.Personale;

public class Personale {

    //I denne procedure behandles Personaleobjektet.
    /*

       Personale obj:
       Gate gateId.
       Tid arbejdsdag.
       Enum status
       List<fly> toDo
       Tid arbejdstid.
       Collector til at sorterer en stack efter hvilket fly der er mest akut.



    Bagage objBagage       = new Bagage();
    Brandstof objBradstof  = new Brandstof();
    Rengøring objRengøring = new Rengøring();
    GatePassagerer objGate = new GatePassagerer();    //Passagere ud af flyet
    */
    enum status {
        ikke_Lavet,                 //arbejdet er ikke påbegyndt
        igangMedAtBlive_Lavet,      //arbejdet er igang med at blive lavet
        færdig_lavet                //arbejdet er færdig lavet

           }



    public int idpersonale;
    public String rde;
    public String Name;
    public int Phone;

    //------------------------------------set-----------------------------------------------
    public void setIdpersonale(int idpersonale) {
        this.idpersonale = idpersonale;
    }
    public void setRde(String rde) {
        this.rde = rde;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setPhone(int Phone) {
        this.Phone = Phone;
    }
    //------------------------------------get-----------------------------------------------

    public int getIdpersonale() {
        return idpersonale;
    }
    public String getRde() {
        return rde;
    }
    public String getName() {
        return Name;
    }
    public int getPhone() {
        return Phone;
    }
    //----------------------------------------------------------------------------------------







}
