package com.ztx.qa.dao;

import com.ztx.qa.entites.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by s016374 on 15/8/6.
 */
@Repository
public class DepartmentDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Department> getAll() {
        String jpql = "select d.departmentName from Department d";
        return entityManager.createQuery(jpql).getResultList();
    }
}
