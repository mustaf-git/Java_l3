/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.secretaire;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import view.ConnexionController;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class HomeController implements Initializable {

    private static HomeController ctrl;

    public static HomeController getCtrl() {
        return ctrl;
    }
    @FXML
    private AnchorPane anchorContent;
    @FXML
    private Text txtLoginConnecte;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtLoginConnecte.setText("Email : " + ConnexionController.getCtrl().getUser().getLogin());
        try {  
            loadView("v_lister_rv");
            /*initialiser le controller dans la methode imiatialse*/
            ctrl = this;
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    
    
        private void loadView(String view) throws IOException{
        AnchorPane root;
        root = FXMLLoader.load(getClass().getResource("/view/secretaire/"+view+".fxml"));
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(root);
    }



    @FXML
    private void handleShowRv(ActionEvent event) throws IOException {
        loadView("v_lister_rv");
    }


   
    
}
