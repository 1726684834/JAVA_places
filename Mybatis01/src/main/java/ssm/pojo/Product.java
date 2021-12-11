package ssm.pojo;

public class Product {
	private Integer id;
	private String pro_code;
	private String pro_name;
	private Integer pro_num;
	private Float pro_price;
	
	public Product(){}

	public Product(Integer id, String pro_code, String pro_name, Integer pro_num, Float pro_price) {
		super();
		this.id = id;
		this.pro_code = pro_code;
		this.pro_name = pro_name;
		this.pro_num = pro_num;
		this.pro_price = pro_price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPro_code() {
		return pro_code;
	}

	public void setPro_code(String pro_code) {
		this.pro_code = pro_code;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public Integer getPro_num() {
		return pro_num;
	}

	public void setPro_num(Integer pro_num) {
		this.pro_num = pro_num;
	}

	public Float getPro_price() {
		return pro_price;
	}

	public void setPro_price(Float pro_price) {
		this.pro_price = pro_price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", pro_code=" + pro_code + ", pro_name=" + pro_name + ", pro_num=" + pro_num
				+ ", pro_price=" + pro_price + "]";
	}

	
}
