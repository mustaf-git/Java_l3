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
    //
    private String role = "ROLE_PATIENT";
    private String code;
    private String nom;
    private String prenom;
    private String antecedantMedicaux;
    //

    public Patient() {
        this.role = "ROLE_PATIENT";
    }

    public Patient(String code, String nom, String prenom, String antecedantMedicaux, int id, String login, String password, String role) {
        super(id, login, password);
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.antecedantMedicaux = antecedantMedicaux;
        this.role = "ROLE_PATIENT";
    }

    public Patient(String code, String nom, String prenom, String antecedantMedicaux, String login, String password, String role) {
        super(login, password);
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.antecedantMedicaux = antecedantMedicaux;
        this.role = "ROLE_PATIENT";
    }
    
    //

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getAntecedantMedicaux() {
        return antecedantMedicaux;
    }

    public void setAntecedantMedicaux(String antecedantMedicaux) {
        this.antecedantMedicaux = antecedantMedicaux;
    }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }
 
    
    
}
