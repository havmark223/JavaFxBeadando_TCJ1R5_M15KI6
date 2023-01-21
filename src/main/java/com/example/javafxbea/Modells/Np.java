package com.example.javafxbea.Modells;

public class Np {

    private int parkid;
    private String parknev;

    public Np(int parkid, String parknev) {
        this.parkid = parkid;
        this.parknev = parknev;
    }

    public int getParkid() {
        return parkid;
    }

    public void setParkid(int parkid) {
        this.parkid = parkid;
    }

    public String getParknev() {
        return parknev;
    }

    public void setParknev(String parknev) {
        this.parknev = parknev;
    }

    @Override
    public String toString() {
        return "Np{" +
                "parkid=" + parkid +
                ", parknev='" + parknev + '\'' +
                '}';
    }
}
