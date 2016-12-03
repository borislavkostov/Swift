import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Task0_Sakila {
	public static void main(String args[]) throws SQLException {
		Scanner input = new Scanner(System.in);
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SwiftEvents", "root",
				"****")) {
			// try (PreparedStatement statement = conn.prepareStatement(
			// "INSERT INTO Events(`name`,`date`,`ticket_price`,`type_id`)
			// VALUES(?,?,?,?)")) {
			// statement.execute("INSERT INTO Events
			// (`name`,`date`,`ticket_price`,`type_id`)VALUES('AC/DC','2016-10-12','50','2')");
			// statement.execute("UPDATE `SwiftEvents`.`Events` SET
			// `place`='Vasil Levski' WHERE `id`='7'");
			// statement.execute(
			// "INSERT INTO Events
			// (`name`,`date`,`ticket_price`,`type_id`)VALUES('Rally da
			// car','2017-05-3','300','5')");
			// statement.setString(1, input.nextLine());
			// statement.setString(2, input.nextLine());
			// statement.setDouble(3, input.nextDouble());
			// statement.setInt(4, input.nextInt());
			// input.nextLine();
			// statement.execute();
			try (Statement statement = conn.createStatement()) {
				try(ResultSet result = statement.executeQuery("SELECT `name`,`place` FROM SwiftEvents.Events;")){
					while (result.next()) {
						System.out.printf("%n%s\t| %s%n",result.getString("name"),result.getString("place"));
					}
				}
				

			}
		}

	}
}
