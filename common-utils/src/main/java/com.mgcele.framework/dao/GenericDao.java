package com.mgcele.framework.dao;

import java.io.Serializable;

/**
 * @author mgcele on 2017/4/27.
 */
public interface GenericDao<T extends Serializable, PK extends Serializable> {

    // 根据主键获取实体。如果没有相应的实体，返回 null。
    T findById(PK id);

    // 更新实体
    T update(T entity);

    // 存储实体到数据库
    T save(T entity);

    // 增加或更新实体
    T saveOrUpdate(T entity);

    // 删除指定的实体
    void delete(T entity);

    // 根据主键删除指定实体
    void deleteById(PK id);

}
