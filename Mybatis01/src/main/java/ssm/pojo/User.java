package ssm.pojo;

public class User {
	private Integer id;
	private String user_name;
	private String user_sex;
	private Integer user_age;
	private String user_tel;
	
	public User() {}

	public User(Integer id, String user_name, String user_sex, Integer user_age, String user_tel) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.user_sex = user_sex;
		this.user_age = user_age;
		this.user_tel = user_tel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public Integer getUser_age() {
		return user_age;
	}

	public void setUser_age(Integer user_age) {
		this.user_age = user_age;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", user_sex=" + user_sex + ", user_age=" + user_age
				+ ", user_tel=" + user_tel + "]";
	}

}
