package UtahC;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by UtahC on 2016/5/18.
 */
public class Comment {
    CommentStats stats;
    String time;
    String content;
    String userId;

    public Comment(String content) {
        String statsString = StringUtils.substringBetween(content, "hl push-tag\">",  " </span>");
        if (statsString != null){
            if (statsString.contains("推"))
                stats = CommentStats.Good;
            else if (statsString.contains("→"))
                stats = CommentStats.None;
            else if (statsString.contains("噓"))
                stats = CommentStats.Bad;
            else
                stats = CommentStats.Unknow;
        }
        else
            stats = CommentStats.Unknow;
        userId = StringUtils.substringBetween(content, "<span class=\"f3 hl push-userid\">", "</span>").replace(" ", "");
        this.content = StringUtils.substringBetween(content, "<span class=\"f3 push-content\">: ", "</span>");
        time = StringUtils.substringAfter(content, "<span class=\"push-ipdatetime\"> ");
    }
}
