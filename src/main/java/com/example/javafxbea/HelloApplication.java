package com.example.javafxbea;

import com.example.javafxbea.DAO.UtDAO;
import com.example.javafxbea.Modells.Ut;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root,1024, 768);
        stage.setTitle("Tanösvény");
        stage.setScene(scene);
        stage.show();

/*
        UtDAO utData = new UtDAO("jdbc:mysql://localhost/tanosveny?user=root");
        Ut test = new Ut(250,"Testes",1.2,12,1.2,true,10);
        utData.insertUt(test);
*/

    }

    public static void main(String[] args) {
        launch();
    }
}