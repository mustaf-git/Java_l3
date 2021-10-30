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
public class DossierMedical {
    
    private int id;
    private Consultation consultation;
    private Prestation prestation;

    public DossierMedical() {
    }

    public DossierMedical(Consultation consultation, Prestation prestation) {
        this.consultation = consultation;
        this.prestation = prestation;
    }

    public DossierMedical(int id, Consultation consultation, Prestation prestation) {
        this.id = id;
        this.consultation = consultation;
        this.prestation = prestation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Prestation getPrestation() {
        return prestation;
    }

    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
    }
    
        @Override
    public String toString() {
        return "Dossier Medical{" + "consultation=" + consultation + ", prestation=" + prestation +"}";
    }
}
