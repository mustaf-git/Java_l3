/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class UserDao implements IDao{
    private final DataBase database= new DataBase();
    private final String  SQL_LOGIN = "SELECT * FROM user WHERE login =  ? AND password = ? ";
    private final String SQL_LOGIN_EXIST = "SELECT * FROM user WHERE login = ? ";
    
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
                user = new User(rs.getString("login"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
        }
    @Override
    public int insert(Object ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Object ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}