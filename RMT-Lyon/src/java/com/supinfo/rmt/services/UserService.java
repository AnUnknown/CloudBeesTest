package com.supinfo.rmt.services;

import com.supinfo.rmt.entities.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Francois
 */
@Stateless
public class UserService {
    
    @PersistenceContext
    private EntityManager em;
    
    public User authenticate(String username, String password){
        Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (User) query.getSingleResult();
    }
    
}
