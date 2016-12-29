package contracts;

import address.Address;

public interface AddressStorage {

    public int setCountry(String country) throws Exception;

    public int insertAddress(Address adr) throws Exception;

    public void insertSmallAddress(Address adr) throws Exception;
}
