package MySQL;

import contracts.SocialInsuranceStorage;
import insurance.SocialInsuranceRecord;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLSocialInsuranceStorage implements SocialInsuranceStorage {

    final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/PersonCharacteristicsDB?useUnicode=true&characterEncoding=UTF-8";
    final String DBMS_USERNAME = "root";
    final String DBMS_PASSWORD = "173173";

    @Override
    public void enterSocialInsurance(SocialInsuranceRecord ins, int person_id) throws SQLException {
        Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        try (CallableStatement statement = conn.prepareCall("{call enter_social_insurance(?,?,?,?)}")) {
            statement.setInt("new_year", ins.getYear());
            statement.setInt("new_month", ins.getMonth());
            statement.setDouble("new_amount", ins.getAmount());
            statement.setInt("new_person_id", person_id);
            statement.execute();
            statement.close();
        }
        finally{
            conn.close();
        }

    }

}
