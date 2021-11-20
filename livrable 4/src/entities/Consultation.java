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
public class Consultation extends RendezVous{
    //
    private Medecin medecin;
    private String constante; 
    private Prestation prestation;
    private Ordonnance ordonnance;
    //

    public Consultation() {
    }

    public Consultation(String date, String heure, String type, String etat, Patient patient) {
        super(date, heure, type, etat, patient);
    }
    

    public Consultation(Medecin medecin, String constante, Prestation prestation, Ordonnance ordonnance, int id, String date, String heure, String type, String etat, Patient patient) {
        super(id, date, heure, type, etat, patient);
        this.medecin = medecin;
        this.constante = constante;
        this.prestation = prestation;
        this.ordonnance = ordonnance;
    }

    public Consultation(Medecin medecin, String constante, Prestation prestation, Ordonnance ordonnance, String date, String heure, String type, String etat, Patient patient) {
        super(date, heure, type, etat, patient);
        this.medecin = medecin;
        this.constante = constante;
        this.prestation = prestation;
        this.ordonnance = ordonnance;
    }

    public Consultation(int id, String date, String heure) {
        super(id, date, heure);
    }



    
 
    
    //

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public String getConstante() {
        return constante;
    }

    public void setConstante(String constante) {
        this.constante = constante;
    }

    public Prestation getPrestation() {
        return prestation;
    }

    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
    }

    public Ordonnance getOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }
    
    
    
    
}
