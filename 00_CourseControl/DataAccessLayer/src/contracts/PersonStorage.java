package contracts;

import personaldetails.Citizen;
import address.Address;

public interface PersonStorage {

    public int enterPerson(Citizen person) throws Exception;

    public void enterAddressID(int personID, int addressID) throws Exception;
}
