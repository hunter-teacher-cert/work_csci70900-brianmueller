// javac -cp "jsoup-1.14.1.jar:." Wikipedia.java
// java -cp "jsoup-1.14.1.jar:." Wikipedia.java

// package org.jsoup.examples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * A simple example, used on the jsoup website.
 */
public class Wikipedia {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        System.out.printf(doc.title());

        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            System.out.printf("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
        }
        System.out.println();
    }

    // private static void log(String msg, String... vals) {
    //     System.out.println(String.format(msg, vals));
    // }
}
