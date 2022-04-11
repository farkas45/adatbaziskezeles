package hu.ruander.model;

public class Employee {
	
	private int id  ; 
	private String firstName ;
	private String lastName ;
	private String email ; 
	private String gender ;
	private String company ;
	private int salary ;
	private boolean deleted;
	
	
	
	public Employee(int id, String firstName, String lastName, String email, String gender, String company,
			int salary, boolean deleted) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.company = company;
		this.salary = salary;
		this.deleted = deleted;
	}
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getGender() {
		return gender;
	}
	public String getCompany() {
		return company;
	}
	public int getSalary() {
		return salary;
	}
	public boolean isDeleted() {
		return deleted;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + firstName + ", last_name=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", company=" + company + ", salary=" + salary + ", deleted=" + deleted + "]";
	}
	
	

}
