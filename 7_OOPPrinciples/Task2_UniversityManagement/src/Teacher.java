
public class Teacher extends Employee {
	private String[] lectures;

	public Teacher(String name, String phoneNum) {
		super(name, phoneNum);
		this.setSallaryPerHour(25);
	}

	@Override
	int work() {
		return 0;
	}

}
