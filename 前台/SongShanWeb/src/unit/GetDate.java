package unit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GetDate {
	
	/**
	 * 获取过去或者未来 任意天内的日期数组
	 * @param intervals      intervals天内
	 * @return              日期数组
	 */
	public static ArrayList<String> test(int intervals ) {
	    ArrayList<String> pastDaysList = new ArrayList<String>();
	    ArrayList<String> fetureDaysList = new ArrayList<String>();
	    for (int i = 0; i <intervals; i++) {
	        pastDaysList.add(getPastDate(i));
	        fetureDaysList.add(getFetureDate(i));
	    }
	    return pastDaysList;
	}

	/**
	 * 获取过去第几天的日期
	 *
	 * @param past
	 * @return
	 */
	public static String getPastDate(int past) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
	    Date today = calendar.getTime();
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    String result = format.format(today);
	    return result;
	}
	
	/**
	 * 获取未来 第 past 天的日期
	 * @param past
	 * @return
	 */
	public static String getFetureDate(int past) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
	    Date today = calendar.getTime();
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    String result = format.format(today);
	    return result;
	}
	
}
