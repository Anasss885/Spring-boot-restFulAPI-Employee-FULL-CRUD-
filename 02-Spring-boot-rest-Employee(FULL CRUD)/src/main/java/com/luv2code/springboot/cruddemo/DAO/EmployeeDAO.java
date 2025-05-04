package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.Entity.employee;

import java.util.List;

public interface EmployeeDAO {
    List<employee>get_all_Employees();
    employee get_employee_byId(int id);
    public employee add_employee(employee e); // it may work for both insertion and updating by handling a small logic
   // void update_employee(employee e);
    void delete_employee(int id);


}
