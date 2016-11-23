
public class Address {
	private String country;
	private String city;
	private String municipality;
	private String  postalCode;
	private String street;
	private int number;
	private String floor;
	private String apartmentNO;
	public Address(String country,String city,String  municipality,String postalCode,String street,int number,String floor,String apatmentNO){
		this.setCountry(country);
		this.setCity(city);
		this.setMunicipality(municipality);
		this.setPostalCode(postalCode);
		this.setStreet(street);
		this.setNumber(number);
		this.setFloor(floor);
		this.setApartmentNO(apatmentNO);
	}
	
	
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getApartmentNO() {
		return apartmentNO;
	}
	public void setApartmentNO(String apartmentNO) {
		this.apartmentNO = apartmentNO;
	}
}
