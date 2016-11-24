package education;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Education {
	private double finalGrade;
	private boolean graduated;
	private LocalDate enrollmentDate;
	private LocalDate graduationDate;
	private String institutionName;
	public Education(String instituionName,String enrollmentDate,String graduationDate){
		this.setInstitutionName(instituionName);
		this.setEnrollmentDate(enrollmentDate);
		this.setGraduationDate(graduationDate);
	}
	public Education(String instituionName,String enrollmentDate,String graduationDate,double finalGrade){
		this.setInstitutionName(instituionName);
		this.setEnrollmentDate(enrollmentDate);
		this.setGraduationDate(graduationDate);
		this.setFinalGrade(finalGrade);
	}
	abstract public void getDegree();

	abstract public void gotGraduated();
	public Education() {

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

	public void setEnrollmentDate(String enrollmentDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyy");
		this.enrollmentDate = LocalDate.parse(enrollmentDate, formatter);
	}

	public LocalDate getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(String graduationDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyy");
		this.graduationDate = LocalDate.parse(graduationDate, formatter);
		if(this.graduationDate.isBefore(this.enrollmentDate)){
			throw new IllegalArgumentException("Graduation Date needs to be after enrollment date .");
		}
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
}
