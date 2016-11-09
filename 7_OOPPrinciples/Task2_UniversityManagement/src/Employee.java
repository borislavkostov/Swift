
public abstract class Employee extends Person {
	private double sallaryPerHour;

	abstract int work();

	public Employee(String name, String phoneNum) {
		super(name, phoneNum);
	}

	public double getSallaryPerHour() {
		return sallaryPerHour;
	}

	public void setSallaryPerHour(double sallary) {
		this.sallaryPerHour = sallary;
	}
}
