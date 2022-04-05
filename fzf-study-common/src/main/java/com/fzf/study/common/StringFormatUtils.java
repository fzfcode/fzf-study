package com.fzf.study.common;

/**
 * @author: SunKe
 * @date: 2020/9/15 4:30 下午
 * @description: 字符串格式化工具类
 */
public class StringFormatUtils {

    /**
     * 将对象列表转换为字符串并截取长度
     * @param contentMaxSize 截取最大长度
     * @param content 对象列表
     * @return 对象列表格式化结果
     */
    public static String format(Integer contentMaxSize, Object... content) {
        StringBuilder stringBuilder = new StringBuilder();
        if (content != null && content.length > 0) {
            for (int i = 0; i < content.length; i++) {
                String objStr = String.valueOf(content[i]);
                stringBuilder.append(objStr);
                if (content.length - 1 != i) {
                    stringBuilder.append(",");
                }
            }
        }
        //截取长度
        String contextStr = stringBuilder.toString();
        contextStr = stringBuilder.length() <= contentMaxSize ? contextStr : contextStr.substring(0, contentMaxSize - 3) + "...";
        return contextStr;
    }
}
