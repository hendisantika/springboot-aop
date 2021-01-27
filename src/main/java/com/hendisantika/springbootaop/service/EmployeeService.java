package com.hendisantika.springbootaop.service;

import com.hendisantika.springbootaop.aop.CalculatePerformance;
import com.hendisantika.springbootaop.aop.MethodLogger;
import com.hendisantika.springbootaop.model.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-aop
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/01/21
 * Time: 06.36
 */
@Component
@Log4j2
public class EmployeeService {
    private static final List<Employee> employeeLst = new ArrayList<>();

    @CalculatePerformance
    public List<Employee> getEmployees() {
        return employeeLst;
    }

    @CalculatePerformance
    public Employee getEmployee(String empId) {
        Stream<Employee> empStream = employeeLst.stream().filter(emp -> {
            return emp.getEmpId().equalsIgnoreCase(empId);
        });
        sleepForSeconds(5000L);
        return empStream.findAny().get();
    }

    @MethodLogger
    public String addEmployee(Employee e) {
        employeeLst.add(e);
        sleepForSeconds(3000L);
        return "Success";
    }

    @MethodLogger
    public String updateEmployeeDept(String empId, String deptName) {
        employeeLst.stream().forEach(emp -> {
            if (emp.getEmpId().equalsIgnoreCase(empId)) {
                emp.setDeptName(deptName);
            }
        });
        sleepForSeconds(2000L);
        return "SUCCESS";
    }

    @MethodLogger
    public String deleteEmployee(String empId) {
        log.info("Employee Id -->" + empId);
        if (employeeLst.removeIf(emp -> emp.getEmpId().equalsIgnoreCase(empId)))
            return "SUCCESS";
        else
            return "FAILURE";
    }

    public void sleepForSeconds(Long period) {
        try {
            Thread.sleep(period);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        // employee 1
        emp1.setEmpId("A1234");
        emp1.setEmpName("Uzumaki Naruto");
        emp1.setDeptName("IT");
        // employee 2
        emp2.setEmpId("B1234");
        emp2.setEmpName("Uchiha Sasuke");
        emp2.setDeptName("Finance");

        employeeLst.add(emp1);
        employeeLst.add(emp2);
    }

}
