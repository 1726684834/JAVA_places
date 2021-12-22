package zhang.pojo;

/**
 * @author ZhangJunqi
 * @Date 2021/12/21 -22:12
 */
public class DefingLog {
    private Integer id;
    private String account;//操作账户
    private String dataTime;//操作时间
    private String context;//操作内容
    public DefingLog() {
    }

    public Integer getId() {
        return id;
    }

    public DefingLog setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public DefingLog setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getDataTime() {
        return dataTime;
    }

    public DefingLog setDataTime(String dataTime) {
        this.dataTime = dataTime;
        return this;
    }

    public String getContext() {
        return context;
    }

    public DefingLog setContext(String context) {
        this.context = context;
        return this;
    }

    @Override
    public String toString() {
        return "DefingLog{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", dataTime='" + dataTime + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
