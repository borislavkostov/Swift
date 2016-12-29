
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;
import personaldetails.Citizen;
import personaldetails.Gender;
import education.Education;
import address.Address;
import education.EducationDegree;
import education.GradedEducation;
import education.HigherEducation;
import education.PrimaryEducation;
import insurance.SocialInsuranceRecord;
import java.time.LocalTime;

public class trash {

    public static void main(String args[]) throws FileNotFoundException {
        Scanner input = new Scanner(new File("in.txt"));
        //input.useDelimiter("\\n");
        while (input.hasNext()) {
            System.out.println(LocalTime.now());
            System.out.println(enterPerson(input).toString());
            System.out.println(LocalTime.now());
        }
    }

    public static Citizen enterPerson(Scanner input) {
        input.useDelimiter("\\n");
        Citizen person;
        String[] info = input.next().split(";", -1);
        String[] insurance = input.next().split(";");
        String firstName = info[0];
        String middleName = info[1];
        String lastName = info[2];
        char gender = info[3].charAt(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");//we are using this formatter for date of birth
        LocalDate dateOfBirth = LocalDate.parse(info[4], formatter);
        int height = Integer.parseInt(info[5]);
        if (gender == 'F') {
            person = new Citizen(firstName, middleName, lastName, Gender.Female, height, dateOfBirth);
        } else {
            person = new Citizen(firstName, middleName, lastName, Gender.Male, height, dateOfBirth);
        }
        person.setAddress(enterAddress(info));
        //person.addEducation(enterEducation(info));
        Education edu = null;
        for (int i = 14; i < info.length; i++) {

            if (info[i].equals("P")) {
                String institutionName = info[++i];
                LocalDate enrollmentDate = LocalDate.parse(info[++i], formatter);
                LocalDate graduationDate = LocalDate.parse(info[++i], formatter);
                edu = new PrimaryEducation(institutionName, enrollmentDate, graduationDate);
            } else if (info[i].equals("B")) {
                String institutionName = info[++i];
                LocalDate enrollmentDate = LocalDate.parse(info[++i], formatter);
                LocalDate graduationDate = LocalDate.parse(info[++i], formatter);
                edu = new HigherEducation(institutionName, enrollmentDate, graduationDate, EducationDegree.Bachelor);
                if (graduationDate.isBefore(LocalDate.now())) {
                    i++;
                }
            } else if (info[i].equals("M")) {
                String institutionName = info[++i];
                LocalDate enrollmentDate = LocalDate.parse(info[++i], formatter);
                LocalDate graduationDate = LocalDate.parse(info[++i], formatter);
                edu = new HigherEducation(institutionName, enrollmentDate, graduationDate, EducationDegree.Master);
                if (graduationDate.isBefore(LocalDate.now())) {
                    i++;
                }
            } else {
                String institutionName = info[++i];
                LocalDate enrollmentDate = LocalDate.parse(info[++i], formatter);
                LocalDate graduationDate = LocalDate.parse(info[++i], formatter);
                edu = new HigherEducation(institutionName, enrollmentDate, graduationDate, EducationDegree.Doctorate);
                if (graduationDate.isBefore(LocalDate.now())) {
                    i++;
                }
            }
            person.addEducation(edu);//Here we are adding Education in person
        }
        for (int i = 0; i < insurance.length; i++) {
            int year =  Integer.parseInt(insurance[i]);
            int month = Integer.parseInt(insurance[++i]);
            double amount = Double.parseDouble(insurance[++i]);
            SocialInsuranceRecord soc = new SocialInsuranceRecord(year,month,amount);
            person.addSocialInsuranceRecord(soc);
            
        }
        return person;
    }

    public static Address enterAddress(String[] info) {
        Address adr;
        String country = info[6];
        String city = info[7];
        String municipality = info[8];
        String postalCode = info[9];
        String street = info[10];
        String number = info[11];
        if (!info[12].equals("")) {
            int floor = Integer.parseInt(info[12]);
            int apartmentNo = Integer.parseInt(info[13]);
            adr = new Address(country, city, municipality, postalCode, street, number, floor, apartmentNo);
        } else {
            adr = new Address(country, city, municipality, postalCode, street, number);
        }
        return adr;
    }


}
