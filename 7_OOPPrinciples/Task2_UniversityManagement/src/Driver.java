import java.util.Scanner;

public class Driver {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String line = "";
		int counter = 0;
		Person pr[] = new Person[100];
		for (;;) {
			line = input.nextLine();
			String[] str = line.trim().split(" ");
			if (!str[0].equals("END")) {
				if (University.getBalance() >= 0) {
					if (!str[0].equals("IDLE")) {
						if (!str[0].equals("WORK")) {
							if (str[0].equals("NEW")) {
								while (true) {
									if (!str[1].equals("")) {
										counter++;
										pr[counter] = lineReader(str, pr);
										break;
									} else {
										break;
									}
								}
							}
						} else {// This is for work
							for (int j = 0; j < pr.length; j++) {
								if (pr[j] != null) {
									if (pr[j].getFirstName().equals(str[1])) {
										pr[j].work(pr);
									}
								} else {
									break;
								}
							}
						}
					} else {// THIS is for IDLE
						for (int j = 0; j < pr.length; j++) {
							if (pr[j] != null) {
								if (pr[j].getTolerance() >= 0) {
									pr[j].setTolerance(pr[j].getTolerance() - 5);
								} else {
									System.out.println(pr[j].getFirstName() + "Is not happy");
								}
							} else {
								break;
							}
						}
					}
				} else {// This is for university
					System.out.println("Bankrupcy");
					break;
				}
			} else {
				break;
			}
		}

	}

	public static Person lineReader(String[] str, Person[] pe) {
		if (str[1].equals("STUD")) {
			Person pr = new Student(str[2], str[3]);
			return pr;
		} else if (str[1].equals("MAINT")) {
			Person pr = new MaintenanceEmployee(str[2], str[3]);
			return pr;
		} else if (str[1].equals("TEACH")) {
			Person pr = new Teacher(str[2], str[3]);
			return pr;
		} else if (str[1].equals("ADMIN")) {
			Person pr = new AdministrationEmployee(str[2], str[3]);
			return pr;
		}
		return null;
	}
}
