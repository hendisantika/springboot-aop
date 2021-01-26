package com.hendisantika.springbootaop.controller;

import com.hendisantika.springbootaop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
