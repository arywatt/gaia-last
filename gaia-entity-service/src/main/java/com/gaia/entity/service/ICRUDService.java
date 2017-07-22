/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.entity.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import com.gaia.entity.filter.IFilter;

/**
 *
 * @author komilo
 */
public interface ICRUDService<T, PK extends Serializable> {

  T getOne(PK id);

  Long count();

  Long count(IFilter filter);

  List<T> getAll();

  List<T> getAll(String sortProperty);

  List<T> getAll(String sortProperty, boolean sortAsc);

  List<T> getAll(int first, int count, String sortProperty, boolean sortAsc);
  
  List<T> getAll(IFilter filter);
  
  List<T> getAll(IFilter filter, int first, int count);

  T saveOne(final T t);

  T updateOne(final T t);

  void deleteOne(PK id);

  void deleteOne(final T t);

  void deleteRange(PK[] pks);

  void deleteRange(Collection<T> ts);
  
  void deleteRange(Iterator<T> ts);

  Collection<T> saveRange(Collection<T> ts);

  Collection<T> saveRange(Iterator<T> ts);

  Collection<T> updateRange(Collection<T> ts);

  Collection<T> updateRange(Iterator<T> ts);

  void deleteAll();

  boolean exist(final PK pk);
}
