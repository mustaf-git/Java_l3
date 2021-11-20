/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Consultation;
import entities.Prestation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class PrestationDao implements IDao<Prestation>{

    // dependences
    
    DataBase database = new DataBase();
    
    
//
    
    
// requette sql pour traitement des prestation
    
    // inserer rv prestation : insérer une prestation
    private String SQL_INSERT = "INSERT INTO `rendez_vous` (`libelle_prestation`, `date`,"
    + " `heure`, `type`, `etat`, `id_patient`) "
    + " VALUES (?, ?, ?, ?, ?, ?)";
    
    // afficher toutes les prestations grâce à l'id
    private String SQL_ALL_PRES_BY_ID = "SELECT * FROM `rendez_vous` WHERE `id_patient` = ? AND `type` = ? ";
    
    
    
//
    
    @Override
    public int insert(Prestation rv) {
        int idRv = 0;
        database.openConnexion();
        database.initPrepareStatement(SQL_INSERT);
        try {
            database.getPs().setString(1, rv.getLibellePrestation());
            database.getPs().setString(2, rv.getDate());
            database.getPs().setString(3, rv.getHeure());
            database.getPs().setString(4, rv.getType());
            database.getPs().setString(5, rv.getEtat());
            database.getPs().setInt(6, rv.getPatient().getId());            
            database.executeUpdate(SQL_INSERT);
            ResultSet rs = database.getPs().getGeneratedKeys();
            if(rs.next()){
                idRv = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            database.closeConnexion();
        }
        return idRv;
    }

    
    
    public List<Prestation> selectAllPrestationById(int id){
        //Liste de consultation
        List<Prestation> prestations = new ArrayList<>();
        // une consulttion à mettre dans la liste de consultation
        Prestation prestation;
        
        database.openConnexion();
        database.initPrepareStatement(SQL_ALL_PRES_BY_ID);
        
        try {
            // injecter la valeur à remplacer par ?
            database.getPs().setInt(1, id);
            database.getPs().setString(2, "prestation");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet rs = database.executeSelect(SQL_ALL_PRES_BY_ID);
        
        try { 
            while(rs.next()){ // tant que ya une ligne
                prestation = new Prestation(rs.getString("libelle_prestation"), rs.getInt("id"),rs.getString("date"), rs.getString("heure")); // crée une consultation
                prestations.add(prestation); // ajouter cette consultation dans la liste des consultations
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrestationDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            database.closeConnexion();
        }
        return prestations; // retourner la liste des consultations
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public int update(Prestation ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Prestation> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Prestation selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
