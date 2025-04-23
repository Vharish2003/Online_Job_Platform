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
	

}
