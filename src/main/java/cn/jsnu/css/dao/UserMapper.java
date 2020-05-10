package cn.jsnu.css.dao;

import cn.jsnu.css.pojo.User;
import java.util.List;
import java.util.Map;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:40
 */
public interface UserMapper {
    /**
     * 新增用户
     * @param user 用户
     * @return 受影响条数
     */
    int addUser(User user);

    /**
     * 根据用户ID查找用户
     * @param id 用户ID
     * @return 对应用户
     */
    User findUserById(String id);

    /**
     * 删除用户
     * @param id 用户ID
     */
    void deleteUserById(String id);

    /**
     * 更新用户数据
     * @param user 用户类
     */
    void updateUser(User user);

    /**
     * 修改用户昵称
     * @param user 修改用户
     */
    void updateUserNickname(User user);

    /**
     * 更新用户密码
     * @param user 修改用户
     */
    void updateUserPassword(User user);

    /**
     * 更新用户邮箱
     * @param user 用户
     */
    void updateUserEmail(User user);

    /**
     * 更新用户电话号
     * @param user 用户
     */
    void updateUserPhoneNum(User user);

    /**
     * 更新用户头像连接
     * @param user 用户
     */
    void updateUserAvatar(User user);

    /**
     * 根据手机号检查用户是否存在
     * @param phoneNum 手机号
     * @return 用户
     */
    User checkPhoneNumExist(String phoneNum);

    /**
     * 根据邮箱检查用户是否存在
     * @param email 邮箱
     * @return 用户
     */
    User checkEmailExist(String email);

    /**
     * 根据手机号和密码获取用户
     * @param userData 用户手机号和密码信息
     * @return 用户
     */
    User findUserByPhoneNumAndPassword(Map<String,String> userData);

    /**
     * 获取所有用户
     * @return 用户集合
     */
    List<User> findAllUsers();

    /**
     * 根据手机号获取用密码
     * @param phoneNum 用户手机号
     * @return 用户密码
     */
    String findPasswordByPhoneNum(String phoneNum);

}
