/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.basedata.entities.inter;

import java.io.Serializable;

/**
 *
 * @author watt
 */
public interface Location extends Serializable{
    
    public String getLocationName();   
    
    public String getLocationType();
    
    public boolean isPointLocation();
    
    public Location getParentLocation();
    
    
    
    
}
