/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.PatientDao;
import dao.RendezVousDao;
import dao.UserDao;
import entities.Consultation;
import entities.DossierMedical;
import entities.Patient;
import entities.Prestation;
import entities.RendezVous;
import entities.User;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Service implements IService{
    
    
    
    UserDao userDao = new UserDao();
    PatientDao patientDao = new PatientDao();
    RendezVousDao randezVousDao = new RendezVousDao();
    
    
    
    
    // Se connecter
    @Override
    public User login(String login, String password) {
        return userDao.findUserLoginAndPassword(login, password);
    }
    // verifier si le login existe
    public User loginExist(String login){
        return userDao.findUserByLogin(login);
    }
    // inscrire le patient
    @Override
    public int addPatient(Patient patient) {
        //int id = patientDao.insert(patient);
        //patient.setId(id);
        //return patient.getId();
        return patientDao.insert(patient);
    }
    // faire une demande de rv
    @Override
    public int addRv(RendezVous rv) {
        return randezVousDao.insert(rv);
    }

    
    
    
    
    
    
    
    @Override
    public List<RendezVous> showRvByMedecin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RendezVous> showRvByPatient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validerRv(RendezVous rv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeRv(RendezVous rv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consultation> showConsultationByMedecin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consultation> showConsultationByDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consultation showConsultationById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String showDetailsConsultation(Consultation consultation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeConsultation(Consultation consultation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DossierMedical showDossierMedicalByPatient(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consultation> showConsultationByPatient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Prestation> showAllPrestation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Prestation> showPrestationByDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Prestation> showPrestationById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showDetailsPrestation(Prestation prestation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePrestation(Prestation prestation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Prestation> showPrestationByPatient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
}
