/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.patient;

import entities.Consultation;
import entities.Medecin;
import entities.RendezVous;
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
import javafx.scene.input.MouseEvent;
import service.Service;
import view.ConnexionController;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class Lister_consultationController implements Initializable {

    Service service = new Service();
    ObservableList<Consultation> obvListCons;
    
    @FXML
    private TableView<Consultation> tblvCons;
    @FXML
    private TableColumn<Consultation, String> tblcConDate;
    @FXML
    private TableColumn<Consultation, String> tblcConsHeure;
    @FXML
    private TableColumn<Consultation, Integer> tblcIdCons;

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
    List<Consultation> listeCons = service.searchAllConsultationById(id);
    obvListCons = FXCollections.observableArrayList(listeCons);
    tblcIdCons.setCellValueFactory(new PropertyValueFactory<>("id"));
    tblcConDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    tblcConsHeure.setCellValueFactory(new PropertyValueFactory<>("heure"));
    tblvCons.setItems(obvListCons);
}

    
}
