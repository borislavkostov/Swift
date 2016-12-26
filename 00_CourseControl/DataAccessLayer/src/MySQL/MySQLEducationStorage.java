package MySQL;

import contracts.EducationStorage;
import education.Education;
import education.GradedEducation;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MySQLEducationStorage implements EducationStorage {

    final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/PersonCharacteristicsDB";
    final String DBMS_USERNAME = "root";
    final String DBMS_PASSWORD = "173173";

    @Override
    public void insertEducation(Education education, int personID) throws SQLException {
        Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        try (CallableStatement statement = conn.prepareCall("{call insert_education(?,?,?,?,?)}")) {
            if (education instanceof GradedEducation) {
                statement.setInt("new_graduated", 1);
            } else {
                statement.setInt("new_graduated", 0);
            }
            statement.setDate("new_enrollment_date", (Date.valueOf(education.getEnrollmentDate())));
            statement.setDate("new_graduation_date", Date.valueOf(education.getGraduationDate()));
            statement.setString("new_institution_name", education.getInstitutionName());
            statement.setInt("new_person_id", personID);
            statement.execute();
        }
    }
}
