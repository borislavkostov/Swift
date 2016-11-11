
public class Student extends Person {
	private int facultyNumber;
	private String[] lections;

	public Student(String name, String phoneNum) {
		super(name, phoneNum);
	}

	@Override
	public void work(Person obj[]) {
		for (int i = 0; i < obj.length; i++) {
			if (obj[i] instanceof Student) {
				obj[i].setTolerance(obj[i].getTolerance() + 2);
			} else if (obj[i] instanceof MaintenanceEmployee) {
				obj[i].setTolerance(obj[i].getTolerance() - 1);
			}	
		}
	}
}
