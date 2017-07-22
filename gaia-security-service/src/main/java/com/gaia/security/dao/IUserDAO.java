/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gaia.security.dao;

import com.gaia.entity.dao.IDAO;
import com.gaia.security.entities.User;

/**
 *
 * @author komilo
 */
public interface IUserDAO extends IDAO<User, Long> {

    User findByUsername(String username);

    void updatePassowrd(Long userId, String newPassword);
}
