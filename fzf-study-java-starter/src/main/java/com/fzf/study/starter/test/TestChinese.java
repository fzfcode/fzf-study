package com.fzf.study.starter.test;

import com.fzf.study.common.ChineseHandlerUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author: fanzhenfeng
 * @date: 2022/5/10 10:56 上午
 * @description:
 * @version: v1.0
 */
public class TestChinese {

    public static void main(String[] args) {
        String chinese = "abc你，好";
        try {
        byte[] chbt = chinese.getBytes("utf-8");
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
        char[] ch = chinese.toCharArray();
        for(char i : ch){
            System.out.println("i= "+i);
            ChineseHandlerUtils.isChinese(i);
        }


        String str = "这是一段字符串";
        byte[] bytes = new byte[0];
            bytes = str.getBytes("UTF-8");
            String newStr = new String(bytes, "UTF-8");
            System.out.println("newstr:"+newStr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
