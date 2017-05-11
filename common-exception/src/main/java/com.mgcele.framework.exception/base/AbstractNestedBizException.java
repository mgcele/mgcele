package com.mgcele.framework.exception.base;


import com.mgcele.framework.exception.model.ExceptionInfo;
import com.mgcele.framework.exception.utils.CommonExceptionUtils;
import com.mgcele.framework.exception.utils.ExceptionTraceIdGenerator;
import com.mgcele.framework.system.SystemProperty;

import static java.lang.Long.*;

/**
 * @author mgcele on 2017/4/29.
 */
public class AbstractNestedBizException extends Exception implements Traceable, Describable{

    private String code;
    private String traceId;
    private final transient Traceable parent;
    private final transient Throwable cause;
    private ExceptionInfo rootExceptionInfo;
    private final Long timestamp;

    public AbstractNestedBizException(String code, String msg)
    {
        super(msg);
        this.code = (SystemProperty.getInstance().getSysName() + code);
        this.timestamp = valueOf(System.currentTimeMillis());
        this.parent = null;
        this.cause = null;
        this.traceId = ExceptionTraceIdGenerator.getInstance().getTraceId();
        this.rootExceptionInfo = CommonExceptionUtils.extractExceptionInfo(this);
    }

    public AbstractNestedBizException(String code, String msg, Throwable e)
    {
        super(msg);

        this.code = (SystemProperty.getInstance().getSysName() + code);
        this.cause = e;
        if ((e instanceof Traceable))
        {
            this.parent = ((Traceable)e);
            this.timestamp = valueOf(((Traceable)e).getTimestamp());
            this.traceId = getTraceId();
            this.rootExceptionInfo = ((Traceable)e).getRootExceptionInfo();
        }
        else
        {
            this.parent = null;
            this.timestamp = valueOf(System.currentTimeMillis());
            this.traceId = getTraceId();
            this.rootExceptionInfo = CommonExceptionUtils.extractExceptionInfo(e);
        }
    }

    public Throwable getCause()
    {
        return this.cause == this ? null : this.cause;
    }

    public String getCode()
    {
        return this.code;
    }

    public String toString()
    {
        String name = getClass().getName();
        String traceId = getTraceId();
        String code = getCode();
        String message = getLocalizedMessage();

        return (name + ":") +
                "trace[ " + traceId + " ], " +
                "code[ " + code + " ], " +
                "msg[ " + message + " ]";
    }

    public String getTraceId()
    {
        if (this.traceId != null) {
            return this.traceId;
        }
        if (this.parent != null)
        {
            this.traceId = this.parent.getTraceId();
            return this.traceId;
        }
        try
        {
            this.traceId = ExceptionTraceIdGenerator.getInstance().getTraceId();
        }
        catch (Exception e)
        {
            this.traceId = null;
        }
        return this.traceId;
    }

    public ExceptionInfo getRootExceptionInfo()
    {
        if (this.rootExceptionInfo != null) {
            return this.rootExceptionInfo;
        }
        if (this.parent != null)
        {
            this.rootExceptionInfo = this.parent.getRootExceptionInfo();
            return this.rootExceptionInfo;
        }
        try
        {
            this.rootExceptionInfo = CommonExceptionUtils.extractExceptionInfo(this);
        }
        catch (Exception e)
        {
            this.rootExceptionInfo = null;
        }
        return this.rootExceptionInfo;
    }

    public long getTimestamp()
    {
        return this.timestamp;
    }

}
