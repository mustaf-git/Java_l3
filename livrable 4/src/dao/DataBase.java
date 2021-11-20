/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */

public class DataBase {
    
    
    // dans une base de données on a besoin de faire les traitements suivants : 
        // définir la chaine de connexion dans la base de données
        // ouvrir la connexion à la base de données
        // faire une requette 
            // de mise à jour ou 
            // d'interogation
        // fermer la connexion avec la base de données
    
    
// chaine de connexion à la base de données
    @SuppressWarnings("FieldMayBeFinal")
    private String url="jdbc:mysql://localhost:3306/gestion_consultation_analyse";
    @SuppressWarnings("FieldMayBeFinal")
    private String user="root";
    @SuppressWarnings("FieldMayBeFinal")
    private String password="";
    Connection cnx=null;
    
    
// Objet d'execution des requetes preparé
    private PreparedStatement ps=null;
    
// recuperer l'execution de la requette préparée
    public PreparedStatement getPs() {
        return ps;
    }
    
    
// ouvrir la connexion à la base de données
    public void openConnexion(){
        try {
            //1-charger le Driver
            Class.forName("com.mysql.jdbc.Driver");
            //2-Ouverture de la connection
            try {
                cnx=DriverManager.getConnection(url,user,password);
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Connexion etablie");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
    
    
// preparer la requette : injection de valeurs
    public void initPrepareStatement(String sql){
        if(sql.toLowerCase().startsWith("insert")){
            try {
                ps=cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS); // si insert alors prépare qussi le dernier id insérer
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                ps=cnx.prepareStatement(sql); // sinon prepare seulement la requette
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // executer la requette la requette de mise à jour => nbre de lignes modifié
    public int executeUpdate(String sql){ 
        int nbreLigne=0;
        try {
            nbreLigne=ps.executeUpdate(); // le nombre de lignes modifées par la requette
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    return nbreLigne;
    }
    
    // executer la requette de selection => jeu de resultat : tableau de resultat de la requette => sous forme de pointeur
    public ResultSet executeSelect(String sql){
        ResultSet rs=null;
        try {
            rs=ps.executeQuery(); // resultat de la requette sous forme de tableau de pointeur
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    return rs;
    }
    
    
// fermer la connexion à la base de données
    public void closeConnexion(){
        if(cnx!=null){
            try {
                cnx.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}