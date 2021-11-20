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
    
// chaque dao doit avoir la possibilités de 
// inserer, modifier, supprimer, ou selectionner des données => (insert, update, delete, selectAll, selectById)
    
// Fonction MAJ : return int 
public int insert(T ogj);       //  insert => dernier id inseré
public int update(T ogj);       //  update => nbre de ligne modifié
public int delete(int id);      //  delete => nbre de ligne supprimé


// Fonction Interrogation : return list(All) ou un objet(ById)
public List<T> selectAll();       // selectAll => list
public T selectById(int id);      // selectById => un objet

}
