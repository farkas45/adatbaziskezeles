package hu.ruander.app;

import javax.swing.SwingUtilities;

import hu.ruander.dao.EmployeeDao;
import hu.ruander.presenter.EmployeePresenter;
import hu.ruander.view.EmployeeView;

public class App {

	
	public App() {
		final EmployeeView view=new EmployeeView();
		final EmployeeDao employeeDao = new EmployeeDao();
		new EmployeePresenter(view,employeeDao);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new App();
			}
		});
		
	}
}
