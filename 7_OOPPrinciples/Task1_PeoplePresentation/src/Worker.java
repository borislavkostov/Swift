
public class Worker extends Person {
	private double weekSalary;
	private int workHoursPerDay;
	public Worker(String fname,String lName,double wSalary,int workHours){
		super(fname,lName);
		weekSalary = wSalary;
		workHoursPerDay = workHours;
	}
	public Worker(){
		super("Unknown", "UNKNOWN");
		weekSalary = 0.0;
		workHoursPerDay = 0;
	}
	@Override
	public String toString(){
		return String.format("First name:%s%nLast name:%s%nOccupation:Worker%nWeek salary:%.2f%nSalary per hour:%d",this.getFirstName(),this.getLastName(),this.getWeekSalary(),this.getWorkHoursPerDay());
	}
	public double getWeekSalary() {
		return weekSalary;
	}
	public void setWeekSalary(double weekSalary) {
		if(weekSalary<0){
			System.out.println("Expected positive number");
		}else{
		this.weekSalary = weekSalary;
		}
	}
	public int getWorkHoursPerDay() {
		return workHoursPerDay;
	}
	public void setWorkHoursPerDay(int workHoursPerDay) {
		this.workHoursPerDay = workHoursPerDay;
	}
	
}
