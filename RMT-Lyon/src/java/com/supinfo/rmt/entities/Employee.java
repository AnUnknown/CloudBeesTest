package com.supinfo.rmt.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Francois
 */
@Entity
@DiscriminatorValue(value = "employee")
public class Employee extends User {

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Manager manager;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
