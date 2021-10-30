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
    
    private final String ROLE = "ROLE_RESPRESTATAIRE";

    public ResPres() {
        this.role = ROLE;
    }

    public ResPres(String login, String password) {
        super(login, password);
        this.role = ROLE;
    }

    public ResPres(int id, String login, String password) {
        super(id, login, password);
        this.role = ROLE;
    }

    public String getROLE() {
        return ROLE;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
}
