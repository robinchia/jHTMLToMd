package com.itsolife.htmltomarkdown;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestMain {
	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("http://en.wikipedia.org/wiki/Text_editor");
			url = new URL("http://www.rockpapershotgun.com/2013/12/02/wot-i-think-journey-of-a-roach/");
			String parsedtext = HtmlToMd.convert(url, 30000);
			System.out.println(parsedtext);
			String pathfile = "/var/www/html/wiznote/工具文章/推荐给开发人员的实用命令行工具.html";
			File f = new File(pathfile);
			String parsedtext1 = HtmlToMd.convertfile(f, "gbk");
			System.out.println(parsedtext1);
			
			System.out.println("done");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}