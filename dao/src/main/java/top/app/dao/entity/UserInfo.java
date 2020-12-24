package top.app.dao.entity;

import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;

/**
 *
 *
 * @author zclys
 * @date 2020/12/21 16:49
 */
@Alias("UserInfo")
public class UserInfo {

    private int sysId;

    private String userAcco;

    private String userName;

    private String phoneNo;

    private String email;

    private BigDecimal salary;

    public int getSysId() {
        return sysId;
    }

    public String getUserAcco() {
        return userAcco;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSysId(int sysId) {
        this.sysId = sysId;
    }

    public void setUserAcco(String userAcco) {
        this.userAcco = userAcco;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "sysId=" + sysId +
                ", userAcco='" + userAcco + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}
