package com.mgcele.service;

import com.mgcele.exception.PasswordIncorrectedException;
import com.mgcele.exception.UserExistedException;
import com.mgcele.exception.UserNotExistException;
import com.mgcele.model.User;

/**
 * @author mgcele on 2017/4/27.
 */
public interface UserService {

    User register(User user) throws UserExistedException;

    User login(String username, String password) throws UserNotExistException, PasswordIncorrectedException;

    boolean validatePassword(String username, String password) throws UserNotExistException;

}
