/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.basedata.entities.geo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author watt
 */

@Entity
@Table(name="cities")
public class City {
    
     private static final long serialVersionUID = 1L;
    
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(unique = true,name = "name",length = 50,nullable = false)
    private String cityName;
    
//    
//    @Column(unique = true,name = "country",length = 50,nullable = true)
//    private Country country;
    
}
