package com.fzf.study.common;


import org.apache.commons.lang3.StringUtils;

public class CodeMarkUtils {
    private final static String asterisk = "*";
    /**
     * <p>目的：为交易日志监控专门使用的卡号加密方法</p>
     * <p>承诺：不使用开关限制，默认全部掩码</p>
     * @param cardNo 卡号
     * @return
     */
    public static String markCreditCard(String cardNo) {
        return markCreditCard(cardNo, 6, 4);
    }

    /**
     * 卡号掩码
     *
     * @param cardNo
     *            卡号
     * @param start
     *            卡号起始显示长度
     * @param end
     *            结尾显示长度
     * @return
     */
    private static String markCreditCard(String cardNo, int start, int end) {
        if (cardNo == null)
            return null;
        if (cardNo.length() < 10)
            return cardNo;
        int length = cardNo.length() - start - end;
        return cardNo.replaceAll("(?<=\\d{" + start + "})(\\d{" + length
                + "})(?=\\d{" + end + "})", getAsterisk(length));
    }


    public static String makeIDCardMask(String idNo) {
         return markIDCard(idNo);
    }

    private static String markIDCard(String idCardNo) {
        if (idCardNo == null) {
            return null;
        } else if (idCardNo.length() < 15) {
            return idCardNo;
        } else {
            int length = idCardNo.length() == 15 ? 6 : 8;
            return idCardNo.replaceAll("(?<=\\d{6})(\\d{" + length + "})(?=\\d+)", getAsterisk(length));
        }
    }

    private static String getAsterisk(int length) {
        return StringUtils.repeat(asterisk, length);
    }


    public static String makeMobileNoMask(String mobileNo) {
        return markMobile(mobileNo);
    }
    /**
     * 手机号掩码
     *
     * @param mobileNo
     *            手机号
     * @return
     */
    private static String markMobile(String mobileNo) {
        if (mobileNo == null)
            return null;
        if (mobileNo.length() < 11) {
            return mobileNo;
        }
        return mobileNo.replaceAll("(?<=\\d{3})(\\d{4})(?=\\d+)",
                getAsterisk(4));
    }

    private static String markName(String name) {
        if (name == null) {
            return null;
        } else if (name.length() <= 1) {
            return name;
        } else {
            return name.replaceFirst(".",asterisk);
        }
    }


    /**
     *
     * @param source 需要处理的xml
     * @param label 需要匹配的标签
     * @param value 已经处理好的数据
     * @return
     */
    public static String xmlReplace(String source,String label,String value)
    {
        if(StringUtils.isBlank(source)||StringUtils.isBlank(label)||StringUtils.isBlank(value)){
            return source;
        }
        label = label.toUpperCase();
        String regReplace = "(\\<"+label+"\\>)\\S+(\\<\\/"+label+"\\>)";
        String strLogger = source;
        strLogger = source.replaceAll (regReplace,"$1"+value+"$2");
        return strLogger;
    }


    /**
     *
     * @param source 需要处理的xml
     * @param label 需要匹配的标签
     * @param value 需要处理的数据
     * @param type 选择处理方式 type为1：信用卡号，2：电话，3：身份证号, 4:姓名
     * @return
     */
    public static String xmlReplace2(String source,String label,String value,int type)
    {
        if(StringUtils.isBlank(source)||StringUtils.isBlank(label)||StringUtils.isBlank(value)){
            return source;
        }
        //xml文件中对应的标签名称需要修改
        label = label.toUpperCase();
        String regReplace ="<"+label+">"+value+"</"+label+">";
        String regNewReplace ="";
        String strLogger = source;
        switch (type) {
            case 1:
                regNewReplace ="<"+label+">"+markCreditCard(value)+"</"+label+">";
                break;
            case 2:
                regNewReplace ="<"+label+">"+markMobile(value)+"</"+label+">";
                break;
            case 3:
                regNewReplace ="<"+label+">"+markIDCard(value)+"</"+label+">";
                break;
            case 4:
                regNewReplace ="<"+label+">"+markName(value)+"</"+label+">";
                break;
        }
        if(StringUtils.isNotBlank(regNewReplace)){
            strLogger=strLogger.replace(regReplace,regNewReplace);
        }
        return strLogger;
    }

}
