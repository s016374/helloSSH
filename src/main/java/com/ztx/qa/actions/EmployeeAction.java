package com.ztx.qa.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.ztx.qa.entites.Employee;
import com.ztx.qa.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by s016374 on 15/8/4.
 */
@Controller
public class EmployeeAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Autowired
    private EmployeeService employeeService;
    private List<Employee> employeeList;
    private Integer id;

    public String list() {
        employeeList = employeeService.getAll();
        return "list";
    }

    public String deleteById() {
        employeeService.deleteById(id);
        return SUCCESS;
    }


    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
