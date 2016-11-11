
public class Teacher extends Employee {
	private String[] lectures;

	public Teacher(String name, String phoneNum) {
		super(name, phoneNum);
		this.setSallaryPerHour(25);
	}

	@Override
	public void work(Person obj[]) {
		University.setBalance(University.getBalance()-this.getSallaryPerHour());
		for (int i = 0; i < obj.length; i++) {
			if (obj[i] instanceof Student) {
				obj[i].setTolerance(obj[i].getTolerance() + 3);
			} else if (obj[i] instanceof MaintenanceEmployee) {
				obj[i].setTolerance(obj[i].getTolerance() - 3);
			} else if (obj[i] instanceof AdministrationEmployee) {
				obj[i].setTolerance(obj[i].getTolerance() - 1);
			}
		}
	}

}
