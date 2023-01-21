package com.example.javafxbea;

import com.example.javafxbea.DAO.NpDAO;
import com.example.javafxbea.DAO.TelepulesDAO;
import com.example.javafxbea.DAO.UtDAO;
import com.example.javafxbea.Modells.Np;
import com.example.javafxbea.Modells.Telepules;
import com.example.javafxbea.Modells.Ut;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class IrController extends SceneController implements Initializable{

    //Select Table
    @FXML
    private ComboBox TableSelectCB;

    //AnchorPane Ut
    @FXML
    public AnchorPane UtAP;
    @FXML
    private TextField UttF1;
    @FXML
    private TextField UttF2;
    @FXML
    private TextField UttF3;
    @FXML
    private TextField UttF4;
    @FXML
    private TextField UttF5;
    @FXML
    private TextField UttF6;
    @FXML
    private CheckBox checkBoxVez;
    @FXML
    private Button UtsubBtn;

    //AnchorPane Tel
    @FXML
    public AnchorPane TelAP;
    @FXML
    private TextField TeltF1;
    @FXML
    private TextField TeltF2;
    @FXML
    private TextField TeltF3;
    @FXML
    private Button TelsubBtn;

    //Np Anchor Pane
    @FXML
    public AnchorPane NpAP;
    @FXML
    private TextField NptF1;
    @FXML
    private TextField NptF2;
    @FXML
    private Button NpsubBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableSelectCB.getItems().add("Út");
        TableSelectCB.getItems().add("Település");
        TableSelectCB.getItems().add("Nemzeti Park");


        UtAP.setVisible(false);
        TelAP.setVisible(false);
        NpAP.setVisible(false);


    }

    public void TableSelected(ActionEvent event) {

        int selectedIndex = TableSelectCB.getSelectionModel().getSelectedIndex();

        System.out.println("Választás index:"+selectedIndex);

        switch (selectedIndex)
        {
            case 0:
                TelAP.setVisible(false);
                NpAP.setVisible(false);
                UtAP.setVisible(true);
                System.out.println("Út");
                break;
            case 1:
                UtAP.setVisible(false);
                NpAP.setVisible(false);
                TelAP.setVisible(true);
                System.out.println("Település");
                break;
            case 2:
                UtAP.setVisible(false);
                TelAP.setVisible(false);
                NpAP.setVisible(true);
                System.out.println("Nemzeti Park ");
                break;

            default: System.out.println("Baj van");break;
        }
    }

    public void utInsertBtn(ActionEvent event) {
        UtDAO utData = new UtDAO("jdbc:mysql://localhost/tanosveny?user=root");
        Ut inUt = new Ut(Integer.parseInt(UttF1.getText()),UttF2.getText(),Double.parseDouble(UttF3.getText()),Integer.parseInt(UttF4.getText()),Double.parseDouble(UttF5.getText()),
                checkBoxVez.isSelected(),Integer.parseInt(UttF6.getText()));

        System.out.println(inUt);
        utData.insertUt(inUt);

    }

    public void NpInsertBtn(ActionEvent event) {
        NpDAO npData = new NpDAO("jdbc:mysql://localhost/tanosveny?user=root");
        Np inNp = new Np(Integer.parseInt(NptF1.getText()),NptF2.getText());
        System.out.println(inNp);
        npData.insertNp(inNp);

    }

    public void TelInsertBtn(ActionEvent event) {
        TelepulesDAO telData = new TelepulesDAO("jdbc:mysql://localhost/tanosveny?user=root");
        Telepules inTel = new Telepules(Integer.parseInt(TeltF1.getText()),TeltF2.getText(),Integer.parseInt(TeltF3.getText()));
        System.out.println(inTel);
        telData.insertTel(inTel);

    }
}
