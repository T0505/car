package com.school.motor.system.utils;

import net.sf.json.JSONObject;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
/**
 * author T
 * 短信验证码
 */
public class PhoneUtil {
    // key编号代码
    private static final String KEY = "0b635b7848a236876d2c6f5d93a2d99b";
    private static final int ID = 67776;
    public static String send(String value, String mobile) throws IOException {
        String uri = "https://v.juhe.cn/vercodesms/send.php?key=%s&tplId=%s&tplValue=%s&mobile=%s";
        value = "#code#=" + value; //拼接验证码
        String url = String.format(uri, KEY, ID, URLEncoder.encode(value, StandardCharsets.UTF_8), mobile);
        final String response = doGet(url);
        JSONObject jsonObject = JSONObject.fromObject(response);
        int error_code = jsonObject.getInt("error_code");
        if (error_code == 0) {
            JSONObject result = jsonObject.getJSONObject("result");
            return result.getString("sid");

        } else {
            return null;
        }
    }
    /**
     * get方式的http请求
     * @param url 请求地址
     * @return 返回结果
     */
    public static String doGet(String url) throws IOException {
        HttpURLConnection connection;
        // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
        connection = (HttpURLConnection) new URL(url).openConnection();
        // 设置连接方式：get
        connection.setRequestMethod("GET");
        // 设置连接主机服务器的超时时间：15000毫秒
        connection.setConnectTimeout(15000);
        // 设置读取远程返回的数据时间：60000毫秒
        connection.setReadTimeout(60000);
        // 发送请求
        connection.connect();
        try(BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),StandardCharsets.UTF_8))) {
            if (connection.getResponseCode() == 200) {
                // 封装输入流，并指定字符集
                StringBuilder builder = new StringBuilder();
                String temp;
                while ((temp = input.readLine()) != null) {
                    builder.append(temp);
                    builder.append(System.lineSeparator());
                }
                return builder.toString();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
