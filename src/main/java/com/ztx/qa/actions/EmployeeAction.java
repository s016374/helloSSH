package com.ztx.qa.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.ztx.qa.entites.Department;
import com.ztx.qa.entites.Employee;
import com.ztx.qa.services.DepartmentService;
import com.ztx.qa.services.EmployeeService;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * Created by s016374 on 15/8/4.
 */
@Controller
public class EmployeeAction extends ActionSupport implements RequestAware, ModelDriven<Employee>, Preparable{
    private static final long serialVersionUID = 1L;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    private List<Employee> employeeList;
    private Integer id;
    private List<Department> departmentList;
    private Map<String, Object> request;
    private Employee model;


    public String list() {
        employeeList = employeeService.getAll();
        return "list";
    }

    public String deleteById() {
        employeeService.deleteById(id);
        return SUCCESS;
    }

    public String input() {
        request.put("departments", departmentService.getAll());
        return INPUT;
    }

    public void prepareInput() {
        if(id != null){
            model = employeeService.get(id);
        }
    }

    public String save(){

       System.out.println(model.getLastName());

        employeeService.saveOrUpdate(model);

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

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }

    public Employee getModel() {
        if(id == null){
            model = new Employee();
        }
        return model;
    }

    public void prepare() throws Exception {

    }
}
