package hu.ruander.presenter;

import hu.ruander.dao.EmployeeDao;
import hu.ruander.view.EmployeeView;

public class EmployeePresenter {

	final private EmployeeView view;
	final private EmployeeDao employeeDao;
	public EmployeePresenter(EmployeeView view, EmployeeDao employeeDao) {
		this.view = view;
		this.employeeDao = employeeDao;
	}

}
