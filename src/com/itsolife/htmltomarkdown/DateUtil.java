package com.itsolife.htmltomarkdown;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * 日期操作工具类
 * @author robin
 *
 */
public class DateUtil {

	public DateUtil() {

	}

	/**
	 * 得到当前时间值，格式：yyyy年MM月dd日HH时mm分ss秒
	 * 
	 * @return String值
	 */
	public static String getNowTime() {
		try {
			Date date = new Date();
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyy年MM月dd日HH时mm分ss秒sss");
			String s = simpledateformat.format(date);
			return s;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 得到当前日期值，格式：yyyy年MM月dd日
	 * 
	 * @return String值
	 */
	public static String getNowDate() {
		try {
			Date date = new Date();
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyy年MM月dd日");
			String s = simpledateformat.format(date);
			return s;
		} catch (Exception e) {
			return "";
		}
	}
	
	/**
	 * 返回指定Date值的时间值，格式：yyyy年MM月dd日HH时mm分ss秒
	 * 
	 * @param date
	 *            需要转换的日期
	 * @return String值
	 */
	public static String dateToString(Date date) {
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyy年MM月dd日HH时mm分ss秒");
			String s = simpledateformat.format(date);
			return s;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 
	 * 返回指定Date值的时间值
	 * 
	 * @param date
	 *            需要转换的日期
	 * @param pattern
	 *            时间格式
	 * @return String值
	 */
	public static String dateToStringCus(Date date, String pattern) {
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat(pattern);
			String s = simpledateformat.format(date);
			return s;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 返回指定Date值的时间值，格式：yyyy-MM-dd HH:mm
	 * 
	 * @param date
	 *            需要转换的日期
	 * @return String值
	 */
	public static String dateToCode(Date date) {
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm");
			String s = simpledateformat.format(date);
			return s;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 返回指定Date值的时间值，格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 *            需要转换的日期
	 * @return String值
	 */
	public static String dateToAllCode(Date date) {
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String s = simpledateformat.format(date);
			return s;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 返回指定Date值的时间值，格式：HH:mm:ss
	 * 
	 * @param date
	 *            需要转换的日期
	 * @return String值
	 */
	public static String dateToTimeCode(Date date) {
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat("HH:mm:ss");
			String s = simpledateformat.format(date);
			return s;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 返回指定Date值的时间值，格式：yyyy年MM月dd日
	 * 
	 * @param date
	 *            需要转换的日期
	 * @return String值
	 */
	public static String dateToShortString(Date date) {
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyy年MM月dd日");
			String s = simpledateformat.format(date);
			return s;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 返回指定Date值的时间值，格式：yyyy-MM-dd
	 * 
	 * @param date
	 *            需要转换的日期
	 * @return String值
	 */
	public static String dateToShortCode(Date date) {
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyy-MM-dd");
			String s = simpledateformat.format(date);
			return s;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 按“-”分割指定Date值
	 * 
	 * @param date
	 *            需要转换的日期
	 * @return String[]值
	 */
	public static String[] SplitDate(Date date) {
		String s = dateToShortCode(date);
		String[] temp = new String[3];
		StringTokenizer st = new StringTokenizer(s, "-");
		int i = 0;
		while (st.hasMoreTokens()) {
			temp[i] = st.nextToken();
			i++;
		}
		return temp;
	}

	/**
	 * 转换字符串为Date值，字符串格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param s
	 *            需要转换的字符串，字符串格式：yyyy-MM-dd HH:mm:ss
	 * @return Date值
	 */
	public static Date strToDate(String s) {
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Date date = simpledateformat.parse(s);
			return date;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 转换字符串为Date值，字符串格式：HH:mm:ss
	 * 
	 * @param s
	 *            需要转换的字符串，字符串格式：HH:mm:ss
	 * @return Date值
	 */
	public static Date timeCodeToDate(String s) {
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat("HH:mm:ss");
			Date date = simpledateformat.parse(s);
			return date;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 转换字符串为Date值，字符串格式：yyyy-MM-dd
	 * 
	 * @param s
	 *            需要转换的字符串，字符串格式：yyyy-MM-dd
	 * @return Date值
	 */
	public static Date strToShortday(String s) {
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyy-MM-dd");
			ParsePosition parseposition = new ParsePosition(0);
			Date date = simpledateformat.parse(s, parseposition);
			return date;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 转换字符串为Date值，字符串格式：yyyyMMdd
	 * 
	 * @param s
	 *            需要转换的字符串，字符串格式：yyyyMMdd
	 * @return Date值
	 */
	public static Date strToShortNoday(String s) {
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyyMMdd");
			ParsePosition parseposition = new ParsePosition(0);
			Date date = simpledateformat.parse(s, parseposition);
			return date;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 返回当前Date对象
	 * 
	 * @return Date值
	 */
	public static Date getNow() {
		Date date = new Date();
		return date;
	}

	/**
	 * 转换日期字符串为long值，字符串格式：yyyy-MM-dd
	 * 
	 * @param s
	 *            需要转换的字符串，字符串格式：yyyy-MM-dd
	 * @return long值
	 */
	public static long getS(String s) {
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyy-MM-dd");
			ParsePosition parseposition = new ParsePosition(0);
			Date date = simpledateformat.parse(s, parseposition);
			return date.getTime();
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 转换日期字符串为long值，字符串格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param s
	 *            需要转换的字符串，字符串格式：yyyy-MM-dd HH:mm:ss
	 * @return long值
	 */
	public static long getStrToLong(String s) {
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			ParsePosition parseposition = new ParsePosition(0);
			Date date = simpledateformat.parse(s, parseposition);
			return date.getTime();
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 得到long类型日期值
	 * 
	 * @return long值
	 */
	public static long getLongTime() {
		return (new Date()).getTime();
	}

	/**
	 * 得到某个时间距离现在的分钟数
	 * 
	 * @param l
	 *            日期long类型值
	 * @return long值
	 */
	public static long getOffMinutes(long l) {
		return getOffMinutes(l, System.currentTimeMillis());
	}

	/**
	 * 得到两个时间之间的时间差，单位为：分钟
	 * 
	 * @param l
	 *            第一个日期long类型值
	 * @param l1
	 *            第二个日期long类型值
	 * @return long值
	 */
	public static long getOffMinutes(long l, long l1) {
		return (long) ((l1 - l) / 60000L);
	}

	/**
	 * 根据指定时间格式字符串（格式:yyyy-MM-dd），取得该时间对应的周一至周日Date对象 Date first =
	 * DateUtil.getMonday(today,Calendar.SUNDAY); Date last =
	 * DateUtil.getMonday(today,Calendar.SATURDAY);
	 * 
	 * @param date
	 *            String类型，格式:yyyy-MM-dd
	 * @param weekDay
	 *            一周的第几天，第一天为Calendar.SUNDAY，第七天为Calendar.SATURDAY
	 * @return Date值
	 */
	public static Date getMonday(String date, int weekDay) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = format.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		// ����DAY_OF_WEEK��˵��
		// Field number for get and set indicating
		// the day of the week. This field takes values
		// SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
		// and SATURDAY
		cal.set(Calendar.DAY_OF_WEEK, weekDay);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}

	/**
	 * 根据指定时间格式字符串（格式:yyyy-MM），取得该时间对应月份第一天Date对象
	 * 
	 * @param date
	 *            String类型，格式:yyyy-MM
	 * @return Date值
	 */
	public static Date getMonthFirstDay(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		Date d = null;
		try {
			d = format.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DAY_OF_MONTH, 0);
		return cal.getTime();
	}

	/**
	 * 根据指定时间格式字符串（格式:yyyy-MM），取得该时间对应月份最后一天Date对象
	 * 
	 * @param date
	 *            String类型，格式:yyyy-MM
	 * @return Date值
	 */
	public static Date getMonthLastDay(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		Date d = null;
		try {
			d = format.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 根据指定时间格式字符串（格式:yyyy），取得该时间对应年份第一天Date对象
	 * 
	 * @param date
	 *            String类型，格式:yyyy
	 * @return Date值
	 */
	public static Date getYearFirstDay(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		Date d = null;
		try {
			d = format.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DAY_OF_YEAR, 0);
		return cal.getTime();
	}

	/**
	 * 根据指定时间格式字符串（格式:yyyy），取得该时间对应年份最后一天Date对象
	 * 
	 * @param date
	 *            String类型，格式:yyyy
	 * @return Date值
	 */
	public static Date getYearLastDay(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		Date d = null;
		try {
			d = format.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.YEAR, 1);
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}
	/**
	 * 指定时间对象，根据日历的规则，为给定的日历字段添加或减去指定的时间量,返回时间对象
	 * @param date Date类型
	 * @param field int 日历字段,如：Calendar.DAY_OF_MONTH
	 * @param amount int 为字段添加的日期或时间量。
	 * @return Date值
	 */
	public static Date getDate(Date date,int field, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, amount);
		return cal.getTime();
	}
	/**
	 * 转换long值为字符串类型日期格式
	 * 
	 * @param l
	 *            long值
	 * @return String值
	 */
	public static String LongToDateString(long l) {
		DateFormat mediumDateFormat = null;
		Date sDate = null;
		try {
			mediumDateFormat = DateFormat.getDateTimeInstance();
			String date = String.valueOf(l);
			sDate = new Date(Long.parseLong(date));
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return mediumDateFormat.format(sDate);
	}
	
	/**
	 * 将String类型数据转换为Date类型
	 * @param dt String类型日期数值
	 * @return Date类型的日期
	 */
	public static Date convertStringToDate(String dt) {
		if (dt == null || dt.equals("")) {
			return null;
		}
		return convertStringToDate("yyyy-MM-dd", dt);
	}

	public static Date convertStringToDate(String style, String dt) {
		if (dt == null || dt.equals("")) {
			return null;
		}
		if (style == null || style.equals("")) {
			style = "yyyy-MM-dd";
		}
		SimpleDateFormat dateformat = new SimpleDateFormat(style);
		dateformat.setLenient(false);
		try {
			return dateformat.parse(dt);
		} catch (ParseException ex) {
			return null;
		}

	}
	
	/**
	 * 返回指定Date值的时间值，格式：yyyy-MM-ddTHH:mm:ss
	 * 
	 * @param date
	 *            需要转换的日期
	 * @return String值
	 */
	public static String dateToBOMCStrDate(Date date) {
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String s = simpledateformat.format(date);
			s=StrToBOMCStrDate(s);
			return s;
		} catch (Exception e) {
			return "";
		}
	}
	/**
	 * 返回指定Date值的时间值，格式：yyyy-MM-ddTHH:mm:ss
	 * 
	 * @param date 格式：yyyy-MM-dd HH:mm:ss
	 *            需要转换的日期
	 * @return String值
	 */
	public static String StrToBOMCStrDate(String date) {
			return date.replace(" ", "T");
	}
}