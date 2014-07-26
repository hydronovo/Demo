package temp;

public abstract class AEmployee implements IEmployeee{
	
	@Override
	public abstract int getId();
	
	@Override
	public abstract String getName();
	
	@Override
	public abstract double getHourlyRate();
	
	@Override
	public abstract boolean isPartTime();
	
	public abstract void setId(int id);
	
	public abstract void setName(String name);
	
	public abstract void setHourlyRate(double hourlyRate);
	
	public abstract void setPartTime(boolean partTime);
	
	
}
