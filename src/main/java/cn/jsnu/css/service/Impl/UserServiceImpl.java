package cn.jsnu.css.service.Impl;

import cn.jsnu.css.dao.UserMapper;
import cn.jsnu.css.pojo.User;
import cn.jsnu.css.service.UserService;
import cn.jsnu.css.utils.MD5Util;
import cn.jsnu.css.utils.RandomId;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.krb5.internal.PAData;

import java.util.Date;

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
        String UUID= RandomId.getUUID();
        while(userMapper.findUserById(UUID)!=null){
            UUID=RandomId.getUUID();
        }
        //密码加盐密
        password= MD5Util.getSaltMD5(password);
        //生成昵称
        String nickname=RandomId.getFirstNickName(phoneNum);
        return userMapper.addUser(new User(phoneNum,password,nickname,UUID,new Date()));
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
     * @return
     */
    @Override
    public int deleteUserById(String id) {
        return userMapper.deleteUserById(id);
    }

    /**
     * 更新用户数据
     * @param user 用户类
     * @return 影响条数
     */
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    /**
     * 修改用户昵称
     * @param id 用户UUID
     * @param nickname 用户昵称
     * @return 影响条数
     */
    @Override
    public int updateUserNickname(String id, String nickname) {
        User user=new User();
        user.setUserId(id);
        user.setNickname(nickname);
        return userMapper.updateUser(user);
    }


}
