package hu.ruander.dao;

import java.sql.ResultSet;
import java.util.List;

import hu.ruander.model.Employee;

public interface IEmployee {

	List<Employee> getAll();
	Employee getId();
	Employee getObjectFromRs(ResultSet rs);
	void saveEmployee(Employee employee);
	
}
