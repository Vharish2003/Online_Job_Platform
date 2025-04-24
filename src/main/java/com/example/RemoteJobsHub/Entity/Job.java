package com.example.RemoteJobsHub.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long j_id;
	private String title;
	private String description;
	private String emp_type;
	private String location;
	private String skills;
	private String salary;
	
	
	@ManyToOne
	@JoinColumn(name="c_id")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="cat_id")
	private JobCategory jobcategory;

	public long getJ_id() {
		return j_id;
	}

	public void setJ_id(long j_id) {
		this.j_id = j_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmp_type() {
		return emp_type;
	}

	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public JobCategory getJobcategory() {
		return jobcategory;
	}

	public void setJobcategory(JobCategory jobcategory) {
		this.jobcategory = jobcategory;
	}
	
	
	

}
