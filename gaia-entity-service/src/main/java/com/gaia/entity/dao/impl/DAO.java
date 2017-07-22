/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.entity.dao.impl;

import com.gaia.entity.dao.IDAO;
import com.gaia.entity.filter.IFilter;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author komilo
 */
public abstract class DAO<T extends Object, PK extends Serializable> implements IDAO<T, PK> {

    @PersistenceContext(unitName = "gaiaPU")
    protected EntityManager em;
    protected Class<T> type;
    
    public DAO() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
	this.type = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    public DAO(Class<T> type) {
        this.type = type;
    }

    @Override
    public T getOne(final PK id) {
        return (T) em.find(type, id);
    }

    @Override
    public Long count() {
        return (Long) em.createQuery("SELECT COUNT(t) FROM " + type.getSimpleName() + " t").getSingleResult();
    }

    @Override
    public Long count(IFilter filter) {
        return (Long) filter.createCountQuery(em).getSingleResult();
    }

    @Override
    public List<T> getAll() {
        return (List<T>) em.createQuery("SELECT t FROM " + type.getSimpleName() + " t").getResultList();
    }

    @Override
    public List<T> getAll(String sortProperty, boolean sortAsc) {
        return (List<T>) em.createQuery("SELECT t FROM " + type.getSimpleName()
                + " t ORDER BY t." + sortProperty
                + ((sortAsc) ? " ASC" : " DESC")).getResultList();
    }

    @Override
    public List<T> getAll(int first, int count, String sortProperty, boolean sortAsc) {
        return (List<T>) em.createQuery("SELECT t FROM " + type.getSimpleName()
                + " t ORDER BY t." + sortProperty
                + ((sortAsc) ? " ASC" : " DESC")).setFirstResult(first).setMaxResults(count).getResultList();
    }
    
    @Override
    public List<T> getAll(IFilter filter) {
        return (List<T>) filter.createQuery(em).getResultList();
    }
    
    @Override
    public List<T> getAll(IFilter filter, int first, int count) {
        return (List<T>) filter.createQuery(em)
                .setFirstResult(first)
                .setMaxResults(count)
                .getResultList();
    }

    @Override
    public T saveOne(final T t) {
        em.persist(t);
        return t;
    }

    @Override
    public T updateOne(final T t) {
        return (T) em.merge(t);
    }

    @Override
    public boolean deleteOne(final PK id) {
        T t = em.find(type, id);
        if (t == null) {
            return false;
        }
        em.remove(t);
        return true;
    }

    @Override
    public boolean deleteOne(final T t) {
        em.remove(t);
        return true;
    }

    @Override
    public void deleteAll() {
        em.createQuery("DELETE FROM " + type.getSimpleName()).executeUpdate();
    }

    @Override
    public List<T> executeQuery(Query query) {
        return (List<T>) query.getResultList();
    }

    @Override
    public int executeUpdate(Query query) {
        return query.executeUpdate();
    }

//    @Override
//    public EntityManager getEntityManager() {
//        return this.em;
//    }
}
