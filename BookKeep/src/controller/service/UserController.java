package controller.service;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.createHttpsRequest;
import Model.TUser;
import business.impl.UserDaoImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@RequestMapping(value = "user")
public class UserController {
	@RequestMapping(value = "getuserid")
	public void getOpenId(HttpServletRequest request, String code,
			String appid, String secret, String nickname,
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
			user.setUsername(nickname);
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

}
