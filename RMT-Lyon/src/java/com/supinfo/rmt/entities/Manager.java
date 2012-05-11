package com.supinfo.rmt.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Francois
 */
@Entity
@DiscriminatorValue(value="manager")
public class Manager extends User{
    
}
