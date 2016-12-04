import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLSchoolData {

	public static Teacher getTeacher(int id, Connection conn) throws SQLException {
		Teacher tc = null;
		try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM School.teachers WHERE id=?;")) {
			statement.setInt(1, id);
			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					tc = new Teacher(result.getInt("id"), result.getString("name"), result.getString("email"),
							result.getDouble("salary"));

				}

			}
		}
		return tc;
	}

	public static Student getStudent(int id, Connection conn) throws SQLException {
		Student st = null;
		try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM School.Students WHERE id=?;")) {
			statement.setInt(1, id);
			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					st = new Student(result.getInt("id"), result.getString("name"), result.getDate("enrollment_date"));
				}
				return st;
			}
		}
	}
	public static List<Teacher> getTeachers(double salaryFrom,double salaryTo ,Connection conn) throws SQLException {
		List<Teacher> teacher = new ArrayList<>();
		try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM School.teachers WHERE salary>? and salary<?;")) {
			statement.setDouble(1,salaryFrom);
			statement.setDouble(2, salaryTo);
			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					teacher.add(new Teacher(result.getInt("id"), result.getString("name"), result.getString("email"),
							result.getDouble("salary")));

				}

			}
		}
		return teacher;
	}
}
