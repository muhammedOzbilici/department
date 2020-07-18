package com.mhmt.dao.emplyoee.impl;

import com.mhmt.dao.emplyoee.DepartmentRepository;
import com.mhmt.domain.employee.Department;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class DepartmentRepositoryImpl implements DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean saveDepartment(Department department) {
        entityManager.persist(department);
        return true;
    }

    @Override
    public boolean deleteDepartment(Department department) {
        if (entityManager.contains(department)) {
            entityManager.remove(department);
            return true;
        }
        Department deleteDepartment = findDepartmentById(department.getDepartmentId());
        entityManager.remove(deleteDepartment);
        return true;
    }

    @Override
    public Department updateDepartment(Department department) {
        Department updateDepartment = entityManager.merge(department);
        entityManager.flush();
        return updateDepartment;
    }

    @Override
    @Transactional(readOnly = true)
    public Department findDepartmentById(Long departmenId) {
        TypedQuery<Department> typedQuery = entityManager.createNamedQuery("Deparment.findLocationAndEmployeesByDepartmentId", Department.class);
        typedQuery.setParameter("departmenId", departmenId);
        return typedQuery.getSingleResult();
    }


    @Override
    @Transactional(readOnly = true)
    public List<Department> findAllDepartments() {
        return entityManager.createNamedQuery("Deparment.findAll", Department.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> findDepartmentName() {
        TypedQuery<String> typedQuery = entityManager.createNamedQuery("Deparment.findByDepartmentName", String.class);
        return typedQuery.getResultList();
    }


}
