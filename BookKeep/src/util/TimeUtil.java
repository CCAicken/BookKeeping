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

	// public static void main(String args[]) {
	// BillDaoImpl dooo = new BillDaoImpl();
	// List outlist = dooo.yearsBillOut("2019", "1004");
	// List intlist = dooo.yearsBillInt("2019", "1004");
	//
	// for (int i = 0; i < outlist.size(); i++) {
	// System.out.println(outlist.get(i).toString());
	// }
	// }
}
