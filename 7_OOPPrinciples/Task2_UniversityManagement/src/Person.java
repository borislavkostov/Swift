
public abstract class Person {
	private String firstName;
	private String phoneNum;
	private int tolerance = 20;
	
	public Person(String firstName, String phoneNum) {
		this.firstName = firstName;
		this.phoneNum = phoneNum;
	}
	abstract void work(Person[] obj);
	public int getTolerance() {
		return tolerance;
	}

	public void setTolerance(int toleranceR) {
		tolerance = toleranceR;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.length() < 2 || firstName.length() > 30) {
			System.out.printf("Expected length for %s isbetween 2 and 30 symbols.%n", firstName);
		} else {
			this.firstName = firstName;
		}
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}
