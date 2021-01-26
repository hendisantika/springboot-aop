package com.hendisantika.springbootaop.controller;

import com.hendisantika.springbootaop.model.Employee;
import com.hendisantika.springbootaop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-aop
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/01/21
 * Time: 06.50
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService dummyService;

    // Get the employee detail based on employee id
    @GetMapping("/{empid}")
    public Employee getEmployee(@PathVariable("empid") String empId) {
        return dummyService.getEmployee(empId);
    }

    //post the new employee details to backend
    @PostMapping
    public String newEmployee(@RequestBody Employee employee) {
        return dummyService.addEmployee(employee);
    }

    // update the employee depart using emp id
    @PutMapping("/{empid}")
    public String updateEmployee(@PathVariable("empid") String empId, @RequestParam("deptName") String deptName) {
        return dummyService.updateEmployeeDept(empId, deptName);
    }
}
