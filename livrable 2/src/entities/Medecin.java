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
public class Medecin extends User{
    
    private String statut;
    private final String ROLE = "ROLE_MEDECIN";

    public Medecin() {
        this.role = ROLE;
    }

    public Medecin(String statut, String login, String password) {
        super(login, password);
        this.role = ROLE;
        this.statut = statut;
    }

    public Medecin(String statut, int id, String login, String password) {
        super(id, login, password);
        this.role = ROLE;
        this.statut = statut;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getROLE() {
        return ROLE;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
}
