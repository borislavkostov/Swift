
public class Person {
	private String name;
	private int age;
	public Person(){
		name = "UNKNOWN";
		age = -1;
	}
	public Person(String nameVar){
		name = nameVar;
		age=-1;
	}
	public Person(int ageVar){
		name = "No name";
		age = ageVar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void printPerson(){
		if (age<=0) {
			System.out.printf("Hello, I am %s.%n",name);
		}else{
		System.out.printf("Hello, I am %s. I am %d years old.%n",name,age);
		}
	}
}
