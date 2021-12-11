package com.zhang.vo;

import java.util.List;

public class UserQueryVo {
	private String userName;
	private String userSex;
	private String userTel;
	List<Integer> ids;
	public UserQueryVo() {
	}
	public UserQueryVo(String userName, String userSex, String userTel) {
		super();
		this.userName = userName;
		this.userSex = userSex;
		this.userTel = userTel;
	}
	public UserQueryVo(List<Integer> ids) {
		super();
		this.ids = ids;
	}
	public UserQueryVo(String userName, String userSex, String userTel, List<Integer> ids) {
		super();
		this.userName = userName;
		this.userSex = userSex;
		this.userTel = userTel;
		this.ids = ids;
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
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	@Override
	public String toString() {
		return "UserQueryVo [userName=" + userName + ", userSex=" + userSex + ", useTel=" + userTel + ", ids=" + ids
				+ "]";
	}
	
	
}
