package com.company;

public class WorkLog {

    public int Personale_id;
    public String task;
    public String starttime;
    public String endtime;
    public String location;


    //-------------------------------------set----------------------------------------------------------
    public void setPersonale_id(int Personale_id){
        this.Personale_id = Personale_id;
    }
    public void setTask(String task){
        this.task = task;
    }
    public void setStarttime(String starttime) {
        this.starttime = starttime;

    }
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    //------------------------------------get-----------------------------------------------------------

    public int getPersonale_id() {
        return Personale_id;
    }
    public String getTask() {
        return task;
    }
    public String getStarttime() {
        return starttime;
    }
    public String getEndtime() {
        return endtime;
    }
    public String getLocation() {
        return location;
    }


}
