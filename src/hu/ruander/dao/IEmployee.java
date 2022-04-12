package hu.ruander.dao;

import java.sql.ResultSet;
import java.util.List;

import hu.ruander.model.Employee;

public interface IEmployee {

	List<Employee> getAll();
	Employee getById(int id);
	Employee getObjectFromRs(ResultSet rs);
	void saveEmployee(Employee employee);
	void setNewDateUpdat(Employee employee, int id);
	void DeleteDataById(Employee employee,int id);
	List<Employee> SearchData(String data );
	
	
	
}
