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
public class Prestation extends RendezVous{
    //
    private String libellePrestation;
    //

    public Prestation() {
    }

    public Prestation(String libellePrestation, int id, String date, String heure, String type, String etat, Patient patient) {
        super(id, date, heure, type, etat, patient);
        this.libellePrestation = libellePrestation;
    }

    public Prestation(String libellePrestation, String date, String heure, String type, String etat, Patient patient) {
        super(date, heure, type, etat, patient);
        this.libellePrestation = libellePrestation;
    }
    
    //

    public Prestation(String libellePrestation, int id, String date, String heure) {
        super(id, date, heure);
        this.libellePrestation = libellePrestation;
    }
    
    



    public String getLibellePrestation() {
        return libellePrestation;
    }

    public void setLibellePrestation(String libellePrestation) {
        this.libellePrestation = libellePrestation;
    }
    

    
}
