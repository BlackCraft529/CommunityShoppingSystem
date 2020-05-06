package cn.jsnu.css.pojo;

import java.util.Date;

/**
 * @author wrx-18090248
 * @date 2020/5/2 22:04
 */
public class User {
    private String userId;
    private String nickname;
    private String password;
    private String phoneNum;
    private String email;
    private Date lastLoginTime;
    private Date createTime;

    public User(){};

    public User(String phoneNum,String password,String nickname,String userId,Date createTime){
        this.userId = userId;
        this.nickname = nickname;
        this.password = password;
        this.phoneNum=phoneNum;
        this.createTime=createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
                ", userName='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", createTime=" + createTime +
                '}';
    }
}
