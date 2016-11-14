
public class Teacher {
	private String name;
	private Discipline discipline[];

	public Teacher(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Discipline[] getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		for (int i = 0; i < this.discipline.length; i++) {
			if (this.discipline[i] == null) {
				this.discipline[i] = discipline;
			}
		}
	}
}
