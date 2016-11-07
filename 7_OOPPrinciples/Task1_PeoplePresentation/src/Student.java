
public class Student extends Person {
	private String facultyNumber;
	private int lectureCount;
	private int exerciseCount;

	public Student(String fName, String lName, String facultyNumber, int lectureCount, int exerciseCount) {
		super(fName, lName);
		facultyNumber = facultyNumber;
		lectureCount = lectureCount;
		exerciseCount = exerciseCount;
	}
	public Student() {
		super("Unknown", "UNKNOWN");
		facultyNumber = "";
		lectureCount = 0;
		exerciseCount = 0;
	}
	@Override
	public String toString(){
		return String.format("First name:%s%nLast name:%s%nOccupation:Student%nFaculty number:%s%n",this.getFirstName(),this.getLastName(),this.getFacultyNumber());
	}
	public String getFacultyNumber() {
		return facultyNumber;
	}

	public void setFacultyNumber(String facultyNumber) {
		if(facultyNumber.length()<=5||facultyNumber.length()>=10){
			System.out.println("Expected length for faculty number is between 5 and 10 symbols.");
		}else{
			this.facultyNumber = facultyNumber;
		}	
	}

	public int getLectureCount() {
		return lectureCount;
	}

	public void setLectureCount(int lectureCount) {
		if(lectureCount<0){
			System.out.println("Expected positive number");
		}else{
		this.lectureCount = lectureCount;
		}
	}

	public int getExerciseCount() {
		return exerciseCount;
	}

	public void setExerciseCount(int exerciseCount) {
		if(exerciseCount<0){
			System.out.println("Expected positive number");
		}else{
		this.exerciseCount = exerciseCount;
		}
	}
	
}
