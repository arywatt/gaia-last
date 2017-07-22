/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.core.service;

import com.gaia.security.entities.UserDetails;

/**
 *
 * @author komilo
 */
public interface ICoreConfigService {
    
    String getPicturesDirectoryPath();
    
    String getPicturePath(UserDetails person);
}
