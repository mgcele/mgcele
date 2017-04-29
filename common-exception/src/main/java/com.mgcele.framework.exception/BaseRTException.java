package com.mgcele.framework.exception;


import com.mgcele.framework.exception.base.AbstractNestedRuntimeException;

import java.util.Arrays;

/**
 * @author mgcele on 2017/4/29.
 */
public class BaseRTException extends AbstractNestedRuntimeException {

    private static final long serialVersionUID = 8458544317507845657L;
    private String friendlyMessage = "";
    private Object[] messageArgs;
    private String defaultFriendlyMessage;

    public BaseRTException(String code)
    {
        super(code);
    }

    public BaseRTException(String code, Throwable cause)
    {
        super(code, cause);
    }

    public BaseRTException(String code, Throwable cause, Object[] messageArgs)
    {
        super(code, cause);
        if (null != messageArgs) {
            this.messageArgs = ((Object[])messageArgs.clone());
        }
    }

    public BaseRTException(String code, String logMsg)
    {
        super(code, logMsg);
    }

    public BaseRTException(String code, String logMsg, Object[] messageArgs)
    {
        super(code, logMsg);
        if (null != messageArgs) {
            this.messageArgs = ((Object[])messageArgs.clone());
        }
    }

    public BaseRTException(String code, String logMsg, Throwable cause)
    {
        super(code, logMsg, cause);
    }

    public BaseRTException(String code, String logMsg, Throwable cause, Object[] messageArgs)
    {
        super(code, logMsg, cause);
        if (null != messageArgs) {
            this.messageArgs = ((Object[])messageArgs.clone());
        }
    }

    public BaseRTException(String code, Throwable cause, String defaultFriendlyMessage)
    {
        super(code, cause);
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }

    public BaseRTException(String code, Throwable cause, Object[] messageArgs, String defaultFriendlyMessage)
    {
        super(code, cause);
        if (null != messageArgs) {
            this.messageArgs = ((Object[])messageArgs.clone());
        }
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }

    public BaseRTException(String code, String logMsg, String defaultFriendlyMessage)
    {
        super(code, logMsg);
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }

    public BaseRTException(String code, String logMsg, Object[] messageArgs, String defaultFriendlyMessage)
    {
        super(code, logMsg);
        if (null != messageArgs) {
            this.messageArgs = ((Object[])messageArgs.clone());
        }
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }

    public BaseRTException(String code, String logMsg, Throwable cause, String defaultFriendlyMessage)
    {
        super(code, logMsg, cause);
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }

    public BaseRTException(String code, String logMsg, Throwable cause, Object[] messageArgs, String defaultFriendlyMessage)
    {
        super(code, logMsg, cause);
        if (null != messageArgs) {
            this.messageArgs = ((Object[])messageArgs.clone());
        }
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }

    public String getFriendlyMessage()
    {
        return this.friendlyMessage;
    }

    public void setFriendlyMessage(String friendlyMessage)
    {
        this.friendlyMessage = friendlyMessage;
    }

    public Object[] getMessageArgs()
    {
        return Arrays.copyOf(this.messageArgs, this.messageArgs.length);
    }

    public void setMessageArgs(Object[] messageArgs)
    {
        if (null != messageArgs) {
            this.messageArgs = ((Object[])messageArgs.clone());
        }
    }

    public String getDefaultFriendlyMessage()
    {
        return this.defaultFriendlyMessage;
    }

    public void setDefaultFriendlyMessage(String defaultFriendlyMessage)
    {
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }

}
