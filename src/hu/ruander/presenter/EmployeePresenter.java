package hu.ruander.presenter;

import java.util.List;

import hu.ruander.dao.EmployeeDao;
import hu.ruander.model.Employee;
import hu.ruander.view.EmployeeView;
import hu.ruander.view.IViewLisenner;

public class EmployeePresenter implements IViewLisenner {

	final private EmployeeView view;
	final private EmployeeDao employeeDao;
	public EmployeePresenter(EmployeeView view, EmployeeDao employeeDao) {
		this.view = view;
		view.addLisener(this);
		this.employeeDao = employeeDao;
		fillTableEmployee(employeeDao.getAll());
	}
	
	public void fillTableEmployee(List<Employee> employees) {
		view.setModelTableEmployee(employees);
	}
	
	@Override
	public void onButtonClickedCreateFrame() {
		view.setEmpNewFrame();
		
	}

	@Override
	public void onButtonClickedSaveEmployee() {
		employeeDao.saveEmployee(view.getEmpDataFromFrame());
		view.tableEmployeeRowsDelet();
		fillTableEmployee(employeeDao.getAll());
		
	}

	@Override
	public void onMouseClickedRowSelected() {
		// TODO Auto-generated method stub
		
	}
}
