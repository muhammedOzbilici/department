package com.mhmt.dao.emplyoee;

import com.mhmt.domain.employee.Department;

import java.util.List;

public interface DepartmentRepository {
    boolean saveDepartment(Department department);

    boolean deleteDepartment(Department department);

    Department updateDepartment(Department department);

    Department findDepartmentById(Long departmenId);

    List<Department> findAllDepartments();

    List<String> findDepartmentName();

}
