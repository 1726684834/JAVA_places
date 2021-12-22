package zhang.pojo;

import org.springframework.stereotype.Component;

/**
 * @author ZhangJunqi
 * @Date 2021/12/21 -22:35
 */
@Component
public class User {
    private int id;
    private String userCode;
    private String userName;
    private String userPsw;

    public User() {
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getUserCode() {
        return userCode;
    }

    public User setUserCode(String userCode) {
        this.userCode = userCode;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserPsw() {
        return userPsw;
    }

    public User setUserPsw(String userPsw) {
        this.userPsw = userPsw;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userPsw='" + userPsw + '\'' +
                '}';
    }
}
