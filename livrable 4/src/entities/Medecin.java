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
    //
    private String role = "ROLE_MEDECIN";
    private String statut;
    //

    public Medecin() {
        this.role = "ROLE_MEDECIN";
    }

    
    public Medecin(String statut, int id, String login, String password, String role) {
        super(id, login, password);
        this.statut = statut;
        this.role = "ROLE_MEDECIN";
    }

    public Medecin(String statut, String login, String password, String role) {
        super(login, password);
        this.statut = statut;
        this.role = "ROLE_MEDECIN";
    }
    
    //

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    
    
    
    
    
}
