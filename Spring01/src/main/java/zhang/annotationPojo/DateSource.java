package zhang.annotationPojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ZhangJunqi
 * @Date 2021/12/20 -20:24
 */
@Component
public class DateSource {
    @Value (value = "${jdbc.driver}")
    private String driver;
    @Value (value = "${jdbc.url}}")
    private String url;
    @Value (value = "${jdbc.username}")
    private String userName;
    @Value (value = "${jdbc.password}")
    private String password;

    public DateSource() {
    }

    public String getDriver() {
        return driver;
    }

    public DateSource setDriver(String driver) {
        this.driver = driver;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public DateSource setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public DateSource setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DateSource setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "DateSource{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
