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
    private TextField txtfPassword;
    @FXML
    private Text txtError;
    
    private final Service service = new Service();
    
    private static ConnexionController ctrl;
    
    private User user;

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
        txtError.setVisible(false);
        ctrl = this;
    }    

    // Se connecter
    @FXML
    private void handleConnexion(ActionEvent event) {
        
        String login = txtfLogin.getText().trim();
        String password = txtfPassword.getText().trim();
        if(login.isEmpty() || password.isEmpty()){
            txtError.setText("login ou mot de passe obligatoire");
            txtError.setStyle("-fx-border-color:red");
            txtError.setVisible(true);
        }else{
            user = service.login(login, password);
            if(user == null){
                txtError.setText("login ou mot de passe incorrect");
                txtError.setVisible(true);
            }else{
                System.out.println(user.getId());
                this.txtError.getScene().getWindow().hide();
                AnchorPane root = null;
                
                try {
                    root = FXMLLoader.load(getClass().getResource("/view/patient/v_home.fxml"));
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

    // effacer les champs pour la connexion
    @FXML
    private void handleClearConnexion(ActionEvent event) {
        txtfLogin.clear();
        txtfPassword.clear();
        txtError.setVisible(false);
    }
    // le boutton s'inscrire : pour charger la page d'inscription du patient 
    // mais l'inscription du patient est traitée au niveau de inscription dans le dossier patient
    @FXML
    private void handleLoadInscriptionPage(ActionEvent event) {
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
