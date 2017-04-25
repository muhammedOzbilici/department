package com.mhmt.dao.emplyoee.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mhmt.dao.emplyoee.JobRepository;
import com.mhmt.domain.employee.Job;

@Repository
@Transactional(rollbackFor = {RuntimeException.class , Throwable.class})
public class JobRepositoryImpl implements JobRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean saveJob(Job job) {
		entityManager.persist(job);
		return true;
	}

	@Override
	public boolean deleteJob(Job job) {
		if (entityManager.contains(job)) {
			entityManager.remove(job);
		}else {
			Job deleteJob = findJobById(job.getJobId());
			entityManager.remove(deleteJob);
		}
		return true;
	}

	@Override
	public Job updateJob(Job job) {
		Job updatedJob = entityManager.merge(job);
		return updatedJob;
	}

	@Override
	@Transactional(readOnly = true)
	public Job findJobById(Long jobId) {
		return entityManager.createNamedQuery("Job.findEmplyoeesById", Job.class)
				.setParameter("jobId", jobId).getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Job> findAllJobs() {
		return entityManager.createNamedQuery("Job.findAll", Job.class).getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<String> findJobTitles() {
		return entityManager.createNamedQuery("Job.findAllByJobTitles", String.class).getResultList();
	}

}
