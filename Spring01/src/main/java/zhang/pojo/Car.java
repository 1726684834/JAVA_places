package zhang.pojo;

public class Car {
	private String mark;
	private double price;
	
	
	public Car() {
	}


	public Car(String mark, double price) {
		super();
		this.mark = mark;
		this.price = price;
	}


	public String getMark() {
		return mark;
	}


	public void setMark(String mark) {
		this.mark = mark;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Car [mark=" + mark + ", price=" + price + "]";
	}
	
	
}
