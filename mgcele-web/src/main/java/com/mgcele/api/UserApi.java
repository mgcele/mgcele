package com.mgcele.api;

import com.mgcele.exception.PasswordIncorrectedException;
import com.mgcele.exception.UserExistedException;
import com.mgcele.exception.UserNotExistException;
import com.mgcele.framework.restful.BaseRestController;
import com.mgcele.framework.restful.bean.RestResponse;
import com.mgcele.model.User;
import com.mgcele.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author mgcele on 2017/4/29.
 */
@RestController
@RequestMapping("/user")
public class UserApi extends BaseRestController {

    private Logger logger = LoggerFactory.getLogger(UserApi.class);

    @Resource(name = "userService")
    private UserService userService;

    @ApiOperation(value = "注册", notes = "注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<RestResponse<User>> register(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, @RequestParam(value = "nickname", required = false) String nickname) {

        logger.info("开始注册；username={}", username);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickname(nickname);
        try {
            user = userService.register(user);
        } catch (UserExistedException e) {
            e.printStackTrace(); //TODO
        }

        logger.info("注册结束；username={}", username);
        RestResponse result = new RestResponse<User>().success(user);
        return new ResponseEntity<RestResponse<User>>(result, HttpStatus.OK);

    }

    @ApiOperation(value = "登陆", notes = "登陆")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<RestResponse<User>> login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {

        logger.info("开始登陆；username={}", username);

        User user = null;
        try {
            user = userService.login(username, password);
        } catch (UserNotExistException e) {
            e.printStackTrace(); //TODO
        } catch (PasswordIncorrectedException e) {
            e.printStackTrace(); //TODO
        }

        logger.info("登陆结束；username={}", username);
        RestResponse result = new RestResponse<User>().success(user);
        return new ResponseEntity<RestResponse<User>>(result, HttpStatus.OK);

    }

}
