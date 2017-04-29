package com.mgcele.exception;

import com.mgcele.enums.ExceptionEnumType;
import com.mgcele.framework.exception.BaseException;

/**
 * @author mgcele on 2017/4/29.
 */
public class UserExistedException extends BaseException {

    private static final long serialVersionUID = -7304873756601595072L;

    public UserExistedException(){
        super(ExceptionEnumType.USER_EXISTED_EXCEPTION.getCode() + "", ExceptionEnumType.USER_EXISTED_EXCEPTION.getDescription());
    }

    public UserExistedException(Throwable e){
        super(ExceptionEnumType.USER_EXISTED_EXCEPTION.getCode() + "", ExceptionEnumType.USER_EXISTED_EXCEPTION.getDescription(), e);
    }

}
