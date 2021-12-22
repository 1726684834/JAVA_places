package zhang.pojo;

import java.util.List;

/**
 * @author ZhangJunqi
 * @Date 2021/12/12 -16:16
 */
public class Car {
    private Integer id;
    private String carType;
    private String carCode;
    private float carPrice;
    private List<String> carImgs;

    public Car() {
    }

    public Car(Integer id, String carType, String carCode, float carPrice, List<String> carImgs) {
        this.id = id;
        this.carType = carType;
        this.carCode = carCode;
        this.carPrice = carPrice;
        this.carImgs = carImgs;
    }

    public Integer getId() {
        return id;
    }

    public Car setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCarType() {
        return carType;
    }

    public Car setCarType(String carType) {
        this.carType = carType;
        return this;
    }

    public String getCarCode() {
        return carCode;
    }

    public Car setCarCode(String carCode) {
        this.carCode = carCode;
        return this;
    }

    public float getCarPrice() {
        return carPrice;
    }

    public Car setCarPrice(float carPrice) {
        this.carPrice = carPrice;
        return this;
    }

    public List<String> getCarImgs() {
        return carImgs;
    }

    public Car setCarImgs(List<String> carImgs) {
        this.carImgs = carImgs;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carType='" + carType + '\'' +
                ", carCode='" + carCode + '\'' +
                ", carPrice=" + carPrice +
                ", carImgs=" + carImgs +
                '}';
    }
}
