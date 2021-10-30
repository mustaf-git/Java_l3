/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Consultation extends RendezVous{
 
    private String temperature;
    private String tension;
    private String prestAFaire;
    private Medecin medecin;
    private Patient patient;
    private Ordonnance Ordonnance;

    public Consultation() {
    }

    public Consultation(String temperature, String tension, String prestAFaire, Medecin medecin, Patient patient, Ordonnance Ordonnance, String date, String type, String etat, Secretaire secretaire) {
        super(date, type, etat, secretaire);
        this.temperature = temperature;
        this.tension = tension;
        this.prestAFaire = prestAFaire;
        this.medecin = medecin;
        this.patient = patient;
        this.Ordonnance = Ordonnance;
    }

    public Consultation(String temperature, String tension, String prestAFaire, Medecin medecin, Patient patient, Ordonnance Ordonnance, int id, String date, String type, String etat, Secretaire secretaire) {
        super(id, date, type, etat, secretaire);
        this.temperature = temperature;
        this.tension = tension;
        this.prestAFaire = prestAFaire;
        this.medecin = medecin;
        this.patient = patient;
        this.Ordonnance = Ordonnance;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTension() {
        return tension;
    }

    public void setTension(String tension) {
        this.tension = tension;
    }

    public String getPrestAFaire() {
        return prestAFaire;
    }

    public void setPrestAFaire(String prestAFaire) {
        this.prestAFaire = prestAFaire;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Ordonnance getOrdonnance() {
        return Ordonnance;
    }

    public void setOrdonnance(Ordonnance Ordonnance) {
        this.Ordonnance = Ordonnance;
    }
    
        @Override
    public String toString() {
        return "Consultation{" + "date=" + date + ", type=" + type + ", medecin=" + medecin.login +"}";
    }
    
    
}
