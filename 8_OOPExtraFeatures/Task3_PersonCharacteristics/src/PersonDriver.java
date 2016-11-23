import java.time.LocalDate;
import java.util.Scanner;

import education.Education;
import education.HigherEducation;
import education.Primary;
import education.Secondary;

public class PersonDriver {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		String line = "";
		Person pr[] = new Person[n];
		for (int i = 0; i < pr.length; i++) {
			line = input.nextLine();
			// pr[i] = new Person();
			pr[i] = lineReader(line);
		}
		for (int i = 0; i < pr.length; i++) {
			System.out.println(pr[i].toString());
		}
	}

	public static Person lineReader(String line) {
		String st[] = line.trim().split(";");
		Education ed;
		Address adr;
		Person pr = new Person(st[0], st[1], st[2], st[3].charAt(0), st[4], Integer.parseInt(st[5]), st[14].charAt(0));
		adr = new Address(st[6], st[7], st[8], st[9], st[10], Integer.parseInt(st[11]), st[12], st[13]);
		if (pr.getEducationCode() == 'P') {
			ed = new Primary(st[15], st[16], st[17]);
		} else if (pr.getEducationCode() == 'S') {
			ed = new Primary(st[15], st[16], st[17]);
			if (ed.getGraduationDate().isBefore(LocalDate.now())) {
				ed.setGraduated(true);
				ed.setFinalGrade(Double.parseDouble(st[18]));
			}
			pr.setEducation(ed);
		} else if (pr.getEducationCode() == 'B' || pr.getEducationCode() == 'D' || pr.getEducationCode() == 'M') {
			ed = new Primary(st[15], st[16], st[17]);
			if (ed.getGraduationDate().isBefore(LocalDate.now())) {
				ed.setGraduated(true);
				ed.setFinalGrade(Double.parseDouble(st[18]));
			}
			pr.setEducation(ed);
		}
		return pr;

	}
}
