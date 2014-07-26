package temp;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;

public class TableModelDemo2 implements ActionListener {
	JTable	table	= null;

	public TableModelDemo2() {
		JFrame frame = new JFrame("DataModel");
		JButton b1 = new JButton("數學老師");
		b1.addActionListener(this);
		JButton b2 = new JButton("學生阿呆");
		JPanel panel = new JPanel();
		b2.addActionListener(this);
		panel.add(b1);
		panel.add(b2);

		table = new JTable(new MyTable(1));
		table.setPreferredScrollableViewportSize(new Dimension(550, 30));
		JScrollPane scrollPane = new JScrollPane(table);

		frame.getContentPane().add(panel, BorderLayout.NORTH);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("學生阿呆")) {

			table.setModel(new MyTable(1));
		}
		if (e.getActionCommand().equals("數學老師")) {
			table.setModel(new MyTable(2));
		}
		table.revalidate();
	}

	public static void main(String[] args) {
		new TableModelDemo2();
	}
}

class MyTable extends AbstractTableModel {
	Object[][]	p1		= { { "阿呆", "1234", new Integer(66), new Integer(50), new Integer(116), new Boolean(false), new Boolean(false) } };
	String[]	n1		= { "姓名", "學號", "語文", "數學", "總分", "及格", "作弊" };
	Object[][]	p2		= { { "阿呆", "1234", new Integer(50), new Boolean(false), new Boolean(false), "01234" }, { "阿瓜", "1234", new Integer(75), new Boolean(true), new Boolean(false), "05678" } };
	String[]	n2		= { "姓名", "學號", "數學", "及格", "作弊", "電話" };
	int			model	= 1;																																											// model為1顯示學生阿呆的要看的表格，model為2顯示數學老師要看的表格

	public MyTable(int i) {
		model = i;
	}

	public int getColumnCount() {
		if (model == 1) {
			return n1.length;
		} else {
			return n2.length;
		}
	}

	public int getRowCount() {
		if (model == 1) {
			return p1.length;
		} else {
			return p2.length;
		}
	}

	public Object getValueAt(int row, int col) {
		if (model == 1) {
			return p1[row][col];
		} else {
			return p2[row][col];
		}
	}

	public String getColumnName(int col) {
		if (model == 1) {
			return n1[col];
		} else {
			return n2[col];
		}
	}

	public Class getColumnClass(int col) {// 復寫了getColumnClass方法后Boolean對象在表格中會以checkbox的形式顯示出來
		return getValueAt(0, col).getClass();
	}
}