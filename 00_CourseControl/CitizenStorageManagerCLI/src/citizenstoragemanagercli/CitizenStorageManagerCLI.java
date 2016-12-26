package citizenstoragemanagercli;

import MySQL.MySqlAddressStorage;
import java.sql.SQLException;
import address.Address;
import MySQL.MySQLPersonStorage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import personaldetails.Citizen;
import personaldetails.Gender;
import education.*;
import java.util.ArrayList;
import java.util.List;
public class CitizenStorageManagerCLI {

    public static void main(String[] args) throws SQLException {
        MySqlAddressStorage adr = new MySqlAddressStorage();
        //adr.setCountry("USA");
        //System.out.println(adr.setCountry("USA"));
//        Address adres = new Address("Bulgaria","Ivanovgrad","Varna","1750","jerusalim","3",2,1);
//        adr.insertAddress(adres);
//        Address adresa = new Address("USA","Wachington","Sofia-grad","1780","blok","222");
//        adr.insertSmallAddress(adresa);
        MySQLPersonStorage personStorage = new MySQLPersonStorage();
        DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
        LocalDate date = LocalDate.parse("13.03.1973", germanFormatter);
        Citizen person = new Citizen("Petar", "Borisov", "Kostov", Gender.Male, 198, date);
        Address adres = new Address("Bulgaria", "Sofia", "Sofia-grad", "1780", "jerusalim", "13", 4, 22);
        person.setAddress(adres);
        List<Education> education= new ArrayList<>();
        Education edu = new SecondaryEducation("PGTK",LocalDate.parse("13.09.2000", germanFormatter),LocalDate.parse("24.05.2005", germanFormatter));
        edu.isGraduated();
        Education edu1 = new HigherEducation("UNWE",LocalDate.parse("15.09.2005", germanFormatter),LocalDate.parse("20.05.2011", germanFormatter),EducationDegree.Bachelor);
        person.addEducation(edu1);
        person.addEducation(edu);
        personStorage.enterPerson(person);

    }

}
