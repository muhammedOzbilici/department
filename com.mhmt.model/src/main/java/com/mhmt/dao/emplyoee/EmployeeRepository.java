package com.mhmt.dao.emplyoee;

import com.mhmt.domain.employee.Employee;

import java.util.List;

public interface EmployeeRepository {
    boolean saveEmployee(Employee employee);

    boolean deleteEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee findEmployeeById(Long employeeId);

    List<Employee> findEmployees();

    Long countEmployee();

    List<Employee> betweenSalaryEmployees(int minSalary, int maxSalary);

    List<Employee> findEmployeesFirstMax(int first, int max);

}
