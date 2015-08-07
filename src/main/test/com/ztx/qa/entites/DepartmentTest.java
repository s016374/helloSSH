package com.ztx.qa.entites;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.*;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by s016374 on 15/8/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DepartmentTest {
    private ApplicationContext applicationContext;
    private EntityManagerFactory entityManagerFactory;
//    @PersistenceContext
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    @org.junit.Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        entityManagerFactory = (EntityManagerFactory) applicationContext.getBean("entityManagerFactory");
        entityManager=entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void test() throws SQLException {
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
        System.out.println(entityManager);
    }

    @Test
    @org.springframework.transaction.annotation.Transactional
    public void addInitDataTest() {
        Department department = new Department();
        department.setDepartmentName("BA");
        entityManager.persist(department);
        Department department1 = new Department();
        department1.setDepartmentName("DEV");
        entityManager.persist(department1);
        Department department2 = new Department();
        department2.setDepartmentName("QA");
        entityManager.persist(department2);

        Employee employee = new Employee();
        employee.setBirth(new Date());
        employee.setCreateTime(new Date());
        employee.setEmail("Mike@mail.com");
        employee.setLastName("Mike");
        employee.setDepartment(department);
        entityManager.persist(employee);
        Employee employee1 = new Employee();
        employee1.setBirth(new Date());
        employee1.setCreateTime(new Date());
        employee1.setEmail("Jack@mail.com");
        employee1.setLastName("Jack");
        employee1.setDepartment(department1);
        entityManager.persist(employee1);
        Employee employee2 = new Employee();
        employee2.setBirth(new Date());
        employee2.setCreateTime(new Date());
        employee2.setEmail("Tim@mail.com");
        employee2.setLastName("Tim");
        employee2.setDepartment(department2);
        entityManager.persist(employee2);
    }

    @Test
    public void testDeleteById() {
        String jpql = "delete from Employee e where e.id = ?";
        entityManager.createQuery(jpql).setParameter(1, 3).executeUpdate();
    }

    @Test
    public void testMerge() {
        Employee employee = new Employee();
        employee.setBirth(null);
        employee.setCreateTime(null);
        employee.setLastName("aa");
        employee.setEmail("mm");
        employee.setId(13);
        entityManager.merge(employee);
    }
}