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
		String id = request.getParameter("id");
		System.out.print(id);

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
			HttpServletResponse response, String time, Model model) {
		BillDaoImpl bdao = new BillDaoImpl();
		String str = "from VBill where createTime like '" + time + "%'";
		List<VBill> list = bdao.selectByPage(str, 1, 999999999);
		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.data = list;
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
}
