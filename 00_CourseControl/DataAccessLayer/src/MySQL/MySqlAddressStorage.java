package MySQL;

import contracts.AddressStorage;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import address.Address;

public class MySqlAddressStorage implements AddressStorage {

    final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/PersonCharacteristicsDB?useUnicode=true&characterEncoding=UTF-8";
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
        } finally {
            conn.close();
        }
    }

    public int insertAddress(Address adr) throws SQLException {
        Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        try (CallableStatement statement = conn.prepareCall("{call set_address(?,?,?,?,?,?,?,?,?)}")) {
            statement.setString("new_country", adr.getCountry());
            statement.setString("new_city", adr.getCity());
            statement.setString("new_municipality", adr.getMunicipality());
            statement.setString("new_postalcode", adr.getPostalCode());
            statement.setString("new_street", adr.getStreet());
            statement.setString("new_number", adr.getNumber());
            statement.setInt("new_floor", adr.getFloor());
            statement.setInt("new_apartment_no", adr.getApartmentNo());
            statement.registerOutParameter("new_id", Types.INTEGER);
            statement.execute();
            Integer newId = statement.getInt("new_id");
            return newId;
        } finally {
            conn.close();
        }
    }

    @Override
    public void insertSmallAddress(Address adr) throws SQLException {
        Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        try (CallableStatement statement = conn.prepareCall("{call insert_small_address(?,?,?,?,?,?)}")) {
            statement.setString("new_country", adr.getCountry());
            statement.setString("new_city", adr.getCity());
            statement.setString("new_municipality", adr.getMunicipality());
            statement.setString("new_postalcode", adr.getPostalCode());
            statement.setString("new_street", adr.getStreet());
            statement.setString("new_number", adr.getNumber());
            statement.execute();
        } finally {
            conn.close();
        }
    }

    @Override
    public Address pullAddress(int id) throws SQLException {
        Address adr;
        Connection conn = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        try (CallableStatement statement = conn.prepareCall("{call pull_address(?,?,?,?,?,?,?,?,?)}")) {
             statement.registerOutParameter("new_country",Types.VARCHAR);
             statement.registerOutParameter("new_city",Types.VARCHAR);
             statement.registerOutParameter("new_municipality",Types.VARCHAR);
             statement.registerOutParameter("new_postalcode",Types.VARCHAR);
             statement.registerOutParameter("new_street",Types.VARCHAR);
             statement.registerOutParameter("new_number",Types.VARCHAR);
             statement.registerOutParameter("new_floor",Types.INTEGER);
             statement.registerOutParameter("new_apartment_no",Types.INTEGER);
             statement.setInt("new_id",id);
             statement.execute();
             String country = statement.getString("new_country");
             String city = statement.getString("new_city");
             String municipality = statement.getString("new_municipality");
             String postalCode = statement.getString("new_postalcode");
             String street = statement.getString("new_street");
             String number = statement.getString("new_number");
             int floor = statement.getInt("new_floor");
             int apartmentNo = statement.getInt("new_apartment_no");
             if(floor==0){
                 adr = new Address(country,city,municipality,postalCode,street,number);
             }else{
                 adr = new Address(country,city,municipality,postalCode,street,number,floor,apartmentNo);
             }
             statement.close();
        }
        finally {
            conn.close();
        }
        return adr;
    }
    
}
