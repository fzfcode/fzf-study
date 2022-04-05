package com.fzf.study.dictionary.enums;


import com.fzf.study.dictionary.typehandler.LabelAndValue;

/**
 * @author: xuaimin
 * @date: 2020/10/13 上午11:26
 * @description: 密码验证结果
 */
public enum PasswordVerifyResultEnum implements LabelAndValue<Integer> {

    Approve(0, "通过"),

    Decline(1, "拒绝"),

    NoThisField(2, "无内容"),

    HsmFail(3, "加密机错误");

    private final Integer value;
    private final String label;

    PasswordVerifyResultEnum(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

    public static boolean contains(Integer type) {
        for (PasswordVerifyResultEnum verifyResult : PasswordVerifyResultEnum.values()) {
            if (verifyResult.getValue().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public static PasswordVerifyResultEnum getEnum(String label) {
        for (PasswordVerifyResultEnum verifyResult : PasswordVerifyResultEnum.values()) {
            if (verifyResult.getLabel().equals(label)) {
                return verifyResult;
            }
        }
        return null;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getLabel() {
        return label;
    }

}
