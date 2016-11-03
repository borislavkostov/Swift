package Task3_VehicleMonitor.src;

import java.util.Calendar;

public class Vehicle {
	private String type;
	private String model;
	private double power;
	private double fuelConsumation;
	private int yearProduced;
	private String licenseNo;
	private double distance;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPower() {
		return power;
	}
	public void setPower(double power) {
		this.power = power;
	}
	public double getFuelConsumation() {
		return fuelConsumation;
	}
	public void setFuelConsumation(double fuelConsumation) {
		this.fuelConsumation = fuelConsumation;
	}
	public int getYearProduced() {
		return yearProduced;
	}
	public void setYearProduced(int yearProduced) {
		this.yearProduced = yearProduced;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public double calculateTripPrice(double fuelPrice) {
		return fuelPrice * (distance / fuelConsumation);
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getInsurancePrice() {
		int year = Calendar.getInstance().get(Calendar.YEAR) - yearProduced;
		if (type.equals("car")) {
			return (0.16 * power) * (1.25 * year) * (0.05 * fuelConsumation)
					* 1;
		} else if (type.equals("suv")) {
			return (0.16 * power) * (1.25 * year) * (0.05 * fuelConsumation)
					* 1.12;
		} else if (type.equals("truck")) {
			return (0.16 * power) * (1.25 * year) * (0.05 * fuelConsumation)
					* 1.25;
		} else {
			return (0.16 * power) * (1.25 * year) * (0.05 * fuelConsumation)
					* 1.50;
		}
	}
	public static Vehicle lineEnter(String line,int i) {
		Vehicle vh = new Vehicle();
		String str[] = line.trim().split(",");
		vh.setType(str[0]);
		vh.setModel(str[1]);
		vh.setPower(Double.parseDouble(str[2]));
		vh.setFuelConsumation(Double.parseDouble(str[3]));
		vh.setYearProduced(Integer.parseInt(str[4]));
		vh.setDistance(Double.parseDouble(str[5]));
		vh.setLicenseNo(generateNum(i));
		return vh;
	}
	public static String generateNum(int i){
		return String.format("%04d", i);
	}
	public String toString(double fuelPrice){
		return String.format(this.getLicenseNo()+"-"+this.getModel()+","+this.getYearProduced()+",\nInsurance cost:%.2f-Travel cost:%.2f",this.getInsurancePrice(),this. calculateTripPrice(fuelPrice));
	}
}
