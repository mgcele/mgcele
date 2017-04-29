package com.mgcele.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mgcele on 2017/4/29.
 */
@Controller
public class LoginController {

    /**
     * 登陆页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("/login/login");
        return modelAndView;
    }

    /**
     * 登陆页面
     */
    @RequestMapping(value = "/mlogin", method = RequestMethod.GET)
    public ModelAndView mlogin(ModelAndView modelAndView){
        modelAndView.setViewName("/login/mlogin");
        return modelAndView;
    }

}
