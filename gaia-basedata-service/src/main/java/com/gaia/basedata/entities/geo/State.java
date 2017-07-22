/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.basedata.entities.geo;

import com.gaia.basedata.entities.inter.Location;
import com.gaia.entity.entities.BaseEntity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author watt
 */
public class State extends BaseEntity{

     private static final long serialVersionUID = 1L;
    
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(unique = true,name = "name",length = 50,nullable = false)
    private String stateName;
    
//    
//    @Column(unique = true,name = "country",length = 50,nullable = true)
//    private Country country;
    
}
