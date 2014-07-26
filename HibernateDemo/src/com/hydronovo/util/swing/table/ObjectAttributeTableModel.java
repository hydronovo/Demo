package com.hydronovo.util.swing.table;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.table.AbstractTableModel;

public class ObjectAttributeTableModel extends AbstractTableModel {

	private static final long	serialVersionUID	= 1L;
	private final String[]		columnNames			= new String[] { "属性", "值", "说明" };
	private final Class<?>[]	columnClass			= new Class[] { String.class, Object.class, String.class };
	private Object				object				= null;

	public ObjectAttributeTableModel(Object object) {
		this.object = object;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int column) {
		return columnClass[column];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (rowIndex > 0 && columnIndex == 1)
			return true;
		return false;
	}

	@Override
	public int getRowCount() {
		Field[] fields = object.getClass().getDeclaredFields();
		int nRow = 0;
		for (Field f : fields) {
			FieldUI fieldUI = f.getAnnotation(FieldUI.class);
			if (fieldUI != null) {
				nRow++;
			}
		}
		return nRow;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Field[] fields = object.getClass().getDeclaredFields();
		int count = -1;
		for (Field f : fields) {
			FieldUI fieldUI = f.getAnnotation(FieldUI.class);
			if (fieldUI != null) {
				count++;
				if (rowIndex != count) {
					continue;
				}
				switch (columnIndex) {
				case 0:
					return fieldUI.name();
				case 1:
					Method[] methods = object.getClass().getMethods();
					for (Method method : methods) {
						if (!fieldUI.getMethod().equalsIgnoreCase("")) {
							try {
								for (Method otherMethod : methods) {
									if (otherMethod.getName().equalsIgnoreCase(fieldUI.getMethod())) {
										return otherMethod.invoke(object);
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						if (method.getName().equalsIgnoreCase("get" + f.getName()) || method.getName().equalsIgnoreCase("is" + f.getName())) {
							try {
								return method.invoke(object);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
					break;
				case 2:
					return fieldUI.description();
				}
			}
		}
		return null;
	}

}
