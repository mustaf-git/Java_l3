/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.patient;

import entities.Consultation;
import entities.Patient;
import entities.Prestation;
import entities.RendezVous;
import entities.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import service.Service;
import view.ConnexionController;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class Demande_rvController implements Initializable {
    
    private Service service = new Service();
    private static Demande_rvController ctrl;
    private String typeRv;
    private String choixPrestation;


    @FXML
    private TextField txtfDate;
    @FXML
    private TextField txtfHeure;
    @FXML
    private ComboBox<String> cboTypeRv;
    @FXML
    private ComboBox<String> cboChoixPrestation;
    @FXML
    private Button txtfConfirmerDemandeRv;
    @FXML
    private Text txtError;
    @FXML
    private Text txtErrorPrestation;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cboTypeRv.getItems().add("consultation");
        cboTypeRv.getItems().add("prestation");

        
        
        cboChoixPrestation.setDisable(true);
        
        cboChoixPrestation.getItems().add("Radio");
        cboChoixPrestation.getItems().add("analyse");
        cboChoixPrestation.getItems().add("scanner");

        
        txtfConfirmerDemandeRv.setVisible(false);
        
        txtError.setVisible(false);
        txtErrorPrestation.setVisible(false);
        
        ctrl = this;    
    }

    @FXML
    private void handleChangerTypeRv(MouseEvent event) {
        typeRv = cboTypeRv.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleChangerTypePrestation(MouseEvent event) {
        choixPrestation = cboChoixPrestation.getSelectionModel().getSelectedItem();
    }  
    
    @FXML
    private RendezVous handleDemanderRv(ActionEvent event) {
        Patient patient = null;
        RendezVous rv = null ;
        
        String date = txtfDate.getText().trim();
        String heure = txtfHeure.getText().trim();
        String typeRv = cboTypeRv.getSelectionModel().getSelectedItem();
        String libellePrestation = cboChoixPrestation.getSelectionModel().getSelectedItem();
        String etat = "En attente";
        int idPatient = ConnexionController.getCtrl().getUser().getId();
        patient = service.searchPatientById(idPatient);
        if(date.isEmpty() || heure.isEmpty()){
            txtError.setText("tous les champs sont obligatoires");
            txtError.setVisible(true);
        }else if(typeRv==null){
            txtError.setText("merci de choisir le type du rv");
            txtError.setVisible(true);
            
        }else if(typeRv.compareTo("consultation")==0){
            System.out.println(typeRv);
            txtfConfirmerDemandeRv.setVisible(true);
            rv = new Consultation(date, heure, typeRv, etat, patient);
        }else if(typeRv.compareTo("prestation")==0){
            System.out.println(typeRv);
            cboChoixPrestation.setDisable(false);
            cboTypeRv.setDisable(true);
            if(libellePrestation==null){
                txtError.setText("merci de choisir la nature de la prestation");
                txtError.setVisible(true);
            }else{
                System.out.println(libellePrestation);
                txtfConfirmerDemandeRv.setVisible(true);
                rv = new Prestation(libellePrestation, date, heure, typeRv, etat, patient);
                
            }
        }
        return rv;
    }

    @FXML
    private void handleConfirmerDemandeRv(ActionEvent event) {
        RendezVous rv = handleDemanderRv(event);
        if(cboTypeRv.getSelectionModel().getSelectedItem().compareTo("consultation")==0){
            System.out.println(cboTypeRv.getSelectionModel().getSelectedItem());
            Consultation consultation = (Consultation)rv;
            int idRv = service.addRvCons(consultation);
            rv.setId(idRv);
        }else if(cboTypeRv.getSelectionModel().getSelectedItem().compareTo("prestation")==0){
            System.out.println(cboTypeRv.getSelectionModel().getSelectedItem());
            Prestation prestation = (Prestation)rv;
            int idRv = service.addRvPres(prestation);
            rv.setId(idRv);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rensez-Vous");
        alert.setContentText("demande de rendez-vous effectuée avec succès");
        alert.show();
        handleClearDemandeRv(event);
    }
    
    
    @FXML
    private void handleClearDemandeRv(ActionEvent event) {
        txtfDate.clear();
        txtfHeure.clear();
        cboChoixPrestation.setDisable(true);
        cboTypeRv.setDisable(false);
        txtfConfirmerDemandeRv.setVisible(false);
        txtError.setVisible(false);
       
    }
    
    
    
    public static Demande_rvController getCtrl() {
        return ctrl;
    }
    
    public String getTypeRv() {
        return typeRv;
    }

    public String getChoixPrestation() {
        return choixPrestation;
    }




    
    
    
    
}
