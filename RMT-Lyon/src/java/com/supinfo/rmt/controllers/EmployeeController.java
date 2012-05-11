package com.supinfo.rmt.controllers;

import com.supinfo.rmt.entities.Employee;
import com.supinfo.rmt.entities.Manager;
import com.supinfo.rmt.services.EmployeeService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Francois
 */
@ManagedBean
public class EmployeeController {

    private Employee employee;
    @EJB
    private EmployeeService employeeService;
    @ManagedProperty(value = "#{userController}")
    private UserController userController;
    private ListDataModel<Employee> model;

    public String create() {
        employee.setManager((Manager) userController.getUser());
        employeeService.create(employee);
        return "add_employee";
    }

    public ListDataModel<Employee> getModel() {
        if (model == null) {
            List<Employee> employees = employeeService.getAllByManager((Manager) userController.getUser());
            model = new ListDataModel<Employee>(employees);
        }
        return model;
    }

    public Employee getEmployee() {
        if (employee == null) {
            employee = new Employee();
        }
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }
}