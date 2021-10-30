/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.patient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.ConnexionController;
//import view.ConnexionController;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class HomeController implements Initializable {
    
    
    //public ConnexionController conexCtrl;
    //String roleUserConec = conexCtrl.getUser().getRole();
    //if(roleUserConec == "ROLE_PATIENT"){
    //desactive le boutoon
//}

    
    private static HomeController ctrl;
    public static HomeController getCtrl() {
        return ctrl;
    }
    @FXML
    private Text txtInfoUserConnect;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtInfoUserConnect.setText(ConnexionController.getCtrl().getUser().getRole());
        ctrl = this;
        
    }    

    @FXML
    private Button txtButtonAddRv;
    @FXML
    private void handleAddRv(ActionEvent event) {
        this.txtButtonAddRv.getScene().getWindow().hide();
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/patient/v_demande_rv.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    @FXML
    private void handleShowRv(ActionEvent event) {
        
        this.txtButtonAddRv.getScene().getWindow().hide();
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/patient/v_lister_rv.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void handleShowCons(ActionEvent event) {
        this.txtButtonAddRv.getScene().getWindow().hide();
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/patient/v_lister_consultation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void handleShowPrest(ActionEvent event) {
        this.txtButtonAddRv.getScene().getWindow().hide();
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/patient/v_lister_prestation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
