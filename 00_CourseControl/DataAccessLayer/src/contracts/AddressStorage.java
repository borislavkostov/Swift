package contracts;
import address.Address;
public interface AddressStorage {

    public int setCountry(String country)throws Exception;
    public void insertAddress(Address adr)throws Exception;
}
