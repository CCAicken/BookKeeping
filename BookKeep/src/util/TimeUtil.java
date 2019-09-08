package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import business.impl.BillDaoImpl;

public class TimeUtil {

	public int getdays(String starTime, String endTimeStr)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date beginTime = sdf.parse(starTime);
		Date endTime = sdf.parse(endTimeStr);
		long diff = (endTime.getTime() - beginTime.getTime()) / (86400 * 1000);
		return (int) Math.abs(diff);
	}

	public static void main(String args[]) {
		BillDaoImpl dooo = new BillDaoImpl();
		List<yearbilltool> outlist = dooo.yearsBillOut("2019", "1004");
		List<yearbilltool> intlist = dooo.yearsBillInt("2019", "1004");
		List<YearBill> billlist = new ArrayList<YearBill>();

		for (Integer i = 1; i < 13; i++) {
			YearBill yearbill = new YearBill();
			for (int j = 0; j < intlist.size(); j++) {
				String timestr = outlist.get(j).getTime().toString();
				String monthstr = timestr.substring(timestr.length() - 1,
						timestr.length());
				if (monthstr.equals(i.toString())) {
					Double jieyu = (intlist.get(j).getMoney() - outlist.get(j)
							.getMoney());
					yearbill.setYuefen(i + "ÔÂ");
					yearbill.setJieyu(jieyu.toString());
					yearbill.setShouru(intlist.get(j).getMoney().toString());
					yearbill.setZhichu(outlist.get(j).getMoney().toString());
					break;

				} else {
					yearbill.setYuefen(i + "ÔÂ");
					yearbill.setJieyu("0");
					yearbill.setShouru("0");
					yearbill.setZhichu("0");
					break;
				}

			}
			billlist.add(yearbill);
		}
		for (YearBill yearBill : billlist) {
			System.out.println(yearBill.getYuefen());
		}
	}
}
