package com.mgcele.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mgcele on 2017/4/26.
 *
 * 测试类
 */
@Controller
public class TestController {

    /**
     * 测试
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView test(ModelAndView modelAndView){
        modelAndView.setViewName("/test/index");
        return modelAndView;
    }

}
