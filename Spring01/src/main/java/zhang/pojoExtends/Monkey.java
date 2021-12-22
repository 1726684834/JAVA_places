package zhang.pojoExtends;

public class Monkey {
	private int age;
	private char sex;
	private String name;
	
	public Monkey() {
		// TODO Auto-generated constructor stub
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Monkey [age=" + age + ", sex=" + sex + ", name=" + name + "]";
	}

}
