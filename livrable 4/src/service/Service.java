/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ConsultationDao;
import dao.PatientDao;
import dao.PrestationDao;
import dao.RendezVousDao;
import dao.UserDao;
import entities.Consultation;
import entities.Medecin;
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
    
    // dependances  
    
    UserDao userDao = new UserDao();
    PatientDao patientDao = new PatientDao();
    RendezVousDao rendezVousDao = new RendezVousDao();
    ConsultationDao consultationDao = new ConsultationDao();
    PrestationDao prestationDao = new PrestationDao();
    
    //
    
// fonctionnalité
    
    // Se connecter
    @Override
    public User login(String login, String password) {
        return userDao.findUserLoginAndPassword(login, password);
    }
    // tester l'unicité du login
    @Override
    public User loginExist(String login) {
        return userDao.findUserByLogin(login);
    }
    // créer compte patient : inscription patient
    @Override
    public int addPatient(Patient patient) {
        return patientDao.insert(patient);
    }
    // retrouver le patient grâce à son id
    public Patient searchPatientById(int id){
        return patientDao.selectById(id);
    }
    // créer un rendez Vous de type consultation
    public int addRvCons(Consultation rv) {
        return consultationDao.insert(rv);
    }
    // créer un rendez Vous de type prestation
    public int addRvPres(Prestation rv) {
        return prestationDao.insert(rv);
    }
    // afficher les rendez vous 
    @Override
    public List<RendezVous> searchAllRvById(int id) {
        return rendezVousDao.selectAllRvByIdPatient(id);
    }
    // afficher les consultations
    @Override
    public List<Consultation> searchAllConsultationById(int id) {
        return consultationDao.selectAllConsultationById(id);
    }
    // afficher les prestations
    @Override
    public List<Prestation> saerchAllPrestationById(int id) {
        return prestationDao.selectAllPrestationById(id);
    }
    // afficher tous les rendez vous => pour permettre a la secreataire de valider
        public List<RendezVous> searchAllRv() {
        return rendezVousDao.selectAllRv();
    }
    // annuler un rendez vous
    @Override
    public int removeRv(int id) {
        return rendezVousDao.delete(id);
    }
    //lister tous les medecins 
    public List<Medecin> searchAllMedecin(){
        return userDao.selectAllMedecin();
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    



    @Override
    public int validateRv(RendezVous rv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RendezVous> serachDossierMedicalByIdPatient(int idPatient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consultation> searchConsultationByDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showDetailsConsultation(Consultation consultation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int removeConsultation(Consultation consultation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Prestation> searchPrestationByDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showDetailsPrestation(Prestation prestation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int removePrestation(Consultation consultation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addRv(RendezVous rv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
