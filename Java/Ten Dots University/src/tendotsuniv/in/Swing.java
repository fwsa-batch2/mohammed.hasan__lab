package tendotsuniv.in;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Swing {

	Connection conn;
	Statement st;
	ResultSet resultSet;
	PreparedStatement preparedStatement;

	private JFrame frmCrudOperation;
	private JTextField txt_city;
	private JTextField txt_dob;
	private JTextField txt_lname;
	private JTextField txt_fname;
	private JTextField txt_id;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing window = new Swing();
					window.frmCrudOperation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Swing() {
		initialize();
		Connect();
		loadData();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudOperation = new JFrame();
		frmCrudOperation.getContentPane().setFont(new Font("Monospaced", Font.PLAIN, 15));
		frmCrudOperation.setTitle("CRUD operation");
		frmCrudOperation.setFont(new Font("Monospaced", Font.PLAIN, 15));
		frmCrudOperation.setBounds(100, 100, 450, 300);
		frmCrudOperation.setSize(900,500);
		frmCrudOperation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrudOperation.getContentPane().setLayout(null);
		frmCrudOperation.setBackground(Color.BLACK);


		JPanel Headings = new JPanel();
		Headings.setBorder(new EmptyBorder(1, 1, 0, 0));
		Headings.setBounds(43, 98, 109, 192);
		frmCrudOperation.getContentPane().add(Headings);
		Headings.setLayout(null);

		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 28, 105, 21);
		Headings.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("First Name");
		lblLastName.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblLastName.setBounds(10, 61, 105, 21);
		Headings.add(lblLastName);
		
		JLabel lblLastName_1 = new JLabel("Last Name");
		lblLastName_1.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblLastName_1.setBounds(10, 93, 105, 21);
		Headings.add(lblLastName_1);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblDob.setBounds(10, 126, 105, 21);
		Headings.add(lblDob);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblCity.setBounds(10, 158, 105, 21);
		Headings.add(lblCity);
		
		JPanel Inputs = new JPanel();
		Inputs.setBorder(new EmptyBorder(0, 0, 0, 0));
		Inputs.setBounds(159, 109, 246, 192);
		frmCrudOperation.getContentPane().add(Inputs);
		Inputs.setLayout(null);

		txt_city = new JTextField();
		txt_city.setBounds(36, 151, 167, 20);
		txt_city.setColumns(10);
		Inputs.add(txt_city);
		
		txt_dob = new JTextField();
		txt_dob.setColumns(10);
		txt_dob.setBounds(37, 117, 167, 20);
		Inputs.add(txt_dob);
		
		txt_lname = new JTextField();
		txt_lname.setColumns(10);
		txt_lname.setBounds(37, 86, 167, 20);
		Inputs.add(txt_lname);
		
		txt_fname = new JTextField();
		txt_fname.setColumns(10);
		txt_fname.setBounds(37, 55, 167, 20);
		Inputs.add(txt_fname);
		
		txt_id = new JTextField();
		txt_id.setColumns(10);
		txt_id.setEditable(false);
		txt_id.setBounds(38, 19, 167, 20);
		Inputs.add(txt_id);
		
		JButton btn_save = new JButton("Save");
		btn_save.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txt_id.getText();
				String f_name = txt_fname.getText();
				String l_name = txt_lname.getText();
				String dob = txt_dob.getText();
				String city = txt_city.getText();

				if(f_name.isEmpty() || f_name == null || f_name.trim().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter your first name");
					txt_fname.requestFocus();
					return;
				}
				if(l_name.isEmpty() || l_name == null || l_name.trim().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter your last name");
					txt_lname.requestFocus();
					return;
				}
				if(city.isEmpty() || city == null || city.trim().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter the city");
					txt_city.requestFocus();
					return;
				}
				if(id.isEmpty()){
					try {
						String query = "insert into students(f_name,l_name,city) values(?,?,?)";
						preparedStatement = conn.prepareStatement(query);
						preparedStatement.setString(1, f_name);
						preparedStatement.setString(2,l_name);
						preparedStatement.setString(3,city);
						preparedStatement.execute();
						JOptionPane.showMessageDialog(null,"Data Insertion Success");
						clear();
						loadData();
					}
					catch (Exception err){
						err.printStackTrace();
					}
				}
			}
		});
		btn_save.setBounds(69, 315, 89, 23);
		frmCrudOperation.getContentPane().add(btn_save);
		
		JButton btn_del = new JButton("Delete");
		btn_del.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_del.setBounds(168, 315, 89, 23);
		frmCrudOperation.getContentPane().add(btn_del);
		btn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!txt_id.getText().isEmpty()) {
					var result = JOptionPane.showConfirmDialog(null, "Are you sure do you want to delete ?",
							"Delete this Id .. ?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						try {
							String query = "delete from students where id=?";
							preparedStatement = conn.prepareStatement(query);
							preparedStatement.setString(1, txt_id.getText());
							preparedStatement.execute();
							JOptionPane.showMessageDialog(null, "Data Deletion Success");
							clear();
							loadData();
						} catch (Exception err) {
							err.printStackTrace();
						}
					}
				}
			}
		});
		
		JButton btn_update = new JButton("Update");
		btn_update.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_update.setBounds(266, 315, 89, 23);
		frmCrudOperation.getContentPane().add(btn_update);
		btn_update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txt_id.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please enter Id");
					return;
				}
				if (!txt_id.getText().isEmpty()){
					try {
						String query = "update students set f_name=?,l_name=?,city=? where id = ?";
						preparedStatement = conn.prepareStatement(query);
						preparedStatement.setString(1,txt_fname.getText());
						preparedStatement.setString(2,txt_lname.getText());
						preparedStatement.setString(3,txt_city.getText());
						preparedStatement.setString(4,txt_id.getText());
						preparedStatement.execute();
						JOptionPane.showMessageDialog(null,"Data Updation Success");
						loadData();
						clear();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("CRUD Operations");
		lblNewLabel_1.setFont(new Font("Lucida Console", Font.BOLD, 17));
		lblNewLabel_1.setBounds(343, 29, 181, 23);
		frmCrudOperation.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(428, 119, 417, 229);
		frmCrudOperation.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				// Gets data from row(index) at 0th column, 1st Column and so on
				txt_id.setText(model.getValueAt(index,0).toString());
				txt_fname.setText(model.getValueAt(index,1).toString());
				txt_lname.setText(model.getValueAt(index,2).toString());
				txt_city.setText(model.getValueAt(index,3).toString());
			}
		});
	}
	void clear(){
		txt_id.setText("");
		txt_fname.setText("");
		txt_fname.requestFocus();
		txt_lname.setText("");
		txt_dob.setText("");
		txt_city.setText("");

	}

	void loadData(){
		try {
			String query = "select * from students";
			st = conn.createStatement();
//			preparedStatement = conn.prepareStatement(query);
			resultSet = st.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


   public void Connect(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","hasan","HasanTheDON7.");
			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class DbUtils {
	public static TableModel resultSetToTableModel(ResultSet rs) {
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			Vector columnNames = new Vector();

			// Get the column names
			for (int column = 0; column < numberOfColumns; column++) {
				columnNames.addElement(metaData.getColumnLabel(column + 1));
			}

			// Get all rows.
			Vector rows = new Vector();

			while (rs.next()) {
				Vector newRow = new Vector();

				for (int i = 1; i <= numberOfColumns; i++) {
					newRow.addElement(rs.getObject(i));
				}

				rows.addElement(newRow);
			}

			return new DefaultTableModel(rows, columnNames);
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}
}
