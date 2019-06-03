/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import static constant.Constants.sdf;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import org.apache.commons.io.IOUtils;

public class PostJson {

    public static void Post_JSON(String reqUrl, String js) {

        // 	String jsonString = mapper.writeValueAsString(object);
        String query_url = reqUrl;
        String json = js;
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            int codeR = conn.getResponseCode();
            System.out.println(sdf.format(new Date())+ " response: " + codeR + (codeR!=200?("-"+conn.getResponseMessage()):""));
            in.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
