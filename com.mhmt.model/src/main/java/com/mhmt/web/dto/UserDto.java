package com.mhmt.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mhmt.validation.PasswordMatches;
import com.mhmt.validation.ValidEmail;

@PasswordMatches
public class UserDto {
	
	@NotNull
	@Size(min = 3 , max = 15 , message = "Firstname en az 3 , en çok 15 karakter")
	private String firstName;
	private String lastName;
	private String userName;
	
	@ValidEmail()
	private String email;
	
	private String password;
	private String matchingPassword;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMatchingPassword() {
		return matchingPassword;
	}
	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
	
	

}
