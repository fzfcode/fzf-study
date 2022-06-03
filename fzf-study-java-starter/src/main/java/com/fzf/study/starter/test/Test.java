package com.fzf.study.starter.test;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: fanzhenfeng
 * @date: 2022/4/26 7:40 下午
 * @description:
 * @version: v1.0
 */
public class Test {


    public static void main(String[] args) {
        List<User> list= new ArrayList<>();
        list.add(new User("BCDE"));
        list.add(new User("BD"));
        list.add(new User("BCD"));
        list.add(new User("D"));
        list.add(new User("ACD"));

        List<User> result = list.stream()
                .filter( s -> s.isStartA(s.name))
                .map(s -> {
                    System.out.println("执行map");;s.setName(s.name);return s;})
                .collect(Collectors.toList());
        System.out.println("result:"+result);
    }
}
@ToString
class User{

    public User(String name){

        this.name = name;
    }

    public  User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;


    public Boolean isStartA(String s){
        System.out.println(s);
        Boolean res = s.startsWith("A");
        System.out.println("res:"+res);
        System.out.println("--------------------");

        return res;

    }



}