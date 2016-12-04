import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {
	public static void main(String args[]) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "173173");
		try (ResultSet result = MySQLSchoolData.getStudent(3, conn);) {
			while (result.next()) {
				System.out.printf("%-30s| %s%n", result.getString("name"), result.getString("enrollment_date"));
			}
		}
	}
}
