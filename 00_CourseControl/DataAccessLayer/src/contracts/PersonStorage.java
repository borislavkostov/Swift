package contracts;

import personaldetails.Citizen;
import address.Address;
import Exception.DALException;
import java.sql.SQLException;

public interface PersonStorage {

    public int enterPerson(Citizen person) throws SQLException;

    public void enterAddressID(int personID, int addressID) throws Exception;

    public Citizen pullPerson(int id) throws DALException;
}
