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
import education.Education;
import Exception.DALException;
import java.util.List;

public class MySQLPersonStorage implements PersonStorage {

    String DBMS_CONN_STRING;
    String DBMS_USERNAME;
    String DBMS_PASSWORD;

    public MySQLPersonStorage(String DBMS_CONN_STRING, String DBMS_USERNAME, String DBMS_PASSWORD) {
        this.DBMS_CONN_STRING = DBMS_CONN_STRING;
        this.DBMS_USERNAME = DBMS_USERNAME;
        this.DBMS_PASSWORD = DBMS_PASSWORD;
    }

    @Override
    public int enterPerson(Citizen person) throws DALException {
        MySqlAddressStorage adr = new MySqlAddressStorage(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        MySQLEducationStorage edu = new MySQLEducationStorage(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        MySQLSocialInsuranceStorage ins = new MySQLSocialInsuranceStorage(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        int newPersonId = 0;

        try (Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);) {
            CallableStatement statement = conn.prepareCall("{call enter_person(?,?,?,?,?,?,?)}");
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
            newPersonId = statement.getInt("new_id");
            int address_id = adr.insertAddress(person.getAddress());//Here we are adding Address enter in database and getting id of the enter
            this.enterAddressID(newPersonId, address_id);
            for (Education education : person.getEducations()) {//Here we are aadding records for education of student
                edu.insertEducation(education, newPersonId);
            }
            //Here we are adding recorrds for social insurance
            ins.enterSocialInsurance(person.getSocialInsuranceRecords(), newPersonId);
            statement.close();
            conn.close();

        }catch(SQLException e){
            new DALException("Problem with adding data in MySQL",e);
        } 
        return newPersonId;
    }

    @Override
    public void enterAddressID(int personID, int addressID) throws SQLException {
        Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        try (PreparedStatement statement = conn.prepareStatement("UPDATE Person SET address_id=? WHERE id=?;")) {
            statement.setInt(1, addressID);
            statement.setInt(2, personID);
            statement.execute();
            statement.close();
        } finally {
            conn.close();
        }
    }

    @Override
    public Citizen pullPerson(int id) throws DALException {
        Citizen Person = null;
        try (Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);) {
            CallableStatement statement = conn.prepareCall("{call pull_person(?,?,?,?,?,?,?)}");
            statement.setInt("new_id", id);
            statement.registerOutParameter("new_first_name", Types.VARCHAR);
            statement.registerOutParameter("new_middle_name", Types.VARCHAR);
            statement.registerOutParameter("new_last_name", Types.VARCHAR);
            statement.registerOutParameter("new_gender", Types.VARCHAR);
            statement.registerOutParameter("new_height", Types.INTEGER);
            statement.registerOutParameter("new_date_of_birth", Types.DATE);
            statement.executeUpdate();
            String firstName = statement.getString("new_first_name");
            String middleName = statement.getString("new_middle_name");
            String lastName = statement.getString("new_last_name");
            String gender = statement.getString("new_gender");
            int height = statement.getInt("new_height");
            LocalDate dateOfBirth = statement.getDate("new_date_of_birth").toLocalDate();
            if (gender.equals("Male")) {
                Person = new Citizen(firstName, middleName, lastName, Gender.Male, height, dateOfBirth);
            } else {
                Person = new Citizen(firstName, middleName, lastName, Gender.Female, height, dateOfBirth);
            }
            MySqlAddressStorage adr = new MySqlAddressStorage(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
            Person.setAddress(adr.pullAddress(id));
            MySQLEducationStorage edu = new MySQLEducationStorage(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
            MySQLSocialInsuranceStorage ins = new MySQLSocialInsuranceStorage(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
            Person.setSocialInsuranceRecords(ins.pullSocialInsurance(id));
            Person.setEducations(edu.pullEducation(id));
            statement.close();
            conn.close();
        } catch (SQLException e) {
            new DALException("Problem with pulling data from DB", e);
        }
        return Person;
    }
     public void enterPersonWeb(Citizen person) throws SQLException {
        int newPersonId = 0;
         MySqlAddressStorage adr = new MySqlAddressStorage(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        try (Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);) {
            CallableStatement statement = conn.prepareCall("{call enter_person(?,?,?,?,?,?,?)}");
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
            newPersonId = statement.getInt("new_id");
            int address_id = adr.insertAddress(person.getAddress());//Here we are adding Address enter in database and getting id of the enter
            this.enterAddressID(newPersonId, address_id);
            MySQLEducationStorage edu = new MySQLEducationStorage(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
            for (Education education : person.getEducations()) {//Here we are aadding records for education of student
                edu.insertEducation(education, newPersonId);
            }
            statement.close();
            conn.close();
        }
     }
     public void enterPerson(List<Citizen> persons) throws DALException {
        MySqlAddressStorage adr = new MySqlAddressStorage(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        MySQLEducationStorage edu = new MySQLEducationStorage(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        MySQLSocialInsuranceStorage ins = new MySQLSocialInsuranceStorage(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        int newPersonId = 0;

        try (Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);) {
            CallableStatement statement = conn.prepareCall("{call enter_person(?,?,?,?,?,?,?)}");
            for(Citizen person:persons){
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
            newPersonId = statement.getInt("new_id");
            int address_id = adr.insertAddress(person.getAddress());//Here we are adding Address enter in database and getting id of the enter
            this.enterAddressID(newPersonId, address_id);
            for (Education education : person.getEducations()) {//Here we are aadding records for education of student
                edu.insertEducation(education, newPersonId);
            }
            //Here we are adding recorrds for social insurance
            ins.enterSocialInsurance(person.getSocialInsuranceRecords(), newPersonId);
            }
            statement.close();
            conn.close();
            
        }catch(SQLException e){
            new DALException("Problem with adding data in MySQL",e);
        } 
    }
}
