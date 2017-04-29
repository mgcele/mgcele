package com.mgcele.dao.impl;

import com.mgcele.dao.UserDao;
import com.mgcele.framework.dao.GenericHibernateDao;
import com.mgcele.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mgcele on 2017/4/27.
 */
@Repository("userDao")
public class UserDaoImpl extends GenericHibernateDao<User, Long> implements UserDao{

    @Resource(name = "sessionFactory")
    public void setMyFactory(SessionFactory sessionFactory){
        this.setSessionFactory(sessionFactory);
    }

    @Override
    public User getUserByUserName(String username) {
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        criteria.add(Restrictions.eq("username", username));
        List<User> tempList = (List<User>) getHibernateTemplate().findByCriteria(criteria);
        if(CollectionUtils.isEmpty(tempList)) {
            return null;
        }
        return tempList.get(0);
    }
}
