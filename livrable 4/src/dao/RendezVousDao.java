/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Patient;
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
public class RendezVousDao implements IDao<RendezVous>{
// dependences
    DataBase database = new DataBase();
//
    
    
// requette sql pour traitement des rendez vous
    // inserer rv
    private String SQL_INSERT = "INSERT INTO `rendez_vous` (`date`,"
    + " `heure`, `type`, `etat`, `id_patient`) "
    + " VALUES (?, ?, ?, ?, ?)";
    // Lister tous les rvs
    private String SQL_ALL_RV = "SELECT * FROM `rendez_vous` ";
    // lister les rvs d'un patient
    private String SQL_ALL_RV_BY_ID_PATIENT = "SELECT * FROM `rendez_vous` WHERE `id_patient` = ? ";
    // supprimer un rv
    private String SQL_DELETE = " DELETE FROM `rendez_vous` WHERE `id` = ? ";
//
    

// *******
    
    // inserer un rv : créer un rendez vous : planifier rv
    @Override
    public int insert(RendezVous rv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    // lister tous les rendez vous 
    public List<RendezVous> selectAllRv(){
        List<RendezVous> rvs = new ArrayList<>();
        database.openConnexion();
        database.initPrepareStatement(SQL_ALL_RV);
        ResultSet rs = database.executeSelect(SQL_ALL_RV);
        try {
            while(rs.next()){
                try {
                    int id = rs.getInt("id");
                    String date = rs.getString("date");
                    String heure = rs.getString("heure");
                    String etat = rs.getString("etat");
                    String type = rs.getString("type");
                    int idPatient = rs.getInt("id_patient");
                    PatientDao patientDao = new PatientDao();
                    Patient patient = patientDao.selectById(idPatient);
                    RendezVous rv = new RendezVous(id, date, heure, type, etat, patient);
                    rvs.add(rv);   
                } catch (SQLException ex) {
                    Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeConnexion();
        return rvs;
    }
    
    // lister tous les rendez vous d'un patient 
    public List<RendezVous> selectAllRvByIdPatient(int id){
        List<RendezVous> rvs = new ArrayList<>();
        database.openConnexion();
        database.initPrepareStatement(SQL_ALL_RV_BY_ID_PATIENT);
        try {
            database.getPs().setInt(1, id);
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = database.executeSelect(SQL_ALL_RV_BY_ID_PATIENT);
        try {
            while(rs.next()){
                try {
                    //Mapping relation vers objet
                    RendezVous rv = new RendezVous(rs.getString("date"), rs.getString("heure"),
                            rs.getString("type"), rs.getString("etat"));
                    rvs.add(rv);
                } catch (SQLException ex) {
                    Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeConnexion();
        return rvs;
    }
   
    // supprimer un rendez vous
    @Override
    public int delete(int id) {
        int idRvSup=0;
        database.openConnexion();
        database.initPrepareStatement(SQL_DELETE);
        try {
            database.getPs().setInt(1,id);
            idRvSup = database.executeUpdate(SQL_DELETE);
            System.out.println(idRvSup);
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeConnexion();
        return idRvSup;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
  
    
  
    
        
    
    
    
    
    
    
    
    @Override
    public int update(RendezVous ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public List<RendezVous> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RendezVous selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
    
    
    
    
}
