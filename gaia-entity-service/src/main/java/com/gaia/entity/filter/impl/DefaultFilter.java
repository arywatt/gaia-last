/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.entity.filter.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.gaia.entity.exception.BusinessException;
import com.gaia.entity.filter.AbstractFilter;

/**
 *
 * @author komilo
 */
public class DefaultFilter extends AbstractFilter {
    
    private Class type;

    public DefaultFilter(Class type) {
        this.type = type;
        this.sortAsc = true;
    }

    public DefaultFilter(Class type, String sortProperty, boolean sortAsc) {
        this.type = type;
        this.sortProperty = sortProperty;
        this.sortAsc = sortAsc;
    }

    /**
     * Implémentation de {@link IFilter#createQuery(EntityManager em)}.
     * @param em
     * @return La requête JPA
     * @throws {@link IllegalStateException} si l'attribut sortProperty vaut null.
     */
    @Override
    public Query createQuery(EntityManager em) {
        if (this.sortProperty == null) {
            throw new IllegalStateException("'sortProperty' est null!");
        }
        return em.createQuery("SELECT t FROM " + type.getSimpleName()
                + " t ORDER BY t." + this.sortProperty
                + ((this.sortAsc) ? " ASC" : " DESC"));
    }

    /**
     * Implémentation de {@link IFilter#createCountQuery(EntityManager em)}.
     * @param em
     * @return La requête JPA
     */
    @Override
    public Query createCountQuery(EntityManager em) {
        return em.createQuery("SELECT COUNT(t) FROM " + type.getSimpleName() + " t");
    }
}
