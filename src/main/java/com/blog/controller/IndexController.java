package com.blog.controller;

import com.blog.core.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * com.blog.controller
 * @author : 余峻豪
 * @date : 15/11/8
 */
@Controller
public class IndexController extends BaseController {


    @RequestMapping(value = {"","index","*"},method = RequestMethod.GET)
    public String index () {
        return "index/index";
    }

    @RequestMapping(value = "top",method = RequestMethod.GET)
    public String top () {
        return "index/top";
    }

    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main () {
        return "index/main";
    }
    @RequestMapping(value = "bottom",method = RequestMethod.GET)
    public String bottom () {
        return "index/bottom";
    }


}
