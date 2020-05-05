package cn.jsnu.css.pojo;

import java.util.Date;

/**
 * @author wrx-18090248
 * @date 2020/5/2 22:04
 */
public class User {
    private String userId;
    private String nickName;
    private String password;
    private String phoneNum;
    private String email;
    private Date lastLoginTime;
    private Date createTime;

    public User(){};
    public User(String userId, String nickName, String password, String phoneNum, String email){
        this.userId = userId;
        this.nickName = nickName;
        this.password = password;
        this.phoneNum=phoneNum;
        this.email=email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + userId + '\'' +
                ", userName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", createTime=" + createTime +
                '}';
    }
}
