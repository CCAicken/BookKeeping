package util;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class yearbilltool {
	private String billType;
	private String time;
	private Double money;

	public yearbilltool() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static List<yearbilltool> toList(ResultSet rs) {
		// 静态方法，用于将0~N的VUser视图数据交换到List数组中来
		List<yearbilltool> list = new ArrayList<yearbilltool>();
		if (rs != null) {
			try {
				while (rs.next()) {
					yearbilltool user2 = new yearbilltool();
					user2.setBillType(rs.getString("billType"));
					user2.setTime(rs.getString("time"));
					user2.setMoney(Double.parseDouble(rs.getString("money")));

					list.add(user2);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return null;
		}
		return list;
	}

	public yearbilltool(String billType, String time, Double money) {
		super();
		this.billType = billType;
		this.time = time;
		this.money = money;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}
