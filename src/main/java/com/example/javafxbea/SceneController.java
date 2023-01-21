package com.example.javafxbea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class SceneController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    MenuBar MyMenuBar;
    @FXML
    private void OlvasMenuItem() throws IOException {
        root = FXMLLoader.load(getClass().getResource("Olvas1.fxml"));
        stage = (Stage)(MyMenuBar.getScene().getWindow());
        scene = new Scene(root,1024, 768);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Olvas2MenuItem() throws IOException {
        root = FXMLLoader.load(getClass().getResource("Olvas2.fxml"));
        stage = (Stage)(MyMenuBar.getScene().getWindow());
        scene = new Scene(root,1024, 768);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void IrMenuItem() throws IOException {
        root = FXMLLoader.load(getClass().getResource("Ir.fxml"));
        stage = (Stage)(MyMenuBar.getScene().getWindow());
        scene = new Scene(root,1024, 768);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ModMenuItem() throws IOException {
        root = FXMLLoader.load(getClass().getResource("Modosit.fxml"));
        stage = (Stage)(MyMenuBar.getScene().getWindow());
        scene = new Scene(root,1024, 768);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void DelMenuItem() throws IOException {
        root = FXMLLoader.load(getClass().getResource("Torol.fxml"));
        stage = (Stage)(MyMenuBar.getScene().getWindow());
        scene = new Scene(root,1024, 768);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void ParhuzaMenuItem() throws IOException {
        root = FXMLLoader.load(getClass().getResource("Parhuzamos.fxml"));
        stage = (Stage)(MyMenuBar.getScene().getWindow());
        scene = new Scene(root,1024, 768);
        stage.setScene(scene);
        stage.show();
    }
}
