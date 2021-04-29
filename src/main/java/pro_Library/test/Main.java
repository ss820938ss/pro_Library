package pro_Library.test;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main {
	// Connection
	public Statement st;
    public ResultSet rs;
    public PreparedStatement pst;
    
    // To load driver (.jar), click right on src >> Build Path >> Configure Build Path
    // then go to Java Build Path >> tab Libraries >> Add External JARs
    private Connection con;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306";
    private String dbname = "test";
    private String user = "root";
    private String password = "";
	
    // GUI Components
    // 1. Frame
    private JFrame frame = new JFrame("Students Data");
    
    // 2. Panel
    private JPanel panel_1 = new JPanel(); // for input fields and tables
    private JPanel panel_2 = new JPanel(); // for buttons
    
    // 3. Label
    private JLabel label_nim_insert = new JLabel("NIM (Insert)");
    private JLabel label_nim = new JLabel("NIM");
    private JLabel label_name = new JLabel("Name");
    private JLabel label_gpa = new JLabel("GPA");
    
    // 4. Input
    private JComboBox combobox = new JComboBox();
    private JTextField txt_field_nim = new JTextField();
    private JTextField txt_field_name = new JTextField();
    private JTextField txt_field_gpa = new JTextField();
    private JButton btnInsert = new JButton("Insert");
    private JButton btnUpdate = new JButton("Update");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnClose = new JButton("Close");
    
    // 5. Scrollable table
    private DefaultTableModel def_table = new DefaultTableModel(
    		new String[] {"BinusianID", "Name", "GPA"}, 0);
    		// DefaultTableModel(columns_on_array_of_string, rows)
    private JTable tables = new JTable(def_table);
    private JScrollPane scrollable = new JScrollPane(tables);
    
    // CONSTRUCTOR for class Main()
    public Main() {
    	frame.setLayout(null);
    	
    	// 1. Add inputs
    	// 1.1. Labels
    	frame.add(label_nim);
    	label_nim.setBounds(10, 5, 40, 40);
    	frame.add(label_nim_insert);
    	label_nim_insert.setBounds(10, 30, 40, 40);
    	frame.add(label_name);
    	label_name.setBounds(10, 55, 40, 40);
    	frame.add(label_gpa);
    	label_gpa.setBounds(10, 78, 40, 40);
    	
    	// 1.2. Combobox and text fields
    	frame.add(combobox);
    	combobox.setBounds(65, 13, 100, 20);	
    	frame.add(txt_field_nim);
    	txt_field_nim.setBounds(65, 40, 100, 20);
    	frame.add(txt_field_name);
    	txt_field_name.setBounds(65, 65, 100, 20);
    	frame.add(txt_field_gpa);
    	txt_field_gpa.setBounds(65, 90, 100, 20);
    	
    	// 2. Add buttons
    	panel_2.add(btnInsert);
    	btnInsert.setSize(50, 40);
    	panel_2.add(btnUpdate);
    	btnUpdate.setSize(50, 40);
    	panel_2.add(btnDelete);
    	btnUpdate.setSize(50, 40);
    	panel_2.add(btnClose);
    	btnUpdate.setSize(50, 40);
    	
    	panel_2.setLayout(new GridLayout());
    	panel_2.setBounds(10, 125, 400, 40);
    	frame.add(panel_2);
    	
    	// 3. Add table
    	scrollable.setBounds(10, 170, 400, 160);
    	frame.add(scrollable);
    	
    	// Action when click Combobox
    	combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = (String) combobox.getSelectedItem();
				String check;
		    	
		    	for(int i=0; i < def_table.getRowCount(); i++){
		    		check = (String) def_table.getValueAt(i, 0);
		    		if(check.compareTo(selected) == 0){
						txt_field_nim.setText(check);
						txt_field_name.setText((String) def_table.getValueAt(i, 1));
						txt_field_gpa.setText(Float.toString((Float)def_table.getValueAt(i, 2)));
		    			break;
		    		}
		    	}
			}
		});
    	
    	// Action when click button INSERT
    	btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nim = txt_field_nim.getText();
				String name = txt_field_name.getText();
				String gpa = txt_field_gpa.getText();
				
				boolean same = false;
				String check;
				for(int i=0; i < def_table.getRowCount(); i++){
		    		check = (String) def_table.getValueAt(i, 0);
		    		if(check.compareTo(nim) == 0){
		    			same = true;
		    			JOptionPane.showMessageDialog(null,"Nim is not unique", "Error",JOptionPane.ERROR_MESSAGE);
		    			break;
		    		}
		    	}
				
				if(!validate(nim,name,gpa) && !same) {
					insert(nim, name, Float.parseFloat(gpa));
				}				
			}
		});
    	
    	// Action when click button UPDATE
    	btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cb = combobox.getSelectedItem().toString(); // cb = value of selected string in combo box
				String nim = txt_field_nim.getText();
				String name = txt_field_name.getText();
				String gpa = txt_field_gpa.getText();
								
				if(!validate(nim, name, gpa)) update(cb,nim,name,gpa);
			}
		});
    	
    	// Action when click button DELETE
    	btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cb = combobox.getSelectedItem().toString();
				delete(cb);
			}
		});
    	
    	// Action when click button CLOSE
    	btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeConnection();
				frame.dispose();	
			}
		});
    	
    	// Setting frame
    	frame.setSize(440, 400);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    	
    	frame.setVisible(true); // must be defined at the bottom of function
    
    	openConnection(); // run connection
    }
    
    public boolean openConnection() {
    	String idVec, nameVec;
    	float gpaVec;
    	
    	// when define Class.forName() and DriverManager.getConnection(),
    	// remember to surround with try-catch
    	
    	try {
    		Class.forName(driver); 
			con = DriverManager.getConnection(url + "/" + dbname, user, password);
			st = con.createStatement();
			st.executeUpdate("CREATE TABLE IF NOT EXISTS student_data("
					+ "binusian_id varchar(10) PRIMARY KEY NOT NULL,"
					+ "student_name varchar(255) NOT NULL,"
					+ "student_gpa float NOT NULL)");
    	} catch (SQLException | ClassNotFoundException e) { 
			e.printStackTrace();
			return false;
		}
    	
    	// .executeQuery = for select
    	// .executeUpdate = for manipulating database (insert/update/delete)
    	try {
			rs = st.executeQuery("SELECT * from student_data");
			while(rs.next()) { // .next() works like foreach, iterate until last row in database
				idVec = rs.getString("binusian_id");
				nameVec = rs.getString("student_name");
				gpaVec = rs.getFloat("student_gpa");
				
				def_table.addRow(new Object[] {idVec, nameVec, gpaVec});
				combobox.addItem(idVec);
			}
    	} catch (SQLException e) { e.printStackTrace(); }
    	
    	return true;
    }
    
    public void closeConnection() {
		try {
			if(st != null) {
				st.close();
				st = null;
			}

			if(con != null) {
				con.close();
				con = null;
			}
		} catch(Exception exc) { }
	}
    
    public boolean validate(String nim, String name, String gpa) {
    	boolean error = false;
		float gpaf = 0;
		
    	if(gpa.trim().equals(""))
			JOptionPane.showMessageDialog(null, "Input GPA field first", "Error", JOptionPane.ERROR_MESSAGE);
		else {
			try { gpaf = Float.parseFloat(gpa);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "GPA field cannot be read", "Error", JOptionPane.ERROR_MESSAGE);
				return true;
			} 
			
			if(nim.trim().equals(""))
				JOptionPane.showMessageDialog(null, "Input NIM field first", "Error", JOptionPane.ERROR_MESSAGE);
			
			else {
				if(name.trim().equals(""))
					JOptionPane.showMessageDialog(null, "Input Name field first", "Error",JOptionPane.ERROR_MESSAGE);
				else return false;
			}
		}
    	return true;
    }
    
    public void insert(String nim, String name, float gpa) {
    	try {
			pst = con.prepareStatement("INSERT INTO student_data(binusian_id, student_name, student_gpa) values(?,?,?)");
	    	pst.setString(1, nim);
	    	pst.setString(2, name);
	    	pst.setFloat(3, gpa);
	    	pst.execute();
    	} catch (SQLException e) { e.printStackTrace(); }
    	
    	combobox.addItem(nim);
    	def_table.addRow(new Object[] {nim, name, gpa});
    }
    
    public void update(String cb, String nim, String name, String gpa) {
    	try {
    		pst = con.prepareStatement("UPDATE student_data SET binusian_id = ?, student_name = ?, student_gpa = ? WHERE binusian_id = ?");
			pst.setString(1, nim);
			pst.setString(2, name);
			pst.setFloat(3, Float.parseFloat(gpa));
			pst.setString(4, cb);
			pst.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
    	
    	int index = combobox.getSelectedIndex();
		combobox.removeItemAt(index);
		combobox.insertItemAt(nim, index);
    	combobox.setSelectedIndex(index);
    	
    	String check;  	
    	for(int i=0; i < def_table.getRowCount(); i++){
    		check = (String) def_table.getValueAt(i, 0);
    		if(check.compareTo(cb) == 0){
    			def_table.removeRow(i);
    			def_table.insertRow(i, new Object[] {nim, name, gpa});
    		}
    	}
    }
    
    public void delete(String cb) {
    	try {
			pst = con.prepareStatement("DELETE FROM student_data WHERE binusian_id = ?");
			pst.setString(1, cb);
			pst.execute();
			
			int index = combobox.getSelectedIndex();
			combobox.removeItemAt(index);
	    	combobox.setSelectedIndex(index);
	    	
	    	String check;
	    	for(int i=0; i < def_table.getRowCount(); i++){
	    		check = (String) def_table.getValueAt(i, 0);
	    		if(check.compareTo(cb) == 0){
	    			def_table.removeRow(i);
	    			break;
	    		}
	    	}		
		} catch (SQLException e) { e.printStackTrace(); }
    }
       
	public static void main(String[] args) { new Main(); }
}