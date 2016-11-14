
public class Class {
	private String classId;
	private Student student[];
	private Teacher teacher[];

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public Class(String classId) {
		this.classId = classId;
	}

	public Student[] getStudents() {
		return student;
	}

	public void setStudent(Student student) {
		for (int i = 0; i < this.student.length; i++) {
			if (this.student[i] == null) {
				this.student[i] = student;
			}
		}
	}

	public Teacher[] getTeachers() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		for (int i = 0; i < this.teacher.length; i++) {
			if (this.teacher[i] == null) {
				this.teacher[i] = teacher;
			}
		}
	}

}
