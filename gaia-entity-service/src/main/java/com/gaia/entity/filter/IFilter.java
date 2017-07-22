/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.entity.filter;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author komilo
 */
public interface IFilter extends Serializable {
    
    Query createQuery(EntityManager em);
    
    Query createCountQuery(EntityManager em);
    
    void setSortProperty(String sortProperty);
    
    void setSortAsc(boolean sortAsc);
}
