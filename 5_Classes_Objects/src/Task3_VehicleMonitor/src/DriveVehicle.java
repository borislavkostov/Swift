package Task3_VehicleMonitor.src;

import java.awt.FontFormatException;
import java.util.Scanner;
import java.util.concurrent.ForkJoinTask;

public class DriveVehicle {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		double price = input.nextDouble();
		String line ="";
		Vehicle vh[] = new Vehicle[n];
		input.nextLine();
		for(int i =0;i<vh.length;i++){
			line = input.nextLine();
			vh[i]=Vehicle.lineEnter(line,i);
		}
		for (int i = 0; i < vh.length; i++) {
			System.out.println(vh[i].toString(price));
		}
	}
}
