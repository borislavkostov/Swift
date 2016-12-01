package education;

import java.time.LocalDate;

public abstract class GradedEducation extends Education {
	private double finalGrade;

	public GradedEducation(String instituionName, String enrollmentDate, String graduationDate) {
		super(instituionName, enrollmentDate, graduationDate);
	}

	public GradedEducation(String instituionName, String enrollmentDate, String graduationDate, double finalGrade) {
		super(instituionName, enrollmentDate, graduationDate, finalGrade);
	}

	public double gotGraduated(double finalGrade) {
		if(finalGrade<2&&finalGrade>6){
			throw new IllegalArgumentException("Graduation grade is expected to be between 2 and 6.");
		}	
		if(this.getGraduationDate().isAfter(LocalDate.now())){
			throw new IllegalArgumentException("Graduation date is expected to be a date in the past.");
		}
		if (this.isGraduated() == true) {
			return finalGrade;
		} else {
			throw new IllegalArgumentException("No final grade can be provided before graduation.");
		}
	}

	public double getFinalGrade() {
		return this.finalGrade;
	}
}
