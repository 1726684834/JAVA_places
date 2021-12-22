package zhang.pojo;

import java.util.List;

public class People {
	private String code;
	private String name;
	private int age;
	private char sex;
	private List<Car> cars;
	private Car car;
	
	public People() {
	}

	public People(String code, String name, int age, char sex, List<Car> cars) {
		super();
		this.code = code;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.cars = cars;
	}

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public char getSex() {
		return sex;
	}


	public void setSex(char sex) {
		this.sex = sex;
	}




	public List<Car> getCars() {
		return cars;
	}




	public void setCars(List<Car> cars) {
		this.cars = cars;
	}


	public Car getCar() {
		return car;
	}

	public People setCar(Car car) {
		this.car = car;
		return this;
	}

	@Override
	public String toString() {
		return "People{" +
				"code='" + code + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", sex=" + sex +
				", cars=" + cars +
				", car=" + car +
				'}';
	}
}
