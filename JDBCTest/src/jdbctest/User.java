package jdbctest;

public class User {//POJO Plain Old Java Object
	// Java Bean
	/*
	 * User.name
	 * User.password
	 * User.email*/
	
	String name;
	String password;
	String email;
	
	public String getMyVeryLongName() {
		return name;
	}
	public void setMyVeryLongName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}