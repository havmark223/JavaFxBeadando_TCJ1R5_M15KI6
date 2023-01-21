package com.example.javafxbea.Modells;

public class Ut {

    private int utid;
    private String utnev;
    private double hossz;
    private int allomas;
    private double ido;
    private boolean vezetes;
    private int telepulesid;

    public Ut(int utid, String utnev, double hossz, int allomas, double ido, boolean vezetes, int telepulesid) {
        this.utid = utid;
        this.utnev = utnev;
        this.hossz = hossz;
        this.allomas = allomas;
        this.ido = ido;
        this.vezetes = vezetes;
        this.telepulesid = telepulesid;
    }

    public int getUtid() {
        return utid;
    }

    public void setUtid(int utid) {
        this.utid = utid;
    }

    public String getUtnev() {
        return utnev;
    }

    public void setUtnev(String utnev) {
        this.utnev = utnev;
    }

    public double getHossz() {
        return hossz;
    }

    public void setHossz(double hossz) {
        this.hossz = hossz;
    }

    public int getAllomas() {
        return allomas;
    }

    public void setAllomas(int allomas) {
        this.allomas = allomas;
    }

    public double getIdo() {
        return ido;
    }

    public void setIdo(double ido) {
        this.ido = ido;
    }

    public boolean isVezetes() {
        return vezetes;
    }

    public void setVezetes(boolean vezetes) {
        this.vezetes = vezetes;
    }

    public int getTelepulesid() {
        return telepulesid;
    }

    public void setTelepulesid(int telepulesid) {
        this.telepulesid = telepulesid;
    }


    @Override
    public String toString() {
        return "Ut{" +
                "utid=" + utid +
                ", utnev='" + utnev + '\'' +
                ", hossz=" + hossz +
                ", allomas=" + allomas +
                ", ido=" + ido +
                ", vezetes=" + vezetes +
                ", telepulesid=" + telepulesid +
                '}';
    }
}
