package education;

public abstract class GradedEducation extends Education{
	private double finalGrade;
	public double gotGraduated(double finalGrade){
		if(this.isGraduated()==true){
			return finalGrade;
		}else{
			return -1;
		}
	}
	public double getFinalGrade(){
		return this.finalGrade;
	}
}
