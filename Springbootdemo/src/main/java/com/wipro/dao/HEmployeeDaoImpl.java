package com.wipro.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.entity.HEmployee;

@Repository
public class HEmployeeDaoImpl implements HEmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void createEmployee(HEmployee employee) {
        getSession().save(employee);
        System.out.println("Employee Added Successfully!");
    }

    @Override
    public List<HEmployee> getAllEmployees() {
        Query<HEmployee> qry = getSession().createQuery("from HEmployee", HEmployee.class);
        List<HEmployee> elist = qry.list();
        System.out.println("All Employees -- " + elist);
        return elist;
    }

    @Override
    public HEmployee getAnEmployee(String email) {
        Query<HEmployee> qry = getSession()
                .createQuery("from HEmployee where email=:email", HEmployee.class)
                .setParameter("email", email);
        HEmployee emp = qry.uniqueResult();
        System.out.println("Emp fetched using email: " + emp);
        return emp;
    }

    @Override
    public List<HEmployee> updateEmployee(HEmployee employee) {
        Query<?> qry = getSession()
                .createQuery("update HEmployee set name=:ename, email=:email, password=:pass where eid=:eid")
                .setParameter("ename", employee.getName())
                .setParameter("email", employee.getEmail())
                .setParameter("pass", employee.getPassword())
                .setParameter("eid", employee.getEid());
        int rows = qry.executeUpdate();
        if (rows > 0) {
            System.out.println("Updated employee with ID: " + employee.getEid());
        }
        return getAllEmployees();
    }

    @Override
    public List<HEmployee> deleteEmployee(int eid) {
        Query<?> qry = getSession()
                .createQuery("delete from HEmployee where eid=:eid")
                .setParameter("eid", eid);
        int rows = qry.executeUpdate();
        if (rows > 0) {
            System.out.println("Deleted employee with ID: " + eid);
        }
        return getAllEmployees();
    }
}
