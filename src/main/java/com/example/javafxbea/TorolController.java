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
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TorolController extends SceneController implements Initializable {

    @FXML
    public ComboBox TableSelectCB;
    //ut
    @FXML
    public AnchorPane utAP;
    @FXML
    public ComboBox utIdSelect;
    @FXML
    public Button utDelBtn;

    //np
    @FXML
    public AnchorPane npAP;
    @FXML
    public ComboBox npIdSelect;
    @FXML
    public Button npDelBtn;

    //tel
    @FXML
    public AnchorPane telAP;
    @FXML
    public ComboBox telIdSelect;
    @FXML
    public Button telDelBtn;

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

        System.out.println("Választás index:" + selectedIndex);

        switch (selectedIndex) {
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

            default:
                System.out.println("Baj van");
                break;
        }
    }

    public void utDeleteClicked(ActionEvent event) {
        UtDAO utData = new UtDAO("jdbc:mysql://localhost/tanosveny?user=root");
        int selectedId = (int)utIdSelect.getSelectionModel().getSelectedItem();
        utData.deleteUt(selectedId);

    }

    public void npDeleteClicked(ActionEvent event) {
        NpDAO npData = new NpDAO("jdbc:mysql://localhost/tanosveny?user=root");
        int selectedId = (int)npIdSelect.getSelectionModel().getSelectedItem();
        npData.deleteNp(selectedId);

    }

    public void telDelClicked(ActionEvent event) {
        TelepulesDAO telData = new TelepulesDAO("jdbc:mysql://localhost/tanosveny?user=root");
        int selectedId = (int)telIdSelect.getSelectionModel().getSelectedItem();
        telData.deleteTel(selectedId);

    }
}
