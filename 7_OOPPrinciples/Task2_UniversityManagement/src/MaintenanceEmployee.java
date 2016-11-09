
public class MaintenanceEmployee extends Employee {
	public MaintenanceEmployee(String name, String phoneNum) {
		super(name, phoneNum);
		this.setSallaryPerHour(15);
	}

	@Override
	int work() {
		// TODO Auto-generated method stub
		return 0;
	}
}
