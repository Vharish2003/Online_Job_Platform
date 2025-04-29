package com.example.RemoteJobsHub.Entity;



import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long u_id;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("address")
	private String address;
	@JsonProperty("contact")
	private long contact;
	@JsonProperty("resumeUrl")
	private String resumeUrl;
	
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}
	public long getContact() {
		// TODO Auto-generated method stub
		return contact;
	}
	
	

}
