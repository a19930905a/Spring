package spring.beans.spel;

public class Car {

	
	private String type;
	private int price;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [type=" + type + ", price=" + price + "]";
	}

}
