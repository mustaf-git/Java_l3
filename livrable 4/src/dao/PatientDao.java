/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Patient;
import entities.User;
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

    
    DataBase database = new DataBase();
    
    private final String SQL_INSERT = "INSERT INTO `user` (`login`, `password`,"
            + " `role`,  `code`, `nom`, `prenom`, `antecedants_medicaux`) "
            + " VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_SELECT_BY = "SELECT * FROM `user` WHERE `id` LIKE ?";
    
    
    @Override
    public int insert(Patient patient) {
        
        database.openConnexion();
        database.initPrepareStatement(SQL_INSERT);
        int idPatient=0;
        
        try {
            database.getPs().setString(1, patient.getLogin());
            database.getPs().setString(2, patient.getPassword());
            database.getPs().setString(3, patient.getRole());
            database.getPs().setString(4, patient.getCode());
            database.getPs().setString(5, patient.getNom());
            database.getPs().setString(6, patient.getPrenom());
            database.getPs().setString(7, patient.getAntecedantMedicaux());
            database.executeUpdate(SQL_INSERT);
            ResultSet rs = database.getPs().getGeneratedKeys();
            if(rs.next()){
                idPatient = rs.getInt(1);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            database.closeConnexion();
        }
        return idPatient;
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
    public List<Patient> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Patient selectById(int id) {
        
        Patient patient = null;
        database.openConnexion();
        database.initPrepareStatement(SQL_SELECT_BY);
        
        try {
            database.getPs().setInt(1, id);
            ResultSet rs = database.executeSelect(SQL_SELECT_BY);
            if(rs.next()){
            id = rs.getInt("id");
            String login = rs.getString("login");
            String password = rs.getString("password");
            String role = rs.getString("role");
            String code = rs.getString("code");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String antecedantsMedicaux = rs.getString("antecedants_medicaux");
            patient = new Patient(code, nom, prenom, antecedantsMedicaux, id, login, password, role);
            }

            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return patient; 
    }
    
}
