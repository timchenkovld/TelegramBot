package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HabrJsoupParser {
    public static void main(String[] args) throws IOException {
        String url = "https://habr.com/ru/all/";

        Document document = Jsoup.connect(url).get();

        Element body = document.body();
        String text = body.text();

        Element head = document.getElementsByTag("head").first();


        System.out.println("element.text() = " + head.text());


    }
}
