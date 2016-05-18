package UtahC;

import junit.framework.TestCase;

import java.net.URL;

/**
 * Created by UtahC on 2016/5/18.
 */
public class ArticleTest extends TestCase {
    /**
     * It's not public anymore
     * @throws Exception
     */
    public void testIsMainContent() throws Exception {
        /*
        Article article = new Article(new URL("https://www.ptt.cc/bbs/LoL/M.1455811061.A.FED.html"));
        boolean isMC = article.isMainContent("<div id=\"main-content\" class=\"bbs-screen bbs-content\"><div class=\"article-metaline\"><span class=\"article-meta-tag\">作者</span><span class=\"article-meta-value\">rainnawind (無聊又幼稚的雨颯)</span></div><div class=\"article-metaline-right\"><span class=\"article-meta-tag\">看板</span><span class=\"article-meta-value\">LoL</span></div><div class=\"article-metaline\"><span class=\"article-meta-tag\">標題</span><span class=\"article-meta-value\">[公告] 伺服器狀況詢問/聊天/揪團/抱怨/多功能區</span></div><div class=\"article-metaline\"><span class=\"article-meta-tag\">時間</span><span class=\"article-meta-value\">Thu Feb 18 23:57:37 2016</span></div>");
        boolean notMC = article.isMainContent("<span class=\"f1 hl\"> A. 遊戲伺服器狀況/詢問區</span>      <a href=\"http://www.leagueoflegends.com/service-status\" target=\"_blank\" rel=\"nofollow\"><span class=\"hl\">http://www.leagueoflegends.com/service-status</span></a>");
        assertEquals(true, isMC);
        assertEquals(false, notMC);
        */
    }

    public void test() throws Exception {
        Article article = new Article(new URL("https://www.ptt.cc/bbs/LoL/M.1455811061.A.FED.html"));
        article.parseContent();
        assertEquals("rainnawind (無聊又幼稚的雨颯)", article.author);
        assertEquals("[公告] 伺服器狀況詢問/聊天/揪團/抱怨/多功能區", article.title);
        assertEquals("Thu Feb 18 23:57:37 2016", article.time);
        assertEquals(true, article.text.contains("但請勿外漏本區內負面情緒至外部其他正常討論之文章。"));
        assertEquals("118.165.224.157", article.ip);
        Comment firstComment = article.getCommentList().get(0);
        assertEquals(CommentStats.None, firstComment.stats);
        assertEquals("DaringDo", firstComment.userId);
        assertEquals("檢舉羅傑 win trade啦", firstComment.content);
        assertEquals("04/01 00:00", firstComment.time);

        Comment the9thComment = article.getCommentList().get(8);
        assertEquals(CommentStats.Good, the9thComment.stats);
        assertEquals("aotearoaz", the9thComment.userId);
        assertEquals("板標呢", the9thComment.content);
        assertEquals("04/01 00:30", the9thComment.time);


    }
}