package com.example.javafxbea;

import com.example.javafxbea.DAO.NpDAO;
import com.example.javafxbea.DAO.TelepulesDAO;
import com.example.javafxbea.DAO.UtDAO;
import com.example.javafxbea.Modells.Np;
import com.example.javafxbea.Modells.Telepules;
import com.example.javafxbea.Modells.Ut;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class OlvasController extends SceneController implements Initializable {


    //tables
    @FXML
    private TableView<Ut> TableUt;
    @FXML
    private TableView<Telepules> TableTel;
    @FXML
    private TableView<Np> TableNp;

    //Ut columns
    @FXML
    private TableColumn<Ut, Integer> columnUtid;
    @FXML
    private TableColumn<Ut, String> columnUtnev;
    @FXML
    private TableColumn<Ut, Double> columnHossz;
    @FXML
    private TableColumn<Ut, Integer> columnAllomas;
    @FXML
    private TableColumn<Ut, Double> columnIdo;
    @FXML
    private TableColumn<Ut, Boolean> columnVezetes;
    @FXML
    private TableColumn<Ut, Integer> columnTelepulesid;

    //Telepules Columns
    @FXML
    private TableColumn<Telepules, Integer> columnTelid;
    @FXML
    private TableColumn<Telepules, String> columnTelnev;
    @FXML
    private TableColumn<Telepules, Integer> columnNpid;

    //Np Columns
    @FXML
    private TableColumn<Np, Integer> columnParkid;
    @FXML
    private TableColumn<Np, String> columnParknev;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //init Ut
        columnUtid.setCellValueFactory(new PropertyValueFactory<Ut, Integer>("utid"));
        columnUtnev.setCellValueFactory(new PropertyValueFactory<Ut, String>("utnev"));
        columnHossz.setCellValueFactory(new PropertyValueFactory<Ut, Double>("hossz"));
        columnAllomas.setCellValueFactory(new PropertyValueFactory<Ut, Integer>("allomas"));
        columnIdo.setCellValueFactory(new PropertyValueFactory<Ut, Double>("ido"));
        columnVezetes.setCellValueFactory(new PropertyValueFactory<Ut, Boolean>("vezetes"));
        columnTelepulesid.setCellValueFactory(new PropertyValueFactory<Ut, Integer>("telepulesid"));

        //init Tel
        columnTelid.setCellValueFactory(new PropertyValueFactory<Telepules, Integer>("telid"));
        columnTelnev.setCellValueFactory(new PropertyValueFactory<Telepules, String>("telnev"));
        columnNpid.setCellValueFactory(new PropertyValueFactory<Telepules, Integer>("npid"));

        //init Np
        columnParkid.setCellValueFactory(new PropertyValueFactory<Np, Integer>("parkid"));
        columnParknev.setCellValueFactory(new PropertyValueFactory<Np, String>("parknev"));


        UtDAO utData = new UtDAO("jdbc:mysql://localhost/tanosveny?user=root");
        TelepulesDAO telData = new TelepulesDAO("jdbc:mysql://localhost/tanosveny?user=root");
        NpDAO npData = new NpDAO("jdbc:mysql://localhost/tanosveny?user=root");

        ObservableList<Ut> ut = TableUt.getItems();
        ObservableList<Telepules> tel = TableTel.getItems();
        ObservableList<Np> np = TableNp.getItems();

        ut.addAll(utData.getAll());
        tel.addAll(telData.getAll());
        np.addAll(npData.getAll());

        TableUt.setItems(ut);
        TableTel.setItems(tel);
        TableNp.setItems(np);


    }
}
