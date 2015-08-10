package com.ztx.qa.entites;

import javax.persistence.*;

/**
 * Created by s016374 on 15/8/3.
 */
@Entity
public class Department {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String departmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
