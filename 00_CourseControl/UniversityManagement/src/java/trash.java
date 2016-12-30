
import MySQL.MySQLPersonStorage;
import java.sql.SQLException;
import personaldetails.Citizen;


public class trash {
    public static void main(String args[]){
        String a = null;
        try{
         MySQLPersonStorage per = new MySQLPersonStorage();
              Citizen  person = per.pullPerson(58);
              a = person.toString();
              System.out.println(person.getAddress().toString());
        }catch(SQLException e){
            
        }System.out.println(a);
    }
}
