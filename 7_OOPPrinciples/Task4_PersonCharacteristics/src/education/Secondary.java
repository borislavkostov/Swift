package education;

public class Secondary extends Education {
	public Secondary(String instituionName, String enrollmentDate, String graduationDate) {
		super(instituionName, enrollmentDate, graduationDate);
	}

	public Secondary(String instituionName, String enrollmentDate, String graduationDate, double finalGrade) {
		super(instituionName, enrollmentDate, graduationDate, finalGrade);
	}

	@Override
	public void getDegree() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gotGraduated() {
		// TODO Auto-generated method stub

	}
}
