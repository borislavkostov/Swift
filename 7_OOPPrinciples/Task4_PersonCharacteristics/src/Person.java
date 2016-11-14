import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import education.Education;

public class Person {
	private String firstName;
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
	private EducationDriver education;// We are using Education driver because
										// we can't initialise abstract class
										// because they don't have constructors
	private char educationCode;

	public Person lineReader(String line) {
		String st[] = line.trim().split(";");
		this.education = new EducationDriver();
		this.setFirstName(st[0]);
		this.setLastName(st[1]);
		this.setGender(st[2].charAt(0));
		this.setHeight(Integer.parseInt(st[3]));
		this.setYearOfBorn(st[4]);
		this.setEducationCode(st[5].charAt(0));
		this.education.setInstitutionName(st[6]);
		this.education.setEnrollmentDate(st[7]);
		this.education.setGraduationDate(st[8]);
		if (this.education.getGraduationDate().isBefore(LocalDate.now())) {
			this.education.setGraduated(true);
		} else {
			this.education.setGraduated(false);
		}
		if (this.education.isGraduated()) {
			this.education.setFinalGrade(Double.parseDouble(st[9]));
		}
		return this;
	}

	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyy");
		if (this.getGender() == 'M') {
			if (this.getEducationCode() == 'B') {
				return String.format(
						"%s %s is %dyears old.He was born in %d.He was started bachelor degree in %s on %s and finished on %s.His degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.education.getInstitutionName(),
						formatter.format(this.education.getEnrollmentDate()),
						formatter.format(this.education.getGraduationDate()), this.education.getFinalGrade());
			} else if (this.getEducationCode() == 'S') {
				return String.format(
						"%s %s is %dyears old.He was born in %d.He was started secondary degree in %s on %s and finished on %s.His degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.education.getInstitutionName(),
						formatter.format(this.education.getEnrollmentDate()),
						formatter.format(this.education.getGraduationDate()), this.education.getFinalGrade());
			} else if (this.getEducationCode() == 'P') {
				return String.format(
						"%s %s is %dyears old.He was born in %d.He was started primary degree in %s on %s and finished on %s.His degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.education.getInstitutionName(),
						formatter.format(this.education.getEnrollmentDate()),
						formatter.format(this.education.getGraduationDate()), this.education.getFinalGrade());
			} else if (this.getEducationCode() == 'M') {
				return String.format(
						"%s %s is %dyears old.He was born in %d.He was started master degree in %s on %s and finished on %s.His degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.education.getInstitutionName(),
						formatter.format(this.education.getEnrollmentDate()),
						formatter.format(this.education.getGraduationDate()), this.education.getFinalGrade());
			} else if (this.getEducationCode() == 'D') {
				return String.format(
						"%s %s is %dyears old.He was born in %d.He was started doctorate degree in %s on %s and finished on %s.His degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.education.getInstitutionName(),
						formatter.format(this.education.getEnrollmentDate()),
						formatter.format(this.education.getGraduationDate()), this.education.getFinalGrade());
			}

		} else {
			if (this.getEducationCode() == 'B') {
				return String.format(
						"%s %s is %dyears old.Shee was born in %d.She was started bachelor degree in %s on %s and finished on %s.Her degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.education.getInstitutionName(),
						formatter.format(this.education.getEnrollmentDate()),
						formatter.format(this.education.getGraduationDate()), this.education.getFinalGrade());
			} else if (this.getEducationCode() == 'S') {
				return String.format(
						"%s %s is %dyears old.She was born in %d.She was started secondary degree in %s on %s and finished on %s.Her degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.education.getInstitutionName(),
						formatter.format(this.education.getEnrollmentDate()),
						formatter.format(this.education.getGraduationDate()), this.education.getFinalGrade());
			} else if (this.getEducationCode() == 'P') {
				return String.format(
						"%s %s is %dyears old.She was born in %d.She was started primary degree in %s on %s and finished on %s.Her degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.education.getInstitutionName(),
						formatter.format(this.education.getEnrollmentDate()),
						formatter.format(this.education.getGraduationDate()), this.education.getFinalGrade());
			} else if (this.getEducationCode() == 'M') {
				return String.format(
						"%s %s is %dyears old.She was born in %d.She was started master degree in %s on %s and finished on %s.Her degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.education.getInstitutionName(),
						formatter.format(this.education.getEnrollmentDate()),
						formatter.format(this.education.getGraduationDate()), this.education.getFinalGrade());
			} else if (this.getEducationCode() == 'D') {
				return String.format(
						"%s %s is %dyears old.She was born in %d.She was started doctorate degree in %s on %s and finished on %s.Her degree was %.2f",
						this.getFirstName(), this.getLastName(),
						Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
						this.getYearOfBorn().getYear(), this.education.getInstitutionName(),
						formatter.format(this.education.getEnrollmentDate()),
						formatter.format(this.education.getGraduationDate()), this.education.getFinalGrade());
			}
		}
		return null;
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
}
