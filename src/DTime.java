import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/*
Date(long date)
Allocates a Date object and initializes it to represent the specified number of milliseconds 
since the standard base time known as "the epoch", namely January 1, 1970, 00:00:00 GMT.
*/

//tb/1603

class DTime
{
	private static String timezone_id="UTC";

	private static String date_format_string="yyyy-MM-dd";
	private static String time_format_string="HH:mm:ss.SSS";
	private static String date_time_format_string=date_format_string+"_"+time_format_string;

	private static SimpleDateFormat date_time_format=new SimpleDateFormat(date_time_format_string);
	private static SimpleDateFormat date_format=new SimpleDateFormat(date_format_string);
	private static SimpleDateFormat time_format=new SimpleDateFormat(time_format_string);

	private static String time2_format_string="HHmmss";
	private static String time3_format_string="HHmmss.SSS";

	private static String date2_format_string="yyyyMMdd";
	private static String date3_format_string="ddMMyy";

	private static SimpleDateFormat time2_format=new SimpleDateFormat(time2_format_string);
	private static SimpleDateFormat time3_format=new SimpleDateFormat(time3_format_string);

	private static SimpleDateFormat date2_format=new SimpleDateFormat(date2_format_string);
	private static SimpleDateFormat date3_format=new SimpleDateFormat(date3_format_string);

	public DTime(){}

	public static void setTimeZone()
	{
		date_time_format.setTimeZone(TimeZone.getTimeZone(timezone_id));
		date_format.setTimeZone(TimeZone.getTimeZone(timezone_id));
		time_format.setTimeZone(TimeZone.getTimeZone(timezone_id));
		time2_format.setTimeZone(TimeZone.getTimeZone(timezone_id));
		time3_format.setTimeZone(TimeZone.getTimeZone(timezone_id));
		date2_format.setTimeZone(TimeZone.getTimeZone(timezone_id));
		date3_format.setTimeZone(TimeZone.getTimeZone(timezone_id));
	}

	static long millisFrom_yyyymmdd(String yyyymmdd) throws Exception {return date2_format.parse(yyyymmdd).getTime();}
	static long millisFrom_ddmmyy(String ddmmyy) throws Exception {return date3_format.parse(ddmmyy).getTime();}

	static long millisFrom_HHMMSS(String HHMMSS) throws Exception {return time2_format.parse(HHMMSS).getTime();}
	static long millisFrom_HHMMSSpSSS(String HHMMSSpSSS) throws Exception {return time3_format.parse(HHMMSSpSSS).getTime();}

	static String yyyymmdd_from_ddmmyy(String ddmmyy) throws Exception {return date2_format.format(date3_format.parse(ddmmyy));}

	static String now() {return date_time_format.format(new Date());}
	static long nowMillis() {return new Date().getTime();}

	static long millisFromDate(String date) throws Exception {return (date_format.parse(date).getTime());}
	static long millisFromTime(String time) throws Exception {return (time_format.parse(time).getTime());}
	static long millisFromDateTime(String date_time) throws Exception {return (date_time_format.parse(date_time)).getTime();}

	static String dateFromMillis(long millis) {return date_format.format(new Date(millis));}
	static String timeFromMillis(long millis) {return time_format.format(new Date(millis));}
	static String dateTimeFromMillis(long millis) {return date_time_format.format(new Date(millis));}

	static String dateFromDateTime(String date_time) throws Exception {return date_format.format(date_time_format.parse(date_time));}
	static String timeFromDateTime(String date_time) throws Exception {return time_format.format(date_time_format.parse(date_time));}
	static long millisSinceStartOfDayFromMillis(long millis) throws Exception {return millis-millisFromDate(dateFromMillis(millis));}

	public static void main(String[] args) throws Exception
	{
		setTimeZone();
		System.err.println("1 "+now());
		System.err.println("2 "+nowMillis());
		System.err.println("3 "+dateTimeFromMillis(nowMillis()));
		System.err.println("4 "+dateTimeFromMillis(1000l));
		System.err.println("5 "+millisFromDateTime("2016-03-06_07:53:13.411"));
		System.err.println("6 "+dateTimeFromMillis(millisFromDateTime("2016-03-06_07:53:13.411")));
		System.err.println("7 "+millisFromDate("1970-01-01"));
		System.err.println("8 "+millisFromTime("00:01:01.234"));
		System.err.println("9 "+dateFromMillis(1457250793411l));
		System.err.println("10 "+timeFromMillis(1457250793411l));
		System.err.println("11 "+timeFromMillis(3600000l));
		System.err.println("12 "+dateFromDateTime("2016-03-06_07:53:13.411"));
		System.err.println("13 "+timeFromDateTime("2016-03-06_07:53:13.411"));
		System.err.println("14 "+millisSinceStartOfDayFromMillis(1457250793411l)/1000d);
		System.err.println("15 "+millisFrom_ddmmyy("270316"));
		System.err.println("16 "+millisFrom_yyyymmdd("20160327"));
		System.err.println("17 "+yyyymmdd_from_ddmmyy("270316"));
		System.err.println("18 "+dateFromMillis(millisFrom_ddmmyy("270316")));
		System.err.println("19 "+millisFrom_HHMMSS("030201"));
		System.err.println("20 "+millisFrom_HHMMSSpSSS("030201.78934"));
		System.err.println(""+dateTimeFromMillis(
			millisFrom_ddmmyy("270316")+millisFrom_HHMMSSpSSS("030201.78934")
		));
	}
}
