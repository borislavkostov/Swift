package education;

public class Primary extends Education {
	public Primary(String instituionName, String enrollmentDate, String graduationDate) {
		super(instituionName, enrollmentDate, graduationDate);
	}

	public Primary(String instituionName, String enrollmentDate, String graduationDate, double finalGrade) {
		super(instituionName, enrollmentDate, graduationDate, finalGrade);
	}

	@Override
	public void getDegree() {

	}

	@Override
	public void gotGraduated() {

	}
}
