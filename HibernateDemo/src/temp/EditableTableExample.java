package temp;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableCell;

import com.hydronovo.util.swing.table.ObjectAttributeTableModel;

public class EditableTableExample extends JFrame {

	private static final long	serialVersionUID	= 1L;

	public EditableTableExample() {
		// Employee row1 = new Employee(1, "John", 40.0, false);
		// Employee row2 = new Employee(2, "Rambo", 70.0, false);
		// Employee row3 = new Employee(3, "Zorro", 60.0, true);
		//
		// // build the list
		// List<Employee> employeeList = new ArrayList<Employee>();
		// employeeList.add(row1);
		// employeeList.add(row2);
		// employeeList.add(row3);
		//
		// // create the model
		// EmployeeTableModel model = new EmployeeTableModel(employeeList);
		// // create the table
		// JTable table = new JTable(model);

		Employee employee = new Employee(1, "么么哒", 40.0, true);
		AEmployee aEmployee = (AEmployee) employee;
		IEmployeee iEmployeee = new Employee(1, "么么哒", 40.0, true);
//		IEmployeee iEmployeee =
		// EmployeeAttTableModel model = new EmployeeAttTableModel(employee);
		ObjectAttributeTableModel model = new ObjectAttributeTableModel(aEmployee);
		
		
		JTable table = new JTable(model);
		
		table.setDefaultRenderer(Boolean.class, new BooleanCellRenderer());
		
		this.add(new JScrollPane(table));

		this.setTitle("Editable Table Example");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new EditableTableExample();
			}
		});
	}
}
