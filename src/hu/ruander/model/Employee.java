package hu.ruander.model;

public class Employee {
	
	private int id  ; 
	private String first_name ;
	private String last_name ;
	private String email ; 
	private String gender ;
	private String company ;
	private int salary ;
	private boolean deleted;
	
	
	
	public Employee(int id, String first_name, String last_name, String email, String gender, String company,
			int salary, boolean deleted) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.gender = gender;
		this.company = company;
		this.salary = salary;
		this.deleted = deleted;
	}
	public int getId() {
		return id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
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
		return "Employee [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", gender=" + gender + ", company=" + company + ", salary=" + salary + ", deleted=" + deleted + "]";
	}
	
	

}
