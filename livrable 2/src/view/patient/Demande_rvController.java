/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.patient;

import entities.RendezVous;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import service.Service;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class Demande_rvController implements Initializable {

    Service service = new Service();
    Demande_rvController ctrl;
    private RendezVous rv;
    
    @FXML
    private TextField txtfDate;
    @FXML
    private TextField txtfHeure;
    @FXML
    private TextField txtfType;
    @FXML
    private Text txtError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtError.setVisible(false);
        ctrl = this;
    }    

    @FXML
    private void handleAddRv(ActionEvent event) {
        
        String date = txtfDate.getText().trim();
        String heure = txtfHeure.getText().trim();
        String type = txtfType.getText().trim();
        
        if(date.isEmpty() || heure.isEmpty() || type.isEmpty()){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Rendez-Vous");
            alert.setContentText("Mercide remplir toutes les cases");
            alert.show();
        }else{
            rv = new RendezVous(date, heure, type);
            int id = service.addRv(rv);
            rv.setId(id);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Rendez-Vous");
            alert.setContentText("Demande de rendez-vous effectue avec succès");
            alert.show();
        }
        txtfDate.clear();
        txtfHeure.clear();
        txtfType.clear();
        
    }
    
}
