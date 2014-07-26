package temp;

import com.hydronovo.util.swing.table.FieldUI;

public class Employee extends AEmployee {

	@FieldUI(name = "工号")
	private int		id;

	@FieldUI(name = "名称", description = "请填写名称", getMethod = "getFullName")
	private String	name;

	@FieldUI(name = "时薪", description = "请填写时薪")
	private double	hourlyRate;

	@FieldUI(name = "是否是兼职", description = "是否是兼职")
	private Boolean	partTime;

	public Employee(int id, String name, double hourlyRate, boolean partTime) {
		this.id = id;
		this.name = name;
		this.hourlyRate = hourlyRate;
		this.partTime = partTime;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getHourlyRate() {
		return hourlyRate;
	}

	@Override
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	@Override
	public boolean isPartTime() {
		return partTime;
	}

	@Override
	public void setPartTime(boolean partTime) {
		this.partTime = partTime;
	}

	public String getFullName() {
		return ("song " + getName());
	}
}
