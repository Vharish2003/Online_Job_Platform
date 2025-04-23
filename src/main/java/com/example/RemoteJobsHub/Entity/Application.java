package com.example.RemoteJobsHub.Entity;

import java.util.Date;

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
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long app_id;
	private Date appliedDate;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="u_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="j_id")
	private Job job;

}
