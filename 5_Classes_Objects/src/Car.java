import java.util.Calendar;

class Car {
	private String model;
	private String brand;
	private int year;
	private double hp;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getHp() {
		return hp;
	}
	public void setHp(double hp) {
		this.hp = hp;
	}
	public String insuranceCategory() {
		int yearsN = Calendar.getInstance().get(Calendar.YEAR) - year;
		String category ="";
		if (yearsN <= 8) {
			category = "Category 1";
			return category;
		} else if (yearsN > 8 && yearsN <= 15) {
			category = "Category 2";
			return category;
		} else if (yearsN > 15 && yearsN <=25) {
			category = "Category 3";
			return category;
		} else {
			category = "Category 4";
			return category;
		}
	}
	public double feeds() {
		String category = this.insuranceCategory();
		double sum = 0;
		if (category.equals("Category 1")) {
			sum += 150;
		} else if (category.equals("Category 2")) {
			sum += 200;
		} else if (category.equals("Category 3")) {
			sum += 300;
		}else {
			sum+=500;
		}
		if(this.hp<85){
			return sum+=sum*0.2;
		}else if(this.hp>140){
			return sum+=sum*0.45;
		}else{
			return sum;
		}

	}
}
