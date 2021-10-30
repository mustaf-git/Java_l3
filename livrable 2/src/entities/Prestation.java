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
public class Prestation extends RendezVous{
    
    private String libelle;

    public Prestation() {
    }

    public Prestation(String libelle, String date, String type, String etat, Secretaire secretaire) {
        super(date, type, etat, secretaire);
        this.libelle = libelle;
    }

    public Prestation(String libelle, int id, String date, String type, String etat, Secretaire secretaire) {
        super(id, date, type, etat, secretaire);
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Prestation{" + "date=" + date + ", type=" + type + ", libelle=" + libelle +"}";
    }
    
    
    
    
    
}
