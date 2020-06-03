package cn.jsnu.css.controller;

import cn.jsnu.css.pojo.User;
import cn.jsnu.css.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("phoneNum") String phoneNum, @RequestParam("password") String password, @RequestParam("email") String email, HttpSession session) {
        System.out.println("phoneNum:" + phoneNum + "password:" + password);
        userService.addUser(phoneNum, password);
        return "login";
    }

    @RequestMapping("/info")
    public String info(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        User newUser = userService.findUserById(user.getUserId());
        model.addAttribute("user", newUser);
        return "/userInfo";
    }

    @RequestMapping("/update")
    public String update(String phoneNum, String nickname, HttpSession session) {
        User user = (User) session.getAttribute("user");
        user.setPhoneNum(phoneNum);
        user.setNickname(nickname);
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
