/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gaia.entity.service.impl.CRUDService;
import com.gaia.security.dao.IUserDetailsDAO;
import com.gaia.security.entities.UserDetails;
import com.gaia.security.service.IUserDetailsService;

/**
 *
 * @author komilo
 */
@Service("userDetailsService")
public class UserDetailsService extends CRUDService<UserDetails, Long> implements IUserDetailsService {

    @Autowired(required=true)
    public UserDetailsService(IUserDetailsDAO dao) {
        super(dao);
    }
}
