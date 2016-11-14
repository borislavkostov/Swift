
public class Student {
	private String schoolId;
	private String name;

	public Student(String schoolId, String name) {
		this.schoolId = schoolId;
		this.name = name;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
