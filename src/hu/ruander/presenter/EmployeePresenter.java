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
	public void onMouseClickedRowSelected(int id) {
		//System.out.println( employeeDao.getById(id));
		view.setUpDateOrDeleteFrame(id,employeeDao.getById(id));
	}

	@Override
	public void onButtonClickedUpdatDate(int id) {
	
		employeeDao.setNewDateUpdat(view.getEmpDataFromFrame(),id);
		view.tableEmployeeRowsDelet();
		fillTableEmployee(employeeDao.getAll());
		view.disposeUpdateorDeletFrame();
	}

	@Override
	public void onButtonClickedDelete(int id) {
		employeeDao.DeleteDataById(view.getEmpDataFromFrame(),id);
		view.tableEmployeeRowsDelet();
		fillTableEmployee(employeeDao.getAll());
		view.disposeUpdateorDeletFrame();
	}

	@Override
	public void onButtonClickedSearch( String data) {
		if (employeeDao.SearchData(data)!=null) {
			view.tableEmployeeRowsDelet();
			fillTableEmployee(employeeDao.SearchData(data));
		}
		else {
			
		}
		
	}

	@Override
	public void onButtonClickedCloseUpdateOrDelete() {
		view.disposeUpdateorDeletFrame();
		
	}

	@Override
	public void onButtonClickedCloseNewDataFrame() {
		view.disposeNewDataFrame();
		
	}

	
}
