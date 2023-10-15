package org.example;

import org.jsoup.nodes.Element;

public class HabrArtParser {
    private Element article;

    public HabrArtParser(Element article) {
        this.article = article;
    }

    public String getTitle() {
        return article.getElementsByTag("h2").text();
    }

    public int getRate() {
        String text = article.selectFirst("span.tm-votes-meter__value").text();
        return Integer.valueOf(text);
    }
}
