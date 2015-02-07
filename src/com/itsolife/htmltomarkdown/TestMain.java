package com.itsolife.htmltomarkdown;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestMain {
    public static void main(String[] args) {
        URL url;
        try {
            url = new URL("http://jsoup.org/");
            String parsedText = HtmlToMd.convert(url, 30000);
            System.out.println(parsedText);
            String pathFile = "test.html";
            File f = new File(pathFile);
            String parsedFileText = HtmlToMd.convertFile(f, "gbk");
            System.out.println(parsedFileText);

            System.out.println("done");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}