package cn.jsnu.css.service;

import cn.jsnu.css.pojo.User;
import java.util.List;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:39
 */
public interface UserService {
    /**
     * 新增用户
     *
     * @param phoneNum 用户手机号
     * @param password 用户密码
     * @return 受影响条数
     */
    int addUser(String phoneNum, String password);

    /**
     * 根据用户ID查找用户
     *
     * @param id 用户ID
     * @return 对应用户
     */
    User findUserById(String id);

    /**
     * 删除用户
     *
     * @param id 用户ID
     */
    void deleteUserById(String id);

    /**
     * 更新用户数据
     *
     * @param user 用户类
     */
    void updateUser(User user);

    /**
     * 修改用户昵称
     *
     * @param id 用户UUID
     * @param nickname 用户昵称
     */
    void updateUserNickname(String id,String nickname);

    /**
     * 更新用户密码
     *
     * @param id 用户id
     * @param  password 密码
     */
    void updateUserPassword(String id,String password);

    /**
     * 更新用户邮箱
     *
     * @param id 用户ID
     * @param email 邮箱
     */
    void updateUserEmail(String id,String email);

    /**
     * 更新用户电话号
     *
     * @param id 用户ID
     * @param phoneNum 电话
     */
    void updateUserPhoneNum(String id,String phoneNum);

    /**
     * 更新用户头像连接
     *
     * @param id 用户ID
     * @param avatar 用户头像连接
     */
    void updateUserAvatar(String id,String avatar);

    /**
     * 根据手机号检查用户是否存在
     *
     * @param phoneNum 手机号
     * @return 是否存在用户
     */
    Boolean checkPhoneNumExist(String phoneNum);

    /**
     * 根据邮箱检查用户是否存在
     *
     * @param email 邮箱
     * @return 用户
     */
    Boolean checkEmailExist(String email);

    /**
     * 根据手机号和密码获取用户
     *
     * @param phoneNum 用户手机号
     * @param password 用户密码
     * @return 用户
     */
    User findUserByPhoneNumAndPassword(String phoneNum,String password);

    /**
     * 获取所有用户
     *
     * @return 用户集合
     */
    List<User> findAllUsers();

    /**
     * 根据手机号获取用密码
     *
     * @param phoneNum 用户手机号
     * @return 用户密码
     */
    String findPasswordByPhoneNum(String phoneNum);
}
