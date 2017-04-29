package com.mgcele.framework.enums;

import org.apache.commons.lang3.StringUtils;

import java.time.Year;

/**
 * @author mgcele on 2017/4/26.
 */
public enum YesOrNo implements ConvertableEnum<Integer, YesOrNo>{

    YES(0, "是"),

    NO(1, "否")

    ;

    private Integer code;
    private String description;

    YesOrNo(Integer code, String description){
        this.code = code;
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public Integer getCode(){
        return this.getCode();
    }

    public YesOrNo getEnumByCode(Integer code){
        if(code == null){
            return null;
        }
        for (YesOrNo result : values()){
            if(code.equals(result.getCode())){
                return result;
            }
        }
        return null;
    }

}
