package com.mgcele.enums;

import com.mgcele.framework.enums.ConvertableEnum;

/**
 * @author mgcele on 2017/4/29.
 */
public enum ExceptionEnumType implements ConvertableEnum<Integer, ExceptionEnumType>{

    USER_NOT_EXISTED_EXCEPTION(10001, "用户不存在"),

    PASSWORD_INCORRECTED_EXCEPTION(10002, "密码错误"),

    USER_EXISTED_EXCEPTION(10001, "用户已存在"),

    ;

    private Integer code;
    private String description;

    ExceptionEnumType(Integer code, String description){
        this.code = code;
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public Integer getCode(){
        return this.getCode();
    }

    public ExceptionEnumType getEnumByCode(Integer code){
        if(code == null){
            return null;
        }
        for (ExceptionEnumType result : values()){
            if(code.equals(result.getCode())){
                return result;
            }
        }
        return null;
    }

}
