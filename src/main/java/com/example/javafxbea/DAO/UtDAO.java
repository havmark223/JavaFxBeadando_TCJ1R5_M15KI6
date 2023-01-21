package com.example.javafxbea.DAO;

import com.example.javafxbea.Modells.Ut;
import java.sql.*;
import java.util.ArrayList;

public class UtDAO {
    private Connection conn;
    public UtDAO(String URI)
    {
        try{
            conn = DriverManager.getConnection(URI);
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Ut> getAll() {
        ArrayList<Ut> ans = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM ut");
            while (res.next()){
                ans.add(new Ut(res.getInt("utid"), res.getString("utnev"), res.getDouble("hossz"), res.getInt("allomas"),
                        res.getDouble("ido"), res.getBoolean("vezetes"), res.getInt("telepulesid")));
            }
            return ans;

        } catch (SQLException e) {
            return null;
        }
    }

    public Ut getItemById(int id) {
        Ut ans;
        try {
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM ut WHERE utid = " + id);
            res.next();
            ans = new Ut(res.getInt("utid"), res.getString("utnev"), res.getDouble("hossz"), res.getInt("allomas"),
                    res.getDouble("ido"), res.getBoolean("vezetes"), res.getInt("telepulesid"));
        return ans;
        } catch (SQLException e) {
            return null;
        }
    }

    public void insertUt(Ut item){
        try {
            Statement stm = conn.createStatement();

           stm.executeUpdate(String.format("INSERT INTO ut (utid, utnev, hossz, allomas, ido, vezetes, telepulesid) VALUES (%d,\"%s\",%f,%d,%f,%b,%d)", item.getUtid(),item.getUtnev(),
                   item.getHossz(), item.getAllomas(), item.getIdo(), item.isVezetes(),item.getTelepulesid()));

        } catch (SQLException e) {
            System.out.println("Hiba a beillesztésnél!");
            throw new RuntimeException(e);
        }
    }

    public void updateUt(Ut item){
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(String.format("UPDATE ut SET utnev=\"%s\", hossz= %f, allomas= %d, ido= %f, vezetes= %b, telepulesid= %d WHERE utid = %d",item.getUtnev(),
                    item.getHossz(), item.getAllomas(), item.getIdo(), item.isVezetes(),item.getTelepulesid(), item.getUtid()));

        } catch (SQLException e) {
            System.out.println("Hiba a módosításnál!");
            throw new RuntimeException(e);
        }
    }

    public void deleteUt(int id)
    {
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE from ut Where utid= "+id );


        } catch (SQLException e) {
            System.out.println("Hiba a törléssel");
            throw new RuntimeException(e);
        }
    }


}
