/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.entity.service.impl;

import com.gaia.entity.dao.IDAO;
import com.gaia.entity.filter.IFilter;
import com.gaia.entity.service.ICRUDService;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author komilo
 */
@Transactional
public abstract class CRUDService<T, PK extends Serializable> implements ICRUDService<T, PK> {

    protected IDAO<T, PK> dao;

    public CRUDService(IDAO<T, PK> dao) {
        this.dao = dao;
    }

    @Override
    public synchronized T getOne(PK id) {
        return this.dao.getOne(id);
    }

    @Override
    public synchronized Long count() {
        return this.dao.count();
    }

    @Override
    public synchronized Long count(IFilter filter) {
        return this.dao.count(filter);
    }

    @Override
    public synchronized List<T> getAll() {
        return this.dao.getAll();
    }

    @Override
    public synchronized List<T> getAll(String sortProperty) {
        return this.dao.getAll(sortProperty, true);
    }

    @Override
    public synchronized List<T> getAll(String sortProperty, boolean sortAsc) {
        return this.dao.getAll(sortProperty, sortAsc);
    }

    @Override
    public synchronized List<T> getAll(int first, int count, String sortProperty, boolean sortAsc) {
        return this.dao.getAll(first, count, sortProperty, sortAsc);
    }
    
    @Override
    public List<T> getAll(IFilter filter) {
        return this.dao.getAll(filter);
    }
    
    @Override
    public List<T> getAll(IFilter filter, int first, int count) {
        return this.dao.getAll(filter, first, count);
    }

    @Override
    public synchronized T saveOne(T t) {
        return this.dao.saveOne(t);
    }

    @Override
    public synchronized T updateOne(T t) {
        return this.dao.updateOne(t);
    }

    @Override
    public synchronized void deleteOne(PK id) {
        this.dao.deleteOne(id);
    }

    @Override
    public synchronized void deleteOne(T t) {
        this.dao.deleteOne(t);
    }

    @Override
    public synchronized void deleteRange(PK[] pks) {
        for (int i = 0; i < pks.length; i++) {
            this.dao.deleteOne(pks[i]);
        }
    }

    @Override
    public synchronized void deleteRange(Collection<T> ts) {
        this.deleteRange(ts.iterator());
    }

    @Override
    public synchronized void deleteRange(Iterator<T> ts) {
        while (ts.hasNext()) {
            this.dao.deleteOne(ts.next());
        }
    }

    @Override
    public synchronized Collection<T> saveRange(Collection<T> ts) {
        return this.saveRange(ts.iterator());
    }

    @Override
    public synchronized Collection<T> saveRange(Iterator<T> ts) {
        Collection<T> ts2 = new LinkedList<T>();
        while (ts.hasNext()) {
            ts2.add(this.dao.saveOne(ts.next()));
        }
        return ts2;
    }

    @Override
    public synchronized Collection<T> updateRange(Collection<T> ts) {
        return this.updateRange(ts.iterator());
    }

    @Override
    public synchronized Collection<T> updateRange(Iterator<T> ts) {
        Collection<T> ts2 = new LinkedList<T>();
        while (ts.hasNext()) {
            ts2.add(this.dao.updateOne(ts.next()));
        }
        return ts2;
    }

    @Override
    public synchronized void deleteAll() {
        this.dao.deleteAll();
    }

    @Override
    public boolean exist(PK pk) {
        return this.dao.getOne(pk) != null;
    }
}
