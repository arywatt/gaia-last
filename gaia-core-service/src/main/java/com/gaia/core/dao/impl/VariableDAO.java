/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.dao.impl;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.gaia.core.dao.IVariableDAO;
import com.gaia.core.entities.Variable;
import com.gaia.entity.dao.impl.DAO;

/**
 *
 * @author komilo
 */
@Repository("variableDAO")
public class VariableDAO extends DAO<Variable, String> implements IVariableDAO {

    public VariableDAO() {
        super(Variable.class);
    }

    public String getValue(String name) {
        String value = "";
        try {
            Query q = em.createQuery("SELECT v.varValue FROM Variable v "
                    + "WHERE v.name = :name");
            q.setParameter("name", name);
            value = (String) q.getSingleResult();
        } catch (Exception ex) {
        }
        return value;
    }
}
