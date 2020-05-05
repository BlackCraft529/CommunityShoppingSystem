package cn.jsnu.css.controller;

import cn.jsnu.css.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:48
 */
@Controller
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
}
