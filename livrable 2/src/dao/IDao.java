/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author DELL
 */
public interface IDao<T> {
    
/*
    Fonction MAJ
    return int
        insert=>dernier  inserer
        update=>nbre de ligne modifier

*/
public int insert(T ogj);
public int update(T ogj);
public int delete(int id);


/*
    Fonction Interrogation
        return List findAll()
        return un objet findById()
*/
public List<T> findAll();
public T findById(int id);


}
