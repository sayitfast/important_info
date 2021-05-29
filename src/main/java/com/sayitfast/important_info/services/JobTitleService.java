package com.sayitfast.important_info.services;

import com.sayitfast.important_info.models.JobTitle;
import com.sayitfast.important_info.repositories.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {
    @Autowired
    private JobTitleRepository jobTitleRepository;

    //Return list of countries
    public List<JobTitle> getJobTitles() {
        return jobTitleRepository.findAll();
    }

    //SAve new JobTitle
    public void save(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
    }

    //get by id
    public Optional<JobTitle> findById(int id) {
        return jobTitleRepository.findById(id);
    }

    public void delete(Integer id) {
        jobTitleRepository.deleteById(id);
    }

}
