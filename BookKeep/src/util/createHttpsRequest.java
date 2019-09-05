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
 * @Description: ����HTTP���������·����ҳ�桢�ӿڵȣ�
 */
public class createHttpsRequest {

	/**
	 * ��ָ��URL����GET����������
	 * 
	 * @param url
	 *            �����������URL
	 * @param param
	 *            ������������������Ӧ���� name1=value1&name2=value2&name3=value3 ����ʽ��
	 * @return String[result]��������Զ����Դ����Ӧ���
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);

			// �򿪺�URL֮�������
			URLConnection connection = realUrl.openConnection();

			// ����ͨ�õ���������
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			// ����ʵ�ʵ�����
			connection.connect();

			// ��ȡ������Ӧͷ�ֶ�
			Map<String, List<String>> map = connection.getHeaderFields();

			// �������е���Ӧͷ�ֶ�
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}

			// ���� BufferedReader����������ȡURL����Ӧ
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("����GET��������쳣��" + e);
			e.printStackTrace();
		}

		// ʹ��finally�����ر�������
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
	 * ��ָ�� URL ����POST����������
	 *
	 * @param url
	 *            ����������� URL
	 * @param param
	 *            ������������������Ӧ���� name1=value1&name2=value2 ����ʽ��
	 * @return String[result]��������Զ����Դ����Ӧ���
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);

			// �򿪺�URL֮�������
			URLConnection conn = realUrl.openConnection();

			// ����ͨ�õ���������
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			// ����POST�������������������
			conn.setDoOutput(true);
			conn.setDoInput(true);

			// ��ȡURLConnection�����Ӧ�������
			out = new PrintWriter(conn.getOutputStream());

			// �����������
			out.print(param);

			// flush������Ļ���
			out.flush();

			// ����BufferedReader����������ȡURL����Ӧ
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("���� POST ��������쳣��" + e);
			e.printStackTrace();
		}

		// ʹ��finally�����ر��������������
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
	// ��ʵ�ʿ����У�main��������ɾ����ֱ���������λ�õ���HttpRequest.sendGet()����HttpRequest.sendPost()����
	// public static void main(String[] args) {
	//
	// // ���� GET ���󣬵�һ������Ϊurl���ڶ�������Ϊ�������
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
