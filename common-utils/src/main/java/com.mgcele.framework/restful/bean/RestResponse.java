package com.mgcele.framework.restful.bean;

/**
 * @author mgcele on 2017/4/29.
 */
public class RestResponse<T> {

    private static final String RET_CODE_SUCCESS = "0";
    private static final RestResponse simpleSuccessJson = new RestResponse().success();
    private RestResponse<T>.Meta meta;
    private T data;

    public RestResponse success()
    {
        this.meta = new Meta("0");
        return this;
    }

    public RestResponse success(T data)
    {
        this.meta = new Meta("0");
        this.data = data;
        return this;
    }

    public RestResponse failure(String retCode, String message)
    {
        this.meta = new Meta(retCode, message);
        return this;
    }

    public RestResponse failure(String retCode, String[] msgs)
    {
        this.meta = new Meta(retCode, msgs);
        return this;
    }

    public RestResponse<T>.Meta getMeta()
    {
        return this.meta;
    }

    public T getData()
    {
        return this.data;
    }

    public void setFilterExcluded()
    {
        this.meta.setFilterExcluded(true);
    }

    public static RestResponse getSimpleSuccessJson()
    {
        return simpleSuccessJson;
    }

    public class Meta
    {
        private String retCode;
        private boolean isFilterExcluded = false;
        private String[] msgs;

        public Meta(String retCode)
        {
            this.retCode = retCode;
            this.msgs = new String[1];
            this.msgs[0] = "";
        }

        public Meta(String retCode, String retMsg)
        {
            this.retCode = retCode;
            this.msgs = new String[1];
            this.msgs[0] = retMsg;
        }

        public Meta(String retCode, String[] msgs)
        {
            this.retCode = retCode;
            this.msgs = msgs;
        }

        public String getRetCode()
        {
            return this.retCode;
        }

        public String[] getMsgs()
        {
            return this.msgs;
        }

        public void setMsgs(String[] msgs)
        {
            this.msgs = msgs;
        }

        public boolean isFilterExcluded()
        {
            return this.isFilterExcluded;
        }

        public void setFilterExcluded(boolean isFilterExcluded)
        {
            this.isFilterExcluded = isFilterExcluded;
        }
    }

}
