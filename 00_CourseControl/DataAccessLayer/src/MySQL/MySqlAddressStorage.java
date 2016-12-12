package MySQL;

import contracts.AddressStorage;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import address.Address;

public class MySqlAddressStorage implements AddressStorage {

    final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/PersonCharacteristicsDB";
    final String DBMS_USERNAME = "root";
    final String DBMS_PASSWORD = "173173";

    @Override
    public int setCountry(String country) throws SQLException {
        Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        try (CallableStatement statement = conn.prepareCall("{call enter_country(?,?)}")) {
            statement.setString("new_country", country);
            statement.registerOutParameter("new_id", Types.INTEGER);
            statement.execute();   
            Integer newId = statement.getInt("new_id");
            return newId;
        }
    }
    public void insertAddress(Address adr)throws SQLException{
         Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
         try (CallableStatement statement = conn.prepareCall("{call set_address(?,?,?,?,?,?,?,?,?)}")) {
             statement.setString("new_country", adr.getCountry());
             statement.setString("new_city", adr.getCity());
             statement.setString("new_municipality",adr.getMunicipality());
              statement.setString("new_postalcode",adr.getPostalCode());
              statement.setString("new_street", adr.getStreet());
              statement.setString("new_number", adr.getNumber());
              statement.setInt("new_floor", adr.getFloor());
              statement.setInt("new_apartment_no",adr.getApartmentNo());
              statement.execute();
         }
    }

    @Override
    public void insertSmallAddress(Address adr) throws SQLException {
       Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
         try (CallableStatement statement = conn.prepareCall("{call insert_small_address(?,?,?,?,?,?)}")) {
             statement.setString("new_country", adr.getCountry());
             statement.setString("new_city", adr.getCity());
             statement.setString("new_municipality",adr.getMunicipality());
              statement.setString("new_postalcode",adr.getPostalCode());
              statement.setString("new_street", adr.getStreet());
              statement.setString("new_number", adr.getNumber());
              statement.execute();
    }
    }
}
