/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Consultation;
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
    
    
    // C'est ici qu'on definissent la logique métier de notre application : les Use Case à programmer

    
    /*
    Si c'etait fonctionnalités par package on aurait pour RV par exemple : 
        // Demander RV ==> insert
        // Valider RV  ==> update
        // Lister RV   ==> select
        // Annuler RV  ==> delete
    L'idée c'est de passer par les package et réaliser les use case associès à chaque package
    Comme ça dans une package on traite tous les requettes et on fini avec toutes les fonctionnalités 
    relatives à ce package
    */
    // ========++++++====== Les fonctionnalités sont à livrer par acteur donc : =======++++++======
    
    // ============++++++============ pour chaque acteur nous avons  : ===========++++++==========
   
    public User login(String login, String password);                       // Se connecter => tous
    //                                                                      =======================================
    public int addPatient(Patient patient);                                 // Créer compte patient => patient
    public User loginExist(String login);                                   // s'assurer que le login soit unique
    public int addRv(RendezVous rv);                                        // Demander RV => patient,
    public List<RendezVous> searchAllRvById(int id);                           // Lister RV => medecin, patient
    public List<Prestation> saerchAllPrestationById(int id);                   // Lister prestation => prestataire, patient
    public List<Consultation> searchAllConsultationById(int id);               // Lister Consultation => medecin, patient
    public int removeRv(int id);                                     // Annuler RV => patient
    //                                                                      =======================================
    public int validateRv(RendezVous rv);                                   // Valider RV => secretaire *****
    //                                                                      =======================================
    public List<RendezVous> serachDossierMedicalByIdPatient(int idPatient); // chercher dossier medical => medecin  ******
    public List<Consultation> searchConsultationByDate();                   // Filtrer consultation par date => medecin     ******
    public void showDetailsConsultation(Consultation consultation);         // Voir détails consultation => medecin     ******
    public int removeConsultation(Consultation consultation);               // Annuler consultation => medecin
    //                                                                      =======================================
    public List<Prestation> searchPrestationByDate();                       // Filtrer prestation par date => prestataire   ******
    public void showDetailsPrestation(Prestation prestation);               // Voir détails prestation => prestataire   ******
    public int removePrestation(Consultation consultation);                 // Annuler prestation => prestataire

    
}
