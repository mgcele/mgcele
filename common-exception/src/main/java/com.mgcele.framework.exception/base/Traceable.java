package com.mgcele.framework.exception.base;

import com.mgcele.framework.exception.model.ExceptionInfo;

/**
 * @author mgcele on 2017/4/29.
 */
public interface Traceable {

    String getTraceId();

    ExceptionInfo getRootExceptionInfo();

    long getTimestamp();

}
