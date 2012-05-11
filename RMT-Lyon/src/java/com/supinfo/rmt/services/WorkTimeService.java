package com.supinfo.rmt.services;

import com.supinfo.rmt.entities.Employee;
import com.supinfo.rmt.entities.WorkTime;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Francois
 */
@Stateless
public class WorkTimeService {

    @PersistenceContext
    private EntityManager em;

    public void create(WorkTime workTime) {
        em.persist(workTime);
    }

    public List<WorkTime> getAllByEmployee(Employee employee) {
        return em.createQuery("SELECT w FROM WorkTime w WHERE w.employee = :employee")
                .setParameter("employee", employee)
                .getResultList();
    }
    
    public void delete(WorkTime workTime){
        em.remove(em.find(WorkTime.class, workTime.getId()));
    }
}
