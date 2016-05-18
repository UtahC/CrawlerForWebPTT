package UtahC;

import org.apache.commons.lang3.StringUtils;
import java.net.URL;
import java.util.*;

/**
 * Created by UtahC on 2016/5/18.
 */
public class Article extends HtmlPage {
    int id;
    String author;
    String title;
    String time;
    String ip;
    String text;//僅含本文
    List<Comment> commentList;
    private ArrayList<String> contentList;

    public Article(URL url) {
        super(url);
        commentList = new ArrayList<Comment>();
    }

    public void parseContent() {
        int nowIndex = 0;
        contentList = getContent();
        for (; nowIndex < contentList.size(); nowIndex++) {
            if (contentList.get(nowIndex).contains("<div id=\"main-content\"")) {
                saveInfo(contentList.get(nowIndex));
                nowIndex++;
                break;
            }
        }
        nowIndex = saveTextAndIp(nowIndex);
        saveComments(nowIndex);
    }

    /**
     * To get the author name, the title and the time of  the article.
     * @param content: the "main-content" string
     */
    private void saveInfo(String content) {
        author = StringUtils.substringBetween(content, "作者</span><span class=\"article-meta-value\">", "</span>");
        title = StringUtils.substringBetween(content, "標題</span><span class=\"article-meta-value\">", "</span>");
        time = StringUtils.substringBetween(content, "時間</span><span class=\"article-meta-value\">", "</span>");
    }

    /**
     * To get the text and the ip of the article.
     * @param nowIndex: start index
     * @return: end index
     */
    private int saveTextAndIp(int nowIndex) {
        StringBuilder stringBuilder = new StringBuilder();
        for (; nowIndex < contentList.size(); nowIndex++) {
            if (contentList.get(nowIndex).contains("--") &&
                    contentList.get(nowIndex + 1).contains("<span class=\"f2\">※ 發信站: 批踢踢實業坊(ptt.cc)")) {
                nowIndex++;
                break;
            }
            stringBuilder.append(contentList.get(nowIndex));
        }
        text = stringBuilder.toString();
        ip = StringUtils.substringAfter(contentList.get(nowIndex), "※ 發信站: 批踢踢實業坊(ptt.cc), 來自: ");
        return nowIndex;
    }

    /**
     * To get all the comments of the article.
     * @param nowIndex: start index
     */
    private void saveComments(int nowIndex) {
        for (; nowIndex < contentList.size(); nowIndex++) {
            if (contentList.get(nowIndex).contains("<div class=\"push\">")) {
                Comment comment = new Comment(contentList.get(nowIndex));
                commentList.add(comment);
            }
        }
    }

    public List<Comment> getCommentList() {
        return commentList;
    }
}
