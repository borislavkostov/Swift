
public class Person {
	private String firstName;
	private String lastName;	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if(firstName.length()<2||firstName.length()>30){
			System.out.printf("Expected length for %s isbetween 2 and 30 symbols.%n",firstName);
		}else{
			this.firstName = firstName;
		}
	}
	public String getLastName() {
			return lastName;
	}
	public void setLastName(String lastName) {
		if(firstName.length()<2||firstName.length()>30){
			System.out.printf("Expected length for %s isbetween 2 and 30 symbols.%n",firstName);
		}else{
		this.lastName = lastName;
		}
	}
}
