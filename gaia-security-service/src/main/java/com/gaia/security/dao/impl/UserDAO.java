package com.gaia.security.dao.impl;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import com.gaia.entity.dao.impl.DAO;
import com.gaia.security.dao.IUserDAO;
import com.gaia.security.entities.Role;
import com.gaia.security.entities.User;

/**
 *
 * @author komilo
 */
@Repository("userDAO")
public class UserDAO extends DAO<User, Long> implements IUserDAO {
    
    public UserDAO() {
        super(User.class);
    }

    /**
     * Renvoie l'utilisateur correspondant au username passé en paramètre.
     *
     * @param username Le nom d'utilisateur.
     * @return l'objet User correspondant.
     */
    @Override
    public User findByUsername(String username) {
        try {
        String query = "SELECT u FROM User u WHERE u.enabled=:enabled AND u.username=:username";
        return (User) em.createQuery(query)
                .setParameter("enabled", Boolean.TRUE)
                .setParameter("username", username)
                .getSingleResult();
        } catch (EmptyResultDataAccessException ex) {
            return null;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public User saveOne(User t) {
        Set<Role> roles = new HashSet<Role>();
        for (Role role : t.getRoles()) {
            roles.add(this.em.merge(role));
        }
        t.setRoles(roles);
        return super.saveOne(t);
    }

    @Override
    public void updatePassowrd(Long userId, String newPassword) {
        Query query = this.em.createQuery("UPDATE User u SET u.password = :password "
                + "WHERE u.id = :userId");
        query.setParameter("password", newPassword);
        query.setParameter("userId", userId);
        query.executeUpdate();
    }
}
