package com.luv2code.springboot.cruddemo;

import com.luv2code.springboot.cruddemo.DAO.EmployeeDAO;
import com.luv2code.springboot.cruddemo.Entity.employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EmployeeDAO employeeDAO ){
		return runner ->{ // this gonna used to run all of Our CRUD operations locally , Not on browser
			//retriveOurEmployee(employeeDAO);
			//add_new_employee(employeeDAO);
			//get_all_employees(employeeDAO);
			//DeleteThisEmployee(employeeDAO);
		};
	}

	private void DeleteThisEmployee(EmployeeDAO employeeDAO){
		int id=5;
		System.out.println("Deleting Employee");
		employeeDAO.delete_employee(5);
	}

	private void get_all_employees(EmployeeDAO employeeDAO){
		List<employee> e=employeeDAO.get_all_Employees();
		for(employee OurEmployees:e){
			System.out.println(OurEmployees);
		}


	}

	private void add_new_employee(EmployeeDAO employeeDAO){
		employee employee1=new employee("Ahmed","Hassan","miaao@gmail.com");
		employeeDAO.add_employee(employee1);

	}

	private void retriveOurEmployee(EmployeeDAO employeeDAO){
		int id=7; // need to be more dynamic
		employee e= new employee();
		e=employeeDAO.get_employee_byId(id);
		System.out.println("Our employee is "+ e);
	}

}
