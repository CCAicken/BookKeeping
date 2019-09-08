package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.LayuiData;
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
		String id = request.getParameter("id");
		System.out.print(id);

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
			HttpServletResponse response, String time, Model model) {
		BillDaoImpl bdao = new BillDaoImpl();
		String str = "from VBill where createTime like '" + time + "%'";
		List<VBill> list = bdao.selectByPage(str, 1, 999999999);
		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.data = list;
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
}
