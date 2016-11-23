import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import education.Education;

public class Person {
	private String firstName;
	private String middleName;
	private String lastName;
	private char gender;
	private LocalDate yearOfBorn;
	private double weight;
	private int height;
	private String profession;
	private double grade1;
	private double grade2;
	private double grade3;
	private double grade4;
	private Education education;
	private char educationCode;
	private Address address;

	public Person(String fName, String middleName, String lName, char gender, String yearOfBorn, int heigh,
			char educationCode) {
		this.firstName = fName;
		this.middleName = middleName;
		this.lastName = lName;
		this.gender = gender;
		this.height = heigh;
		this.setYearOfBorn(yearOfBorn);
		this.setEducationCode(educationCode);
	}

	public Person() {
		this.firstName = "UNKNOWN";
		this.lastName = "UNKNOWN";
	}

	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyy");
		if (this.getGender() == 'M') {
			if (this.getEducationCode() == 'B') {
				return String.format(
						"%s %s is %dyears old.He was born in %d.He was started bachelor degree in %s on %s and finished on %s.His degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.getEducation().getInstitutionName(),
						formatter.format(this.getEducation().getEnrollmentDate()),
						formatter.format(this.getEducation().getGraduationDate()), this.getEducation().getFinalGrade());
			} else if (this.getEducationCode() == 'S') {
				return String.format(
						"%s %s is %dyears old.He was born in %d.He was started secondary degree in %s on %s and finished on %s.His degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.getEducation().getInstitutionName(),
						formatter.format(this.getEducation().getEnrollmentDate()),
						formatter.format(this.getEducation().getGraduationDate()), this.getEducation().getFinalGrade());
			} else if (this.getEducationCode() == 'P') {
				return String.format(
						"%s %s is %dyears old.He was born in %d.He was started primary degree in %s on %s and finished on %s.His degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.getEducation().getInstitutionName(),
						formatter.format(this.getEducation().getEnrollmentDate()),
						formatter.format(this.getEducation().getGraduationDate()), this.getEducation().getFinalGrade());
			} else if (this.getEducationCode() == 'M') {
				return String.format(
						"%s %s is %dyears old.He was born in %d.He was started master degree in %s on %s and finished on %s.His degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.getEducation().getInstitutionName(),
						formatter.format(this.getEducation().getEnrollmentDate()),
						formatter.format(this.getEducation().getGraduationDate()), this.getEducation().getFinalGrade());
			} else if (this.getEducationCode() == 'D') {
				return String.format(
						"%s %s is %dyears old.He was born in %d.He was started doctorate degree in %s on %s and finished on %s.His degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.getEducation().getInstitutionName(),
						formatter.format(this.getEducation().getEnrollmentDate()),
						formatter.format(this.getEducation().getGraduationDate()), this.getEducation().getFinalGrade());
			}

		} else {
			if (this.getEducationCode() == 'B') {
				return String.format(
						"%s %s is %dyears old.Shee was born in %d.She was started bachelor degree in %s on %s and finished on %s.Her degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.getEducation().getInstitutionName(),
						formatter.format(this.getEducation().getEnrollmentDate()),
						formatter.format(this.getEducation().getGraduationDate()), this.getEducation().getFinalGrade());
			} else if (this.getEducationCode() == 'S') {
				return String.format(
						"%s %s is %dyears old.She was born in %d.She was started secondary degree in %s on %s and finished on %s.Her degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.getEducation().getInstitutionName(),
						formatter.format(this.getEducation().getEnrollmentDate()),
						formatter.format(this.getEducation().getGraduationDate()), this.getEducation().getFinalGrade());
			} else if (this.getEducationCode() == 'P') {
				return String.format(
						"%s %s is %dyears old.She was born in %d.She was started primary degree in %s on %s and finished on %s.Her degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.getEducation().getInstitutionName(),
						formatter.format(this.getEducation().getEnrollmentDate()),
						formatter.format(this.getEducation().getGraduationDate()), this.getEducation().getFinalGrade());
			} else if (this.getEducationCode() == 'M') {
				return String.format(
						"%s %s is %dyears old.She was born in %d.She was started master degree in %s on %s and finished on %s.Her degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.getEducation().getInstitutionName(),
						formatter.format(this.getEducation().getEnrollmentDate()),
						formatter.format(this.getEducation().getGraduationDate()), this.getEducation().getFinalGrade());
			} else if (this.getEducationCode() == 'D') {
				return String.format(
						"%s %s is %dyears old.She was born in %d.She was started doctorate degree in %s on %s and finished on %s.Her degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.getEducation().getInstitutionName(),
						formatter.format(this.getEducation().getEnrollmentDate()),
						formatter.format(this.getEducation().getGraduationDate()), this.getEducation().getFinalGrade());
			}
		}
		return null;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public LocalDate getYearOfBorn() {
		return yearOfBorn;
	}

	public void setYearOfBorn(String yearOfBorn) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyy");
		this.yearOfBorn = LocalDate.parse(yearOfBorn, formatter);
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public double getGrade1() {
		return grade1;
	}

	public void setGrade1(double grade1) {
		this.grade1 = grade1;
	}

	public double getGrade2() {
		return grade2;
	}

	public void setGrade2(double grade2) {
		this.grade2 = grade2;
	}

	public double getGrade3() {
		return grade3;
	}

	public void setGrade3(double grade3) {
		this.grade3 = grade3;
	}

	public double getGrade4() {
		return grade4;
	}

	public void setGrade4(double grade4) {
		this.grade4 = grade4;
	}

	public char getEducationCode() {
		return educationCode;
	}

	public void setEducationCode(char educationCode) {
		this.educationCode = educationCode;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
