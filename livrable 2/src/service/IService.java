/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
public interface IService {
    
    /**
     * Gérer patient
     */
    
    public int addPatient(Patient patient);
    
    
    /**
     * Gérer rv
     */
    
    //Medecin ou patient
    public int addRv(RendezVous rv);
    // medecin
    public List<RendezVous> showRvByMedecin();
    //patient
    public List<RendezVous> showRvByPatient();
    //secretaire
    public void validerRv(RendezVous rv);
    public void removeRv(RendezVous rv);
    
    /**
     * Gérer consultation
     */
    
    //Medecin
    public List<Consultation> showConsultationByMedecin();
    public List<Consultation> showConsultationByDate();
    public Consultation showConsultationById(int id);
    public String showDetailsConsultation(Consultation consultation);
    public void removeConsultation(Consultation consultation);
    public DossierMedical showDossierMedicalByPatient(int id);
    //patient 
    public List<Consultation> showConsultationByPatient();
    
    
    /**
     * Gérer prestation
     */
    
    // rp
    public List<Prestation> showAllPrestation();
    public List<Prestation> showPrestationByDate();
    public List<Prestation> showPrestationById();
    public void showDetailsPrestation(Prestation prestation);
    public void removePrestation(Prestation prestation);
    // patient 
    public List<Prestation> showPrestationByPatient();
    
    /*Se connecter */
    public User login(String login,String password);
    
    

    
    
    
    
    
    
    
    
}
