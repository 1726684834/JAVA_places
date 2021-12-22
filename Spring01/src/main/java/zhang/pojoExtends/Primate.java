package zhang.pojoExtends;

public class Primate {
	private int age;
	private char sex;
	
	public Primate() {
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

	@Override
	public String toString() {
		return "Primate [age=" + age + ", sex=" + sex + "]";
	}
	

}
