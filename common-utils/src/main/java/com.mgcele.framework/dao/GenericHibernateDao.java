package com.mgcele.framework.dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author mgcele on 2017/4/27.
 */
public abstract class GenericHibernateDao<T extends Serializable, PK extends Serializable>
        extends HibernateDaoSupport implements GenericDao<T, PK> {

    // 实体类类型(由构造方法自动赋值)
    private Class<T> entityClass;

    // 构造方法，根据实例类自动获取实体类类型
    public GenericHibernateDao() {
        this.entityClass = null;
        Class c = getClass();
        Type t = c.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            this.entityClass = (Class<T>) p[0];
        }
    }

    // 根据主键获取实体。如果没有相应的实体，返回 null。
    @Override
    public T findById(PK id) {
        return (T) getHibernateTemplate().get(entityClass, id);
    }


    // 更新实体
    @Override
    public T update(T entity) {
        Assert.notNull(entity, "entity不能为null。");
        getHibernateTemplate().update(entity);
        return entity;
    }


    // 存储实体到数据库
    @Override
    public T save(T entity) {
        Assert.notNull(entity, "entity不能为null。");
        getHibernateTemplate().save(entity);
        return entity;
    }

    // 增加或更新实体
    @Override
    public T saveOrUpdate(T entity) {
        Assert.notNull(entity, "entity不能为null。");
        getHibernateTemplate().saveOrUpdate(entity);
        return entity;
    }

    // 删除指定的实体
    @Override
    public void delete(T entity) {
        getHibernateTemplate().delete(entity);
    }

    // 根据主键删除指定实体
    @Override
    public void deleteById(PK id) {
        Assert.notNull(id, "id不能为null。");
        T entity = findById(id);
        if(entity != null){
            delete(entity);
        }
    }
}
