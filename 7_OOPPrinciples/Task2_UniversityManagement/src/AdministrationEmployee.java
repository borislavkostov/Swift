
public class AdministrationEmployee extends Employee {
	public AdministrationEmployee(String name, String phoneNum) {
		super(name, phoneNum);
		this.setSallaryPerHour(19);
	}

	@Override
	int work() {
		// TODO Auto-generated method stub
		return 0;
	}
}
