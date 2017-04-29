package com.mgcele.framework.enums;

import java.io.Serializable;

/**
 * @author mgcele on 2017/4/29.
 */
public interface ConvertableEnum <T, E extends Enum<?>> extends Serializable{

    T getCode();

    E getEnumByCode(T paramT);
}
