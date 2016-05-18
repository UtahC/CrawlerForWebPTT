package UtahC;

import junit.framework.TestCase;

import java.net.URL;

/**
 * Created by UtahC on 2016/5/18.
 */
public class ArticleTest extends TestCase {
    public void testIsMainContent() throws Exception {
        Article article = new Article(new URL("https://www.ptt.cc/bbs/LoL/M.1455811061.A.FED.html"));
        boolean isMC = article.isMainContent("<div id=\"main-content\" class=\"bbs-screen bbs-content\"><div class=\"article-metaline\"><span class=\"article-meta-tag\">作者</span><span class=\"article-meta-value\">rainnawind (無聊又幼稚的雨颯)</span></div><div class=\"article-metaline-right\"><span class=\"article-meta-tag\">看板</span><span class=\"article-meta-value\">LoL</span></div><div class=\"article-metaline\"><span class=\"article-meta-tag\">標題</span><span class=\"article-meta-value\">[公告] 伺服器狀況詢問/聊天/揪團/抱怨/多功能區</span></div><div class=\"article-metaline\"><span class=\"article-meta-tag\">時間</span><span class=\"article-meta-value\">Thu Feb 18 23:57:37 2016</span></div>");
        boolean notMC = article.isMainContent("<span class=\"f1 hl\"> A. 遊戲伺服器狀況/詢問區</span>      <a href=\"http://www.leagueoflegends.com/service-status\" target=\"_blank\" rel=\"nofollow\"><span class=\"hl\">http://www.leagueoflegends.com/service-status</span></a>");
        assertEquals(true, isMC);
        assertEquals(false, notMC);
    }

}