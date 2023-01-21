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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ModController extends SceneController implements Initializable {

    @FXML
    public ComboBox TableSelectCB;
    //Ut
    @FXML
    public AnchorPane utAP;
    @FXML
    public ComboBox utIdSelect;
    @FXML
    public TextField utnevTF;
    @FXML
    public TextField hosszTF;
    @FXML
    public TextField allomasTF;
    @FXML
    public TextField idoTF;
    @FXML
    public CheckBox vezCheckBox;
    @FXML
    public TextField telidTF;

    //np
    @FXML
    public AnchorPane npAP;
    @FXML
    public ComboBox npIdSelect;
    @FXML
    public TextField parknevTF;

    //Tel
    @FXML
    public AnchorPane telAP;
    @FXML
    public ComboBox telIdSelect;
    @FXML
    public TextField telnevTF;
    @FXML
    public TextField npidTF;
    @FXML
    public Button utSubBtn;
    @FXML
    public Button npSubBtn;
    @FXML
    public Button telSubBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableSelectCB.getItems().add("Út");
        TableSelectCB.getItems().add("Település");
        TableSelectCB.getItems().add("Nemzeti Park");

        utAP.setVisible(false);
        telAP.setVisible(false);
        npAP.setVisible(false);
    }

    public void TableSelected(ActionEvent event) {
        int selectedIndex = TableSelectCB.getSelectionModel().getSelectedIndex();

        System.out.println("Választás index:"+selectedIndex);

        switch (selectedIndex)
        {
            case 0:
                telAP.setVisible(false);
                npAP.setVisible(false);
                utAP.setVisible(true);
                System.out.println("Út");
                UtDAO utData = new UtDAO("jdbc:mysql://localhost/tanosveny?user=root");
                ArrayList<Ut> indexut = utData.getAll();
                for(Ut item : indexut)
                {
                    utIdSelect.getItems().add(item.getUtid());
                }

                break;
            case 1:
                utAP.setVisible(false);
                npAP.setVisible(false);
                telAP.setVisible(true);
                System.out.println("Település");
                TelepulesDAO telData = new TelepulesDAO("jdbc:mysql://localhost/tanosveny?user=root");
                ArrayList<Telepules> indextel = telData.getAll();
                for(Telepules item : indextel)
                {
                    telIdSelect.getItems().add(item.getTelid());
                }
                break;
            case 2:
                utAP.setVisible(false);
                telAP.setVisible(false);
                npAP.setVisible(true);
                System.out.println("Nemzeti Park ");
                NpDAO npData = new NpDAO("jdbc:mysql://localhost/tanosveny?user=root");
                ArrayList<Np> indexnp = npData.getAll();
                for(Np item : indexnp)
                {
                    npIdSelect.getItems().add(item.getParkid());
                }

                break;

            default: System.out.println("Baj van");break;
        }

    }

    public void utIdSelected(ActionEvent event) {
        UtDAO utData = new UtDAO("jdbc:mysql://localhost/tanosveny?user=root");
        int selindex = (int)utIdSelect.getSelectionModel().getSelectedItem();
        Ut selut =utData.getItemById(selindex);
        utnevTF.setText(selut.getUtnev());
        hosszTF.setText(String.valueOf(selut.getHossz()));
        allomasTF.setText(String.valueOf(selut.getAllomas()));
        idoTF.setText(String.valueOf(selut.getIdo()));
        vezCheckBox.setSelected(selut.isVezetes());
        telidTF.setText(String.valueOf(selut.getTelepulesid()));

    }
    public void utUpdateBtn(ActionEvent event) {
        UtDAO utData = new UtDAO("jdbc:mysql://localhost/tanosveny?user=root");
        int selindex = (int)utIdSelect.getSelectionModel().getSelectedItem();
        String ujnev = utnevTF.getText();
        double ujhossz = Double.parseDouble(hosszTF.getText());
        int ujallomas = Integer.parseInt(allomasTF.getText());
        double ujido = Double.parseDouble(idoTF.getText());
        boolean ujvez = vezCheckBox.isSelected();
        int ujtelid = Integer.parseInt(telidTF.getText());

        Ut modUt = new Ut(selindex,ujnev,ujhossz,ujallomas,ujido,ujvez,ujtelid);
        utData.updateUt(modUt);

    }

    public void npIdSelected(ActionEvent event) {
        NpDAO npData = new NpDAO("jdbc:mysql://localhost/tanosveny?user=root");
        int selindex= (int)npIdSelect.getSelectionModel().getSelectedItem();
        Np selnp = npData.getItemById(selindex);
        parknevTF.setText(selnp.getParknev());
    }
    public void npUpdateBtn(ActionEvent event) {
        NpDAO npData = new NpDAO("jdbc:mysql://localhost/tanosveny?user=root");
        int selindex= (int)npIdSelect.getSelectionModel().getSelectedItem();
        String ujnev = parknevTF.getText();
        Np modNp = new Np(selindex, ujnev);
        npData.updateNp(modNp);
    }

    public void telIdSelected(ActionEvent event) {
        TelepulesDAO telData = new TelepulesDAO("jdbc:mysql://localhost/tanosveny?user=root");
        int selindex = (int)telIdSelect.getSelectionModel().getSelectedItem();
        Telepules seltel = telData.getItemById(selindex);
        telnevTF.setText(seltel.getTelnev());
        npidTF.setText(String.format(String.valueOf(seltel.getNpid())));
    }
    public void telUpdateBtn(ActionEvent event) {
        TelepulesDAO telData = new TelepulesDAO("jdbc:mysql://localhost/tanosveny?user=root");
        int selindex = (int)telIdSelect.getSelectionModel().getSelectedItem();
        String ujnev = telnevTF.getText();
        int ujnpid = Integer.parseInt(npidTF.getText());
        Telepules modtel = new Telepules(selindex,ujnev,ujnpid);
        telData.updateTel(modtel);
    }
}
