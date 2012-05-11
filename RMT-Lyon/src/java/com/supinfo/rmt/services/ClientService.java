package com.supinfo.rmt.services;

import com.supinfo.rmt.entities.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Francois
 */
@Stateless
public class ClientService {

    @PersistenceContext
    private EntityManager em;

    public void create(Client client) {
        em.persist(client);
    }

    public Client getById(Long id) {
        return em.find(Client.class, id);
    }
    
    public List<Client> getAll(){
        return em.createQuery("SELECT c FROM Client c").getResultList();
    }
    
}
