package com.fzf.study.dictionary.enums;


import com.fzf.study.dictionary.typehandler.LabelAndValue;

/**
 * @author: xuaimin
 * @date: 2020/10/13 上午11:14
 * @description: 证件类型
 */
public enum IdTypeEnum implements LabelAndValue<String> {

    ID("I", "身份证"),
    TEMP_ID("T", "临时身份证"),
    OFFICERS("A", "军官证"),
    SOLDIERS("S", "士兵证"),
    PASSPORT("P", "护照"),
    OTHER("O", "其他有效证件"),
    RESIDENCE_BOOKLET("R", "户口簿"),
    HONG_KONG_MACAO_PERMIT("H", "港澳居民来往内地通行证"),
    TAIWAN_PERMIT("W", "台湾同胞来往内地通行证"),
    RESIDENCE_PERMIT_FOR_FOREIGNERS("F", "外国人居留证"),
    OFFICERS_CARD("C", "警官证"),
    HONG_KONG_ID("L", "香港身份证"),
    MACAO_ID("G", "澳门身份证"),
    TAIWAN_ID("J", "台湾身份证");

    private final String value;
    private final String label;

    IdTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static IdTypeEnum getBy(String value) {
        if (value == null || "".equals(value)) {
            return null;
        }

        for (IdTypeEnum idType : IdTypeEnum.values()) {
            if (idType.value.equals(value)) {
                return idType;
            }
        }
        return null;
    }

    public static boolean contains(String type) {
        for (IdTypeEnum nameListType : IdTypeEnum.values()) {
            if (nameListType.getValue().equals(type)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
