package UtahC;

import org.json.*;

import java.io.FileWriter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by UtahC on 2016/5/18.
 */
public class Crawler {
    Board board;
    public Crawler (String boardName) {
        URL url = null;
        try {
            url = new URL("https://www.ptt.cc/bbs/" + boardName + "/index.html");
        }
        catch (MalformedURLException e) {
            System.out.println("invalid board name.");
            e.printStackTrace();
        }
        board = new Board(url);
    }

    public void start() {
        JSONObject jArticles = new JSONObject();
        board.parseContent();
        Integer articleCounter = 1;
        for(Article theArticle : board.getArticleList()) {
            theArticle.parseContent();
            JSONObject jArticle = new JSONObject();
            JSONObject jComments = new JSONObject();
            jArticle.put("article_id", theArticle.id);
            jArticle.put("article_title", theArticle.title);
            jArticle.put("article_author", theArticle.author);
            jArticle.put("article_text", theArticle.text);
            jArticle.put("article_time", theArticle.time);
            jArticle.put("article_ip", theArticle.ip);
            Integer commentCounter = 1;
            for (Comment theComment : theArticle.getCommentList()) {
                JSONObject jCommentDetails = new JSONObject();
                jCommentDetails.put("comment_stats", theComment.stats);
                jCommentDetails.put("comment_userid", theComment.userId);
                jCommentDetails.put("comment_content", theComment.content);
                jCommentDetails.put("comment_time", theComment.time);
                jComments.put(commentCounter.toString(), jCommentDetails);
                commentCounter ++;
            }
            jArticle.put("article_comments", jComments);
            jArticles.put(articleCounter.toString(), jArticle);
            articleCounter++;
        }
        save(jArticles);
    }

    private void save(JSONObject jArticles) {
        try {
            FileWriter file = new FileWriter("C:\\\\json.txt");
            file.write(jArticles.toString());
            System.out.println(jArticles.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
