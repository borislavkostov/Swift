
public class Teacher {
	private int id;
	private String name;
	private String email;
	private double salary;

	public Teacher(int id, String name, String email, double salary) {
		this.setId(id);
		this.setName(name);
		this.setEmail(email);
		this.setSalary(salary);
	}

	public String toString() {
		return this.getId() + " " + this.getName() + " " + this.getEmail()+" "+this.getSalary();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
