package cn.jsnu.css.service;

import cn.jsnu.css.pojo.User;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:39
 */
public interface UserService {
    /**
     * 新增用户
     * @param phoneNum 用户手机号
     * @param password 用户密码
     * @return 受影响条数
     */
    int addUser(String phoneNum, String password);

    /**
     * 根据用户ID查找用户
     * @param id 用户ID
     * @return 对应用户
     */
    User findUserById(String id);

    /**
     * 删除用户
     * @param id 用户ID
     * @return 影响条数
     */
    int deleteUserById(String id);

    /**
     * 更新用户数据
     * @param user 用户类
     * @return 受影响条数
     */
    int updateUser(User user);

    /**
     * 修改用户昵称
     * @param id 用户UUID
     * @param nickname
     * @return
     */
    int updateUserNickname(String id,String nickname);
}
