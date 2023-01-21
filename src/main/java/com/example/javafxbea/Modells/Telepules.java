package com.example.javafxbea.Modells;

public class Telepules {

    private int telid;
    private String telnev;
    private int npid;

    public Telepules(int telid, String telnev, int npid) {
        this.telid = telid;
        this.telnev = telnev;
        this.npid = npid;
    }

    public int getTelid() {
        return telid;
    }

    public void setTelid(int telid) {
        this.telid = telid;
    }

    public String getTelnev() {
        return telnev;
    }

    public void setTelnev(String telnev) {
        this.telnev = telnev;
    }

    public int getNpid() {
        return npid;
    }

    public void setNpid(int npid) {
        this.npid = npid;
    }

    @Override
    public String toString() {
        return "Telepules{" +
                "telid=" + telid +
                ", telnev='" + telnev + '\'' +
                ", npid=" + npid +
                '}';
    }
}
