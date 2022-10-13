package com.hotelmanagement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Visitor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long vid;

	@Column(name = "first_name", nullable = false)
	public String firstName;

	@Column(name = "last_name", nullable = false)
	public String lastName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "vid")
	List<Product> products;

	@Column(name = "mobile_number", nullable = false)
	@Pattern(regexp = "^\\d{10}$" ,message = "inviled phone no")
	@Size(min = 10, max = 10)
	public String mobileNumber;

	@Email(regexp = "[a-z0-9._%+-]+@[gmail.com]")
	public String emailId;

	
}
