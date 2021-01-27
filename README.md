# springboot-aop

### Things todo list:

1. Clone this repository: `git clone https://github.com/hendisantika/springboot-aop.git`
2. Go inside the folder: `cd springboot-aop`
3. Run the application: `mvn clean spring-boot:run`
4. Open your favorite terminal

Add New Employee

![Add New Employee](img/add.png "Add New Employee")

```shell
curl --location --request POST 'http://localhost:8080/api/employees' \
--header 'Content-Type: application/json' \
--data-raw '{
"empId" : "A12345",
"empName": "Uzumaki Naruto",
"deptName": "Shinobi"
}' | jq .
```

Get All Employees

![Get All Employees](img/get.png "Get All Employees")

```shell
curl --location --request GET 'http://localhost:8080/api/employees/A12345' \
--header 'Content-Type: application/json' \
--data-raw '{
    "empId" : "A12345",
    "empName": "Uzumaki Naruto",
    "deptName": "Shinobi"
}' | jq .
```