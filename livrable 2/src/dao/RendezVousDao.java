/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.RendezVous;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class RendezVousDao implements IDao<RendezVous>{
    
    DataBase database = new DataBase();
    private final String  SQL_INSERT = "INSERT INTO `rendez_vous` "
            + " (`date`, `heure`, `type`) VALUES (?, ?, ?)";

    @Override
    public int insert(RendezVous rv) {
        int idRv = 0;
        database.openConnexion();
        database.initPrepareStatement(SQL_INSERT);
        try {
            database.getPs().setString(1, rv.getDate());
            database.getPs().setString(2, rv.getHeure());
            database.getPs().setString(3, rv.getType());
            database.executeUpdate(SQL_INSERT);
            ResultSet rs = database.getPs().getGeneratedKeys();
            if(rs.next()){
                idRv = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            database.closeConnexion();
        }
        return idRv;
    }

    @Override
    public int update(RendezVous ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RendezVous> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RendezVous findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
