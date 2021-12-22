package ssm.pojo;

import java.util.List;

public class Car {
	private Integer id;
	private String car_type;
	private String car_code;
	private float car_price;
	private List<String> car_imgs;
	public Car() {
		super();
	}
	public Car(Integer id, String car_type, String car_code, float car_price, List<String> car_imgs) {
		super();
		this.id = id;
		this.car_type = car_type;
		this.car_code = car_code;
		this.car_price = car_price;
		this.car_imgs = car_imgs;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public String getCar_code() {
		return car_code;
	}
	public void setCar_code(String car_code) {
		this.car_code = car_code;
	}
	public float getCar_price() {
		return car_price;
	}
	public void setCar_price(float car_price) {
		this.car_price = car_price;
	}
	public List<String> getCar_imgs() {
		return car_imgs;
	}
	public void setCar_imgs(List<String> car_imgs) {
		this.car_imgs = car_imgs;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", car_type=" + car_type + ", car_code=" + car_code + ", car_price=" + car_price
				+ ", car_imgs=" + car_imgs + "]";
	}
	

}
