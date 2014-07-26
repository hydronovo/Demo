package temp;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * TableModel with two columns: Boolean (CheckBox) and String
 * 
 * @author Aleksandr
 */
class BooleanTableModel extends DefaultTableModel {

	private static final int	LOGICAL_COLUMN		= 0;
	private static final int	DESCRIPTION_COLUMN	= 1;
	private static final int	COLUMNS_COUNT		= 2;

	/**
	 * Model data.
	 */
	private List<RowItem>		data				= new Vector<RowItem>();

	public BooleanTableModel(RowItem... data) {
		if (data != null)
			this.data.addAll(Arrays.asList(data));
	}

	/**
	 * Returns number of lines
	 * 
	 * @return number of rows
	 */
	@Override
	public int getRowCount() {
		return data != null ? data.size() : 0;
	}

	/**
	 * Returns number of columns
	 * 
	 * @return number of columns
	 */
	@Override
	public int getColumnCount() {
		return COLUMNS_COUNT;
	}

	/**
	 * Forbids editing og cells
	 * 
	 * @param row
	 *            Row index
	 * @param column
	 *            Column index
	 * @return <tt>false</tt> always
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	/**
	 * Returns class of values in column <tt>columnIndex</tt>
	 * 
	 * @param columnIndex
	 *            Number of column
	 * @return Class of values in column <tt>columnIndex</tt>
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case LOGICAL_COLUMN:
			return Boolean.class;
		case DESCRIPTION_COLUMN:
			return String.class;

		}
		return null;
	}

	/**
	 * Returns value in row <tt>rowIndex</tt> and column <tt>columnIndex</tt>
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		RowItem item = data.get(rowIndex);
		if (item == null)
			return null;
		switch (columnIndex) {
		case LOGICAL_COLUMN:
			return item.getLogical();
		case DESCRIPTION_COLUMN:
			return item.getDescription();

		}
		return null;
	}

	/**
	 * Data class for incapsulation data
	 */
	protected static class RowItem {

		private Boolean	logical;
		private String	description;

		/**
		 * Constructs the class with the given values
		 * 
		 * @param logical
		 *            Logical value
		 * @param description
		 *            Description value
		 */
		RowItem(Boolean logical, String description) {
			this.logical = logical;
			this.description = description;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Boolean getLogical() {
			return logical;
		}

		public void setLogical(Boolean logical) {
			this.logical = logical;
		}

	}

}