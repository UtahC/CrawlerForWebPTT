package UtahC;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class App
{
    public static void main(String[] args) {
        String encoding = "UTF-8";
        String body = "";
        try {
            URL url = new URL("https://www.ptt.cc/bbs/LoL/M.1455811061.A.FED.html");
            URLConnection conn = url.openConnection();
            InputStream in = conn.getInputStream();
            body = IOUtils.toString(in, encoding);
            System.out.println("url: " + url.toString());
            System.out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
