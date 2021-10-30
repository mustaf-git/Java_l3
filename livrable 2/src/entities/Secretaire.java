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
public class Secretaire extends User{
    
    private final String ROLE = "ROLE_SECRETAIRE";

    public Secretaire() {
        this.role = ROLE;
    }

    public Secretaire(String login, String password) {
        super(login, password);
        this.role = ROLE;
    }

    public Secretaire(int id, String login, String password) {
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
