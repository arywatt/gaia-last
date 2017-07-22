/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.entity.dao;

import com.gaia.entity.filter.IFilter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 *
 * @author komilo
 */
public interface IDAO<T, PK extends Serializable> {

  T getOne(final PK id);

  Long count();

  Long count(IFilter filter);

  List<T> getAll();

  List<T> getAll(String sortProperty, boolean sortAsc);

  List<T> getAll(int first, int count, String sortProperty, boolean sortAsc);
  
  List<T> getAll(IFilter filter);
  
  List<T> getAll(IFilter filter, int first, int count);

  T saveOne(final T t);

  T updateOne(final T t);

  boolean deleteOne(final PK id);

  boolean deleteOne(final T t);

  void deleteAll();
  
  List<T> executeQuery(Query query);
  
  int executeUpdate(Query query);
  
//  EntityManager getEntityManager();
}
