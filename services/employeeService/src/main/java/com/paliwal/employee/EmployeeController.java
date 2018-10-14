package com.paliwal.employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

	@Autowired
	Employee employee;
	
    
	 @GetMapping("/list")
	 @ResponseBody
    public ArrayList<Employee> getDetails(){
		 
		 ArrayList<Employee> employeeList = new ArrayList<Employee>();
		 
		 Employee employee = new Employee();
		 employee.setFirstName("gaurav");
		 employee.setLastName("paliwal");
		 employee.setGender("male");
		 employee.setDob("25-07-1988");
		 employee.setDepartment("IT");
		 
		 employeeList.add(employee);
		 
		 employee = new Employee();
		 employee.setFirstName("john");
		 employee.setLastName("tom");
		 employee.setGender("male");
		 employee.setDob("30-08-1987");
		 employee.setDepartment("IT");
		 employeeList.add(employee);
		 
		 FileInputStream fin = null;
			ObjectInputStream ois = null;
			try {
				fin = new FileInputStream("employee.ser");
				ois = new ObjectInputStream(fin);
				employee = new Employee();
				employee = (Employee) ois.readObject();
				 employeeList.add(employee);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 
        return employeeList;
    }

    //@RequestMapping(value="/addEmployee", method = RequestMethod.POST)
    @PostMapping("/addEmployee")
    public ResponseEntity saveEmployee(@RequestBody Employee emp){
      
    	    	 
    	try {
    		FileOutputStream fout = null;
    		ObjectOutputStream oos = null;
    		
    		fout = new FileOutputStream("employee.ser");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(emp);
			return ResponseEntity.ok(HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.ok(HttpStatus.NOT_FOUND);
		}
    	
        
    }
}
