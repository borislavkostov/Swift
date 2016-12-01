package education;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SecondaryEducation {
	private double finalGrade;
	private boolean graduated;
	private LocalDate enrollmentDate;
	private LocalDate graduationDate;
	private String institutionName;

	public SecondaryEducation(String institutionName, String enrollmentDate, String graduationDate, double finalGrade) {
			this.finalGrade = finalGrade;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyy");
			this.enrollmentDate = LocalDate.parse(enrollmentDate,formatter);
			this.graduationDate = LocalDate.parse(graduationDate,formatter);
			this.institutionName = institutionName;
	}

	public SecondaryEducation(String institutionName, String enrollmentDate, String graduationDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyy");
		this.enrollmentDate = LocalDate.parse(enrollmentDate,formatter);
		this.graduationDate = LocalDate.parse(graduationDate,formatter);
		this.institutionName = institutionName;
	}

	public double getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(double finalGrade) {
		this.finalGrade = finalGrade;
	}

	public boolean isGraduated() {
		return graduated;
	}

	public void setGraduated(boolean graduated) {
		this.graduated = graduated;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public LocalDate getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(LocalDate graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getInstitutionName() {
		return institutionName;
	}

}
