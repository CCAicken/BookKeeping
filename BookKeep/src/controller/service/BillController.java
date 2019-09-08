package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.LayuiData;
import util.YearBill;
import util.yearbilltool;
import Model.TBill;
import Model.VBill;
import business.impl.BillDaoImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "bill")
public class BillController {
	/**
	 * 获取所有账单
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getallbill")
	public void getallbill(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		BillDaoImpl bdao = new BillDaoImpl();
		List<VBill> list = bdao.getAllBill();
		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		String userid = request.getParameter("user");
		String date = request.getParameter("yearmonth");
		System.out.print(userid + date);

		LayuiData laydata = new LayuiData();

		if (list != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "查询成功，共查出" + list.size() + "条记录";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "查询失败";
		}

		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "";
	}

	/**
	 * 根据用户id获取账单
	 * 
	 * @param request
	 * @param response
	 * @param userid
	 *            用户id
	 * @param model
	 */
	@RequestMapping(value = "getbillbyuser")
	public void getBillByUser(HttpServletRequest request,
			HttpServletResponse response, String userid, Model model) {
		BillDaoImpl bdao = new BillDaoImpl();
		List<VBill> list = bdao.getBillByUser(userid);
		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (list != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "查询成功，共查出" + list.size() + "条记录";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "查询失败";
		}

		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "";
	}

	/**
	 * 添加账单
	 * 
	 * @param request
	 * @param response
	 * @param userid
	 *            用户id
	 * @param money
	 *            钱
	 * @param billType
	 *            账单类型（收入/支出）
	 * @param consumptionType
	 * @param remarks
	 *            备注
	 * @param createtime
	 *            时间
	 * 
	 * @param model
	 */
	@RequestMapping(value = "addbill")
	public void addBill(HttpServletRequest request,
			HttpServletResponse response, String userid, Double money,
			String billType, String consumptionType, String remarks,
			String createtime, Model model) {
		BillDaoImpl bdao = new BillDaoImpl();

		TBill bill = new TBill();
		bill.setUserId(userid);
		bill.setMoney(money);
		bill.setBillType(billType);
		bill.setConsumptionType(consumptionType);
		bill.setRemarks(remarks);
		bill.setCreateTime(createtime);

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (bdao.insertBill(bill) != 0) {
			laydata.msg = "账单添加成功";
		} else {
			laydata.msg = "账单添加失败";
		}

		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "";
	}

	/**
	 * 获取用户的 记账总天数，连续天数，记账总数量
	 * 
	 * @param request
	 * @param response
	 * @param userid
	 *            用户id
	 * @param model
	 */
	@RequestMapping(value = "getuserbillinfo")
	public void getUserBillInfo(HttpServletRequest request,
			HttpServletResponse response, String userid, Model model) {
		BillDaoImpl bdao = new BillDaoImpl();
		int allcount = bdao.getBillCountByUser(userid);
		Integer continueDays = bdao.getBillContinueDaysByUser(userid);
		Integer billDays = bdao.getBillDaysByUser(userid);
		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = allcount;
		laydata.result = continueDays.toString();
		laydata.result2 = billDays.toString();
		laydata.msg = "code 是账单总数，result 是连续天数，result2是记账天数";
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "";
	}

	/**
	 * 根据时间查询当天账单
	 * 
	 * @param request
	 * @param response
	 * @param time
	 *            时间
	 * @param model
	 */
	@RequestMapping(value = "getuserbillbytime")
	public void getUserBillByTime(HttpServletRequest request,
			HttpServletResponse response, String time, String userid,
			Model model) {
		BillDaoImpl bdao = new BillDaoImpl();
		String str = " where createTime like '" + time + "%' and userid='"
				+ userid + "'";
		System.out.println(str + "++++++" + time + userid);
		List<VBill> list = bdao.selectByPage(str, 1, 999999999);
		
		String strwhere = "createTime like '"+time+"%'"+" and userid="+userid;
		String dayin = bdao.getDayIn(strwhere);
		String dayout = bdao.getDayOut(strwhere);
		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		System.out.println(dayin+","+dayout);
		
		LayuiData laydata = new LayuiData();
		laydata.data=list;
		laydata.result2 = dayin;
		laydata.result = dayout;
		laydata.msg = "当天账单数";
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "";
	}

	@RequestMapping(value = "getsumbymonth")
	public void getSumByMonth(String userid, HttpServletRequest request,
			HttpServletResponse response, String time, Model model) {
		BillDaoImpl bdao = new BillDaoImpl();

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		double in = bdao.getBillInByTime(userid, time);
		String out = bdao.getBillOutByTime(userid, time);
		double sum=0;
		System.out.println(sum+","+in+","+out);
		if(in!=0&&out=="0.00"){
			sum=Double.valueOf(in);
		}else if (in==0&&out!="0.00") {
			sum=0;
		}else if(in!=0&&out!="0.00") {
			Double dayin = new Double(in);
			Double dayout = new Double(out);
			sum = dayin-dayout;
		}
		LayuiData laydata = new LayuiData();
		if (sum >= 0) {
			laydata.code = LayuiData.SUCCESS;
			laydata.data = sum;
			//laydata.result = in;
			laydata.result2=out;
			laydata.msg = "结余";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.data = 0;
			//laydata.result = in;
			laydata.result2=out;
			laydata.msg = "结余";
		}
		Writer ptintout;
		try {
			ptintout = response.getWriter();
			ptintout.write(JSON.toJSONString(laydata));
			ptintout.flush();
			ptintout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "getyearbill")
	public void getYearBill(String userid, HttpServletRequest request,
			HttpServletResponse response, String year, Model model) {
		BillDaoImpl bdao = new BillDaoImpl();

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		List<yearbilltool> outlist = bdao.yearsBillOut(year, userid);
		List<yearbilltool> intlist = bdao.yearsBillInt(year, userid);
		List<YearBill> billlist = new ArrayList<YearBill>();

		for (Integer i = 0; i < 13; i++) {
			YearBill yearbill = new YearBill();
			String timestr = outlist.get(i).getTime().toString();
			String monthstr = timestr.substring(timestr.length() - 1,
					timestr.length());
			if (monthstr.equals(i.toString())) {
				yearbill.setYuefen("0" + i + "月");
				yearbill.setJieyu("0");
				yearbill.setShouru("0");
				yearbill.setZhichu("6666");
			} else {
				yearbill.setYuefen("0" + i + "月");
				yearbill.setJieyu("0");
				yearbill.setShouru("0");
				yearbill.setZhichu("0");
			}

			System.out.println(outlist.get(i).getTime());
		}

		LayuiData laydata = new LayuiData();
		if (outlist != null && intlist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.data = intlist;
			laydata.data1 = outlist;
			laydata.msg = "月账单";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.data = 0;
			laydata.msg = "月账单";
		}
		Writer ptintout;
		try {
			ptintout = response.getWriter();
			ptintout.write(JSON.toJSONString(laydata));
			ptintout.flush();
			ptintout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据billid获取账单信息
	 * 
	 * @param billid
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getbybillid")
	public void getBillByBillId(int billid, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		BillDaoImpl bdao = new BillDaoImpl();

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		List<VBill> list = bdao.getBillByBillId(billid);
		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.data = list;
		laydata.msg = "账单编辑";
		Writer ptintout;
		try {
			ptintout = response.getWriter();
			ptintout.write(JSON.toJSONString(laydata));
			ptintout.flush();
			ptintout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="dellbill")
	public void DellBill(int billid, HttpServletRequest request,
			HttpServletResponse response, Model model){
		BillDaoImpl bdao = new BillDaoImpl();

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		boolean result = bdao.delBill(billid);
		LayuiData laydata = new LayuiData();
		if(result){
			laydata.code=LayuiData.SUCCESS;
			laydata.msg="删除成功";
		}else{
			laydata.code=LayuiData.ERRR;
			laydata.msg="删除失败";
		}
		Writer ptintout;
		try {
			ptintout = response.getWriter();
			ptintout.write(JSON.toJSONString(laydata));
			ptintout.flush();
			ptintout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
