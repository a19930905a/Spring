package spring.beans.time;


public class Car {

	public Car() {
		super();
		System.out.println("Carºc³y¨ç¼Æ...");
	}
	private String brand;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		
		System.out.println("Setbreand...");
		this.brand = brand;
	}

	public void init() {
		System.out.println("init...");
	}

	public void destroy() {
		System.out.println("destroy..");
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}
	
}
