package com.mhmt.dao.emplyoee;

import java.util.List;

import com.mhmt.domain.employee.Department;

public interface DepartmentRepository {
	boolean saveDepartment(Department department);
	boolean deleteDepartment(Department department);
	Department updateDepartment(Department department);
	Department findDepartmentById(Long departmenId);
	List<Department> findAllDepartments();
	List<String> findDepartmentName();

}
