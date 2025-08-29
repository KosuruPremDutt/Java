package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dao.HEmployeeDao;
import com.wipro.entity.HEmployee;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class HEmployeeServiceImpl implements HEmployeeService {

    @Autowired
    private HEmployeeDao hEmployeeDao;

    @Override
    public void createEmployee(HEmployee employee) {
        hEmployeeDao.createEmployee(employee);
    }

    @Override
    public List<HEmployee> getAllEmployees() {
        return hEmployeeDao.getAllEmployees();
    }

    @Override
    public HEmployee getAnEmployee(String email) {
        return hEmployeeDao.getAnEmployee(email);
    }

    @Override
    public List<HEmployee> updateEmployee(HEmployee employee) {
        return hEmployeeDao.updateEmployee(employee);
    }

    @Override
    public List<HEmployee> deleteEmployee(int eid) {
        return hEmployeeDao.deleteEmployee(eid);
    }
}
