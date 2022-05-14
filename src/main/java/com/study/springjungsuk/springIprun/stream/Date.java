package com.study.springjungsuk.springIprun.stream;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date {

    public static void main(String[] args)  {
        String exDate = "20220214";
        exDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));


        System.out.println("newstring = " + exDate);
     }
    }





