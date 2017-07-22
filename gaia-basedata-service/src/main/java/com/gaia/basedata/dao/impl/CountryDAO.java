/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.basedata.dao.impl;

import com.gaia.basedata.dao.ICountryDAO;
import com.gaia.basedata.entities.geo.Country;
import com.gaia.entity.dao.impl.DAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author watt
 */
@Repository("CountryDAO")
public class CountryDAO extends DAO<Country,Integer> implements ICountryDAO{

    public CountryDAO() {
        super(Country.class);
    }

    
    
}
