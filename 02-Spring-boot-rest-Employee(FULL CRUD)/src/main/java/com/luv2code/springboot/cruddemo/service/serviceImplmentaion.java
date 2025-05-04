package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.DAO.EmployeeDAO;
import com.luv2code.springboot.cruddemo.Entity.employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class serviceImplmentaion implements employeeService{

    private EmployeeDAO employeeDAO;
    @Autowired
    public serviceImplmentaion(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<employee> get_all_Employees() {
        List<employee>Our_employees=employeeDAO.get_all_Employees();
        return Our_employees;
    }

    @Override
    public employee get_employee_byId(int id) {
        //employee employee1=employeeDAO.get_employee_byId(id);
        return employeeDAO.get_employee_byId(id);
    }

    @Transactional
    @Override
    public employee add_employee(employee e) {
        //employee employee1=employeeDAO.add_employee(e);
        return employeeDAO.add_employee(e); // in case of rendring when updating
    }

    @Transactional
    @Override
    public void delete_employee(int id) {
        employeeDAO.delete_employee(id);
    }
}
