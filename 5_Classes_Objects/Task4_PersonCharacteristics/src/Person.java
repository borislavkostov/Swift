import java.util.Calendar;
import java.util.Scanner;

public class Person {
	private String firstName;
	private String lastName;
	private char gender;
	private int yearOfBorn;
	private double weight;
	private int height;
	private String profession;
	private double grade1;
	private double grade2;
	private double grade3;
	private double grade4;
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
	public int getYearOfBorn() {
		return yearOfBorn;
	}
	public void setYearOfBorn(int yearOfBorn) {
		this.yearOfBorn = yearOfBorn;
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
		String st[] = line.trim().split(",");
		this.setFirstName(st[0]);
		this.setLastName(st[1]);
		this.setGender(st[2].charAt(0));
		this.setYearOfBorn(Integer.parseInt(st[3]));
		this.setWeight(Double.parseDouble(st[4]));
		this.setHeight(Integer.parseInt(st[5]));
		this.setProfession(st[6]);
		this.setGrade1(Double.parseDouble(st[7]));
		this.setGrade2(Double.parseDouble(st[8]));
		this.setGrade3(Double.parseDouble(st[9]));
		this.setGrade4(Double.parseDouble(st[10]));
		return this;
	}
	public String toString(){
		int years = Calendar.getInstance().get(Calendar.YEAR)-this.getYearOfBorn();
		double grade = (this.getGrade1()+this.getGrade2()+this.getGrade3()+this.getGrade4())/4;
		if(years>18){
		return String.format("%s %s is %d years old.He was born in  %d.His weight is %.2f and he is %dcm tall.He is a %s with an average grade of %.3f.",this.getFirstName(),this.getLastName(),years,
				this.getYearOfBorn(),this.getWeight(),this.getHeight(),this.getProfession(),grade);
		}else{
			return String.format("%s %s is %d years old.He was born in  %d.His weight is %.2f and he is %dcm tall.He is a %s with an average grade of %.3f.%s %s is under-aged.",this.getFirstName(),this.getLastName(),years,
					this.getYearOfBorn(),this.getWeight(),this.getHeight(),this.getProfession(),grade,this.getFirstName(),this.getLastName());
		}
	}
}
