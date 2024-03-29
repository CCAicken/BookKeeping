package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @Author: Chengqb
 * @Date: Created in 20:19 2019/5/28
 * @ClassName: HttpRequest
 * @Description: 发起HTTP请求第三方路径（页面、接口等）
 */
public class createHttpsRequest {

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            ：发送请求的URL
	 * @param param
	 *            ：请求参数，请求参数应该是 name1=value1&name2=value2&name3=value3 的形式。
	 * @return String[result]：所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);

			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();

			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			// 建立实际的连接
			connection.connect();

			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();

			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}

			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}

		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 *
	 * @param url
	 *            ：发送请求的 URL
	 * @param param
	 *            ：请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return String[result]：所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);

			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();

			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);

			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());

			// 发送请求参数
			out.print(param);

			// flush输出流的缓冲
			out.flush();

			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}

		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	// //
	// 在实际开发中，main方法可以删除；直接在所需的位置调用HttpRequest.sendGet()或者HttpRequest.sendPost()方法
	// public static void main(String[] args) {
	//
	// // 发送 GET 请求，第一个参数为url，第二个参数为请求参数
	// String s = createHttpsRequest
	// .sendPost(
	// "https://api.weixin.qq.com/sns/jscode2session?",
	// "appid=wx2dd06ecfc846d560&secret=446eccd174c34fe905c6d57763fa3dac&js_code=0338QfIk2IgzCC0uvPIk2ICqIk28QfIQ&grant_type=authorization_code");
	// System.out.println(s);
	// JSONObject obj = JSON.parseObject(s);
	// System.out.println(obj.get("openid"));
	//
	// }
}
