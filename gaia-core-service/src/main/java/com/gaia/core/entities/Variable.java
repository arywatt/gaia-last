/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.gaia.entity.entities.BaseEntity;

/**
 *
 * @author komilo
 */
@Entity
@Table(name="variables")
public class Variable extends BaseEntity {

    @Id
    @Column(name="var_name", length=256, nullable=false)
    private String name;

    @Column(name="var_value", length=256, nullable=false)
    private String varValue;
    
    @Column(name="default_var_value", length=256, nullable=false)
    private String defaultVarValue;

    public Variable() {
    }

    public Variable(String name, String varValue) {
        this.name = name;
        this.varValue = varValue;
    }

    public Variable(String name, String varValue, String defaultVarValue) {
        this.name = name;
        this.varValue = varValue;
        this.defaultVarValue = defaultVarValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return varValue;
    }

    public void setValue(String value) {
        this.varValue = value;
    }

    public String getDefaultVarValue() {
        return defaultVarValue;
    }

    public void setDefaultVarValue(String defaultVarValue) {
        this.defaultVarValue = defaultVarValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Variable other = (Variable) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Variable{" + "name=" + name + ", value=" + varValue + '}';
    }
}
