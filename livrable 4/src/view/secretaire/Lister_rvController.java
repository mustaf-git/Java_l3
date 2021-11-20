/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.secretaire;

import entities.Medecin;
import view.patient.*;
import entities.RendezVous;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
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
    ObservableList<Medecin> obvListMedecin;
    
    
    // recupérer le rendez-vous electionné grace au clic de la souris sur un élément de la liste : du tableau : tableview
    private RendezVous rvSelected = null;

    
    
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
    private TableColumn<RendezVous, String> tblcNomPatient;
    @FXML
    private Button idButtonAnnulerRv;
    @FXML
    private Button idButtonValiderRv;
    @FXML
    private ComboBox<Medecin> cboChoixMedecin;
    @FXML
    private Button idButtonEnregistrer;
    @FXML
    private Text txtError;
    
    

    /**
     * Initializes the controller class.
     */
    
    //au chargement de la page 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTableView();
        /*
        idButtonAnnulerRv.setVisible(false);
        idButtonValiderRv.setVisible(false);
        cboChoixMedecin.setVisible(false);
        idButtonEnregistrer.setVisible(false);
        txtError.setVisible(false);
        */

    }   
    
    //
    public void loadTableView(){
    // récuper l'id du patient
    //int id = 0;
    //id = ConnexionController.getCtrl().getUser().getId();
    // recupérer la liste de rv grace à l'id du patient : les rvs du patient
    List<RendezVous> listeRv = service.searchAllRv();
    // transformer la liste de rvs récupéré en une observableList 
    obvListRv = FXCollections.observableArrayList(listeRv);
    // Construire les colones du table( table view => vu fxml ) à partir des elements de l'objet de ce type de liste
    tblcRvDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    tblcRvHeure.setCellValueFactory(new PropertyValueFactory<>("heure"));
    tblcRvType.setCellValueFactory(new PropertyValueFactory<>("type"));
    tblcRvEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
    tblcNomPatient.setCellValueFactory(new PropertyValueFactory<>("patient"));
    //ajouter chaque ligne de cette observableList dans le tableau ( table view : vu fxml )
    tblvRv.setItems(obvListRv);
}

    @FXML
    private RendezVous handleSelectRv(MouseEvent event) {
        //RendezVous rv = null;
        // recupéré l'objet selectionné sur le tableview tableau vu fxml avec un simple clic de la souris sur l'élément
        
        rvSelected = tblvRv.getSelectionModel().getSelectedItem();
        // faire aparaitre le boutton annuler et valider quand on clic seulement sur un élément de la liste
        if(rvSelected!=null){
                    //System.out.println(rvSelected);
                    //System.err.println(rvSelected.getId());
                    idButtonAnnulerRv.setVisible(true);
                    idButtonValiderRv.setVisible(true);
                    cboChoixMedecin.setVisible(false);
                    idButtonEnregistrer.setVisible(false);
                    txtError.setVisible(false);
                    //rv = rvSelected;
        }
        return rvSelected;
    }

    @FXML
    private void handleAnnulerRv(ActionEvent event) {
        idButtonValiderRv.setDisable(true);
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression d'un rendez-vous");
        alert.setContentText("Voulez annuler ce rendez-vous?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        int id = service.removeRv(rvSelected.getId());
        alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Rendez-vous annulé avec succès");
        alert.show();
        }
        loadTableView();
    }

    @FXML
    private void handleValidateRv(ActionEvent event) {
        idButtonAnnulerRv.setVisible(false);
        idButtonValiderRv.setVisible(false);
        List<Medecin> listMedecin = service.searchAllMedecin();
        obvListMedecin = FXCollections.observableArrayList(listMedecin);
        cboChoixMedecin.setItems(obvListMedecin);
        cboChoixMedecin.setVisible(true);
        idButtonEnregistrer.setVisible(true);
        
        
    }


    @FXML
    private void handleEnregistrerRv(ActionEvent event) {
        if(cboChoixMedecin.getSelectionModel().getSelectedItem()!=null){
            txtError.setVisible(false);
        }else{
            txtError.setVisible(true);
        }  
    }
    
    
}
