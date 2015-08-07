package com.ztx.qa.services;

//import com.ztx.qa.dao.EmployeeDao;

import com.ztx.qa.dao.EmployeeDao;
import com.ztx.qa.entites.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by s016374 on 15/8/4.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Transactional
    public void deleteById(Integer id) {
        employeeDao.deleteById(id);
    }

    @Transactional
    public void saveOrUpdate(Employee employee) {
        employeeDao.saveOrUpdate(employee);
    }

    @Transactional
    public Employee get(Integer id) {
        return employeeDao.get(id);
    }
}
