package com.ztx.qa.dao;

import com.ztx.qa.entites.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by s016374 on 15/8/4.
 */
@Repository
public class EmployeeDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> getAll() {
        String jpql = "select e from Employee e left outer join fetch e.department";
        Query query = entityManager.createQuery(jpql);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    public void deleteById(Integer id) {
        String jpql = "delete from Employee e where e.id = ?";
//        getEntityManager().createQuery(jpql).setParameter(1, id).executeUpdate();
//        entityManager.createQuery(jpql).setParameter(1, id).executeUpdate();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
