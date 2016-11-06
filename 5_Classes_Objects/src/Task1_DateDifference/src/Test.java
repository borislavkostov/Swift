package Task1_DateDifference.src;

import java.util.Scanner;

public class Test {
	public static void main(String args[]){
		
		SwiftDate t = new SwiftDate();
		SwiftDate d = new SwiftDate();
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		t=setDate(line);
		String line2 = input.nextLine();
		d=setDate(line2);
		d.printInfo();
		t.printInfo();
		System.out.println(d.getDaysDifference(t));
		
	}
	public static SwiftDate setDate(String line){
		String str[] = line.trim().split(" ");
		SwiftDate d = new SwiftDate();
		d.setDay(Integer.parseInt(str[2]));
		d.setMonth(Integer.parseInt(str[1]));
		d.setYear(Integer.parseInt(str[0]));
		return d;
	}
}
