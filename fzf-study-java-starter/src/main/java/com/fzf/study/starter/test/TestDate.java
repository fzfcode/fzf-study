package com.fzf.study.starter.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: fanzhenfeng
 * @date: 2022/5/28 1:46 下午
 * @description:
 * @version: v1.0
 */
public class TestDate {

    public static void main(String[] args) {
        String dateStr= "2016年10月25日";
        String dateStr2= "2022-03-25";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");

        //LocalDate练习
        LocalDate date= LocalDate.parse(dateStr, formatter);
        System.out.println(date);
        String format1 = date.format(formatter);
        System.out.println(format1);


        System.out.println("-----------------------------");


        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date2= LocalDate.parse(dateStr2, formatter2);
        System.out.println(date2);
        String format2 = date2.format(formatter2);
        System.out.println(format2);

        System.out.println("-----------------------------");

        String dateTimeStr= "2016-10-25 12:00:00";
        DateTimeFormatter formatter02 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime=LocalDateTime.parse(dateTimeStr,formatter02);
        System.out.println(localDateTime);
        String format = localDateTime.format(formatter02);
        System.out.println(format);

        System.out.println("-----------------------------");

        String date1 = "2022-03-04";
        Date sql_date = java.sql.Date.valueOf(date1);
        System.out.println("sql_date="+sql_date);

        Date cr_date = new java.sql.Date(2022 - 1900, 3 - 1, 4);
        System.out.println("cr_date:"+cr_date);

        SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
        SimpleDateFormat sdfw = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date newDate = sdf.parse(date1);
            Calendar cal = Calendar.getInstance();
            cal.setTime(newDate);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(sql_date);
            System.out.println("cal2="+sdfw.format(cal2.getTime()));

            cal2.set(Calendar.MONTH,02);
            System.out.println("month-calendar="+cal2.get(Calendar.MONTH));

            System.out.println("newDate="+sdfw.format(cal2.getTime()));

            Integer month = Integer.valueOf(sdf.format(sql_date).substring(0,2));
            Integer day = Integer.valueOf(sdf.format(sql_date).substring(2,4));
            System.out.println("month="+month);
            System.out.println("day="+day);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
