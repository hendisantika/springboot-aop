package com.hendisantika.springbootaop.controller;

import com.hendisantika.springbootaop.model.Employee;
import com.hendisantika.springbootaop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService dummyService;

    // Get the employee detail based on employee id
    @GetMapping("/employee/{empid}")
    public Employee getEmployee(@PathVariable("empid") String empId) {
        return dummyService.getEmployee(empId);
    }

    //post the new employee details to backend
    @PostMapping("/employee")
    public String newEmployee(@RequestBody Employee employee) {
        return dummyService.addEmployee(employee);
    }
}
