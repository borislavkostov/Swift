package MySQL;

import contracts.PersonStorage;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import personaldetails.Citizen;
import personaldetails.Gender;
import address.Address;
import education.Education;
import insurance.SocialInsuranceRecord;

public class MySQLPersonStorage implements PersonStorage {

    final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/PersonCharacteristicsDB";
    final String DBMS_USERNAME = "root";
    final String DBMS_PASSWORD = "173173";

    @Override
    public int enterPerson(Citizen person) throws SQLException {
        MySqlAddressStorage adr = new MySqlAddressStorage();
        MySQLEducationStorage edu = new MySQLEducationStorage();
        MySQLSocialInsuranceStorage ins = new MySQLSocialInsuranceStorage();
        Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        try (CallableStatement statement = conn.prepareCall("{call enter_person(?,?,?,?,?,?,?)}")) {
            statement.setString("new_first_name", person.getFirstName());
            statement.setString("new_middle_name", person.getMiddleName());
            statement.setString("new_last_name", person.getLastName());
            if (person.getGender() == Gender.Male) {
                statement.setString("new_gender", "Male");
            } else {
                statement.setString("new_gender", "Female");
            }
            statement.setInt("new_height", person.getHeight());
            statement.setDate("new_date_ofbirt", (Date.valueOf(person.getDateOfBirth())));
            statement.registerOutParameter("new_id", Types.INTEGER);
            statement.execute();//we are executing enter_person procedure
            int newPersonId = statement.getInt("new_id");
            int address_id = adr.insertAddress(person.getAddress());//Here we are adding Address enter in database and getting id of the enter
            this.enterAddressID(newPersonId, address_id);
            for (Education education : person.getEducations()) {//Here we are aadding records for education of student
                edu.insertEducation(education, newPersonId);
            }
            for (SocialInsuranceRecord rec : person.getSocialInsuranceRecords()) {//Here we are adding recorrds for social insurance
                ins.enterSocialInsurance(rec, newPersonId);
            }
            return newPersonId;
        }
    }

    @Override
    public void enterAddressID(int personID, int addressID) throws SQLException {
        Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        try (PreparedStatement statement = conn.prepareStatement("UPDATE Person SET address_id=? WHERE id=?;")) {
            statement.setInt(1, addressID);
            statement.setInt(2, personID);
            statement.execute();
        }
    }

}
