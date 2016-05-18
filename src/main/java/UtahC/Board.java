package UtahC;

import java.net.URL;
import java.util.*;

/**
 * Created by UtahC on 2016/5/18.
 */
public class Board extends HtmlPage{
    private List<Article> articleList;

    public Board (URL url) {
        super(url);
        articleList = new ArrayList<Article>();
    }

    public String parseContent(String content) {
        //TODO
        return "";
    }

    public List<Article> getArticleList() {
        return articleList;
    }
}
