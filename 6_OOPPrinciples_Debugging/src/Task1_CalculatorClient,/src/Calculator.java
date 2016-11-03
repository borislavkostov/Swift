import java.util.Scanner;

public class Calculator {
	private double a;
	private double b;
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double sum(){
		return this.getA()+this.getB();
	}
	public double subtract(){
		return this.getA()-this.getB();
	}
	public double multiply(){
		return this.getA()*this.getB();
	}
	public double divide(){
		return this.getA()/this.getB();
	}
	public double percentage(){
		return this.getA()%this.getB();
	}
	public void toString(Scanner input){
		String line = "";
		for (;;) {
			line=input.nextLine();
			String st[] = line.trim().split(" ");
			if(st[0].equals("SUM")){
				this.setA(Double.parseDouble(st[1]));
				this.setB(Double.parseDouble(st[2]));
				System.out.printf("%.3f%n",this.sum());
			}else if(st[0].equals("MUL")){
				this.setA(Double.parseDouble(st[1]));
				this.setB(Double.parseDouble(st[2]));
				System.out.printf("%.3f%n",this.multiply());
			}else if(st[0].equals("SUB")){
				this.setA(Double.parseDouble(st[1]));
				this.setB(Double.parseDouble(st[2]));
				System.out.printf("%.3f%n",this.subtract());
			}else if(st[0].equals("DIV")){
				this.setA(Double.parseDouble(st[1]));
				this.setB(Double.parseDouble(st[2]));
				System.out.printf("%.3f%n",this.divide());
			}else if(st[0].equals("PER")){
				this.setA(Double.parseDouble(st[1]));
				this.setB(Double.parseDouble(st[2]));
				System.out.printf("%.3f%n",this.percentage());
			}else if(st[0].equals("END")){
				break;
			}
		}
		
	}
}
