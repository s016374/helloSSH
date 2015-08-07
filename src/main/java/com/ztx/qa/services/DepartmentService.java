package com.ztx.qa.services;

import com.ztx.qa.dao.DepartmentDao;
import com.ztx.qa.entites.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by s016374 on 15/8/6.
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public List<Department> getAll() {
        return departmentDao.getAll();
    }
}
