package com.hand.re.utils;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Created with IDEA
 * @author:longming
 * @Date: 2021/6/2
 * @Time: 10:11
 * @Description:
 */
public class DateUtilsTest {

    /**
     * 测试日期所在的期间
     * @throws ParseException
     */
    @Test
    public void getPeriodWithDateTest() throws ParseException {
        String dateStr = "2021-12-02";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(dateStr);
        String monthPeriod = DateUtils.getPeriodWithDate(date,"MONTH");
        String yearPeriod = DateUtils.getPeriodWithDate(date,"YEAR");
        String quarterPeriod = DateUtils.getPeriodWithDate(date,"QUARTER");
        System.out.println(monthPeriod);
        System.out.println(yearPeriod);
        System.out.println(quarterPeriod);
    }

    /**
     * 获取上一期间
     *
     * @throws ParseException
     */
    @Test
    public void getLastPeriod() throws ParseException {
        String periodMonth = "2021-01";
        String periodQuarter = "2021-Q1";
        String periodYear = "2021";

        String monthPeriod = DateUtils.getLastPeriod(periodMonth,"MONTH");
        String yearPeriod = DateUtils.getLastPeriod(periodYear,"YEAR");
        String quarterPeriod = DateUtils.getLastPeriod(periodQuarter,"QUARTER");
        System.out.println(monthPeriod);
        System.out.println(yearPeriod);
        System.out.println(quarterPeriod);
    }

    /**
     *测试获取期间的开始时间
     *
     * @throws ParseException
     */
    @Test
    public void getPeriodStartTime() throws ParseException {
        String periodMonth = "2021-02";
        String periodQuarter = "2021-Q4";
        String periodYear = "2021";

        Date monthDate = DateUtils.getPeriodStartTime(periodMonth,"MONTH");
        Date yearDate = DateUtils.getPeriodStartTime(periodYear,"YEAR");
        Date quarterDate = DateUtils.getPeriodStartTime(periodQuarter,"QUARTER");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(monthDate));
        System.out.println(format.format(yearDate));
        System.out.println(format.format(quarterDate));
    }

    /**
     *测试获取期间的开始时间
     *
     * @throws ParseException
     */
    @Test
    public void getPeriodEndTime() throws ParseException {
        String periodMonth = "2021-02";
        String periodQuarter = "2021-Q3";
        String periodYear = "2021";

        Date monthDate = DateUtils.getPeriodEndTime(periodMonth,"MONTH");
        Date yearDate = DateUtils.getPeriodEndTime(periodYear,"YEAR");
        Date quarterDate = DateUtils.getPeriodEndTime(periodQuarter,"QUARTER");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(monthDate));
        System.out.println(format.format(yearDate));
        System.out.println(format.format(quarterDate));
    }
}
