package com.supinfo.rmt.controllers;

import com.supinfo.rmt.entities.Employee;
import com.supinfo.rmt.entities.Manager;
import com.supinfo.rmt.entities.User;
import com.supinfo.rmt.services.UserService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Francois
 */
@ManagedBean
@SessionScoped
public class UserController {

    @EJB
    private UserService userService;
    private String username;
    private String password;
    private User user;

    public String authenticate() {
        user = userService.authenticate(username, password);
        if (user instanceof Employee) {
            return "employee_home";
        } else if (user instanceof Manager) {
            return "manager_home";
        }
        return "login";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
