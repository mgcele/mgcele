package com.mgcele.service.impl;

import com.mgcele.dao.UserDao;
import com.mgcele.exception.PasswordIncorrectedException;
import com.mgcele.exception.UserExistedException;
import com.mgcele.exception.UserNotExistException;
import com.mgcele.framework.exception.BaseRTException;
import com.mgcele.model.User;
import com.mgcele.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author mgcele on 2017/4/27.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    @Transactional
    public User register(User user) throws UserExistedException {

        User temp = userDao.getUserByUserName(user.getUsername());
        if(temp != null){
            throw new UserExistedException();
        }

        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        return userDao.save(user);
    }

    @Override
    public User login(String username, String password) throws UserNotExistException, PasswordIncorrectedException {
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            throw new BaseRTException("username或password不能为空！");
        }
        User user = userDao.getUserByUserName(username);
        if(user == null){
            throw new UserNotExistException();
        }
        if(!password.equals(user.getPassword())){
            throw new PasswordIncorrectedException();
        }
        return user;
    }

    @Override
    public boolean validatePassword(String username, String password) throws UserNotExistException {
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            throw new BaseRTException("username或password不能为空！");
        }
        User user = userDao.getUserByUserName(username);
        if(user == null){
            throw new UserNotExistException();
        }
        return password.equals(user.getPassword());
    }

}
