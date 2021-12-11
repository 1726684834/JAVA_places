package zhang.pojo;

/**
 * @author ZhangJunqi
 * @Date 2021/12/8 -21:41
 */
public class Product {
    private int id;
    private String proCode;
    private String proName;
    private int proNum;
    private double proPrice;

    public Product() {
    }

    public Product(int id, String proCode, String proName, int proNum, double proPrice) {
        this.id = id;
        this.proCode = proCode;
        this.proName = proName;
        this.proNum = proNum;
        this.proPrice = proPrice;
    }

    public Product(String proCode, String proName, int proNum, double proPrice) {
        this.proCode = proCode;
        this.proName = proName;
        this.proNum = proNum;
        this.proPrice = proPrice;
    }

    public int getId() {
        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public String getProCode() {
        return proCode;
    }

    public Product setProCode(String proCode) {
        this.proCode = proCode;
        return this;
    }

    public String getProName() {
        return proName;
    }

    public Product setProName(String proName) {
        this.proName = proName;
        return this;
    }

    public int getProNum() {
        return proNum;
    }

    public Product setProNum(int proNum) {
        this.proNum = proNum;
        return this;
    }

    public double getProPrice() {
        return proPrice;
    }

    public Product setProPrice(double proPrice) {
        this.proPrice = proPrice;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", proCode='" + proCode + '\'' +
                ", proName='" + proName + '\'' +
                ", proNum=" + proNum +
                ", proPrice=" + proPrice +
                '}';
    }
}
