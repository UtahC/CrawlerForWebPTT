package UtahC;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by UtahC on 2016/5/18.
 */
public abstract class HtmlPage {
    URL url;

    protected HtmlPage (URL url) {
        this.url = url;
    }

    public ArrayList<String> getContent() {
        ArrayList list = null;
        try {
            final String encoding = "UTF-8";
            URLConnection conn = url.openConnection();
            InputStream in = conn.getInputStream();
            String body = IOUtils.toString(in, encoding);
            String[] sLine = body.split("\n");
            list = new ArrayList<String>(Arrays.asList(sLine));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    abstract void parseContent();
}
