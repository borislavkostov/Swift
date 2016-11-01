package Task1_DateDifference.src;

public class Test {
	public static void main(String args[]){
		SwiftDate d = new SwiftDate();
		SwiftDate t = new SwiftDate();
		d.setDay(26);
		d.setMonth(9);
		d.setYear(2016);
		t.setDay(3);
		t.setMonth(3);
		t.setYear(1878);
		System.out.println(t.getDaysDifference(d));
		d.printInfo();
		t.printInfo();
	}
}
