package com.example.javafxbea.DAO;

import com.example.javafxbea.Modells.Telepules;
import com.example.javafxbea.Modells.Ut;

import java.sql.*;
import java.util.ArrayList;

public class TelepulesDAO {

    private Connection conn;
    public TelepulesDAO(String URI)
    {
        try{
            conn = DriverManager.getConnection(URI);
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Telepules> getAll() {
        ArrayList<Telepules> ans = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM telepules");
            while (res.next()){
                ans.add(new Telepules(res.getInt("telid"), res.getString("telnev"), res.getInt("npid")));
            }
            return ans;

        } catch (SQLException e) {
            return null;
        }
    }

    public Telepules getItemById(int id) {
        Telepules ans;
        try {
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM telepules WHERE telid = " + id);
            res.next();
            ans = new Telepules(res.getInt("telid"), res.getString("telnev"), res.getInt("npid"));
            return ans;
        } catch (SQLException e) {
            return null;
        }
    }

    public void insertTel(Telepules item){
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(String.format("INSERT INTO telepules VALUES (%d,\"%s\",%d )", item.getTelid(),item.getTelnev(), item.getNpid()));

        } catch (SQLException e) {
            System.out.println("Hiba a beillesztésnél!");
            throw new RuntimeException(e);
        }
    }

    public void updateTel(Telepules item){
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(String.format("UPDATE telepules SET telnev=\"%s\", npid= %d WHERE telid = %d",item.getTelnev(), item.getNpid(), item.getTelid()));

        } catch (SQLException e) {
            System.out.println("Hiba a módosításnál!");
            throw new RuntimeException(e);
        }
    }

    public void deleteTel(int id)
    {
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE from telepules Where telid= "+id );


        } catch (SQLException e) {
            System.out.println("Hiba a törléssel");
            throw new RuntimeException(e);
        }
    }

}
