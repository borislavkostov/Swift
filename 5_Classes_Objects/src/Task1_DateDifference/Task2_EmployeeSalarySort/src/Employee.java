package Task1_DateDifference.Task2_EmployeeSalarySort.src;

public class Employee {
	private String name;
	private double salary;
	private String position;
	private String department;
	private int age;
	private String email;
	public Employee(String nameNew,double salaryNew,String positionNew,String departmentNew){
		name = nameNew;
		salary = salaryNew;
		position = positionNew;
		department = departmentNew;
	}
	public Employee(String nameNew,double salaryNew,String positionNew,String departmentNew,int ageNew,String emailNew){
		name = nameNew;
		salary = salaryNew;
		position = positionNew;
		department = departmentNew;
		age = ageNew;
		email = emailNew;
	}
	public Employee(){
		name = null;
		salary = 0;
		position = null;
		department = null;
		age = 0;
		email = null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static Employee lineEnter(String line){
		String str[] = line.trim().split(",");
			Employee em = new Employee();
			if(str.length<5){
				em.setName(str[0]);
				em.setSalary(Double.parseDouble(str[1]));
				em.setPosition(str[2]);
				em.setDepartment(str[3]);
			}else if(str.length==6){
				em.setName(str[0]);
				em.setSalary(Double.parseDouble(str[1]));
				em.setPosition(str[2]);
				em.setDepartment(str[3]);
				em.setAge(Integer.parseInt(str[4]));
				em.setEmail(str[5]);
			}else{
				System.out.println("Max words are 6 ");
			}
			return em;
	}
	public String toString(){
		return this.getName()+" "+this.getSalary()+" "+this.getPosition();
	}
	
}
