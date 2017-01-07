package citizenstoragemanagercli;

import Exception.DALException;
import address.Address;
import MySQL.MySQLPersonStorage;
import MySQL.MySQLRemoveDB;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import personaldetails.Citizen;
import personaldetails.Gender;
import education.*;
import insurance.SocialInsuranceRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CitizenStorageManagerCLI {

    public static void main(String[] args) throws FileNotFoundException, DALException {
        String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/PersonCharacteristicsDB?useUnicode=true&characterEncoding=UTF-8";
        String DBMS_USERNAME = "root";
        String DBMS_PASSWORD = "173173";
        MySQLRemoveDB db = new MySQLRemoveDB(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        db.removeDataFromDB();
        MySQLPersonStorage personStorage = new MySQLPersonStorage(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        Scanner input = new Scanner(new File("in.txt"));
        int recordsMax = input.nextInt();

        for (int i = 0; i < recordsMax; i++) {
            Citizen citizen = parseCitizen(input);
            int id = personStorage.enterPerson(citizen);
            System.out.println(id);
        }

    }

    public static Citizen parseCitizen(Scanner input) {
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
            } else if (info[i].equals("D")) {
                String institutionName = info[++i];
                LocalDate enrollmentDate = LocalDate.parse(info[++i], formatter);
                LocalDate graduationDate = LocalDate.parse(info[++i], formatter);
                edu = new HigherEducation(institutionName, enrollmentDate, graduationDate, EducationDegree.Doctorate);
                if (graduationDate.isBefore(LocalDate.now())) {
                    i++;
                }
            } else if (info[i].equals("S")) {
                String institutionName = info[++i];
                LocalDate enrollmentDate = LocalDate.parse(info[++i], formatter);
                LocalDate graduationDate = LocalDate.parse(info[++i], formatter);
                edu = new SecondaryEducation(institutionName, enrollmentDate, graduationDate);
                if (graduationDate.isBefore(LocalDate.now())) {
                    i++;
                }
            }
            person.addEducation(edu);//Here we are adding Education in person
        }
        for (int i = 0; i < insurance.length; i++) {
            int year = Integer.parseInt(insurance[i]);
            int month = Integer.parseInt(insurance[++i]);
            double amount = Double.parseDouble(insurance[++i]);
            SocialInsuranceRecord soc = new SocialInsuranceRecord(year, month, amount);
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
