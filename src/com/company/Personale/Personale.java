package com.company.Personale;
import com.company.Personale.Rengøring;
import com.company.TaskTime.TaskTime;
import com.company.TimeLine;

//import com.mysql.cj.x.protobuf.MysqlxDatatypes;

public class Personale {

    //I denne procedure behandles Personaleobjektet.
    //Hvad skal personaleclassen kunne.  Hvad er kravet til denne classe
    //Det er ikke tilstrækkeligt specificeret hvad classen skal kunne
    //Alle kan skrive her:

    
    //Foreløbig skal classen kunne: 20201008
    // skal se på pending task  ( eller en liste med arbejdsopgaver )
    // Jeg forventer at modtager et opgavenummer og en lokaliserin af hvor opgaven er
    // Jeg skal finde den tid det tager at komme hen til det sted hvor opgaven er
    // skal kunne opdatere i en opgave liste.
    //
    //
    //Jeg vil simulere at opgavenummeret er 1
    //Jeg vil simulere at gatenr er 12

    //Jeg vil simulere at
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
    public Personale(){};
    Rengøring objRengøring = new Rengøring();
    //public int estimeret_Tid_i_minutter = 0;

    //------------------------------------set-----------------------------------------------
    public void setIdpersonale(int idpersonale) {
        this.idpersonale = idpersonale;
    }
    public void setRole(String rde) {
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
    public String getRole() {
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

    public String størrelse = "stor";
    int estimeret_Tid_i_minutter = objRengøring.rengor_Fly(størrelse);
    //Rengøring objRengøring = new Rengøring();
    //String ren = objRengøring.rengor_Fly1();
    //20201009  Der er fortsat usikkerhed om hvad denne classe skal kunne, og de oplysninger
    // classen skal bruge er ikke klar endnu. Jeg forbereder nogle kald til den classe
    // hvor jeg tror at jeg kan få fat i de oplysninger som denne classe skal bruge.
    // Alle er velkommen til at skrive her hvis de har bedre ideer.


    TaskTime objTaskTime = new TaskTime();
    TimeLine objTimeLine = new TimeLine();
    int personaleTilNabo          = objTaskTime.getPersonaleTilNabo();
    int personaleTilDenneTerminal = objTaskTime.getPersonaleTilDenneTerminal();




}
