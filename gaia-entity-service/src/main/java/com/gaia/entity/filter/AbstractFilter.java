/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.entity.filter;

/**
 *
 * @author komilo
 */
public abstract class AbstractFilter implements IFilter {
    
    protected String sortProperty;
    
    protected boolean sortAsc;

    @Override
    public void setSortAsc(boolean sortAsc) {
        this.sortAsc = sortAsc;
    }

    @Override
    public void setSortProperty(String sortProperty) {
        this.sortProperty = sortProperty;
    }
}
