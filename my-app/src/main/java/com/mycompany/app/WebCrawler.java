package com.mycompany.app;

import org.jsoup.Jsoup;   
import org.jsoup.nodes.Document;   
import org.jsoup.nodes.Element;   
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;   

public class WebCrawler {

	
	private HashSet<String> urlLinks;//create set that stores links
	private static final int MAX_DEPTH = 2;
	private List<List<String>> articles;
	
	public WebCrawler() {
		urlLinks = new HashSet<>();
		articles = new ArrayList<>();
		}
	
	//find allpages linked in a url
	public void getPageLinks(String URL, int depth, int level) {
		//check if crawled
		if(urlLinks.size() != 50 && !urlLinks.contains(URL) && depth < MAX_DEPTH && URL.startsWith(URL.substring(0, level))) {
				System.out.println(">> Depth: " + depth + " [" + URL + "]");  
			
			try { //use try-catch for recursion
				urlLinks.add(URL);
				
				
				//fetch HTML code of the url 
				Document doc = Jsoup.connect(URL).get();
				Elements availableLinksOnPage = doc.select("a[href]");
				depth++;
				//repeat for each extracted URL
				for(Element e : availableLinksOnPage) {
					if(e.attr("abs:href").startsWith(URL.substring(0, level))) {
						getPageLinks(e.attr("abs:href"), depth, level); //pass the extracted url as argument 
					}
				}
			}catch(IOException e){
				System.out.println("For" + URL + ":" + e.getMessage());
				
			}
		}
	}
	
	//find all articles in the pages
	public void getArticles() {
		Iterator<String> i = urlLinks.iterator();
		
		while(i.hasNext()) {
			Document doc;
			
			try {
				doc = Jsoup.connect(i.next()).get();
				
				Elements articleLinks = doc.select("a[href]");
				Elements p = doc.select("p"); 
				String txt = p.text();
				
				for(Element e : articleLinks) {
					if(e.text().contains("Leader")) {
						
						System.out.println(e.text());
						System.out.println(txt);
						
						//create temp list that stores articles
						ArrayList<String> temp = new ArrayList<>();
						temp.add(e.text());//add article title
						temp.add(e.attr("abs:href"));//get url of the article 
						temp.add(txt);
						
						articles.add(temp);
					}
				}
			} catch(IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	// create writeToFile() method to write data into file  
	public void writeToFile(String fName) throws IOException {  
	    // declare variable of type FileWriter  
		FileWriter wr = null;  
	  
	        //use try-catch block to write data into file  
		try {  
			// initialize FileWriter for fName  
			wr = new FileWriter(fName);  
	  
			for(int i = 0; i < articles.size(); i++) {  
	      
				try {       
					String article = "- Title: " + articles.get(i).get(0) + " (link: " + articles.get(i).get(1) + ")\n + " + "Text: " + articles.get(i).get(2) + "\n";  
	  
					// show the article and save it to the specified file  
					System.out.println(article);  
					wr.write(article);
	    	
				}catch (IOException e) {  
	    				System.err.println(e.getMessage());  
	                	} 
                	}
			}catch(IOException e) {  
	                		System.err.println(e.getMessage());  
	                    }finally {
	    		            
	                    	// close FileWriter class object  
	                    	wr.close();   
			}
		}

	      
	


}
