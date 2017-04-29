package com.mgcele.test.service;

import com.mgcele.exception.UserExistedException;
import com.mgcele.framework.utils.RandomUtil;
import com.mgcele.model.User;
import com.mgcele.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author mgcele on 2017/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/dataourceTest.xml")
public class UserServiceTest {

    @Resource(name = "userService")
    private UserService userService;

    @Test
    public void testAddUser() throws UserExistedException {
        User user = new User();
        user.setUsername(RandomUtil.randomInt(8) + "");
        user.setPassword(RandomUtil.randomInt(8) + "");
        user.setNickname(RandomUtil.randomInt(8) + "");
        userService.register(user);
    }

}
