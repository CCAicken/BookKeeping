package util;

public class YearBill {
	private String yuefen;
	private String shouru;
	private String zhichu;
	private String jieyu;

	public YearBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public YearBill(String yuefen, String shouru, String zhichu, String jieyu) {
		super();
		this.yuefen = yuefen;
		this.shouru = shouru;
		this.zhichu = zhichu;
		this.jieyu = jieyu;
	}

	public String getYuefen() {
		return yuefen;
	}

	public void setYuefen(String yuefen) {
		this.yuefen = yuefen;
	}

	public String getShouru() {
		return shouru;
	}

	public void setShouru(String shouru) {
		this.shouru = shouru;
	}

	public String getZhichu() {
		return zhichu;
	}

	public void setZhichu(String zhichu) {
		this.zhichu = zhichu;
	}

	public String getJieyu() {
		return jieyu;
	}

	public void setJieyu(String jieyu) {
		this.jieyu = jieyu;
	}

}
