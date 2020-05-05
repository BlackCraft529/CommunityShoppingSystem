package cn.jsnu.css.service.Impl;

import cn.jsnu.css.dao.UserMapper;
import cn.jsnu.css.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:42
 */
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) { this.userMapper=userMapper; }
}
