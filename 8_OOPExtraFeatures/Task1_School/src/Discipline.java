
public class Discipline {
	private String disciplineName;
	private int hoursPerWeek;

	public Discipline(String disciplineName, int hoursPerWeek) {
		this.disciplineName = disciplineName;
		this.hoursPerWeek = hoursPerWeek;
	}

	public String getDisciplineName() {
		return disciplineName;
	}

	public void setDisciplineName(String disciplineName) {
		this.disciplineName = disciplineName;
	}

	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
}
