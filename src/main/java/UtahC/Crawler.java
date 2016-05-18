package UtahC;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by UtahC on 2016/5/18.
 */
public class Crawler {
    URL url;
    Board board;
    public Crawler (String boardName) {
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
        //TODO
    }
}
