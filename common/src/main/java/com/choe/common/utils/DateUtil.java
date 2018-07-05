package com.choe.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/** 日期时间处理工具 */
public class DateUtil {

	/** 缺省格式 */
	private String pattern = "yyyy-MM-dd HH:mm:ss";
	
	/** 一天的毫秒数 */
	private final long oneDayTime = 24*3600*1000;
	
	/** 缺省实例 */
	private static DateUtil defaultUtil = new DateUtil();


	// 年月日
	public static final SimpleDateFormat DATE_FORMAT_0 = new SimpleDateFormat("yy/MM/dd");
	// 年月日
	public static final SimpleDateFormat DATE_FORMAT_1 = new SimpleDateFormat("yyyy-MM-dd");
	// 年月
	public static final SimpleDateFormat DATE_FORMAT_2 = new SimpleDateFormat("yyyyMM");
	// 年月日时分秒
	public static final SimpleDateFormat DATE_FORMAT_3 = new SimpleDateFormat("yyyyMMddHHmmss");
	// yyyy-MM-dd HH:mm:ss
	public static final SimpleDateFormat DATE_FORMAT_4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// 年月日时分秒毫秒
	public static final SimpleDateFormat DATE_FORMAT_5 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    // 年月日时
    public static final SimpleDateFormat DATE_FORMAT_6 = new SimpleDateFormat("yyyy-MM-dd_HH");

	public static final SimpleDateFormat DATE_FORMAT_7 = new SimpleDateFormat("yyyyMMdd");

	
	public DateUtil(){}
	/**
	 * Date工具类
	 * @param pattern	格式(缺省：yyyy-MM-dd HH:mm:ss)
	 */
	public DateUtil(String pattern) {
		this.pattern = pattern;
	}
	
	/**
	 * 将字符串转换为毫秒数
	 * @param dateStr 对应格式的时间字符串
	 * @return	毫秒数
	 */
	public Long dateStrToLong(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Long timeStart = 0l;
		try {
			timeStart = sdf.parse(dateStr).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
//			LoggerUtil.error(this.getClass(), e);
//			throw new CommonException(e);
		}
		return timeStart;
	}
	
	/**
	 * 将毫秒数转换为可显示的字符串
	 * @param dateLong	毫秒数
	 * @return	对应格式的时间字符串
	 */
	public  String dateLongToString(Long dateLong) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = new Date(dateLong);
		return sdf.format(date);
	}
	
	/**
	 * 计算时间(计算传入时间前几天或者后几天的时间)
	 * @param nowTime	传入时间
	 * @param addNum	要增加的天数(为负数则是减少的天数)
	 * @return	计算后的时间
	 */
	public Long dateAddDay(Long nowTime, int addNum) {
		return nowTime + (oneDayTime*addNum);
	}
	
	/** 获取date缺省工具类(使用缺省的格式：yyyy-MM-dd HH:mm:ss) */
	public static DateUtil getDefaultUtil() {
		return defaultUtil;
	}
	
	/** 获取今天的零点时间 */
	public static long getTodayZero(){
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		
		calendar.set(Calendar.DAY_OF_YEAR, day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
	}
	
	/** 获取time那天的凌晨零点时间 */
	public static long getZero(Long time){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(time));
		c.set(Calendar.HOUR_OF_DAY, 0);  
		c.set(Calendar.MINUTE, 0);  
		c.set(Calendar.SECOND, 0);  
		c.set(Calendar.MILLISECOND, 0);  
        return c.getTimeInMillis();
	}
	
	/** 获取time明天的凌晨零点时间 */
	@SuppressWarnings("static-access")
	public static long getTomorrowZero(Long time){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(time));
		c.add(c.DATE,1);
		c.set(Calendar.HOUR_OF_DAY, 0);  
		c.set(Calendar.MINUTE, 0);  
		c.set(Calendar.SECOND, 0);  
		c.set(Calendar.MILLISECOND, 0);  
        return c.getTimeInMillis();
	}
	
	
	/**
	 * 获取传入时间的这一天的开始时间和结束时间
	 * (如何传入为null 获取今天的开始时间和结束时间)
	 * @param time 时间戳
	 * @return map(key start_time为开始时间 key end_time为结束时间)
	 */
	@SuppressWarnings("static-access")
	public static Map<String, Object> getTodayStartAndEnd(Long time){
		if (time!=null && time>System.currentTimeMillis()) {
//			throw new BizException(Error.system_createtime_fail);
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (time != null) {
			// 获取现在的时间
			Date date = new Date(time);
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			
			// 获取昨天24:00
	        Calendar strat = now;   
	        strat.set(Calendar.HOUR_OF_DAY, 0);  
	        strat.set(Calendar.MINUTE, 0);  
	        strat.set(Calendar.SECOND, 0);  
	        strat.set(Calendar.MILLISECOND, 0);  
	        Long start_time=strat.getTimeInMillis();  
	        // 获取今天24:00
	        Calendar end = now;   
	        end.add(now.DATE,1);
	        end.set(Calendar.HOUR_OF_DAY, 0);  
	        end.set(Calendar.MINUTE, 0);  
	        end.set(Calendar.SECOND, 0);  
	        end.set(Calendar.MILLISECOND, 0);  
	        Long end_time=end.getTimeInMillis();  
	        map.put("start_time", start_time);
			map.put("end_time", end_time);
			return map;
		}
		Calendar calendar = Calendar.getInstance();
		// 获取昨天24:00
        Calendar strat = Calendar.getInstance();   
        strat.set(Calendar.HOUR_OF_DAY, 0);  
        strat.set(Calendar.MINUTE, 0);  
        strat.set(Calendar.SECOND, 0);  
        strat.set(Calendar.MILLISECOND, 0);  
        Long start_time=strat.getTimeInMillis();  
        // 获取今天24:00
        Calendar end = Calendar.getInstance();   
        end.add(calendar.DATE,1);
        end.set(Calendar.HOUR_OF_DAY, 0);  
        end.set(Calendar.MINUTE, 0);  
        end.set(Calendar.SECOND, 0);  
        end.set(Calendar.MILLISECOND, 0);  
        Long end_time=end.getTimeInMillis();  
        map.put("start_time", start_time);
		map.put("end_time", end_time);
        return map;
	}


	/**
	 * 取当前时间
	 *
	 * @return
	 */
	public static Long getDateTime() {
		return System.currentTimeMillis();
	}

	/**
	 * 获取当前时间
	 *
	 * @return
	 */
	public static Date getDateTime2Date() {
		return new Date(getDateTime());
	}

	/**
	 * 取时间戳
	 *
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static Long getDateTime(SimpleDateFormat f, String time) throws ParseException {
		return f.parse(time).getTime();
	}

	/**
	 * 取某几小时前（或后）的时间
	 * @param hour 小时数（正数为取后几小时，负数为取前小时）
	 * @return
	 */
	public static Long getDateTimeHour(Integer hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, hour);
		return calendar.getTimeInMillis();
	}

	/**
	 * 取某几天前（或后）的时间
	 *
	 * @param day 日数（正数为取后几天，负数为取前几天）
	 * @return 时间
	 */
	public static Long getDateTime(Integer day) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, day);
		return calendar.getTimeInMillis();
	}

	/**
	 * 返回格式化后的日期（yyyy-MM-dd）
	 *
	 * @param format 格式化对象
	 * @param time   时间
	 * @return 格式化后的日期
	 */
	public static String getDateTime(SimpleDateFormat format, Long time) {
		return format.format(time);
	}

	/**
	 * 取某几天前（或后）的时间
	 *
	 * @param day 日数（正数为取后几天，负数为取前几天）
	 * @return 时间
	 */
	public static Date getDateTime2Date(Integer day) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}

	/**
	 * 获取一天的开始时间
	 *
	 * @param date
	 * @return
	 */
	public static Date getStartTime(String date) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(DATE_FORMAT_1.parse(date));
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取一天的开始时间
	 *
	 * @param date
	 * @return
	 */
	public static long getStartTime(long date) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime().getTime();
	}

	/**
	 * 获取一天的结束时间
	 *
	 * @param date
	 * @return
	 */
	public static Date getEndTime(String date) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(DATE_FORMAT_1.parse(date));
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	/**
	 * 返回上一天的整点信息
	 *
	 * @param date
	 * @return 2014-3-3 00:00:00
	 */
	@SuppressWarnings("static-access")
	public static Date lastDayWholePointDate(Date date) {
		Date newDate = null;
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		if ((gc.get(gc.HOUR_OF_DAY) == 0) && (gc.get(gc.MINUTE) == 0)
				&& (gc.get(gc.SECOND) == 0)) {
			newDate = new Date(date.getTime() - (24 * 60 * 60 * 1000));
		} else {
			Date date2 = new Date(date.getTime() - gc.get(gc.HOUR_OF_DAY) * 60 * 60
					* 1000 - gc.get(gc.MINUTE) * 60 * 1000 - gc.get(gc.SECOND)
					* 1000 - 24 * 60 * 60 * 1000);
			newDate = date2;
		}
		return new Date(newDate.getTime() / 1000 * 1000);
	}

	/**
	 * 获取一天的结束时间
	 *
	 * @param date
	 * @return
	 */
	public static long getEndTime(long date) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime().getTime();
	}

	/**
	 * 取当前年月
	 *
	 * @return yyyymm
	 */
	public static String getYm() {
		return getDateTime(DATE_FORMAT_2, getDateTime());
	}


	public static String date2FmtString(Date date) {
		return DATE_FORMAT_1.format(date);
	}

}
