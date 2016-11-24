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
				if (this.getAddress().getFloor().equals("")) {
					return String.format(
							"%s %s %s is %d years old. He was born in %s.%nHe lives at:%n%d %s Street%n%s %s%n%s %s%nHe was started bachelor degree in %s on %s and finished on %s.His grade was %.2f",
							this.getFirstName(), this.getMiddleName(), this.getLastName(),
							Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
							this.getYearOfBorn().getYear(), this.getAddress().getNumber(),
							this.getAddress().getStreet(), this.getAddress().getPostalCode(),
							this.getAddress().getMunicipality(), this.getAddress().getCity(),
							this.getAddress().getCountry(), this.getEducation().getInstitutionName(),
							formatter.format(this.getEducation().getEnrollmentDate()),
							formatter.format(this.getEducation().getGraduationDate()),
							this.getEducation().getFinalGrade());
				} else if (!this.getAddress().getFloor().equals("")) {
					return String.format(
							"%s %s %s is %d years old. He was born in %s.%nHe lives at:%n%d %s Street%nfl. %s ,ap. %s%n%s %s%n%s %s%nHe was started bachelor degree in %s on %s and finished on %s.His grade was %.2f",
							this.getFirstName(), this.getMiddleName(), this.getLastName(),
							Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
							this.getYearOfBorn().getYear(), this.getAddress().getNumber(),
							this.getAddress().getStreet(), this.getAddress().getFloor(),
							this.getAddress().getApartmentNO(), this.getAddress().getPostalCode(),
							this.getAddress().getMunicipality(), this.getAddress().getCity(),
							this.getAddress().getCountry(), this.getEducation().getInstitutionName(),
							formatter.format(this.getEducation().getEnrollmentDate()),
							formatter.format(this.getEducation().getGraduationDate()),
							this.getEducation().getFinalGrade());
				}
			} else if (this.getEducationCode() == 'M') {
				if (this.getAddress().getFloor().equals("")) {
					return String.format(
							"%s %s %s is %d years old. He was born in %s.%nHe lives at:%n%d %s Street%n%s %s%n%s %s%nHe was started master degree in %s on %s and finished on %s.His grade was %.2f",
							this.getFirstName(), this.getMiddleName(), this.getLastName(),
							Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
							this.getYearOfBorn().getYear(), this.getAddress().getNumber(),
							this.getAddress().getStreet(), this.getAddress().getPostalCode(),
							this.getAddress().getMunicipality(), this.getAddress().getCity(),
							this.getAddress().getCountry(), this.getEducation().getInstitutionName(),
							formatter.format(this.getEducation().getEnrollmentDate()),
							formatter.format(this.getEducation().getGraduationDate()),
							this.getEducation().getFinalGrade());
				} else if (!this.getAddress().getFloor().equals("")) {
					return String.format(
							"%s %s %s is %d years old. He was born in %s.%nHe lives at:%n%d %s Street%nfl. %s ,ap. %s%n%s %s%n%s %s%nHe was started master degree in %s on %s and finished on %s.His grade was %.2f",
							this.getFirstName(), this.getMiddleName(), this.getLastName(),
							Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
							this.getYearOfBorn().getYear(), this.getAddress().getNumber(),
							this.getAddress().getStreet(), this.getAddress().getFloor(),
							this.getAddress().getApartmentNO(), this.getAddress().getPostalCode(),
							this.getAddress().getMunicipality(), this.getAddress().getCity(),
							this.getAddress().getCountry(), this.getEducation().getInstitutionName(),
							formatter.format(this.getEducation().getEnrollmentDate()),
							formatter.format(this.getEducation().getGraduationDate()),
							this.getEducation().getFinalGrade());
				}
			} else if (this.getEducationCode() == 'S') {
				if (this.getAddress().getFloor().equals("")) {
					return String.format(
							"%s %s %s is %d years old. He was born in %s.%nHe lives at:%n%d %s Street%n%s %s%n%s %s%nHe was started secondary degree in %s on %s and finished on %s.His grade was %.2f",
							this.getFirstName(), this.getMiddleName(), this.getLastName(),
							Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
							this.getYearOfBorn().getYear(), this.getAddress().getNumber(),
							this.getAddress().getStreet(), this.getAddress().getPostalCode(),
							this.getAddress().getMunicipality(), this.getAddress().getCity(),
							this.getAddress().getCountry(), this.getEducation().getInstitutionName(),
							formatter.format(this.getEducation().getEnrollmentDate()),
							formatter.format(this.getEducation().getGraduationDate()),
							this.getEducation().getFinalGrade());
				} else if (!this.getAddress().getFloor().equals("")) {
					return String.format(
							"%s %s %s is %d years old. He was born in %s.%nHe lives at:%n%d %s Street%nfl. %s ,ap. %s%n%s %s%n%s %s%nHe was started secondary degree in %s on %s and finished on %s.His grade was %.2f",
							this.getFirstName(), this.getMiddleName(), this.getLastName(),
							Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
							this.getYearOfBorn().getYear(), this.getAddress().getNumber(),
							this.getAddress().getStreet(), this.getAddress().getFloor(),
							this.getAddress().getApartmentNO(), this.getAddress().getPostalCode(),
							this.getAddress().getMunicipality(), this.getAddress().getCity(),
							this.getAddress().getCountry(), this.getEducation().getInstitutionName(),
							formatter.format(this.getEducation().getEnrollmentDate()),
							formatter.format(this.getEducation().getGraduationDate()),
							this.getEducation().getFinalGrade());
				}
			}
		} else if (this.getGender() == 'F') {
			if (this.getEducationCode() == 'B') {
				if (this.getAddress().getFloor().equals("")) {
					return String.format(
							"%s %s %s is %d years old. She was born in %s.%nShe lives at:%n%d %s Street%n%s %s%n%s %s%nShe was started bachelor degree in %s on %s and finished on %s.Her grade was %.2f",
							this.getFirstName(), this.getMiddleName(), this.getLastName(),
							Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
							this.getYearOfBorn().getYear(), this.getAddress().getNumber(),
							this.getAddress().getStreet(), this.getAddress().getPostalCode(),
							this.getAddress().getMunicipality(), this.getAddress().getCity(),
							this.getAddress().getCountry(), this.getEducation().getInstitutionName(),
							formatter.format(this.getEducation().getEnrollmentDate()),
							formatter.format(this.getEducation().getGraduationDate()),
							this.getEducation().getFinalGrade());
				} else if (!this.getAddress().getFloor().equals("")) {
					return String.format(
							"%s %s %s is %d years old. She was born in %s.%nShe lives at:%n%d %s Street%nfl. %s ,ap. %s%n%s %s%n%s %s%nShe was started bachelor degree in %s on %s and finished on %s.Her grade was %.2f",
							this.getFirstName(), this.getMiddleName(), this.getLastName(),
							Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
							this.getYearOfBorn().getYear(), this.getAddress().getNumber(),
							this.getAddress().getStreet(), this.getAddress().getFloor(),
							this.getAddress().getApartmentNO(), this.getAddress().getPostalCode(),
							this.getAddress().getMunicipality(), this.getAddress().getCity(),
							this.getAddress().getCountry(), this.getEducation().getInstitutionName(),
							formatter.format(this.getEducation().getEnrollmentDate()),
							formatter.format(this.getEducation().getGraduationDate()),
							this.getEducation().getFinalGrade());
				}
			} else if (this.getEducationCode() == 'M') {
				if (this.getAddress().getFloor().equals("")) {
					return String.format(
							"%s %s %s is %d years old. She was born in %s.%nShe lives at:%n%d %s Street%n%s %s%n%s %s%nShe was started master degree in %s on %s and finished on %s.Her grade was %.2f",
							this.getFirstName(), this.getMiddleName(), this.getLastName(),
							Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
							this.getYearOfBorn().getYear(), this.getAddress().getNumber(),
							this.getAddress().getStreet(), this.getAddress().getPostalCode(),
							this.getAddress().getMunicipality(), this.getAddress().getCity(),
							this.getAddress().getCountry(), this.getEducation().getInstitutionName(),
							formatter.format(this.getEducation().getEnrollmentDate()),
							formatter.format(this.getEducation().getGraduationDate()),
							this.getEducation().getFinalGrade());
				} else if (!this.getAddress().getFloor().equals("")) {
					return String.format(
							"%s %s %s is %d years old. She was born in %s.%nShe lives at:%n%d %s Street%nfl. %s ,ap. %s%n%s %s%n%s %s%nShe was started master degree in %s on %s and finished on %s.Her grade was %.2f",
							this.getFirstName(), this.getMiddleName(), this.getLastName(),
							Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
							this.getYearOfBorn().getYear(), this.getAddress().getNumber(),
							this.getAddress().getStreet(), this.getAddress().getFloor(),
							this.getAddress().getApartmentNO(), this.getAddress().getPostalCode(),
							this.getAddress().getMunicipality(), this.getAddress().getCity(),
							this.getAddress().getCountry(), this.getEducation().getInstitutionName(),
							formatter.format(this.getEducation().getEnrollmentDate()),
							formatter.format(this.getEducation().getGraduationDate()),
							this.getEducation().getFinalGrade());
				}
			} else if (this.getEducationCode() == 'S') {
				if (this.getAddress().getFloor().equals("")) {
					return String.format(
							"%s %s %s is %d years old. She was born in %s.%nShe lives at:%n%d %s Street%n%s %s%n%s %s%nShe was started secondary degree in %s on %s and finished on %s.Her grade was %.2f",
							this.getFirstName(), this.getMiddleName(), this.getLastName(),
							Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
							this.getYearOfBorn().getYear(), this.getAddress().getNumber(),
							this.getAddress().getStreet(), this.getAddress().getPostalCode(),
							this.getAddress().getMunicipality(), this.getAddress().getCity(),
							this.getAddress().getCountry(), this.getEducation().getInstitutionName(),
							formatter.format(this.getEducation().getEnrollmentDate()),
							formatter.format(this.getEducation().getGraduationDate()),
							this.getEducation().getFinalGrade());
				} else if (!this.getAddress().getFloor().equals("")) {
					return String.format(
							"%s %s %s is %d years old. She was born in %s.%nShe lives at:%n%d %s Street%nfl. %s ,ap. %s%n%s %s%n%s %s%nShe was started secondary degree in %s on %s and finished on %s.Her grade was %.2f",
							this.getFirstName(), this.getMiddleName(), this.getLastName(),
							Calendar.getInstance().get(Calendar.YEAR) - this.getYearOfBorn().getYear(),
							this.getYearOfBorn().getYear(), this.getAddress().getNumber(),
							this.getAddress().getStreet(), this.getAddress().getFloor(),
							this.getAddress().getApartmentNO(), this.getAddress().getPostalCode(),
							this.getAddress().getMunicipality(), this.getAddress().getCity(),
							this.getAddress().getCountry(), this.getEducation().getInstitutionName(),
							formatter.format(this.getEducation().getEnrollmentDate()),
							formatter.format(this.getEducation().getGraduationDate()),
							this.getEducation().getFinalGrade());
				}
			}
		}
		return firstName;

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
