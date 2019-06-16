package com.itheima.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/********
 * author:shenkunlin
 * date:2018/8/24 15:05
 * description:深圳黑马
 * version:1.0
 ******/
public class DateUtil {

    public static SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy年MM月dd日");
    public static SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy/MM/dd");
    public static SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /****
     * date类型转字符串
     * @param date
     * @return
     */
    public static String date2str(Date date,SimpleDateFormat simpleDateFormat){
        return simpleDateFormat.format(date);
    }

    public static void main(String[] args) {
        System.out.println(date2str(new Date(), DateUtil.simpleDateFormat2));
    }

}
