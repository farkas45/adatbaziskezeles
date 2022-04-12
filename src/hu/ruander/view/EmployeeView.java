package hu.ruander.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
	private JTextField tfGender;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblSalary;
	private JLabel lblEmail;
	private JLabel lblCompany;
	private JLabel lblGender;
	private JButton btnEmpSave;
	private JButton btnEmpDelet;
	private JFrame empUpDateOrDeleteFrame;
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
		
		tableEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				notifyListenersMouseClickedRowSelected(getTableId(tableEmployee.rowAtPoint(e.getPoint())));
			}
			  
			
		});
		
		btnCreateEmpNewFrame = new JButton("Új dolgozó felvitel");
		btnCreateEmpNewFrame.setBounds(60,240, 150, 50);
		
		btnCreateEmpNewFrame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyListenersOnButtonClickedCreateFrame();
				
			}
		});
		
		empListFrame.add(btnCreateEmpNewFrame);
		empListFrame.setVisible(true);
	}
//--------------------------------------------------------------------------------------------------------------------------
	//Lisenerek
	public void addLisener(final IViewLisenner listener) {
		listeners.add(listener);
	}
	private void notifyListenersOnButtonClickedCreateFrame() {
		for (final IViewLisenner listener :listeners) {
			listener.onButtonClickedCreateFrame();
		}
	}
	
	private void notifyListenersOnButtonClickedSaveEmployee() {
		for (final IViewLisenner listener : listeners) {
			listener.onButtonClickedSaveEmployee();
		}
	}
	
	private void  notifyListenersMouseClickedRowSelected(int id) {
		for (IViewLisenner listener : listeners) {
			listener.onMouseClickedRowSelected(id);
		}
	}
//----------------------------------------------------------------------------------------------------------------------
	public void setTabbleCellCenter() {
		DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < tableEmployee.getColumnCount(); i++) {
			tableEmployee.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
	}
	public void tableEmployeeRowsDelet() {
		int rowcount=tableEmployee.getModel().getRowCount();
		for (int i = rowcount-1; i >=0; i--) {
			((DefaultTableModel) tableEmployee.getModel()).removeRow(i);
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
	
	public void setEmpNewFrame() {
		empNewFrame = new JFrame();
		empNewFrame.setBounds(900, 200, 600, 700);
		empNewFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		empNewFrame.getContentPane().setLayout(null);
		empNewFrame.setTitle("Új dolgozó");
		empNewFrame.setVisible(true);
		
		lblFirstName = new JLabel("Keresztnév");
		lblFirstName.setBounds(100,60,190,45);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 16));
		empNewFrame.add(lblFirstName);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(280,60,190,45);
		tfFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		tfFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		empNewFrame.add(tfFirstName);
		
		lblLastName = new JLabel("Vezetéknév");
		lblLastName.setBounds(100,120,190,45);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		empNewFrame.add(lblLastName);
		
		tfLastName = new JTextField();
		tfLastName.setBounds(280,120,190,45);
		tfLastName.setHorizontalAlignment(SwingConstants.CENTER);
		tfLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		empNewFrame.add(tfLastName);
		
		lblEmail= new JLabel("Email");
		lblEmail.setBounds(100,180,190,45);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		empNewFrame.add(lblEmail);
		
		tfEmail= new JTextField();
		tfEmail.setBounds(280,180,190,45);
		tfEmail.setHorizontalAlignment(SwingConstants.CENTER);
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		empNewFrame.add(tfEmail);
		
		lblCompany= new JLabel("Vállalat");
		lblCompany.setBounds(100,240,190,45);
		lblCompany.setFont(new Font("Tahoma", Font.BOLD, 16));
		empNewFrame.add(lblCompany);
		
		tfCompany= new JTextField();
		tfCompany.setBounds(280,240,190,45);
		tfCompany.setHorizontalAlignment(SwingConstants.CENTER);
		tfCompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
		empNewFrame.add(tfCompany);
		
		lblGender= new JLabel("Nem");
		lblGender.setBounds(100,300,190,45);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		empNewFrame.add(lblGender);
		
		tfGender= new JTextField();
		tfGender.setBounds(280,300,190,45);
		tfGender.setHorizontalAlignment(SwingConstants.CENTER);
		tfGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		empNewFrame.add(tfGender);
		
		lblSalary= new JLabel("Fizetés");
		lblSalary.setBounds(100,360,190,45);
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 16));
		empNewFrame.add(lblSalary);
		
		tfSalary = new JTextField();
		tfSalary.setBounds(280,360,190,45);
		tfSalary.setHorizontalAlignment(SwingConstants.CENTER);
		tfSalary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		empNewFrame.add(tfSalary);
		
		btnEmpSave = new JButton("MENTÉS");
		btnEmpSave.setBounds(280,480,190,45);
		empNewFrame.add(btnEmpSave);
		btnEmpSave.setVisible(true);
		
		btnEmpSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyListenersOnButtonClickedSaveEmployee();
				
			}
		});
		
	}
	
	public Employee getEmpDataFromFrame() {
		Employee employee = new Employee(
				tfFirstName.getText(),
				tfLastName.getText(),
				tfEmail.getText(),
				tfCompany.getText(),
				tfGender.getText(),
				Integer.parseInt(tfSalary.getText())
				
				
	);
		return employee;
	}
	
	public void setUpDateOrDeleteFrame(int id) {
		empUpDateOrDeleteFrame = new JFrame();
		empUpDateOrDeleteFrame.setBounds(900, 200, 600, 700);
		empUpDateOrDeleteFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		empUpDateOrDeleteFrame.getContentPane().setLayout(null);
		empUpDateOrDeleteFrame.setTitle("Adat módósítás vagy törlés id: "+id);
		empUpDateOrDeleteFrame.setVisible(true);
		
		lblFirstName = new JLabel("Keresztnév");
		lblFirstName.setBounds(100,60,190,45);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 16));
		empUpDateOrDeleteFrame.add(lblFirstName);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(280,60,190,45);
		tfFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		tfFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		empUpDateOrDeleteFrame.add(tfFirstName);
		
		lblLastName = new JLabel("Vezetéknév");
		lblLastName.setBounds(100,120,190,45);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		empUpDateOrDeleteFrame.add(lblLastName);
		
		tfLastName = new JTextField();
		tfLastName.setBounds(280,120,190,45);
		tfLastName.setHorizontalAlignment(SwingConstants.CENTER);
		tfLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		empUpDateOrDeleteFrame.add(tfLastName);
		
		lblEmail= new JLabel("Email");
		lblEmail.setBounds(100,180,190,45);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		empUpDateOrDeleteFrame.add(lblEmail);
		
		tfEmail= new JTextField();
		tfEmail.setBounds(280,180,190,45);
		tfEmail.setHorizontalAlignment(SwingConstants.CENTER);
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		empUpDateOrDeleteFrame.add(tfEmail);
		
		lblCompany= new JLabel("Vállalat");
		lblCompany.setBounds(100,240,190,45);
		lblCompany.setFont(new Font("Tahoma", Font.BOLD, 16));
		empUpDateOrDeleteFrame.add(lblCompany);
		
		tfCompany= new JTextField();
		tfCompany.setBounds(280,240,190,45);
		tfCompany.setHorizontalAlignment(SwingConstants.CENTER);
		tfCompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
		empUpDateOrDeleteFrame.add(tfCompany);
		
		lblGender= new JLabel("Nem");
		lblGender.setBounds(100,300,190,45);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		empUpDateOrDeleteFrame.add(lblGender);
		
		tfGender= new JTextField();
		tfGender.setBounds(280,300,190,45);
		tfGender.setHorizontalAlignment(SwingConstants.CENTER);
		tfGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		empUpDateOrDeleteFrame.add(tfGender);
		
		lblSalary= new JLabel("Fizetés");
		lblSalary.setBounds(100,360,190,45);
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 16));
		empUpDateOrDeleteFrame.add(lblSalary);
		
		tfSalary = new JTextField();
		tfSalary.setBounds(280,360,190,45);
		tfSalary.setHorizontalAlignment(SwingConstants.CENTER);
		tfSalary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		empUpDateOrDeleteFrame.add(tfSalary);
		
		btnEmpSave = new JButton("Modósítás");
		btnEmpSave.setBounds(80,480,190,45);
		empUpDateOrDeleteFrame.add(btnEmpSave);
		btnEmpSave.setVisible(true);
		btnEmpDelet = new JButton("Törlés");
		btnEmpDelet.setBounds(280,480,190,45);
		btnEmpDelet.setBackground(Color.red);
		btnEmpDelet.setForeground(Color.WHITE);
		empUpDateOrDeleteFrame.add(btnEmpDelet);
		btnEmpDelet.setVisible(true);
		
		
		
	}
	public int getTableId(int rowCount) {
		
		int id=Integer.parseInt(tableEmployee.getModel().getValueAt(rowCount, 0).toString());
		
		
		return id;
	}

}
