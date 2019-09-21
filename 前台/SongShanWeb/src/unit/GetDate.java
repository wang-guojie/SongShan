package unit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GetDate {
	
	/**
	 * ��ȡ��ȥ����δ�� �������ڵ���������
	 * @param intervals      intervals����
	 * @return              ��������
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
	 * ��ȡ��ȥ�ڼ��������
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
	 * ��ȡδ�� �� past �������
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
