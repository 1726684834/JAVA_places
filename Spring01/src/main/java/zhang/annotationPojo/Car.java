package zhang.annotationPojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Value (value = "宝马")
	private String mark;

	public Car() {
	}


	public Car(String mark) {
		super();
		this.mark = mark;
	}


	public String getMark() {
		return mark;
	}


	public void setMark(String mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Car [mark=" + mark+"]";
	}
	
	
}
