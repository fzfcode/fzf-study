package com.fzf.study.common;

import java.io.UnsupportedEncodingException;

/**
 * @author: fanzhenfeng
 * @date: 2022/5/10 10:02 上午
 * @description:
 * @version: v1.0
 */
public class ChineseHandlerUtils {


    /**
     * 处理乱码
     * byte 返回如果小于0则表示是中文
     * utf-8编码中文三个字节表示一个字；gbk编码中文两个字节表示一个字
     * @return
     */
    public static String handleGarbled(String chineseCode){
        try {
            byte[] chbt = chineseCode.getBytes("utf-8");
            System.out.println(chbt.length);

            for(int i = 0;i<chbt.length;i++){
                byte[] ne = new byte[3];
                if(i+2<chbt.length){
                    if(chbt[i]<0 && chbt[i+1]<0 && chbt[i+2]<0){
                        ne[0] = chbt[i];
                        ne[1] = chbt[i+1];
                        ne[2] = chbt[i+2];
                        System.out.println("中文:"+ new String(ne,"utf-8"));
                        i=i+2;
                    }else{
                        System.out.println("i:"+ chbt[i]);
                    }
                }else{
                    ne[0] = chbt[i];
                    System.out.println("i:"+ new String(ne));
                }
            }
            char[] ch = chineseCode.toCharArray();
            for(char i : ch){
                System.out.println("i= "+i);
                ChineseHandlerUtils.isChinese(i);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "";

    }

    /***
     * 判断字符是否为中文
     * @param ch 需要判断的字符
     * @return 中文返回true，非中文返回false
     */
    public static boolean isChinese(char ch) {
        //获取此字符的UniCodeBlock
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(ch);
        //  GENERAL_PUNCTUATION 判断中文的“号
        //  CJK_SYMBOLS_AND_PUNCTUATION 判断中文的。号
        //  HALFWIDTH_AND_FULLWIDTH_FORMS 判断中文的，号
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION         // 判断中文的。号
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS       // 判断中文的，号
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION                 // 判断中文的“号
        ){
            System.out.println(ch + " 是中文");
            return true;
        }
        return false;
    }
}
