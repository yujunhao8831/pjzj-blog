package com.blog.controller;/**
 * Created by apple on 15/11/8.
 */

import com.blog.domain.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * com.blog.controller
 *
 * @author : 余峻豪
 * @date : 15/11/8
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    private @Autowired  UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public User get (HttpSession session) {
        User user = userService.selectById(1L);
        session.setAttribute("user", user);
        return user;
    }

}












