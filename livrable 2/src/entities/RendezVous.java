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
public class RendezVous {
    
    protected int id;
    protected String date;
    protected String heure;
    protected String type;

    public RendezVous(String date, String heure, String type) {
       
        this.date = date;
        this.heure = heure;
        this.type = type;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
    protected String etat;
    protected Secretaire secretaire;

    public RendezVous() {
    }

    public RendezVous(String date, String type, String etat, Secretaire secretaire) {
        this.date = date;
        this.type = type;
        this.etat = etat;
        this.secretaire = secretaire;
    }

    public RendezVous(int id, String date, String type, String etat, Secretaire secretaire) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.etat = etat;
        this.secretaire = secretaire;
    }

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

    public Secretaire getSecretaire() {
        return secretaire;
    }

    public void setSecretaire(Secretaire secretaire) {
        this.secretaire = secretaire;
    }

    public String ToString(){
        return "Rendez-Vous{" + "date=" + date + ", type=" + type + ", etat=" + etat +"}";
    }
    
    
    
}
