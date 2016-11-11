
public class MaintenanceEmployee extends Employee {
	public MaintenanceEmployee(String name, String phoneNum) {
		super(name, phoneNum);
		this.setSallaryPerHour(15);
	}

	@Override
	public void work(Person obj[]) {
		for (int i = 0; i < obj.length; i++) {
			if (obj[i] instanceof Student) {
				obj[i].setTolerance(obj[i].getTolerance() + 2);
			} else if (obj[i] instanceof Teacher) {
				obj[i].setTolerance(obj[i].getTolerance() + 2);
			} else if (obj[i] instanceof AdministrationEmployee) {
				obj[i].setTolerance(obj[i].getTolerance() + 2);
			}
		}
	}
}
