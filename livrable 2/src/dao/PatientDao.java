/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entities.Patient;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author DELL
 */


public class PatientDao implements IDao<Patient>{
    
    private  DataBase database = new DataBase();
    private final String SQL_INSERT =
"INSERT INTO `user` (`login`, `password`, `role`, `code`, `nom`, `prenom`, `antecedants_medicaux`) VALUES (?, ?, ?, ?, ?, ?, ?)";


    @Override
    public int insert(Patient patient) {
        int lastInsertId = 0;
        try {
            database.openConnexion();
            database.initPrepareStatement(SQL_INSERT);
            database.getPs().setString(1, patient.getLogin());
            database.getPs().setString(2, patient.getPassword());
            database.getPs().setString(3, patient.getRole());
            database.getPs().setString(4, patient.getCode());
            database.getPs().setString(5, patient.getNom());
            database.getPs().setString(6, patient.getPrenom());
            database.getPs().setString(7, patient.getAntecedentsMedicaux());
            database.executeUpdate(SQL_INSERT);
            ResultSet rs = database.getPs().getGeneratedKeys();
            if(rs.next())
            {
                lastInsertId = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            database.closeConnexion();   
        } 
        return lastInsertId;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public int update(Patient ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Patient> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Patient findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   
    
    
    
    
    
    
    
    
}
