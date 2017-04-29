package com.mgcele.exception;

import com.mgcele.enums.ExceptionEnumType;
import com.mgcele.framework.exception.BaseException;

/**
 * @author mgcele on 2017/4/29.
 */
public class PasswordIncorrectedException extends BaseException {

    private static final long serialVersionUID = 7890729504516220537L;

    public PasswordIncorrectedException(){
        super(ExceptionEnumType.PASSWORD_INCORRECTED_EXCEPTION.getCode() + "", ExceptionEnumType.PASSWORD_INCORRECTED_EXCEPTION.getDescription());
    }

    public PasswordIncorrectedException(Throwable e){
        super(ExceptionEnumType.PASSWORD_INCORRECTED_EXCEPTION.getCode() + "", ExceptionEnumType.PASSWORD_INCORRECTED_EXCEPTION.getDescription(), e);
    }

}
