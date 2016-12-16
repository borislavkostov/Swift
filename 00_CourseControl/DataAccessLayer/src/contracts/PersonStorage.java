
package contracts;
import personaldetails.Citizen;

public interface PersonStorage {
    public Integer enterPerson(Citizen person)throws Exception;
    public void enterAddressID(int personID,int addressID)throws Exception;
}
