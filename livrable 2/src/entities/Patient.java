/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author DELL
 */
public class Patient extends User{
    
    
    
    private final String  ROLE = "ROLE_PATIENT";
    private String code;
    private String nom;
    private String prenom;
    private String antecedentsMedicaux;
    //private DossierMedical dossierMedical;
    

    public Patient() {
        this.role = ROLE;
    }
    
    // inséerer patient

    public Patient(String code, String nom, String prenom, String antecedentsMedicaux, String login, String password, String role) {
        super(login, password);
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.role = ROLE;
        this.antecedentsMedicaux = antecedentsMedicaux;
        //this.dossierMedical = dossierMedical;
        
    }
    
    //update patient

    public Patient(String code, String nom, String prenom, String antecedentsMedicaux, int id, String login, String password) {
        super(id, login, password);
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.role = ROLE;
        this.antecedentsMedicaux = antecedentsMedicaux;
        //this.dossierMedical = dossierMedical;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAntecedentsMedicaux() {
        return antecedentsMedicaux;
    }

    public void setAntecedentsMedicaux(String antecedentsMedicaux) {
        this.antecedentsMedicaux = antecedentsMedicaux;
    }

    /**
     * 
         public DossierMedical getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(DossierMedical dossierMedical) {
        this.dossierMedical = dossierMedical;
    }
     */


    public String getROLE() {
        return ROLE;
    }

    
    @Override
    public String toString() {
        return nom;
    }
    
    
    
    
    
    
    
}
