package com.mgcele.framework.exception.utils;

import com.mgcele.framework.exception.base.Describable;
import com.mgcele.framework.exception.base.Traceable;
import com.mgcele.framework.exception.model.ConfigConstant;
import com.mgcele.framework.exception.model.ExceptionInfo;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mgcele on 2017/4/29.
 */
public class CommonExceptionUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public static String buildMessage(String message, Throwable cause)
    {
        if (cause != null)
        {
            StringBuilder sb = new StringBuilder();
            if (message != null) {
                sb.append(message).append("; ");
            }
            sb.append("nested exception is ").append(cause);
            return sb.toString();
        }
        return message;
    }

    public static Throwable getRootCause(Throwable ex)
    {
        Throwable rootCause = null;
        Throwable cause = ex.getCause();
        while ((cause != null) && (cause != rootCause))
        {
            rootCause = cause;
            cause = cause.getCause();
        }
        return rootCause;
    }

    public static Throwable getMostSpecificCause(Throwable ex)
    {
        Throwable rootCause = getRootCause(ex);
        return rootCause != null ? rootCause : ex;
    }

    public static String getExceptionStackTrace(Throwable ex)
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        pw.close();
        return sw.toString();
    }

    public static String getMostSpecificCauseMessageInfo(Throwable ex)
    {
        Throwable rootCause = getMostSpecificCause(ex);

        StackTraceElement[] elements = rootCause.getStackTrace();

        String rootException = rootCause.getClass().getName();
        String rootExceptionMsg = rootCause.getLocalizedMessage();

        String rootCauseSpotClass = elements[0].getClassName();

        String rootCauseSpotMethod = elements[0].getMethodName();

        int rootCauseSpotLine = elements[0].getLineNumber();

        StringBuilder sbdr = new StringBuilder(ConfigConstant.LINE_SEPARATOR);

        sbdr.append("[Root Exception]: ").append(rootException).append(ConfigConstant.LINE_SEPARATOR).append("[Root Exception Message]: ").append(rootExceptionMsg).append(ConfigConstant.LINE_SEPARATOR).append("[Root Exception throwed on]: ").append(rootCauseSpotClass).append(".").append(rootCauseSpotMethod).append("  Line:").append(rootCauseSpotLine);




        return sbdr.toString();
    }

    public static ExceptionInfo extractExceptionInfo(Throwable e)
    {
        ExceptionInfo info = new ExceptionInfo();
        if ((e instanceof Traceable))
        {
            info.setTraceId(((Traceable)e).getTraceId());
            info.setInterceptTime(sdf.format(new Date(((Traceable)e).getTimestamp())));
        }
        else
        {
            info.setInterceptTime(sdf.format(new Date()));
        }
        if ((e instanceof Describable)) {
            info.setCode(((Describable)e).getCode());
        }
        StackTraceElement[] elements = e.getStackTrace();
        info.setExceptionClass(e.getClass().getName());
        try
        {
            info.setExceptionMessage(e.getMessage());
        }
        catch (Exception ee) {}
        info.setInterceptedClass(elements[0].getClassName());
        info.setInterceptedMethod(elements[0].getMethodName());
        info.setInterceptedLine(Integer.toString(elements[0].getLineNumber()));


        Throwable rootCause = getMostSpecificCause(e);
        if ((rootCause != null) && (rootCause != e))
        {
            StackTraceElement[] rootElements = rootCause.getStackTrace();
            info.setRootException(rootCause.getClass().getName());
            try
            {
                info.setRootExceptionMsg(rootCause.getMessage());
            }
            catch (Exception ee) {}
            info.setRootCauseSpotClass(rootElements[0].getClassName());
            info.setRootCauseSpotMethod(rootElements[0].getMethodName());
            info.setRootCauseSpotLine(Integer.toString(rootElements[0].getLineNumber()));
        }
        return info;
    }

}
