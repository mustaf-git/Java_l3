/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Medecin;
import entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */

public class UserDao implements IDao<User>{

    private final DataBase database= new DataBase();
    private final String  SQL_LOGIN = "SELECT * FROM user WHERE login =  ? AND password = ? ";
    private final String SQL_LOGIN_EXIST = "SELECT * FROM user WHERE login = ? " ;
    private final String SQL_SELECT_ALL_MEDECIN = "SELECT * FROM user WHERE role = ? " ;
    
        public User findUserLoginAndPassword(String login,String password){
        User user = null;
        database.openConnexion();
        database.initPrepareStatement(SQL_LOGIN);
        try {
            database.getPs().setString(1, login);
            database.getPs().setString(2, password);
            ResultSet rs = database.executeSelect(SQL_LOGIN);
            if(rs.next())
            {
                    user = new User(
                    rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("role") 
                    );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
        
    public User findUserByLogin(String login){
            User user = null;
            database.openConnexion();
            database.initPrepareStatement(SQL_LOGIN_EXIST);
        try {
            database.getPs().setString(1,login);
            ResultSet rs = database.executeSelect(SQL_LOGIN_EXIST);
            if(rs.next()){
                user = new User(rs.getString("login"),rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        return user;
        }
        
    public List<Medecin> selectAllMedecin(){
            List<Medecin> listMedecin = new ArrayList<>();
            Medecin medecin;
            database.openConnexion();
            database.initPrepareStatement(SQL_SELECT_ALL_MEDECIN);
        try {
            database.getPs().setString(1, "ROLE_MEDECIN");
            ResultSet rs = database.executeSelect(SQL_SELECT_ALL_MEDECIN);
            while(rs.next()){
                medecin = new Medecin(
                        rs.getString("statut"),
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("role"));
                listMedecin.add(medecin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMedecin;
    }
        
        
        
        
        
    @Override
    public int insert(User ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(User ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
