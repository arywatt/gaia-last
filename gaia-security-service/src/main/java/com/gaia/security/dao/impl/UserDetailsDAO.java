/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.security.dao.impl;

import org.springframework.stereotype.Repository;
import com.gaia.entity.dao.impl.DAO;
import com.gaia.security.dao.IUserDetailsDAO;
import com.gaia.security.entities.UserDetails;

/**
 *
 * @author komilo
 */
@Repository("userDetailsDAO")
public class UserDetailsDAO extends DAO<UserDetails, Long> implements IUserDetailsDAO {

    public UserDetailsDAO() {
        super(UserDetails.class);
    }
}
