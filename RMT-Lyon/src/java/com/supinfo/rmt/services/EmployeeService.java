package com.supinfo.rmt.services;

import com.supinfo.rmt.entities.Employee;
import com.supinfo.rmt.entities.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Francois
 */
@Stateless
public class EmployeeService {

    @PersistenceContext
    private EntityManager em;

    public void create(Employee employee) {
        em.persist(employee);
    }

    public List<Employee> getAllByManager(Manager manager) {
        return em.createQuery("SELECT e FROM Employee e WHERE e.manager = :manager")
                 .setParameter("manager", manager)
                 .getResultList();
    }
}
