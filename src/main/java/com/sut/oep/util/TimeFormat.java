package com.sut.oep.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat {
    public static String getTime(){
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return ft.format(date);
    }
}
