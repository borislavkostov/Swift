package Task1_DateDifference.Task2_EmployeeSalarySort.src;

import java.util.Arrays;
import java.util.Scanner;

public class DriverEmployee {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();// This need to be here because there is problem to
							// read next line on my next String
		Employee[] employee = new Employee[n];
		for (int i = 0; i < n; i++) {
			String line = input.nextLine();
			employee[i] = Employee.lineEnter(line);
		}
		Employee.sortArray(employee);
		for (int i = 0; i < 3; i++) {
			System.out.println(employee[i].toString());
		}

	}
}
