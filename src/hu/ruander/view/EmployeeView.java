package hu.ruander.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

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
}
