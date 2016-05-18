package UtahC;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by UtahC on 2016/5/18.
 */
public abstract class HtmlPage {
    URL url;

    protected HtmlPage (URL url) {
        this.url = url;
    }

    public String getContent() {
        String encoding = "UTF-8";
        String body = "";
        try {
            URLConnection conn = url.openConnection();
            InputStream in = conn.getInputStream();
            body = IOUtils.toString(in, encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    abstract String parseContent(String Content);
}
