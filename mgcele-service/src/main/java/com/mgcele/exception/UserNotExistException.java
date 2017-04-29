package com.mgcele.exception;

import com.mgcele.enums.ExceptionEnumType;
import com.mgcele.framework.exception.BaseException;

/**
 * @author mgcele on 2017/4/29.
 */
public class UserNotExistException extends BaseException {

    private static final long serialVersionUID = 3686883079255075618L;

    public UserNotExistException() {
        super(ExceptionEnumType.USER_NOT_EXISTED_EXCEPTION.getCode() + "", ExceptionEnumType.USER_NOT_EXISTED_EXCEPTION.getDescription());
    }

    public UserNotExistException(Throwable e) {
        super(ExceptionEnumType.USER_NOT_EXISTED_EXCEPTION.getCode() + "", ExceptionEnumType.USER_NOT_EXISTED_EXCEPTION.getDescription(), e);
    }

}
