/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.basedata.service.impl;

import com.gaia.basedata.dao.ICountryDAO;
import com.gaia.basedata.entities.geo.Country;
import com.gaia.basedata.service.ICountryService;
import com.gaia.entity.service.impl.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author watt
 */
@Repository("countryService")
public class CountryService extends CRUDService<Country,Integer> implements ICountryService{
    
    @Autowired(required=true)
    public CountryService(ICountryDAO dao) {
        super(dao);
    }
}
    

    
