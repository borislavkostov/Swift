import java.sql.Date;

public class Student {
	private int id;
	private String name;
	private Date enrollmentDate;
	public Student(int id, String name, Date enrollmentDate) {
		this.id = id;
		this.name = name;
		this.enrollmentDate = enrollmentDate;
	}
	public String toString(){
		return this.getId()+" "+this.getName()+" "+this.getEnrollmentDate();
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
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	
}
