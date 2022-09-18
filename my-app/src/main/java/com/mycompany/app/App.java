package com.mycompany.app;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App{
    public static void main( String[] args ) throws IOException{
    	WebCrawler crawler = new WebCrawler();
		
		crawler.getPageLinks("https://www.amazon.jobs/en/", 0,20);
		crawler.getArticles();
		crawler.writeToFile("Crawler data");
    }
}
