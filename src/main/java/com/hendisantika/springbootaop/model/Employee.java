package com.hendisantika.springbootaop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-aop
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/01/21
 * Time: 06.34
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String empId;
    private String empName;
    private String deptName;
}
