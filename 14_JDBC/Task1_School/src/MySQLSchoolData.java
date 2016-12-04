import java.sql.Connection;
import java.sql.Date;
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

	public static List<Teacher> getTeachers(double salaryFrom, double salaryTo, Connection conn) throws SQLException {
		List<Teacher> teacher = new ArrayList<>();
		try (PreparedStatement statement = conn
				.prepareStatement("SELECT * FROM School.teachers WHERE salary>? and salary<?;")) {
			statement.setDouble(1, salaryFrom);
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

	public static List<Student> getStudents(Date afterDate, Connection conn) throws SQLException {
		List<Student> students = new ArrayList<>();
		try (PreparedStatement statement = conn
				.prepareStatement("SELECT * FROM School.Students WHERE enrollment_date>?;")) {
			statement.setDate(1, afterDate);
			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					students.add(new Student(result.getInt("id"), result.getString("name"),
							result.getDate("enrollment_date")));
				}
				return students;
			}
		}
	}

	public static void insertTeacher(Teacher tc, Connection conn) throws SQLException {
		try (PreparedStatement statement = conn
				.prepareStatement("INSERT INTO School.teachers(`name`,`email`,`salary`)VALUES(?,?,?)")) {
			statement.setString(1, tc.getName());
			statement.setString(2, tc.getEmail());
			statement.setDouble(3, tc.getSalary());
			statement.execute();

		}
	}

	public static void insertStudent(Student st, Connection conn) throws SQLException {
		try (PreparedStatement statement = conn
				.prepareStatement("INSERT INTO School.Students(`name`,`enrollment_date`)VALUES(?,?)")) {
			statement.setString(1, st.getName());
			statement.setDate(2, st.getEnrollmentDate());
			;
			statement.execute();

		}
	}

	public static List<Discipline> getDisciplinesByTeacherId(int teacherId, Connection conn) throws SQLException {
		List<Discipline> disciplines = new ArrayList<>();
		try (PreparedStatement statement = conn.prepareStatement(
				"SELECT School.disciplines_taught.disciplines_id,School.disciplines.name FROM disciplines_taught INNER JOIN disciplines ON teacher_id=? AND School.disciplines.id = School.disciplines_taught.disciplines_id")) {
			statement.setInt(1, teacherId);
			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					disciplines.add(new Discipline(result.getInt("disciplines_id"), result.getString("name")));
				}
				return disciplines;
			}
		}
	}
}
