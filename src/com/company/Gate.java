package com.company;

public class Gate extends Finger {

    private String size;
    private int idPlane;
    private int idFinger;
    private int idGate;

    enum Side{
        LEFT,
        RIGHT
    }
    private Side side;

    public Gate() {
    }

    public Gate(String size, int idPlane, int idFinger, int idGate, Side side) {
        this.size = size;
        this.idPlane = idPlane;
        this.idFinger = idFinger;
        this.idGate = idGate;
        this.side = side;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = Side.valueOf(side);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    public int getIdFinger() {
        return idFinger;
    }

    public void setIdFinger(int idFinger) {
        this.idFinger = idFinger;
    }

    public int getIdGate() {
        return idGate;
    }

    public void setIdGate(int idGate) {
        this.idGate = idGate;
    }



    @Override
    public String toString() {
        return "Gate" + idGate + " on the " + side + " side of finger " + 1;
    }
}
