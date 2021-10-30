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
public class User {
    
    protected int id;
    protected String login;
    protected String password;
    protected String role;

    public User() {
    }
    
    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;  
    }

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
         
    }
    
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login) {
        this.login = login;
    } 

    public User(int id, String login, String password, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }


    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "login=" + login + ", role=" + role + '}';
    }
    
}
