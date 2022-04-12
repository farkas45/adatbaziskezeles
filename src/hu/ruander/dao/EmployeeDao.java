package hu.ruander.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ruander.model.Employee;
import hu.ruander.utils.Database;

public class EmployeeDao implements IEmployee{
	private Connection con = new Database().createConnection();
	private ResultSet rs = null;
	private PreparedStatement pstmt = null; 
	@Override
	public List<Employee> getAll() {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT * FROM employee WHERE employee.deleted = 0;"; 
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				employees.add(getObjectFromRs(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return employees;
	}

	@Override
	public Employee getById(int id) {
		String sql = "SELECT * FROM employee WHERE employee.id= ?;"; 
		Employee employee=null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				employee= getObjectFromRs(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee getObjectFromRs(ResultSet rs) {
		Employee empObj = null;
		try {
			empObj = new Employee(
				rs.getInt("id"),
				rs.getString("first_name"),
				rs.getString("last_name"),
				rs.getString("email"),
				rs.getString("gender"),
				rs.getString("company"),
				rs.getInt("salary"),
				rs.getBoolean("deleted")
				
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empObj;
	}

	@Override
	public void saveEmployee(Employee employee) {
		System.out.println(employee.toString());
		System.out.println(con);
		String sql = "INSERT INTO employee (first_name, last_name, email, gender, "
				+ "company, salary) "
				+ "VALUES (?,?,?,?,?,?);";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2, employee.getLastName());
			pstmt.setString(3, employee.getEmail());
			pstmt.setString(4, employee.getGender());
			pstmt.setString(5, employee.getCompany());
			pstmt.setInt(6, employee.getSalary());
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void setNewDateUpdat(Employee employee, int id) {
		System.out.println(employee.toString());
		String sql="UPDATE employee SET first_name=?, last_name=?,email=?,gender=?, company=?, salary=? WHERE id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2, employee.getLastName());
			pstmt.setString(3, employee.getEmail());
			pstmt.setString(4, employee.getGender());
			pstmt.setString(5, employee.getCompany());
			pstmt.setInt(6, employee.getSalary());
			pstmt.setInt(7, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
	}

	@Override
	public void DeleteDataById(Employee employee, int id ) {
		String sql="UPDATE employee SET deleted=1 WHERE id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





}
