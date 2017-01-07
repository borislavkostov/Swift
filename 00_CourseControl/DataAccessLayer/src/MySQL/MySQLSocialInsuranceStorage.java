package MySQL;

import contracts.SocialInsuranceStorage;
import insurance.SocialInsuranceRecord;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLSocialInsuranceStorage implements SocialInsuranceStorage {

    String DBMS_CONN_STRING;
     String DBMS_USERNAME;
    String DBMS_PASSWORD;

    public MySQLSocialInsuranceStorage(String DBMS_CONN_STRING, String DBMS_USERNAME, String DBMS_PASSWORD) {
        this.DBMS_CONN_STRING = DBMS_CONN_STRING;
        this.DBMS_USERNAME = DBMS_USERNAME;
        this.DBMS_PASSWORD = DBMS_PASSWORD;
    }
    

    @Override
    public void enterSocialInsurance(List<SocialInsuranceRecord> ins, int person_id) throws SQLException {
        Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        try (CallableStatement statement = conn.prepareCall("{call enter_social_insurance(?,?,?,?)}")) {
            for (SocialInsuranceRecord soc : ins) {
                statement.setInt("new_year", soc.getYear());
                statement.setInt("new_month", soc.getMonth());
                statement.setDouble("new_amount", soc.getAmount());
                statement.setInt("new_person_id", person_id);
                statement.execute();
            }
            statement.close();
        } finally {
            conn.close();
        }

    }

    @Override
    public List<SocialInsuranceRecord> pullSocialInsurance(int personID) throws SQLException {
        List<SocialInsuranceRecord> soc = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT year,month,amount FROM social_insurance WHERE person_id=" + personID);
            while (rs.next()) {
                int year = rs.getInt("year");
                int month = rs.getInt("month");
                double amount = rs.getDouble("amount");
                soc.add(new SocialInsuranceRecord(year, month, amount));
            }

            statement.close();
            rs.close();
            conn.close();
        }
        return soc;
    }

}
