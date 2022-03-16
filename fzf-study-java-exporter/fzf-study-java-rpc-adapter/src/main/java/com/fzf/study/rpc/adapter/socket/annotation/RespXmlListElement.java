package com.fzf.study.rpc.adapter.socket.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface RespXmlListElement {
    String elementName() default "##default";

    Class subType() default DEFAULT.class;

    final class DEFAULT {
    }
}