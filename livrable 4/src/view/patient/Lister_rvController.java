/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.patient;

import entities.RendezVous;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class Lister_rvController implements Initializable {
    
    // dependences
    
    Service service = new Service();
    
    //
    
    // créer un observableList : sujet d'observation pour la liste:  => actualiser la liste automatiquement s'il s'actualise
    ObservableList<RendezVous> obvListRv;
    
    
    // recupérer le rendez-vous electionné grace au clic de la souris sur un élément de la liste : du tableau : tableview
    private RendezVous rvSelected;
    
    // variable fxml
    @FXML
    private TableView<RendezVous> tblvRv;
    @FXML
    private TableColumn<RendezVous, String> tblcRvDate;
    @FXML
    private TableColumn<RendezVous, String> tblcRvHeure;
    @FXML
    private TableColumn<RendezVous, String> tblcRvType;
    @FXML
    private TableColumn<RendezVous, String> tblcRvEtat;
    @FXML
    private Button idButtonDeleteRv;

    /**
     * Initializes the controller class.
     */
    
    //au chargement de la page 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTableView();
        idButtonDeleteRv.setVisible(false);
    }   
    
    //
    public void loadTableView(){
    // récuper l'id du patient
    int id = 0;
    id = ConnexionController.getCtrl().getUser().getId();
    // recupérer la liste de rv grace à l'id du patient : les rvs du patient
    List<RendezVous> listeRv = service.searchAllRvById(id);
    // transformer la liste de rvs récupéré en une observableList 
    obvListRv = FXCollections.observableArrayList(listeRv);
    // Construire les colones du table( table view => vu fxml ) à partir des elements de l'objet de ce type de liste
    tblcRvDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    tblcRvHeure.setCellValueFactory(new PropertyValueFactory<>("heure"));
    tblcRvType.setCellValueFactory(new PropertyValueFactory<>("type"));
    tblcRvEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
    //ajouter chaque ligne de cette observableList dans le tableau ( table view : vu fxml )
    tblvRv.setItems(obvListRv);
}

    @FXML
    private void handleSelectRv(MouseEvent event) {
        // recupéré l'objet selectionné sur le tableview tableau vu fxml avec un simple clic de la souris sur l'élément
        rvSelected = tblvRv.getSelectionModel().getSelectedItem();
        // faire aparaitre le boutton annuler quand on clic seulement sur un élément de la liste
        idButtonDeleteRv.setVisible(true);
    }

    @FXML
    private void handleDeleteRv(ActionEvent event) {
        //supprimer le rendez-vous : 
    }
    
    
}
