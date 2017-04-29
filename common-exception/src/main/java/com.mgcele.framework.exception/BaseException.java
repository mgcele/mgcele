package com.mgcele.framework.exception;


import com.mgcele.framework.exception.base.AbstractNestedBizException;

import java.util.Arrays;

/**
 * @author mgcele on 2017/4/29.
 */
public class BaseException extends AbstractNestedBizException {

    private static final long serialVersionUID = 1L;
    private Object[] params;

    public BaseException(String code, String msg)
    {
        super(code, msg);
    }

    public BaseException(String code, String msg, Throwable e)
    {
        super(code, msg, e);
    }

    public BaseException(String code, Object[] params, String msg)
    {
        this(code, msg);
        this.params = Arrays.copyOf(params, params.length);
    }

    public BaseException(String code, Object[] params, String msg, Throwable e)
    {
        this(code, msg, e);
        this.params = Arrays.copyOf(params, params.length);
    }

    public Object[] getParams()
    {
        return Arrays.copyOf(this.params, this.params.length);
    }

}
