package com.company.Personale;

//import com.mysql.cj.x.protobuf.MysqlxDatatypes;

public class Personale {

    //I denne procedure behandles Personaleobjektet.
    //Hvad skal personaleclassen kunne.  Hvad er kravet til denne classe
    //Det er ikke tilstrækkeligt specificeret hvad classen skal kunne
    //Alle kan skrive her:

    
    //Foreløbig skal classen kunne:
    // skal se på pending task  ( eller en liste med arbejdsopgaver )
    // skal kunne kunne opdatere i en opgave liste.
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

    
    public String nytfelt;

    public int idpersonale;
    public String role;
    public String Name;
    public int Phone;
    public int opgaveId;

    //------------------------------------set-----------------------------------------------
    public void setIdpersonale(int idpersonale) {
        this.idpersonale = idpersonale;
    }
    public void setRde(String rde) {
        this.role = role;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setPhone(int Phone) {
        this.Phone = Phone;
    }
    public void setOpgaveId(int opgaveId) {
        this.opgaveId = opgaveId;
    }
    //------------------------------------get-----------------------------------------------

    public int getIdpersonale() {
        return idpersonale;
    }
    public String getRde() {
        return role;
    }
    public String getName() {
        return Name;
    }
    public int getPhone() {
        return Phone;
    }
    public int getOpgaveId() {return opgaveId;}
    //----------------------------------------------------------------------------------------


}
