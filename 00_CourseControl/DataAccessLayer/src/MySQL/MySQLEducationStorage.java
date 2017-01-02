package MySQL;

import contracts.EducationStorage;
import education.Education;
import education.EducationDegree;
import education.GradedEducation;
import education.HigherEducation;
import education.PrimaryEducation;
import education.SecondaryEducation;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MySQLEducationStorage implements EducationStorage {

    final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/PersonCharacteristicsDB?useUnicode=true&characterEncoding=UTF-8";
    final String DBMS_USERNAME = "root";
    final String DBMS_PASSWORD = "173173";

    @Override
    public void insertEducation(Education education, int personID) throws SQLException {
        Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        try (CallableStatement statement = conn.prepareCall("{call insert_education(?,?,?,?,?,?)}")) {
            if (education instanceof GradedEducation) {
                statement.setInt("new_graduated", 1);
            } else {
                statement.setInt("new_graduated", 0);
            }
            statement.setDate("new_enrollment_date", (Date.valueOf(education.getEnrollmentDate())));
            statement.setDate("new_graduation_date", Date.valueOf(education.getGraduationDate()));
            statement.setString("new_institution_name", education.getInstitutionName());
            statement.setInt("new_person_id", personID);
            switch (education.getDegree()) {
                case Primary:
                    statement.setString("new_education_code", "P");
                    break;
                case Master:
                    statement.setString("new_education_code", "M");
                    break;
                case Doctorate:
                    statement.setString("new_education_code", "D");
                    break;
                case Secondary:
                    statement.setString("new_education_code", "S");
                    break;
                case Bachelor:
                    statement.setString("new_education_code", "B");
                    break;
                default:
                    break;
            }
            statement.execute();
            statement.close();
        } finally {
            conn.close();
        }
    }

    @Override
    public List<Education> pullEducation(int id) throws SQLException {
        List<Education> edu = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT graduated ,enrollment_date ,graduation_date,institution_name,education_code "
                    + "FROM Education "
                    + "WHERE person_id =" + id);
            while (rs.next()) {
                String institutionName = rs.getString("institution_name");
                LocalDate enrollmentDate = rs.getDate("enrollment_date").toLocalDate();
                LocalDate graduationDate = rs.getDate("graduation_date").toLocalDate();
                switch (rs.getString("education_code")) {
                    case "P":
                        edu.add(new PrimaryEducation(institutionName, enrollmentDate, graduationDate));
                        break;
                    case "B":
                        edu.add(new HigherEducation(institutionName, enrollmentDate, graduationDate, EducationDegree.Bachelor));
                        break;
                    case "D":
                        edu.add(new HigherEducation(institutionName, enrollmentDate, graduationDate, EducationDegree.Doctorate));
                        break;
                    case "M":
                        edu.add(new HigherEducation(institutionName, enrollmentDate, graduationDate, EducationDegree.Master));
                        break;
                    case "S":
                        edu.add(new SecondaryEducation(institutionName, enrollmentDate, graduationDate));
                        break;
                    default:
                        break;
                }
            }
            rs.close();
            statement.close();
            conn.close();
        }
        return edu;
    }

    @Override
    public void updateEducationCode(int id, String code) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);) {
            Statement statement = conn.createStatement();
            statement.execute("Update Education Set education_code ='" + code + "' Where id =" + id);
            statement.close();
            conn.close();
        }

    }
}
