
public class Demo {
	public static void main(String args[]){
		Person Bob = new Person("Bob");
		Bob.setAge(53);
		Bob.printPerson();
		Car mercedes = new Car();
		mercedes.setBrand("Mercedes");
		mercedes.setModel("S220");
		mercedes.setHp(160);
		mercedes.setYear(2009);
		mercedes.insuranceCategory();
		System.out.println(mercedes.feeds());
	}
}
