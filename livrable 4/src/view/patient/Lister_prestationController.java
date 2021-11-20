/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.patient;

import entities.Prestation;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.Service;
import view.ConnexionController;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class Lister_prestationController implements Initializable {

    Service service = new Service();
    ObservableList<Prestation> obvListPres;
    
    @FXML
    private TableView<Prestation> tblvPres;
    @FXML
    private TableColumn<Prestation, Integer> tblcIdPres;
    @FXML
    private TableColumn<Prestation, String> tblcPresDate;
    @FXML
    private TableColumn<Prestation, String> tblcPresHeure;
    @FXML
    private TableColumn<Prestation, String> tblcLibPres;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
@Override
    public void initialize(URL url, ResourceBundle rb) {
       loadTableView();
    }    
    
    public void loadTableView(){
    int id = 0;
    id = ConnexionController.getCtrl().getUser().getId();
    List<Prestation> listePres = service.saerchAllPrestationById(id);
    obvListPres = FXCollections.observableArrayList(listePres);
    tblcIdPres.setCellValueFactory(new PropertyValueFactory<>("id"));
    tblcPresDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    tblcPresHeure.setCellValueFactory(new PropertyValueFactory<>("heure"));
    tblcLibPres.setCellValueFactory(new PropertyValueFactory<>("libellePrestation"));
    tblvPres.setItems(obvListPres);
}

    
}
