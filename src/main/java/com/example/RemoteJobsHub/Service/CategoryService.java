package com.example.RemoteJobsHub.Service;

import com.example.RemoteJobsHub.Entity.JobCategory;
import com.example.RemoteJobsHub.Repository.CategoryRepo;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public JobCategory SaveAll(JobCategory category){
        return categoryRepo.save(category);
    }

    public List<JobCategory>getAll(){
        return categoryRepo.findAll();
    }
    public Optional<JobCategory>getById(Long id){
        return categoryRepo.findById(id);
    }
}
