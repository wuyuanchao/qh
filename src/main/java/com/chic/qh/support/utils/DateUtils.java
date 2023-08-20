package com.chic.qh.support.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 日期处理相关工具类
 */
public class DateUtils {

	private final static Logger logger = LoggerFactory.getLogger(DateUtils.class);
	/** 定义常量 **/
	public static final String DATE_JFP_STR = "yyyyMM";
	public static final String DATE_FULL_STR = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FULL_T_STR = "yyyy-MM-dd'T'HH:mm:ssz";
	public static final String DATE_FULL_T_STR2 = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String DATE_FULL_STR1 = "yyyy-MM-dd HH:mm";
	public static final String DATE_FULL_STR2 = "yyyy-MM-dd HH";
	public static final String DATE_FULL_STR3 = "HH:mm:ss dd/MM/yyyy";

//	public static final String DATE_SMALL_STR = "yyyy-MM-dd";
	public static final String DATE_SMALL_STR = "yyyy-MM-dd";
	public static final String DATE_STR = "MM/dd/yyyy";
	public static final String DATE_STR_2 = "dd/MM/yyyy";

	public static final int one_day_minutes = 1440;
	public static final int ONE_MINUTES = 60;
	public static final int ONE_DAY = 86400;
	public static final int SEVEN_DAY = 604800;
	public static final long TWO_DAY = 172800L;
	public static final int ONE_HOUR = 3600;

	public static final String DATE_KEY_STR = "yyMMddHHmmss";
	public static final String HOUR = "HOUR";
	public static final String MINUTE = "MINUTE";
	private static final String[] CN_MONTH = { "", "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月",
			"十二月" };

	private static Map<String, ThreadLocal<SimpleDateFormat>> dateFormats = new HashMap<String, ThreadLocal<SimpleDateFormat>>();
	private static SimpleDateFormat getDateFormatter(final String format) {
		ThreadLocal<SimpleDateFormat> formatLocal = dateFormats.get(format);
		if (formatLocal == null) {
			formatLocal = new ThreadLocal<SimpleDateFormat>() {
				protected SimpleDateFormat initialValue() {
					return new SimpleDateFormat(format);
				}
			};
			dateFormats.put(format, formatLocal);
		}
		return formatLocal.get();
	}

	public static String formatDate(String format, Date date) {
		if (date == null)
			return null;
		SimpleDateFormat formatter = getDateFormatter(format);
		return formatter.format(date);
	}

	public static Date getNextTime(Date date, int type, int n) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if (type == Calendar.DATE) {
			c.set(Calendar.DATE, c.get(Calendar.DATE) + n);
		} else if (type == Calendar.HOUR_OF_DAY) {
			c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + n);
		} else if (type == Calendar.MINUTE) {
			c.set(Calendar.MINUTE, c.get(Calendar.MINUTE) + n);
		} else if (type == Calendar.SECOND) {
			c.set(Calendar.SECOND, c.get(Calendar.SECOND) + n);
		} else if (type == Calendar.MILLISECOND) {
			c.set(Calendar.MILLISECOND, c.get(Calendar.MILLISECOND) + n);
		}
		return c.getTime();
	}

	public static Date addDateTime(Date date, Long times) {
		Calendar cal = Calendar.getInstance();
		long addMill = date.getTime() + times;
		cal.setTimeInMillis(addMill);
		return cal.getTime();
	}

	public static String format(Date date) {

		return format(date, DATE_SMALL_STR);
	}

	public static String format(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		}
		return null;
	}

	/**
	 * 获取系统当前时间
	 *
	 * @return
	 */
	public static String getDateStr(Date date) {
		SimpleDateFormat df = new SimpleDateFormat(DATE_FULL_STR);
		return df.format(date);
	}

	/**
	 * 获取系统当前时间
	 *
	 * @return
	 */
	public static String getDateStr(Date date, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}

	/**
	 * 使用预设格式提取字符串日期
	 *
	 * @param strDate 日期字符串
	 * @return
	 */
	public static Date parse(String strDate) {
		return parse(strDate, DATE_FULL_STR);
	}

	public static Date parseSmall(String strDate) {
		return parse(strDate, DATE_SMALL_STR);
	}

	/**
	 * 使用用户格式提取字符串日期
	 *
	 * @param strDate 日期字符串
	 * @param pattern 日期格式
	 * @return
	 */
	public static Date parse(String strDate, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(strDate);
		} catch (ParseException e) {
			logger.error("出现异常", e);
			return null;
		} catch (Exception e) {
			logger.error("出现异常", e);
			return null;
		}
	}

	/**
	 * 两个时间比较 前者 = 后者: 返回 0; 前者 > 后者: 返回 1;
	 *
	 * 前者 < 后者: 返回 -1;
	 *
	 *
	 * @param date
	 * @return
	 */
	public static int compareDate(Date date1, Date date2) {
		int rnum = date1.compareTo(date2);
		return rnum;
	}

	/**
	 * 两个时间比较
	 *
	 * @param date
	 * @return
	 */
	public static int compareDateWithNow(Date date1) {
		Date date2 = new Date();
		int rnum = date1.compareTo(date2);
		return rnum;
	}

	/**
	 * 两个时间比较(时间戳比较)
	 *
	 * @param date
	 * @return
	 */
	public static int compareDateWithNow(long date1) {
		long date2 = dateToUnixTimestamp();
		if (date1 > date2) {
			return 1;
		} else if (date1 < date2) {
			return -1;
		} else {
			return 0;
		}
	}

	public static boolean compareDateMoreThanADay(Date start, Date end) {
		long cha = end.getTime() - start.getTime();
		double result = cha * 1.0 / (1000 * 60 * 60);
		if (result <= 24) {
			return false; // 说明小于24小时
		} else {
			return true;
		}
	}

	/**
	 * 获取系统当前时间
	 *
	 * @return
	 */
	public static String getNowTime() {
		SimpleDateFormat df = new SimpleDateFormat(DATE_FULL_STR);
		return df.format(new Date());
	}

	/**
	 * 获取系统当前时间
	 *
	 * @return
	 */
	public static String getNowTime(String type) {
		SimpleDateFormat df = new SimpleDateFormat(type);
		return df.format(new Date());
	}

	/**
	 * 获取系统当前计费期
	 *
	 * @return
	 */
	public static String getJFPTime() {
		SimpleDateFormat df = new SimpleDateFormat(DATE_JFP_STR);
		return df.format(new Date());
	}

	/**
	 * 将指定的日期转换成Unix时间戳
	 *
	 * @param String date 需要转换的日期 yyyy-MM-dd HH:mm:ss
	 * @return long 时间戳
	 */
	public static long dateToUnixTimestamp(String date) {
		long timestamp = 0;
		try {
			timestamp = new SimpleDateFormat(DATE_FULL_STR).parse(date).getTime();
		} catch (ParseException e) {
			logger.error("出现异常", e);
		} catch (Exception e) {
			logger.error("出现异常", e);
		}
		return timestamp;
	}

	/**
	 * 将指定的日期转换成Unix时间戳
	 *
	 * @param String date 需要转换的日期 yyyy-MM-dd
	 * @return long 时间戳
	 */
	public static long dateToUnixTimestamp(String date, String dateFormat) {
		long timestamp = 0;
		try {
			timestamp = new SimpleDateFormat(dateFormat).parse(date).getTime();
		} catch (ParseException e) {
			logger.error("出现异常", e);
		} catch (Exception e) {
			logger.error("出现异常", e);
		}
		return timestamp;
	}

	/**
	 * 将当前日期转换成Unix时间戳
	 *
	 * @return long 时间戳
	 */
	public static long dateToUnixTimestamp() {
		long timestamp = new Date().getTime();
		return timestamp;
	}

	/**
	 * 将Unix时间戳转换成日期
	 *
	 * @param long timestamp 时间戳
	 * @return String 日期字符串
	 */
	public static String unixTimestampToDate(long timestamp) {
		SimpleDateFormat sd = new SimpleDateFormat(DATE_FULL_STR);
		sd.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return sd.format(new Date(timestamp));
	}

	/**
	 * 将Unix时间戳转换成日期
	 *
	 * @param Integer timestamp 时间戳
	 * @return String 日期字符串
	 */
	public static String unixTimestampToDate(Integer timestamp) {
		SimpleDateFormat sd = new SimpleDateFormat(DATE_FULL_STR);
		sd.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return sd.format(new Date(timestamp * 1000l));
	}

	/**
	 * 将Unix时间戳转换成日期
	 *
	 * @param long timestamp 时间戳
	 * @return String 日期字符串
	 */
	public static String unixTimestampToDateT(Integer timestamp) {
		String str = unixTimestampToDate(timestamp * 1000l);
		DateTimeFormatter formatter0 = DateTimeFormatter.ofPattern(DATE_FULL_STR).withZone(ZoneId.of("Asia/Shanghai"));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FULL_T_STR);

		ZonedDateTime zoneTime = ZonedDateTime.parse(str, formatter0);

		return zoneTime.withFixedOffsetZone().format(formatter);
	}

	public static List<String> getDateSegmental(Date start, Date end) {
		List<String> dateList = new ArrayList<String>();
		Calendar dd = Calendar.getInstance();// 定义日期实例
		dd.setTime(start);// 设置日期起始时间
		while (dd.getTime().before(end)) {// 判断是否到结束日期
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_SMALL_STR);
			String str = sdf.format(dd.getTime());
			// logger.debug(str);//输出日期结果
			dateList.add(str);
			dd.add(Calendar.DAY_OF_MONTH, 1);
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_SMALL_STR);
		String str = sdf.format(dd.getTime());
		dateList.add(str);
		return dateList;
	}

	/**
	 * 获取指定多少天后的时间
	 *
	 * @param day
	 * @return
	 */
	public static Date getAfterDate(Date dNow, int day) {
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); // 得到日历
		calendar.setTime(dNow);// 把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, day); // 设置为前一天
		dBefore = calendar.getTime(); // 得到前一天的时间
		return dBefore;
	}

	public static String afterMinute(Date d, int minute) {

		return DateUtils.getDateStr(new Date(d.getTime() + minute * 60 * 1000), DateUtils.DATE_FULL_STR);

	}

	public static String afterTermDate(Date d, int minute) {

		return DateUtils.getDateStr(new Date(d.getTime() + minute * 60 * 1000), DateUtils.DATE_SMALL_STR);

	}

// 获取当天的开始时间
	public static Date getDayBegin() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	// 获取当天的开始时间
	public static Integer getDayBeginSecond() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Long time = cal.getTimeInMillis() / 1000;
		return time.intValue();
	}

// 获取当天的开始时间
	public static Integer getDayBeginWithTimeZone(String timeZone) {
		TimeZone curTimeZone = TimeZone.getTimeZone(timeZone);
		Calendar cal = new GregorianCalendar(curTimeZone);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Long time = cal.getTimeInMillis() / 1000;
		return time.intValue();
	}

	// 获取当天的结束时间
	public static Integer getDayEndWithTimeZone(String timeZone) {
		TimeZone curTimeZone = TimeZone.getTimeZone(timeZone);
		Calendar cal = new GregorianCalendar(curTimeZone);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 0);
		Long time = cal.getTimeInMillis() / 1000;
		return time.intValue();
	}

	// 获取当天的结束时间
	public static Date getDayEnd() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	// 获取昨天的开始时间
	public static Date getBeginDayOfYesterday() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayBegin());
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

	/***
	 * 获取昨天秒数
	 *
	 * @return
	 */
	public static long getBeginDayOfYesterdayTime() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayBegin());
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime().getTime();
	}

	/***
	 *
	 * @return
	 */
	public static long getEndDayOfYesterDayTime() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayEnd());
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime().getTime();
	}

	// 获取昨天的结束时间
	public static Date getEndDayOfYesterDay() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayEnd());
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

	// 获取明天的开始时间
	public static Date getBeginDayOfTomorrow() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayBegin());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	// 获取明天的结束时间
	public static Date getEndDayOfTomorrow() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayEnd());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	// 获取本周的开始时间
	@SuppressWarnings("unused")
	public static Date getBeginDayOfWeek() {
		Date date = new Date();
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayofweek == 1) {
			dayofweek += 7;
		}
		cal.add(Calendar.DATE, 2 - dayofweek);
		return getDayStartTime(cal.getTime());
	}

	// 获取本周的结束时间
	public static Date getEndDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getBeginDayOfWeek());
		cal.add(Calendar.DAY_OF_WEEK, 6);
		Date weekEndSta = cal.getTime();
		return getDayEndTime(weekEndSta);
	}

	// 获取上周的开始时间
	@SuppressWarnings("unused")
	public static Date getBeginDayOfLastWeek() {
		Date date = new Date();
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayofweek == 1) {
			dayofweek += 7;
		}
		cal.add(Calendar.DATE, 2 - dayofweek - 7);
		return getDayStartTime(cal.getTime());
	}

	// 获取上周的结束时间
	public static Date getEndDayOfLastWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getBeginDayOfLastWeek());
		cal.add(Calendar.DAY_OF_WEEK, 6);
		Date weekEndSta = cal.getTime();
		return getDayEndTime(weekEndSta);
	}

	// 获取本月的开始时间
	public static Date getBeginDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		return getDayStartTime(calendar.getTime());
	}

	// 获取本月的结束时间
	public static Date getEndDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		int day = calendar.getActualMaximum(5);
		calendar.set(getNowYear(), getNowMonth() - 1, day);
		return getDayEndTime(calendar.getTime());
	}

	// 获取上月的开始时间
	public static Date getBeginDayOfLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 2, 1);
		return getDayStartTime(calendar.getTime());
	}

	// 获取上月的结束时间
	public static Date getEndDayOfLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 2, 1);
		int day = calendar.getActualMaximum(5);
		calendar.set(getNowYear(), getNowMonth() - 2, day);
		return getDayEndTime(calendar.getTime());
	}

	// 获取本年的开始时间
	public static Date getBeginDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DATE, 1);
		return getDayStartTime(cal.getTime());
	}

	// 获取本年的结束时间
	public static Date getEndDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DATE, 31);
		return getDayEndTime(cal.getTime());
	}

	// 获取某个日期的开始时间
	public static Timestamp getDayStartTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0,
				0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return new Timestamp(calendar.getTimeInMillis());
	}

	// 获取某个日期的结束时间
	public static Timestamp getDayEndTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23,
				59, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return new Timestamp(calendar.getTimeInMillis());
	}

	// 获取今年是哪一年
	public static Integer getNowYear() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return Integer.valueOf(gc.get(1));
	}

	// 获取本月是哪一月
	public static int getNowMonth() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return gc.get(2) + 1;
	}

	public static int getNowDayOfMonth() {
		Calendar now = Calendar.getInstance();
		return now.get(5);
	}

	// 获取小时点
	public static int getNowHour(Integer time, String timeZone) {
		try{
			SimpleDateFormat sf = new SimpleDateFormat(DATE_FULL_STR2);
			if(StringUtils.isNotBlank(timeZone)){
				sf.setTimeZone(TimeZone.getTimeZone(timeZone));
			}
			String format = sf.format(new Date((long) time * 1000L));
			String[] s = format.split(" ");
			return  Integer.valueOf(s[1]);
		}catch (Exception e){

		}
		return 23;
	}

	// 获取小时点
	public static int getNowHour(Integer time) {
		try{
			SimpleDateFormat sf = new SimpleDateFormat(DATE_FULL_STR2);
			String format = sf.format(new Date((long) time * 1000L));
			String[] s = format.split(" ");
			return  Integer.valueOf(s[1]);
		}catch (Exception e){

		}
		return 23;
	}

	// 获取小时点
	public static int getNowHour() {
		try{
			Integer currentSecond = getCurrentSecond();
			SimpleDateFormat sf = new SimpleDateFormat(DATE_FULL_STR2);
			String format = sf.format(new Date((long) currentSecond * 1000L));
			String[] s = format.split(" ");
			return  Integer.valueOf(s[1]);
		}catch (Exception e){

		}
		return 23;
	}

	// 获取小时点
	public static String getDateByTimeAndZone(Integer time, String formatStr, String timeZone) {
		try {
			formatStr = StringUtils.isBlank(formatStr) ? DATE_STR : formatStr;
			SimpleDateFormat sf = new SimpleDateFormat(formatStr);
			sf.setTimeZone(TimeZone.getTimeZone(timeZone));
			return sf.format(new Date((long) time * 1000L));
		} catch (Exception e) {

		}
		return "";
	}

	// 两个日期相减得到的天数
	public static int getDiffDays(Date beginDate, Date endDate) {
		if (beginDate == null || endDate == null) {
			throw new IllegalArgumentException("getDiffDays param is null!");
		}
		long diff = (endDate.getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24);
		int days = new Long(diff).intValue();
		return days;
	}

	// 两个日期相减得到的毫秒数
	public static long dateDiff(Date beginDate, Date endDate) {
		long date1ms = beginDate.getTime();
		long date2ms = endDate.getTime();
		return date2ms - date1ms;
	}

	// 获取两个日期中的最大日期
	public static Date max(Date beginDate, Date endDate) {
		if (beginDate == null) {
			return endDate;
		}
		if (endDate == null) {
			return beginDate;
		}
		if (beginDate.after(endDate)) {
			return beginDate;
		}
		return endDate;
	}

	// 获取两个日期中的最小日期
	public static Date min(Date beginDate, Date endDate) {
		if (beginDate == null) {
			return endDate;
		}
		if (endDate == null) {
			return beginDate;
		}
		if (beginDate.after(endDate)) {
			return endDate;
		}
		return beginDate;
	}

	// 返回某月该季度的第一个月
	public static Date getFirstSeasonDate(Date date) {
		final int[] SEASON = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4 };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int sean = SEASON[cal.get(Calendar.MONTH)];
		cal.set(Calendar.MONTH, sean * 3 - 3);
		return cal.getTime();
	}

	// 返回某个日期下几天的日期
	public static Date getNextDay(Date date, int i) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) + i);
		return cal.getTime();
	}

	// 返回某个日期前几天的日期
	public static Date getFrontDay(Date date, int i) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - i);
		return cal.getTime();
	}

	// 获取某年某月到某年某月按天的切片日期集合(间隔天数的集合)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getTimeList(int beginYear, int beginMonth, int endYear, int endMonth, int k) {
		List list = new ArrayList();
		if (beginYear == endYear) {
			for (int j = beginMonth; j <= endMonth; j++) {
				list.add(getTimeList(beginYear, j, k));
			}
		} else {
			{
				for (int j = beginMonth; j < 12; j++) {
					list.add(getTimeList(beginYear, j, k));
				}
				for (int i = beginYear + 1; i < endYear; i++) {
					for (int j = 0; j < 12; j++) {
						list.add(getTimeList(i, j, k));
					}
				}
				for (int j = 0; j <= endMonth; j++) {
					list.add(getTimeList(endYear, j, k));
				}
			}
		}
		return list;
	}

	// 获取某年某月按天切片日期集合(某个月间隔多少天的日期集合)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List getTimeList(int beginYear, int beginMonth, int k) {
		List list = new ArrayList();
		Calendar begincal = new GregorianCalendar(beginYear, beginMonth, 1);
		int max = begincal.getActualMaximum(Calendar.DATE);
		for (int i = 1; i < max; i = i + k) {
			list.add(begincal.getTime());
			begincal.add(Calendar.DATE, k);
		}
		begincal = new GregorianCalendar(beginYear, beginMonth, max);
		list.add(begincal.getTime());
		return list;
	}

	public static List<Integer> getMonthDateList() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);// 得到年份
		int month = calendar.get(Calendar.MONTH);// 得到月份
		List<Date> timeList = getTimeList(year, month, 1);
		List<Integer> dayList = new ArrayList<Integer>();
		for (Date date : timeList) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(date.getTime());
			String day = dateFormat.format(cal.getTime());
			dayList.add(Integer.parseInt(day));
		}

		return dayList;
	}

	public static Date getBeginDate(Date d) {

		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	public static Date getEndDate(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	public static Date getDateWithOffsetSecond(Date date, int offsetSecond) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.SECOND, offsetSecond);
		return cal.getTime();
	}

	// 获取月的开始时间
	public static Date getMonthStart(Integer monthNum) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), monthNum - 1, 1);
		return getDayStartTime(calendar.getTime());
	};

	// 获取月的结束时间
	public static Date getMonthEnd(Integer monthNum) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), monthNum - 1, 1);
		int day = calendar.getActualMaximum(5);
		calendar.set(getNowYear(), monthNum - 1, day);
		return getDayEndTime(calendar.getTime());
	};

	// 两个日期相减得到的分钟
	public static int getMinutes(Date beginDate, Date endDate) {
		if (beginDate == null || endDate == null) {
			throw new IllegalArgumentException("getDiffDays param is null!");
		}
		long minutes = (endDate.getTime() - beginDate.getTime()) / (1000 * 60);
		System.out.println("minutes:" + minutes);
		if (minutes >= 0 && minutes < 1) {
			System.out.println("输出结果为1");
			return 1;
		}
		int minute = new Long(minutes).intValue();
		return minute;
	}

	public static String getChMonth(Integer month) {
		if (month == null || month < 1 || month > 12) {
			return "";
		}
		return CN_MONTH[month];
	};

	/***
	 * 判断两个时间是否同一天
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameDate(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);

		boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
		boolean isSameMonth = isSameYear && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
		boolean isSameDate = isSameMonth && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);

		return isSameDate;
	}

	public static String dateToWeek(String datetime) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
		Calendar cal = Calendar.getInstance(); // 获得一个日历
		Date datet = null;
		try {
			datet = f.parse(datetime);
			cal.setTime(datet);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个周中的某天。
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	public static String getAfterMonth(String inputDate, int number) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			// 初始日期
			date = sdf.parse(inputDate);
		} catch (Exception e) {

		}
		// 设置日历时间
		c.setTime(date);
		// 在日历的月份上增加number个月
		c.add(Calendar.MONTH, number);
		// 的到你想要得number个月后的日期
		String strDate = sdf.format(c.getTime());
		return strDate;
	}

	/**
	 * 当前日期加上天数后的日期
	 *
	 * @param num 为增加的天数
	 * @return
	 */
	public static Date plusDay2(int num) {
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currdate = format.format(d);
		System.out.println("现在的日期是：" + currdate);
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
		d = ca.getTime();
		String enddate = format.format(d);
		System.out.println("增加天数以后的日期：" + enddate);
		return parse(enddate);
	}

	public static String formatTolong(Date date) {
		return format(date, DATE_SMALL_STR);
	}

	public static String parse(long time) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date.setTime(time);// java里面应该是按毫秒
		return sdf.format(date);
	}

	/***
	 *
	 *
	 * /** 获得当前时间秒数
	 */
	public static Integer getCurrentSecond() {
		return (int) (System.currentTimeMillis() / 1000);
	}
	/***
	 *
	 *
	 * /** 获得当前时间秒数
	 */
	public static long getCurrentSecondLong() {
		return System.currentTimeMillis() / 1000;
	}

	public static Long getCurrentSecondMill() {
		return System.currentTimeMillis();
	}

	/**
	 * 获得当前时间豪秒数
	 */
	public static String getCurrentMillSecond() {
		return String.valueOf(System.currentTimeMillis());
	}

	public static boolean getTimeOverlap(String startdate1, String enddate1, String startdate2, String enddate2) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date leftStartDate = null;
		Date leftEndDate = null;
		Date rightStartDate = null;
		Date rightEndDate = null;
		try {
			leftStartDate = format.parse(startdate1);
			leftEndDate = format.parse(enddate1);
			rightStartDate = format.parse(startdate2);
			rightEndDate = format.parse(enddate2);
		} catch (ParseException e) {
			return false;
		}
		return ((leftStartDate.getTime() >= rightStartDate.getTime())
				&& leftStartDate.getTime() < rightEndDate.getTime())
				|| ((leftStartDate.getTime() > rightStartDate.getTime())
						&& leftStartDate.getTime() <= rightEndDate.getTime())
				|| ((rightStartDate.getTime() >= leftStartDate.getTime())
						&& rightStartDate.getTime() < leftEndDate.getTime())
				|| ((rightStartDate.getTime() > leftStartDate.getTime())
						&& rightStartDate.getTime() <= leftEndDate.getTime());

	}

	public static Integer getMaxTime(Integer time1, Integer time2) {
		if (time1 - time2 >= 0) {
			return time1;
		}
		return time2;

	}

	public static String getFormatTime(Integer time, String format) {
		if (time == null || time == 0) {
			return "";
		}
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(new Date(time * 1000L));
	}

	public static void main(String[] args) {

		System.out.println(TimeZone.getTimeZone("MA"));

		/*String startdate1 = unixTimestampToDate(1595088000 * 1000L);

		String enddate1 = unixTimestampToDate(1595390340 * 1000L);

		String startdate2 = unixTimestampToDate(1595088000 * 1000L);

		String enddate2 = unixTimestampToDate(1595303940 * 1000L);

		System.out.println(getTimeOverlap(startdate1, enddate1, startdate2, enddate2));

		System.out.println(1595303940 - 1595390340);*/

	}


}
