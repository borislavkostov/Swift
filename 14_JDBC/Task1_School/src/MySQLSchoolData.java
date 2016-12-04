import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLSchoolData {

	public static Teacher getTeacher(int id, Connection conn) throws SQLException {
		Teacher tc = null;
		try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM School.teachers WHERE id=?;")) {
			statement.setInt(1, id);
			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					tc = new Teacher(result.getInt("id"), result.getString("name"), result.getString("email"));

				}
				
			}
		}
		return tc;
	}

	public static ResultSet getStudent(int id, Connection conn) throws SQLException {
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM School.Students WHERE id=?;");
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		return result;

	}

}
