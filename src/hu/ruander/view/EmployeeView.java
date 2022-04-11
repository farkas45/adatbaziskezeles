package hu.ruander.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import hu.ruander.model.Employee;

public class EmployeeView {
	private final ArrayList<IViewLisenner> listeners;
	private JFrame empListFrame;
	private JButton btnCreateEmpNewFrame;
	private JScrollPane scrollPane;
	private JTable tableEmployee;
	private JFrame empNewFrame;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfSalary;
	private JTextField tfEmail;
	private JTextField tfCompany;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblSalary;
	private JLabel lblEmail;
	private JLabel lblCompany;
	private JButton btnEmpSave;
	public EmployeeView() {
		this.listeners=new ArrayList<IViewLisenner>();
		empListFrame = new JFrame();
		empListFrame.setBounds(300, 200, 1020, 650);
		empListFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		empListFrame.getContentPane().setLayout(null);
		empListFrame.setTitle(" nyilvántartás");
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(35,21,921,180);
		empListFrame.getContentPane().add(scrollPane);
		
		tableEmployee = new JTable();
		scrollPane.setViewportView(tableEmployee);
		
		btnCreateEmpNewFrame = new JButton("Új dolgozó felvitel");
		btnCreateEmpNewFrame.setBounds(60,240, 150, 50);
		
		empListFrame.setVisible(true);
	}
	
	
	
	public void setTabbleCellCenter() {
		DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < tableEmployee.getColumnCount(); i++) {
			tableEmployee.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
	}
	
	public void setModelTableEmployee(List<Employee> employees) {
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Azonosító");
		model.addColumn("Keresztnév");
		model.addColumn("Vezetéknév");
		model.addColumn("Email");
		model.addColumn("Nem");
		model.addColumn("Vállalat");
		model.addColumn("Fizetés");
		
		for (Employee employee : employees) {
			model.addRow(new Object[] {
					
					employee.getId(),
					employee.getFirstName(),
					employee.getLastName(),
					employee.getEmail(),
					employee.getGender(),
					employee.getCompany(),
					employee.getSalary(),
			});
		}
		tableEmployee.setModel(model);
		tableEmployee.setRowHeight(30);
		setTabbleCellCenter();
	}
}
