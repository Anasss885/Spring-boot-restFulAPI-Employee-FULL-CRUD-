package com.luv2code.springboot.cruddemo.rest;


import com.luv2code.springboot.cruddemo.DAO.EmployeeDAO;
import com.luv2code.springboot.cruddemo.Entity.employee;
import com.luv2code.springboot.cruddemo.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class employeeRestController {
    //private EmployeeDAO employeeDAO;
    private employeeService theemployeeService;
    //Constructor injection
    @Autowired
    public employeeRestController(employeeService theemployeeService) {
        this.theemployeeService = theemployeeService;
    }
    // function to get all of our employees
    @GetMapping("/getOuremployees")
    public List<employee>OurEmployees(){
        return theemployeeService.get_all_Employees();
    }
    // function to get our Employee by its ID
    @GetMapping("/getOuremployees/{employeeID}")
    public  employee getAnEmployeeByID(@PathVariable int employeeID){
        employee employee1=theemployeeService.get_employee_byId(employeeID);
        if(employee1==null)
            throw new RuntimeException("EmployeeID is not found " + employeeID);
        else
            return employee1;
    }

    // function to insert/update the employee u was send based on having a generated ID or not
  @PostMapping("/getOuremployees")
   public employee add_employee(@RequestBody employee employee1){
        // in case they put an id in JSON , set it to 0 to force saving a new item , instead of update
      //  we do this to an id , because we're using a POST Request i.e we will post a new informations , not updating , in case of update we'll use PUT request as u will see
      employee1.setId(0);
      employee theEmployee=theemployeeService.add_employee(employee1);
      return  theEmployee;
  }

  // this method to update an already existing employee
    @PutMapping ("/getOuremployees")
    public employee update_employee(@RequestBody employee employee1){
            employee theEmployee=theemployeeService.add_employee(employee1);
            return  theEmployee;
    }

    @DeleteMapping("/getOuremployees/{employeeID}")
    public  String deleteAnEmployeeByID(@PathVariable int employeeID){
        employee employee1=theemployeeService.get_employee_byId(employeeID);
        if(employee1==null)
            throw new RuntimeException("EmployeeID is not found " + employeeID);
        else{
            theemployeeService.delete_employee(employeeID);
            return "deleting the Employee sucessfully";
        }
        
    }





}
