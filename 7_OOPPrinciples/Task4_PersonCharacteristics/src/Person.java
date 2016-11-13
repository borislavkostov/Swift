import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.omg.Messaging.SyncScopeHelper;

import education.SecondaryEducation;

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
	private SecondaryEducation secondaryEducation;

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

	public Person lineReader(String line) {
		String st[] = line.trim().split(";");
		this.setFirstName(st[0]);
		this.setLastName(st[1]);
		this.setGender(st[2].charAt(0));
		this.setHeight(Integer.parseInt(st[3]));
		this.setYearOfBorn(st[4]);

		if (st.length == 9) {
			this.secondaryEducation = new SecondaryEducation(st[5], st[6], st[7], Double.parseDouble(st[8]));
		} else {
			this.secondaryEducation = new SecondaryEducation(st[5], st[6], st[7]);
		}
		return this;
	}

	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyy");
			/*return String.format(
					"%s %s is %d years old.He was born in  %s.He is %dcm tall.He started %s on %d and finished on %d",
					this.getFirstName(), this.getLastName(),
					this.getYearOfBorn().getYear() - Calendar.getInstance().get(Calendar.YEAR), formatter.format(this.getYearOfBorn()),
					this.getWeight(), this.getHeight(), this.secondaryEducation.getInstitutionName(),
					this.secondaryEducation.getEnrollmentDate(), this.secondaryEducation.getGraduationDate());
	*/
		return String.format("%d %s", Calendar.getInstance().get(Calendar.YEAR)-this.getYearOfBorn().getYear(),formatter.format(this.getYearOfBorn()));
	}
}
