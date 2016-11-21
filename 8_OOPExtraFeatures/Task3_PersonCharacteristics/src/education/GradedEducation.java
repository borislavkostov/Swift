package education;

public abstract class GradedEducation extends Education {
	private double finalGrade;

	public GradedEducation(String instituionName, String enrollmentDate, String graduationDate) {
		super(instituionName, enrollmentDate, graduationDate);
	}

	public GradedEducation(String instituionName, String enrollmentDate, String graduationDate, double finalGrade) {
		super(instituionName, enrollmentDate, graduationDate, finalGrade);
	}

	public double gotGraduated(double finalGrade) {
		if (this.isGraduated() == true) {
			return finalGrade;
		} else {
			return -1;
		}
	}

	public double getFinalGrade() {
		return this.finalGrade;
	}
}
