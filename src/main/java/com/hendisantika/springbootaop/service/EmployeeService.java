package com.hendisantika.springbootaop.service;

import com.hendisantika.springbootaop.aop.CalculatePerformance;
import com.hendisantika.springbootaop.aop.MethodLogger;
import com.hendisantika.springbootaop.model.Employee;
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
public class EmployeeService {
    private static final List<Employee> employeeLst = new ArrayList<>();

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
}
