package com.gs.entity.enums;

/**
 * @author gongsong
 * @description: 是否有效枚举
 * @date 2020/11/10 17:41
 */
public enum StatusCdEnum {

    STATUS_CD_0(0,"有效"),
    STATUS_CD_1(1,"无效");

    private Integer type;
    private String value;

    StatusCdEnum(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



}
