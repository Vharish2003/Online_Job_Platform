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
public class Interview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long int_id;
	private Date interviewDate;
	private String mode;
	private String result;
	
	
	@ManyToOne
	@JoinColumn(name="app_id")
	private Application application;

}
