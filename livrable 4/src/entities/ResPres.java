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
public class ResPres extends User{
    
    String role = "ROLE_PRESTATAIRE";
    //
    
    
    public ResPres() {
        this.role = "ROLE_PRESTATAIRE";
    }

    public ResPres(int id, String login, String password) {
        super(id, login, password);
        this.role = "ROLE_PRESTATAIRE";
    }

    public ResPres(String login, String password) {
        super(login, password);
        this.role = "ROLE_PRESTATAIRE";
    }
}
