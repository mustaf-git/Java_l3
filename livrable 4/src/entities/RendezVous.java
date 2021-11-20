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
public class RendezVous {
    //
    private int id;
    private String date;
    private String heure;
    private String type;
    private String etat;
    private Patient patient;
    
    //

    public RendezVous() {
    }

    public RendezVous(int id, String date, String heure, String type, String etat, Patient patient) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.type = type;
        this.etat = etat;
        this.patient = patient;
    }

    public RendezVous(String date, String heure, String type, String etat, Patient patient) {
        this.date = date;
        this.heure = heure;
        this.type = type;
        this.etat = etat;
        this.patient = patient;
    }
// * constructeur pour afficher un rv : ==> ça devait être un dto
    public RendezVous(String date, String heure, String type, String etat) {
        this.date = date;
        this.heure = heure;
        this.type = type;
        this.etat = etat;
    }

    public RendezVous(int id, String date, String heure) {
    this.id = id;
    this.date = date;
    this.heure = heure;
    }
    
    
    //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
        public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return  type;
    }
    
    
    
}
