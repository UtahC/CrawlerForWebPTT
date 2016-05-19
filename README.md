# CrawlerForWebPTT  #
## Summary ##
It is used to visit web PTT and convert webpages into json formatted data.
## Library ##
[Junit / 3.8.1](http://mvnrepository.com/artifact/junit/junit/3.8.1 "Junit 3.8.1")  
[Commons IO / 2.5](http://mvnrepository.com/artifact/commons-io/commons-io/2.5)  
[Json / 20160212](http://mvnrepository.com/artifact/org.json/json/20160212)  
[Commons Lang / 3.4](http://mvnrepository.com/artifact/org.apache.commons/commons-lang3/3.4)
## Output (json) ##
<pre><code>
{
    "article_id": A non-repetitive string for each article,  
    "article_title": The title of the article,  
    "article_author": User id and name of the author included,  
    "article_text": The content of the article,  
    "article_time": The publish time of the article,  
    "article_ip": The IP address of the author,  
    "article_comments": {  
        "comment_stats": Maybe Good or Bad or None,  
        "comment_content": The content of the comment,  
        "comment_time": The publish time of the comment,  
        "comment_userid": The user id of the comment  
    }  
}  
</code></pre>
