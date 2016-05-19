package UtahC;

import org.apache.commons.lang3.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Created by UtahC on 2016/5/18.
 */
public class Board extends HtmlPage{
    private ArrayList<Article> articleList;
    private ArrayList<String> contentList;
    int lastPage;

    public Board (URL url) {
        super(url);
        articleList = new ArrayList<Article>();
    }

    public void parseContent() {
        contentList = getContent();
        int nowIndex = saveLastPage();
        saveArticles(nowIndex);
    }

    private int saveLastPage() {
        int nowIndex = 0;
        for (; nowIndex < contentList.size(); nowIndex++) {
            if (contentList.get(nowIndex).contains("上頁") &&
                    contentList.get(nowIndex + 1).contains("下頁")) {
                lastPage = Integer.parseInt(StringUtils.substringBetween(contentList.get(nowIndex), "/bbs/LoL/index", ".html\">")) + 1; //exclude bottom articles
                break;
            }
        }
        return nowIndex;
    }

    private void saveArticles(int nowIndex) {
        for (; nowIndex < contentList.size(); nowIndex++) {
            if (contentList.get(nowIndex).contains("<div class=\"r-list-container bbs-screen\">"))
                break;
        }
        for (; nowIndex < contentList.size(); nowIndex++) {
            if (contentList.get(nowIndex).contains("<a href=\"") && contentList.get(nowIndex).contains("</a>")) {
                String urlString = "https://www.ptt.cc" + StringUtils.substringBetween(contentList.get(nowIndex), "<a href=\"", "\">");
                try {
                    Article article = new Article(new URL(urlString));
                    articleList.add(article);
                }
                catch (MalformedURLException e) {
                    System.out.println("Invalid url");
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Article> getArticleList() {
        return articleList;
    }
}
