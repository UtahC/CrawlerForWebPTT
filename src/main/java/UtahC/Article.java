package UtahC;

import sun.net.util.IPAddressUtil;

import java.net.URL;
import java.util.*;

/**
 * Created by UtahC on 2016/5/18.
 */
public class Article extends HtmlPage {
    int id;
    String author;
    String title;
    String date;
    String ip;
    String content;//僅含本文

    private List<Comment> commentList;

    public Article(URL url) {
        super(url);
        commentList = new ArrayList<Comment>();
    }

    public String parseContent(String content) {
        //TODO
        return "";
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

}
