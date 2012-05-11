package com.supinfo.rmt.controllers;

import com.supinfo.rmt.entities.Employee;
import com.supinfo.rmt.entities.WorkTime;
import com.supinfo.rmt.services.WorkTimeService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Francois
 */
@ManagedBean
public class WorkTimeController {
    
    @EJB
    private WorkTimeService workTimeService;
    private WorkTime worktime;
    @ManagedProperty(value = "#{userController}")
    private UserController userController;
    private ListDataModel<WorkTime> workTimeModel;
    
    public ListDataModel<WorkTime> getWorkTimeModel() {
        if (workTimeModel == null) {
            workTimeModel = new ListDataModel<WorkTime>(workTimeService.getAllByEmployee((Employee) userController.getUser()));
        }
        return workTimeModel;
    }
    
    public void setWorkTimeModel(ListDataModel<WorkTime> workTimeModel) {
        this.workTimeModel = workTimeModel;
    }
    
    public String create() {
        worktime.setEmployee((Employee) userController.getUser());
        workTimeService.create(worktime);
        return "";
    }
    
    public String delete(){
        workTimeService.delete(workTimeModel.getRowData());
        return "employee_home?faces-redirect=true";
    }
    
    public WorkTime getWorktime() {
        if (worktime == null) {
            worktime = new WorkTime();
        }
        return worktime;
    }
    
    public void setWorktime(WorkTime worktime) {
        this.worktime = worktime;
    }
    
    public UserController getUserController() {
        return userController;
    }
    
    public void setUserController(UserController userController) {
        this.userController = userController;
    }
}
