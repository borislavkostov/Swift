
public class Discipline {
	private int id;
	private String name;
	public Discipline(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public String toString(){
		return this.getId()+" "+this.getName();
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
	
}
