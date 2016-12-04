
public class Teacher {
	private int id;
	private String name;
	private String email;
	
	public Teacher(int id, String name, String email) {
		this.setId(id);
		this.setName(name);;
		this.setEmail(email);;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString(){
		return this.getId()+" "+this.getName()+" "+this.getEmail();
	}
	
}
