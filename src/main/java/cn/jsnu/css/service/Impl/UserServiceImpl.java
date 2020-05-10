package cn.jsnu.css.service.Impl;

import cn.jsnu.css.dao.UserMapper;
import cn.jsnu.css.pojo.User;
import cn.jsnu.css.service.UserService;
import cn.jsnu.css.utils.MD5Util;
import cn.jsnu.css.utils.RandomId;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:42
 */
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) { this.userMapper=userMapper; }

    /**
     * 新增一个用户
     * @param phoneNum 用户手机号
     * @param password 用户密码
     * @return 成功条数 1
     */
    @Override
    public int addUser(String phoneNum, String password) {
        //确定UUID
        String UUID= RandomId.getUUID().replaceAll("-","");
        while(userMapper.findUserById(UUID)!=null){
            UUID=RandomId.getUUID().replaceAll("-","");
        }
        //密码加盐密
        String MD5password= MD5Util.getSaltMD5(password);
        //生成昵称
        String nickname=RandomId.getFirstNickName(phoneNum);
        return userMapper.addUser(new User(phoneNum,MD5password,nickname,UUID,new Date()));
    }

    /**
     * 查找一个用户
     * @param id 用户ID
     * @return 用户
     */
    @Override
    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }

    /**
     * 删除一个用户
     * @param id 用户ID
     */
    @Override
    public void deleteUserById(String id) {
        userMapper.deleteUserById(id);
    }

    /**
     * 更新用户数据
     * @param user 用户类
     */
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    /**
     * 修改用户昵称
     * @param id 用户UUID
     * @param nickname 用户昵称
     */
    @Override
    public void updateUserNickname(String id, String nickname) {
        User user=new User();
        user.setUserId(id);
        user.setNickname(nickname);
        userMapper.updateUser(user);
    }

    /**
     * 更新用户密码
     * @param id 用户ID
     * @param password 密码
     */
    @Override
    public void updateUserPassword(String id , String password) {
        User user=findUserById(id);
        user.setPassword(MD5Util.getSaltMD5(password));
        userMapper.updateUserPassword(user);
    }

    /**
     * 更新用户邮箱
     * @param id 用户ID
     * @param email 邮箱
     */
    @Override
    public void updateUserEmail(String id , String email) {
        User user=findUserById(id);
        user.setEmail(email);
        userMapper.updateUserEmail(user);
    }

    /**
     * 更新用户电话号
     * @param id 用户ID
     * @param phoneNum 电话
     */
    @Override
    public void updateUserPhoneNum(String id,String phoneNum) {
        User user=findUserById(id);
        user.setPhoneNum(phoneNum);
        userMapper.updateUserPhoneNum(user);
    }

    /**
     * 更新用户头像连接
     * @param id 用户ID
     * @param avatar 用户头像连接
     */
    @Override
    public void updateUserAvatar(String id , String avatar) {
        User user=findUserById(id);
        user.setAvatar(avatar);
        userMapper.updateUserAvatar(user);
    }

    /**
     * 查找用户是否存在
     * @param phoneNum 手机号
     * @return 是否存在
     */
    @Override
    public Boolean checkPhoneNumExist(String phoneNum) {
        return userMapper.checkPhoneNumExist(phoneNum)==null?false:true;
    }

    /**
     * 查找用户邮箱是否存在
     * @param email 邮箱
     * @return 是否存在
     */
    @Override
    public Boolean checkEmailExist(String email) {
        return userMapper.checkEmailExist(email)==null?false:true;
    }

    /**
     * 根据手机号和密码获取用户
     * @param phoneNum 用户手机号
     * @param password 用户密码
     * @return 用户
     */
    @Override
    public User findUserByPhoneNumAndPassword(String phoneNum, String password) {
        Map<String,String> userData=new HashMap<>();
        String sqlPassword= findPasswordByPhoneNum(phoneNum);
        if(MD5Util.getSaltverifyMD5(password,sqlPassword)) {
            userData.put("phoneNum",phoneNum);
            userData.put("password",sqlPassword);
            return userMapper.findUserByPhoneNumAndPassword(userData);
        }
        return null;
    }

    /**
     * 返回所有用户合集
     * @return 所有用户
     */
    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    /**
     * 根据用户手机号获取密码
     * @param phoneNum 用户手机号
     * @return 密码
     */
    @Override
    public String findPasswordByPhoneNum(String phoneNum) {
        return userMapper.findPasswordByPhoneNum(phoneNum);
    }


}
