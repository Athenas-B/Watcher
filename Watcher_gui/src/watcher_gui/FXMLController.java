/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watcher_gui;

import global.databaze.Databaze;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import serialy.Serial;

/**
 * FXML Controller class
 *
 * @author Oldřich
 */
public class FXMLController implements Initializable {

    @FXML
    private AnchorPane horniPanel;
    @FXML
    private AnchorPane dolniPanel;
    @FXML
    private SplitPane spnlPanel;
    @FXML
    private Button btnNovy;
    @FXML
    private Button btnSmazat;
    @FXML
    private CheckBox chbDnes;
    @FXML
    private DatePicker dtpDatum;
    @FXML
    private Button btnDilPlus;
    @FXML
    private Button btnDilMinus;
    @FXML
    private Button btnSeriePlus;
    @FXML
    private Button btnSerieMinus;
    @FXML
    public TableView<Serial> tblTabulka;

    private Databaze<Serial> db;
    private ObservableList<Serial> seznam;
    //@FXML
    //private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                super.run();
                db.konec();
                System.out.println("konec");
            }
        });

        db = new Databaze<>("serialy", Serial.class);
        db.start();
        db.startAktualizace();
        seznam = observableArrayList(db.vratVsechny());
        TableColumn idCol = new TableColumn("Id");
        TableColumn nazevCol = new TableColumn("Název");
        TableColumn nazevAngCol = new TableColumn("Název-anglicky");
        TableColumn<Serial, ComboBox> typCol = new TableColumn("Typ");
        TableColumn stavCol = new TableColumn("Stav");
        TableColumn adresaCol = new TableColumn("Adresa");
        TableColumn titulkyCol = new TableColumn("Titulky");
        TableColumn dneCol = new TableColumn("Dne");
        TableColumn serieCol = new TableColumn("Serie");
        TableColumn dilCol = new TableColumn("Dil");

        idCol.setCellValueFactory(
                new PropertyValueFactory<Serial, String>("id"));
        nazevCol.setCellValueFactory(
                new PropertyValueFactory<Serial, String>("nazev"));
        nazevCol.setEditable(true);
        nazevAngCol.setCellValueFactory(
                new PropertyValueFactory<Serial, String>("nazevAnglicky"));
        nazevAngCol.setCellValueFactory(
                new PropertyValueFactory<Serial, String>("nazevAnglicky"));
        typCol.setCellValueFactory(
                new PropertyValueFactory<Serial, ComboBox>("typ"));

        dilCol.setCellValueFactory(new PropertyValueFactory<Serial, String>("Dil"));

        tblTabulka.getColumns().clear();
        tblTabulka.getColumns().addAll(idCol, nazevCol, nazevAngCol, typCol, stavCol, adresaCol, titulkyCol, dneCol, serieCol, dilCol);

        tblTabulka.setItems(seznam);

        tblTabulka.setEditable(true);

    }

    @FXML
    public void dilPlus() {
        db.startAktualizace();
        Serial selectedItem = tblTabulka.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            return;
        }
        selectedItem.setDil(selectedItem.getDil() + 1);
        aktualizujTabulku();
        db.aktualizuj();
    }

    @FXML
    public void dilMinus() {
        db.startAktualizace();
        Serial selectedItem = tblTabulka.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            return;
        }
        selectedItem.setDil(selectedItem.getDil() - 1);
        aktualizujTabulku();
        db.aktualizuj();
    }

    @FXML
    public void seriePlus() {
        db.startAktualizace();
        Serial selectedItem = tblTabulka.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            return;
        }
        selectedItem.setSerie(selectedItem.getSerie() + 1);
        aktualizujTabulku();
        db.aktualizuj();
    }

    @FXML
    public void serieMinus() {
        db.startAktualizace();
        Serial selectedItem = tblTabulka.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            return;
        }
        selectedItem.setSerie(selectedItem.getSerie() - 1);
        aktualizujTabulku();
        db.aktualizuj();
    }

    private void aktualizujTabulku() {
        for (int i = 0; i < tblTabulka.getColumns().size(); i++) {
            ((TableColumn) (tblTabulka.getColumns().get(i))).setVisible(false);
            ((TableColumn) (tblTabulka.getColumns().get(i))).setVisible(true);
        }
    }
}
