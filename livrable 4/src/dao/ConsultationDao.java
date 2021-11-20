/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Consultation;
import entities.Medecin;
import entities.RendezVous;
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
public class ConsultationDao implements IDao<Consultation>{
    
// dependences
    
    DataBase database = new DataBase();
    
    
//
    
    
// requette sql pour traitement des rendez vous
    
    // inserer rv type Consultation
    private String SQL_INSERT = "INSERT INTO `rendez_vous` (`date`,"
    + " `heure`, `type`, `etat`, `id_patient`) "
    + " VALUES (?, ?, ?, ?, ?)";
    
    // afficher toutes les consultation grâce à l'id
    private String SQL_ALL_CONS_BY_ID = "SELECT * FROM `rendez_vous` WHERE `id_patient` = ? AND `type` = ? ";

    
    
    
//
    
    
    @Override
    public int insert(Consultation rv) {
        int idRv = 0;
        database.openConnexion();
        database.initPrepareStatement(SQL_INSERT);
        try {      
            database.getPs().setString(1, rv.getDate());
            database.getPs().setString(2, rv.getHeure());
            database.getPs().setString(3, rv.getType());
            database.getPs().setString(4, rv.getEtat());
            database.getPs().setInt(5, rv.getPatient().getId());            
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

 
    public List<Consultation> selectAllConsultationById(int id){
        //Liste de consultation
        List<Consultation> consultations = new ArrayList<>();
        // une consulttion à mettre dans la liste de consultation
        Consultation consultation;
        
        database.openConnexion();
        database.initPrepareStatement(SQL_ALL_CONS_BY_ID);
        
        try {
            // injecter la valeur à remplacer par ?
            database.getPs().setInt(1, id);
            database.getPs().setString(2, "consultation");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet rs = database.executeSelect(SQL_ALL_CONS_BY_ID);
        
        try { 
            while(rs.next()){ // tant que ya une ligne
                consultation = new Consultation(rs.getInt("id"),rs.getString("date"), rs.getString("heure")); // crée une consultation
                consultations.add(consultation); // ajouter cette consultation dans la liste des consultations
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultationDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            database.closeConnexion();
        }
        return consultations; // retourner la liste des consultations
    }

    
    
    
    
    
    
    
    
    
    

    @Override
    public int update(Consultation ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consultation> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consultation selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
