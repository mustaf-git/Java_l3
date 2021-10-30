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
public class Medicament {
    
    private int id;
    private String code;
    private String nom;
    private String posologie;
    private Ordonnance ordonnance;

    public Medicament() {
    }

    public Medicament(String code, String nom, String posologie, Ordonnance ordonnance) {
        this.code = code;
        this.nom = nom;
        this.posologie = posologie;
        this.ordonnance = ordonnance;
    }

    public Medicament(int id, String code, String nom, String posologie, Ordonnance ordonnance) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.posologie = posologie;
        this.ordonnance = ordonnance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPosologie() {
        return posologie;
    }

    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }

    public Ordonnance getOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }
    
        @Override
    public String toString() {
        return "Prestation{" + "nom=" + nom + ", posologie=" + posologie  +"}";
    }
    
    
}
