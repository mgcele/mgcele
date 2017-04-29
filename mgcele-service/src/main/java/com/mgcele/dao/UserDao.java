package com.mgcele.dao;

import com.mgcele.framework.dao.GenericDao;
import com.mgcele.model.User;

/**
 * @author mgcele on 2017/4/27.
 */
public interface UserDao extends GenericDao<User, Long> {

    User getUserByUserName(String username);

}
