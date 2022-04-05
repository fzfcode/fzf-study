package com.fzf.study.common;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {

    private GsonUtils() {
        throw new IllegalStateException("gson class state illegal");
    }

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    private static Gson prettyGson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").setPrettyPrinting().create();

    /**
     * gson.fromJson(json, new TypeToken<List<Customer>>() {}.getType());
     * @param json
     * @param typeToken
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, TypeToken<T> typeToken) {
        return gson.fromJson(json, typeToken.getType());
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static String toJson(Object o) {
        return gson.toJson(o);
    }

    /**
     * print pretty
     * @param o
     * @param pretty
     * @return
     */
    public static String toJson(Object o, boolean pretty) {
        if (pretty) {
            return prettyGson.toJson(o);
        }
        return toJson(o);
    }
}
