package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	public int getdays(String starTime, String endTimeStr)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date beginTime = sdf.parse(starTime);
		Date endTime = sdf.parse(endTimeStr);
		long diff = (endTime.getTime() - beginTime.getTime()) / (86400 * 1000);
		return (int) Math.abs(diff);
	}
	//
	// public static void main(String args[]) throws ParseException {
	// TimeUtil util = new TimeUtil();
	// System.out.println(util.getdays("2019-09-01", "2019-09-06"));
	// }
}
