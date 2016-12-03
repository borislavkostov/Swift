import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Task0_Sakila {
	public static void main(String args[]) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SwiftEvents", "root",
				"*******")) {
			try (Statement statement = conn.createStatement()) {
				// statement.execute("INSERT INTO Events
				// (`name`,`date`,`ticket_price`,`type_id`)VALUES('AC/DC','2016-10-12','50','2')");
				// statement.execute("UPDATE `SwiftEvents`.`Events` SET
				// `place`='Vasil Levski' WHERE `id`='7'");
				statement.execute(
						"INSERT INTO Events (`name`,`date`,`ticket_price`,`type_id`)VALUES('Rally da car','2017-05-3','300','5')");
			}
		}

	}
}
