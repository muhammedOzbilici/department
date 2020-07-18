package com.mhmt.dao.emplyoee;

import com.mhmt.domain.employee.Job;

import java.util.List;

public interface JobRepository {
    boolean saveJob(Job job);

    boolean deleteJob(Job job);

    Job updateJob(Job job);

    Job findJobById(Long jobId);

    List<Job> findAllJobs();

    List<String> findJobTitles();


}
