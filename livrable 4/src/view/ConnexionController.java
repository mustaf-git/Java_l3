/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.User;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.Service;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ConnexionController implements Initializable {

    @FXML
    private TextField txtfLogin;
    @FXML
    private TextField txtPassword;
    @FXML
    private Text txtLoginError;
    @FXML
    private Text txtPasswordError;
    
    private Service service = new Service();
    private static ConnexionController ctrl;
    private User user;
    @FXML
    private Text txtError;

    public static ConnexionController getCtrl() {
        return ctrl;
    }

    public User getUser() {
        return user;
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtLoginError.setVisible(false);
        txtPasswordError.setVisible(false);
        ctrl = this;
    }    

    @FXML
    private void handleConnexion(ActionEvent event) {
        
        String login = txtfLogin.getText().trim();
        String password = txtPassword.getText().trim();
        
        
        if(login.isEmpty() && password.isEmpty()){
            txtLoginError.setVisible(true);
            txtPasswordError.setVisible(true);
            
        }else if(login.isEmpty()){
            txtLoginError.setVisible(true); 
            
        }else if(password.isEmpty()){
            txtPasswordError.setVisible(true);
            
        }else{
            user = service.login(login, password);
            
            if(user == null){
                txtError.setText("login ou mot de passe incorrect");
                txtError.setVisible(true);
                
            }else{
                //System.out.println(user.getId());
                this.txtError.getScene().getWindow().hide();
                AnchorPane root = null;
                try {
                    if(user.getRole().compareTo("ROLE_SECRETAIRE")==0){
                        root = FXMLLoader.load(getClass().getResource("/view/secretaire/v_home.fxml"));
                    }else if(user.getRole().compareTo("ROLE_MEDECIN")==0){
                        root = FXMLLoader.load(getClass().getResource("/view/medecin/v_home.fxml"));
                    }else if(user.getRole().compareTo("ROLE_PRESTATAIRE")==0){
                        root = FXMLLoader.load(getClass().getResource("/view/prestataire/v_home.fxml"));
                    }else{
                        root = FXMLLoader.load(getClass().getResource("/view/patient/v_home.fxml"));
                    }
                    //root = FXMLLoader.load(getClass().getResource("/view/patient/v_home.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                }catch (IOException ex) {
                    Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
              }
            } 
        }
    }

    @FXML
    private void handleClearConnexion(ActionEvent event) {
        txtfLogin.clear();
        txtPassword.clear();
        txtLoginError.setVisible(false);
        txtPasswordError.setVisible(false);
    }

    @FXML
    private void handleInscription(ActionEvent event) {
        this.txtError.getScene().getWindow().hide();
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/patient/v_inscription.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
