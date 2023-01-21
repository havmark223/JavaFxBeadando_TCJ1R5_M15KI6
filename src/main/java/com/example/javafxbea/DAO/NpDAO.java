package com.example.javafxbea.DAO;

import com.example.javafxbea.Modells.Np;
import com.example.javafxbea.Modells.Telepules;

import java.sql.*;
import java.util.ArrayList;

public class NpDAO {
    private Connection conn;
    public NpDAO(String URI)
    {
        try{
            conn = DriverManager.getConnection(URI);
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Np> getAll() {
        ArrayList<Np> ans = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM np");
            while (res.next()){
                ans.add(new Np(res.getInt("parkid"), res.getString("parknev")));
            }
            return ans;

        } catch (SQLException e) {
            return null;
        }
    }

    public Np getItemById(int id) {
        Np ans;
        try {
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM np WHERE parkid = " + id);
            res.next();
            ans = new Np(res.getInt("parkid"), res.getString("parknev"));
            return ans;
        } catch (SQLException e) {
            return null;
        }
    }

    public void insertNp(Np item){
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(String.format("INSERT INTO np VALUES (%d,\"%s\")", item.getParkid(),item.getParknev()));

        } catch (SQLException e) {
            System.out.println("Hiba a beillesztésnél!");
            throw new RuntimeException(e);
        }
    }

    public void updateNp(Np item){
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(String.format("UPDATE np SET parknev=\"%s\" WHERE parkid = %d",item.getParknev(), item.getParkid()));

        } catch (SQLException e) {
            System.out.println("Hiba a módosításnál!");
            throw new RuntimeException(e);
        }
    }

    public void deleteNp(int id)
    {
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE from np Where parkid= "+id );


        } catch (SQLException e) {
            System.out.println("Hiba a törléssel");
            throw new RuntimeException(e);
        }
    }



}
