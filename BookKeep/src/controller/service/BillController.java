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
	 * ��ȡ�����˵�
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
		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		String userid = request.getParameter("user");
		String date = request.getParameter("yearmonth");
		System.out.print(userid + date);

		LayuiData laydata = new LayuiData();

		if (list != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "��ѯ�ɹ��������" + list.size() + "����¼";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "��ѯʧ��";
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
	 * �����û�id��ȡ�˵�
	 * 
	 * @param request
	 * @param response
	 * @param userid
	 *            �û�id
	 * @param model
	 */
	@RequestMapping(value = "getbillbyuser")
	public void getBillByUser(HttpServletRequest request,
			HttpServletResponse response, String userid, Model model) {
		BillDaoImpl bdao = new BillDaoImpl();
		List<VBill> list = bdao.getBillByUser(userid);
		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (list != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "��ѯ�ɹ��������" + list.size() + "����¼";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "��ѯʧ��";
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
	 * ����˵�
	 * 
	 * @param request
	 * @param response
	 * @param userid
	 *            �û�id
	 * @param money
	 *            Ǯ
	 * @param billType
	 *            �˵����ͣ�����/֧����
	 * @param consumptionType
	 * @param remarks
	 *            ��ע
	 * @param createtime
	 *            ʱ��
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

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (bdao.insertBill(bill) != 0) {
			laydata.msg = "�˵���ӳɹ�";
		} else {
			laydata.msg = "�˵����ʧ��";
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
	 * ��ȡ�û��� ��������������������������������
	 * 
	 * @param request
	 * @param response
	 * @param userid
	 *            �û�id
	 * @param model
	 */
	@RequestMapping(value = "getuserbillinfo")
	public void getUserBillInfo(HttpServletRequest request,
			HttpServletResponse response, String userid, Model model) {
		BillDaoImpl bdao = new BillDaoImpl();
		int allcount = bdao.getBillCountByUser(userid);
		Integer continueDays = bdao.getBillContinueDaysByUser(userid);
		Integer billDays = bdao.getBillDaysByUser(userid);
		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = allcount;
		laydata.result = continueDays.toString();
		laydata.result2 = billDays.toString();
		laydata.msg = "code ���˵�������result ������������result2�Ǽ�������";
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
	 * ����ʱ���ѯ�����˵�
	 * 
	 * @param request
	 * @param response
	 * @param time
	 *            ʱ��
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
		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		System.out.println(dayin+","+dayout);
		
		LayuiData laydata = new LayuiData();
		laydata.data=list;
		laydata.result2 = dayin;
		laydata.result = dayout;
		laydata.msg = "�����˵���";
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

		// �ش�json�ַ���
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
			laydata.msg = "����";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.data = 0;
			//laydata.result = in;
			laydata.result2=out;
			laydata.msg = "����";
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

		// �ش�json�ַ���
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
				yearbill.setYuefen("0" + i + "��");
				yearbill.setJieyu("0");
				yearbill.setShouru("0");
				yearbill.setZhichu("6666");
			} else {
				yearbill.setYuefen("0" + i + "��");
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
			laydata.msg = "���˵�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.data = 0;
			laydata.msg = "���˵�";
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
	 * ����billid��ȡ�˵���Ϣ
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

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		List<VBill> list = bdao.getBillByBillId(billid);
		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.data = list;
		laydata.msg = "�˵��༭";
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

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		boolean result = bdao.delBill(billid);
		LayuiData laydata = new LayuiData();
		if(result){
			laydata.code=LayuiData.SUCCESS;
			laydata.msg="ɾ���ɹ�";
		}else{
			laydata.code=LayuiData.ERRR;
			laydata.msg="ɾ��ʧ��";
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
