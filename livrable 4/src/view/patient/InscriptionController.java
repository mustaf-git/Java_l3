/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.patient;

import entities.Patient;
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
import javafx.scene.control.PasswordField;
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
public class InscriptionController implements Initializable {

    
    
    private final Service service = new Service();
    private static InscriptionController ctrl;
    private User user;
    private Patient patient;

    public static InscriptionController getCtrl() {
        return ctrl;
    }
    @FXML
    private TextField txtfNom;
    @FXML
    private TextField txtfPrenom;
    @FXML
    private TextField txtfAntecedantMedicaux;
    @FXML
    private TextField txtfLogin;
    private TextField txtPassword;
    private TextField txtConfirmPassword;
    @FXML
    private Text txtError;
    @FXML
    private PasswordField txtfPassword;
    @FXML
    private PasswordField txtfConfirmPassword;


    public User getUser() {
        return user;
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ctrl = this;
    }    

    // Inscription
    
    // créer un code pour le patient
        public  String generateCode(){
            char[] tabCar = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
            int index1 = (int)Math.round(Math.random()*25);
            int index2 = (int)Math.round(Math.random()*25);
            int index3 = (int)Math.round(Math.random()*25);
            int index4 = (int)Math.round(Math.random()*25);
            return "cp"+tabCar[index1]+tabCar[index2]+tabCar[index3]+tabCar[index4]; 
        }
    @FXML
    private void handleInscription(ActionEvent event) {
        user = null;
        String login = txtfLogin.getText().trim();
        String password = txtPassword.getText().trim();
        String confirmPassword = txtConfirmPassword.getText().trim();
        String role = "ROLE_PATIENT";
        String code = generateCode();
        String nom = txtfNom.getText().trim();
        String prenom = txtfPrenom.getText().trim();
        String antecedantMedicaux = txtfAntecedantMedicaux.getText().trim();
        
        //System.out.println(login+" "+password+" "+confirmPassword+" "+role+" "+code+" "+nom+" "+prenom+" "+antecedantMedicaux);
        // créons un id_dossier_medical pour l'instant
        //int idDossierMedical = 1;

        if(login.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() 
                || role.isEmpty() || code.isEmpty() || nom.isEmpty() 
                || prenom.isEmpty()){
            txtError.setText("Tous les champs sont obligatoires sauf antecedents médicaux");
            txtError.setVisible(true);
        }else{
            user = service.loginExist(login);
            if(user != null){
                txtError.setText("utilisateur existe déja");
                txtError.setVisible(true);
            }else{
                if(password.compareTo(confirmPassword)==0){
                this.txtError.getScene().getWindow().hide();
                AnchorPane root = null;
                try {
                    patient = new Patient(code, nom, prenom, antecedantMedicaux, login, password, role);
                    //System.out.println(patient);
                    //System.out.println(patient.getLogin());
                    //int id = service.addPatient(patient);
                    //System.out.println(id);
                    int idPatient = service.addPatient(patient);
                    patient.setId(idPatient);
                    root = FXMLLoader.load(getClass().getResource("/view/patient/v_home.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show(); 
                } catch (IOException ex) {
                    Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else{
                    txtError.setText("les deux mots de passes sont differents");
                    txtError.setVisible(true);
                }
            }
        }
    }

    @FXML
    private void handleClearInscription(ActionEvent event) {
        
        txtfNom.clear();
        txtfPrenom.clear();
        txtfAntecedantMedicaux.clear();
        txtfLogin.clear();
        txtPassword.clear();
        txtConfirmPassword.clear();
        txtError.setVisible(false);
    }
    
    
}
