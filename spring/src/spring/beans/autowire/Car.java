package spring.beans.autowire;

public class Car {

	private String name;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", type=" + type + "]";
	}
	public Car() {
		super();
		System.out.println("Car���c�y���...");
	}
	
}
