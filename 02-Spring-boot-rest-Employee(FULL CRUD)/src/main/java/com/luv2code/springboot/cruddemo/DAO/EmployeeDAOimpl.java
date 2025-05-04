package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.Entity.employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOimpl implements  EmployeeDAO{

    EntityManager entityManager;

    public EmployeeDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<employee> get_all_Employees() {
        TypedQuery<employee>Query=entityManager.createQuery("from employee",employee.class);
        return Query.getResultList();
    }

    @Override
    public employee get_employee_byId(int id) {
        employee e=entityManager.find(employee.class,id);
        return e;
    }

    @Override
   // @Transactional
    public employee add_employee(employee e) {
        // it will save/insert this employee in case its id equals zero (i.e not generated yet) other it'll update the given one
        employee emp=entityManager.merge(e);
        return emp;
    }

    @Override
    //@Transactional
    public void delete_employee(int id) {
        employee employee1=entityManager.find(employee.class,id);
        if(employee1!=null){
            entityManager.remove(employee1);
        }
        else{
            System.out.println("We can't Found the employee with ID + "+ id);
        }

    }
}
