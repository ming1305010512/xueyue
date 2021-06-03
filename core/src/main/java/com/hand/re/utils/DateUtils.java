package com.hand.re.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/5/31
 * @Time: 16:51
 * @Description:
 */
public class DateUtils {

    /**
     * 获取日期所在的期间
     *
     * @param date 日期
     * @param periodType 期间类型（MONTH:月度,QUARTER:季度,YEAR:年度）
     * @return 返回格式（月度：yyyy-MM,季度yyyy-QM,年度：yyyy）
     */
    public static String getPeriodWithDate(Date date,String periodType){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get((Calendar.YEAR));
        if ("QUARTER".equals(periodType)) {
            String quarter = "1";
            if (month <= 3) {
                quarter = "1";
            } else if (month <= 6) {
                quarter = "2";
            } else if (month <= 9) {
                quarter = "3";
            } else {
                quarter = "4";
            }
            return year+"-Q"+quarter;
        }else if ("MONTH".equals(periodType)){
            if (month<10){
                return year+"-0"+month;
            }else {
                return year+"-"+month;
            }
        }else {
            return String.valueOf(year);
        }
    }

    /**
     * 获取上一期间
     *
     * @param period 期间，格式为（月度：yyyy-MM,季度yyyy-QM,年度：yyyy）
     * @param periodType 期间类型（MONTH:月度,QUARTER:季度,YEAR:年度）
     * @return
     */
    public static String getLastPeriod(String period,String periodType){
        String [] periodArr = period.split("-");
        int year = Integer.valueOf(periodArr[0]);
        if ("QUARTER".equals(periodType)){
            int quarter = Integer.valueOf(periodArr[1].substring(1,2));
            if (quarter == 1){
                year -= 1;
                quarter = 4;
            }else {
                quarter -= 1;
            }
            return year+"-Q"+quarter;
        }else if ("MONTH".equals(periodType)){
            int month = Integer.valueOf(periodArr[1]);
            if (month == 1){
                year -= 1;
                month = 12;
            }else {
                month -= 1;
            }
            if (month<10){
                return year+"-0"+month;
            }else {
                return year+"-"+month;
            }
        }else {
            year -= 1;
            return String.valueOf(year);
        }
    }

    /**
     * 获取期间的开始时间
     *
     * @param period 期间，格式为（月度：yyyy-MM,季度yyyy-QM,年度：yyyy）
     * @param periodType 期间类型（MONTH:月度,QUARTER:季度,YEAR:年度）
     * @return
     */
    public static Date getPeriodStartTime(String period,String periodType){
        String [] periodArr = period.split("-");
        int year = Integer.valueOf(periodArr[0]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        int month = 1;
        if ("QUARTER".equals(periodType)){
            int quarter = Integer.valueOf(periodArr[1].substring(1,2));
            switch (quarter){
                case 1 : month = 1;break;
                case 2 : month = 4;break;
                case 3 : month = 7;break;
                default: month = 10;break;
            }
        }else if ("MONTH".equals(periodType)){
            month = Integer.valueOf(periodArr[1]);
        }else if ("YEAR".equals(periodType)){
            month = 1;
        }
        calendar.set(Calendar.MONTH,month-1);
        //获取某月的最小天数
        int firstDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置月份中的最小天数
        calendar.set(Calendar.DAY_OF_MONTH,firstDay);
        return calendar.getTime();
    }

    /**
     * 获取期间的结束时间
     *
     * @param period 期间，格式为（月度：yyyy-MM,季度yyyy-QM,年度：yyyy）
     * @param periodType 期间类型（MONTH:月度,QUARTER:季度,YEAR:年度）
     * @return
     */
    public static Date getPeriodEndTime(String period,String periodType){
        String [] periodArr = period.split("-");
        int year = Integer.valueOf(periodArr[0]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        int month = 12;
        if ("QUARTER".equals(periodType)){
            int quarter = Integer.valueOf(periodArr[1].substring(1,2));
            switch (quarter){
                case 1 : month = 3;break;
                case 2 : month = 6;break;
                case 3 : month = 9;break;
                default: month = 12;break;
            }
        }else if ("MONTH".equals(periodType)){
            month = Integer.valueOf(periodArr[1]);
        }else if ("YEAR".equals(periodType)){
            month = 12;
        }
        calendar.set(Calendar.MONTH,month-1);
        //获取某月的最小天数
        int firstDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置月份中的最小天数
        calendar.set(Calendar.DAY_OF_MONTH,firstDay);
        return calendar.getTime();
    }
}
