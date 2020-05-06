package cn.jsnu.css.controller;

import cn.jsnu.css.pojo.User;
import cn.jsnu.css.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 李广帅
 * @date 2020/5/5 20:48
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;


    /**
     * 用户登录
     * @param phoneNum 手机号
     * @param password 密码
     * @param session session对象
     * @return 跳转界面
     */
    public String login(String phoneNum, String password, HttpSession session) {

        return "";
    }


    /**
     * 用户登录
     * @param phoneNum 手机号
     * @param password 密码
     * @param session session对象
     * @return 跳转界面
     */
    public String register(String phoneNum, String password, HttpSession session) {

        return "";
    }






    /**
     * 跳转至登录页面
     * @return 登录页面名
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 跳转至注册页面
     * @return 注册页面名
     */
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }



}
