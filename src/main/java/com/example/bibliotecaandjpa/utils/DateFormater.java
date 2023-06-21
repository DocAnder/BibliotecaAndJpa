package com.example.bibliotecaandjpa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class DateFormater {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");

    public static Date stringParaData(String data){
        try{
            return DateFormater.sdf.parse(data);
        }catch(ParseException e){
            return null;
        }
    }

    public static String dateParaString(Date data){
        return DateFormater.sdf.format(data);
    }


}
