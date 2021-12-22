package zhang.pojo;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{//持久化
	private static final long serialVersionUID=1L;
	private Integer id;
	private String userName;
	private String userSex;
	private Integer userAge;
	private String userTel;
	private List<Order> listOrders;
	public User() {}

	public User(Integer id, String userName, String userSex, Integer userAge, String userTel) {
		super();
		this.id = id;
		this.userName = userName;
		this.userSex = userSex;
		this.userAge = userAge;
		this.userTel = userTel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public List<Order> getListOrders() {
		return listOrders;
	}

	public void setListOrders(List<Order> listOrders) {
		this.listOrders = listOrders;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userSex=" + userSex + ", userAge=" + userAge
				+ ", userTel=" + userTel + ", listOrders=" + listOrders + "]";
	}
	
	
	

}
