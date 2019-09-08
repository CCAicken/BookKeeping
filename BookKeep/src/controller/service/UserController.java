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
import util.createHttpsRequest;
import util.yearbilltool;
import Model.TUser;
import business.impl.BillDaoImpl;
import business.impl.UserDaoImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(value = "user")
public class UserController {
	@RequestMapping(value = "getuserid")
	public void getOpenId(HttpServletRequest request, String code,
			String appid, String secret, String nickName,
			HttpServletResponse response, Model model) {
		String userid;
		String url = "https://api.weixin.qq.com/sns/jscode2session?";
		String param = "appid=" + appid + "&secret=" + secret + "&js_code="
				+ code + "&grant_type=authorization_code";
		JSONObject obj = JSON.parseObject(createHttpsRequest.sendPost(url,
				param));
		// System.out.println(obj.get("openid"));
		UserDaoImpl udao = new UserDaoImpl();
		if (udao.isExist((String) obj.get("openid"))) {
			userid = (String) obj.get("openid");
		} else {

			TUser user = new TUser();
			user.setUserId((String) obj.get("openid"));
			user.setPassword("123456");
			user.setUsername(nickName);
			user.setTel("12345678910");
			userid = udao.insert(user);
		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(userid);
			out.flush();
			out.close();
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
					yearbill.setYuefen(i + "月");
					yearbill.setJieyu(jieyu.toString());
					yearbill.setShouru(intlist.get(j).getMoney().toString());
					yearbill.setZhichu(outlist.get(j).getMoney().toString());
					break;

				} else {
					yearbill.setYuefen(i + "月");
					yearbill.setJieyu("0");
					yearbill.setShouru("0");
					yearbill.setZhichu("0");
					break;
				}

			}
			billlist.add(yearbill);
		}
		LayuiData laydata = new LayuiData();
		if (outlist != null && intlist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.data = billlist;
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

}
