
package citizenstoragemanagercli;

import MySQL.MySqlAddressStorage;
import java.sql.SQLException;
import address.Address;


public class CitizenStorageManagerCLI {

    public static void main(String[] args) throws SQLException{
        MySqlAddressStorage adr = new  MySqlAddressStorage();
        //adr.setCountry("USA");
        //System.out.println(adr.setCountry("USA"));
        Address adres = new Address("Bulgaria","Sofia","Sofia-grad","1750","jerusalim","3",2,1);
        adr.insertAddress(adres);
        Address adresa = new Address("Bulgaria","Sofia","Sofia-grad","1780","blok","222");
        adr.insertSmallAddress(adresa);
    }
    
}
