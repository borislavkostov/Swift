package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import Exception.DALException;
import java.sql.SQLException;

public class MySQLRemoveDB {

    String DBMS_CONN_STRING;
    String DBMS_USERNAME;
    String DBMS_PASSWORD;

    public MySQLRemoveDB(String DBMS_CONN_STRING, String DBMS_USERNAME, String DBMS_PASSWORD) {
        this.DBMS_CONN_STRING = DBMS_CONN_STRING;
        this.DBMS_USERNAME = DBMS_USERNAME;
        this.DBMS_PASSWORD = DBMS_PASSWORD;
    }

    public void removeDataFromDB() throws DALException {
        try (Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);) {
            Statement statement = conn.createStatement();
            statement.execute("SET FOREIGN_KEY_CHECKS = 0;");
            statement.execute("TRUNCATE TABLE Person;");
            statement.execute("TRUNCATE TABLE Address;");
            statement.execute("TRUNCATE TABLE social_insurance;");
            statement.execute("TRUNCATE TABLE Education;");
            statement.execute("SET FOREIGN_KEY_CHECKS = 1;");
            statement.close();
            conn.close();
        } catch (SQLException e) {
            new DALException("Error with remove data gorm MySQL DB", e);
        }
    }
}
