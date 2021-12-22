package zhang.annotationPojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
@Component
public class People {
	private String code;
	private String name;
//	@Resource
	@Autowired
	@Qualifier("car")
	private Car car;

	public People() {
	}

	public String getCode() {
		return code;
	}

	public People setCode(String code) {
		this.code = code;
		return this;
	}

	public String getName() {
		return name;
	}

	public People setName(String name) {
		this.name = name;
		return this;
	}

	public Car getCar() {
		return car;
	}

	public People setCar(Car car) {
		this.car = car;
		return this;
	}

	@Override
	public String toString() {
		return "People{" +
				"code='" + code + '\'' +
				", name='" + name + '\'' +
				", car=" + car +
				'}';
	}

	@PostConstruct
	public void init(){
		System.out.println("基于@PostConstruct注解的前置处理。。。。。。");
	}

	@PreDestroy
	public void close(){
		System.out.println("基于@PreDestory注解后置处理。。。。。");
	}
}
