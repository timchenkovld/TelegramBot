package org.example;

import org.jsoup.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HabrArtsParser {
    public static void main(String[] args) throws IOException {
        String url = "https://habr.com/ru/all/";

        Document document = Jsoup.connect(url).get();

        Elements articles = document.selectFirst("div.tm-articles-list").select("article");

        for (Element e : articles){
            HabrArtParser p = new HabrArtParser(e);
            System.out.println("p.getTitle() = " + p.getTitle());
            System.out.println("p.getRate() = " + p.getRate());
            System.out.println("##################################");
        }
    }
}
