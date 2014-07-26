package com.hydronovo.util.swing.table;

import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class ObjectAttributeTable extends JTable{
	
	@Override
	public TableCellEditor getCellEditor(int row, int column) {
		int modelColumn = convertColumnIndexToModel(column);

		if (modelColumn == 1 && row < 3)
			return (TableCellEditor) editors.get(row);
		else
			return super.getCellEditor(row, column);
	}
}
