package cn.jsnu.css.controller;

import cn.jsnu.css.pojo.User;
import cn.jsnu.css.service.UserService;
import cn.jsnu.css.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping("/login")
    public String login(String phoneNum, String password, HttpSession session) {
        User user = userService.findUserByPhoneNumAndPassword(phoneNum, password);
        if (user != null) {
            session.setAttribute("user", user);
            System.out.println(user);
            return "redirect:/index";
        } else {
            return "login";
        }
    }


    /**
     * 用户注册
     * @param phoneNum 手机号
     * @param password 密码
     * @param session session对象
     * @return 跳转界面
     */
    @RequestMapping("/register")
    public String register(String phoneNum, String password, HttpSession session) {
        userService.addUser(phoneNum, password);
        return "login";
    }

    @RequestMapping("/info")
    public String info(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        User newUser = userService.findUserById(user.getUserId());
        System.out.println(newUser);
        model.addAttribute("user", newUser);
        return "/userInfo";
    }

    @RequestMapping("/update")
    public String update(String phoneNum, String nickname, HttpSession session) {
        User user = (User) session.getAttribute("user");
        user.setPhoneNum(phoneNum);
        user.setNickname(nickname);
        System.out.println(user);
        userService.updateUser(user);
        return "redirect:/user/info";
    }

    /**
     * 退出登录
     * @param session session对象
     * @return 首页
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/index";
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
