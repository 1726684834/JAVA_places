package ssm.pojo;

public class Order {
	private Integer id;
	private Integer user_id;
	private Integer pro_id;
	private Integer or_num;
	private Float totalprice;
	public Order(Integer id, Integer user_id, Integer pro_id, Integer or_num, Float totalprice) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.pro_id = pro_id;
		this.or_num = or_num;
		this.totalprice = totalprice;
	}
	
	public Order() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getPro_id() {
		return pro_id;
	}

	public void setPro_id(Integer pro_id) {
		this.pro_id = pro_id;
	}

	public Integer getOr_num() {
		return or_num;
	}

	public void setOr_num(Integer or_num) {
		this.or_num = or_num;
	}

	public Float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Float totalprice) {
		this.totalprice = totalprice;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", pro_id=" + pro_id + ", or_num=" + or_num
				+ ", totalprice=" + totalprice + "]";
	}
	
	

}
