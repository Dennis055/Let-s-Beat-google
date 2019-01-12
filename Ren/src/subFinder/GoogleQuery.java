package subFinder;

import java.io.InputStream;

import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
//
//import javax.swing.text.Document;
//import javax.swing.text.Element;

import org.jsoup.Jsoup;
import org.jsoup.internal.ConstrainableInputStream;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.io.BufferedReader;
import java.io.IOException;



public class GoogleQuery {
 public String searchKeyword;
 public String url;
 public String content;
 public ArrayList<String>RootURL;
 
 public GoogleQuery(String searchKeyword){
  this.searchKeyword = searchKeyword;
  this.url = "https://www.google.com.tw/search?q=" + searchKeyword + "&num=5";//我們先找5筆資料，不然server會爆掉，但太多筆資料時間又很長。
 }
 
 private String fetchContent() throws IOException {
  String retVal = "";
  URL urlStr = new URL(this.url);
  URLConnection connection = urlStr.openConnection();
  connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
  connection.connect();
  InputStream inputStream = connection.getInputStream();
  InputStreamReader inReader = new InputStreamReader(inputStream,"UTF8");
  BufferedReader bf = new BufferedReader(inReader);
  
  String line = null;
  while((line = bf.readLine()) != null) {
   retVal += line;
  }
  return retVal;
 }
 
// public HashMap<String, String> query() throws IOException{
//  if(this.content == null) {
//   this.content = fetchContent();
//  }
//  HashMap<String, String> retVal = new HashMap<String, String>();
//  Document document = Jsoup.parse(this.content);
//  Elements lis =  document.select("div.g");
//  
//  for(Element li : lis) {
//   try {
//    Element h3 = li.select("h3.r").get(0);
//    String title = h3.text();
//    
//    Element cite = li.select("cite").get(0);
//    String citeUrl = cite.text();
//    System.out.println(title + " " + citeUrl);;
//    retVal.put(title, citeUrl);
//   } catch(IndexOutOfBoundsException e) {
//    
//   }
//  }
//  return retVal;
// }
// 
 
 
 public ArrayList<String>queryForArr() throws IOException{
	  if(this.content == null) {
	   this.content = fetchContent();
	  }
	  //HashMap<String, String> retVal = new HashMap<String, String>();
	  ArrayList<String>retVal = new ArrayList<String>();
	  Document document = Jsoup.parse(this.content);
	  Elements lis =  document.select("div.g");
	  
	  for(Element li : lis) {
	   try {
	    Element h3 = li.select("h3.r").get(0);
	    String title = h3.text();
	    
	    Element cite = li.select("cite").get(0);
	    String citeUrl = cite.text();
	    System.out.println(title + " " + citeUrl);;
	    retVal.add(citeUrl);
	   } catch(IndexOutOfBoundsException e) {
	    
	   }
	  }
	  return retVal;
	 }

 public ArrayList<String>queryForTitle() throws IOException{
	  if(this.content == null) {
	   this.content = fetchContent();
	  }
	  //HashMap<String, String> retVal = new HashMap<String, String>();
	  ArrayList<String>retVal = new ArrayList<String>();
	  Document document = Jsoup.parse(this.content);
	  Elements lis =  document.select("div.g");
	  
	  for(Element li : lis) {
	   try {
	    Element h3 = li.select("h3.r").get(0);
	    String title = h3.text();
	    
	    Element cite = li.select("cite").get(0);
	    String citeUrl = cite.text();
	    //System.out.println(title + " " + citeUrl);;
	    retVal.add(title);
	   } catch(IndexOutOfBoundsException e) {
	    
	   }
	  }
	  return retVal;
	 }
 
 	//TODO:把google ban掉
 	public ArrayList<String> query() throws IOException{
 		ArrayList<String>retVal = new ArrayList<String>();
 		if(this.content==null) {
 			this.content = fetchContent();
 		}
 		 Document doc = Jsoup.connect(this.url).get();
 		 Elements links = doc.select("a[href]");
 		 for(Element link:links) {
 			String str =  link.attr("href");
 			if(str.startsWith("http")) {
 			//	System.out.println(str);
 				if(str.contains("google"))
 					continue;
 				retVal.add(str);
 			}
 	}
 		 this.RootURL = retVal;
 		return retVal;
 	}
 	public void printResult() {
 		for(int i = 0 ; i<RootURL.size();i++) {
 			System.out.println(RootURL.get(i));
 		}
 	}
 
 	public static void main(String[]args) throws IOException {
// 		 ArrayList<String>retVal = new ArrayList<String>();
// 		 GoogleQuery query = new GoogleQuery("壽司");
// 		 String content = query.fetchContent();
// 		 Document document = Jsoup.parse(content);
// 		 //Elements links = document.select("h3.r");
// 		// Elements links = document.select("a[href]");
// 		 Document doc = Jsoup.connect(query.url).get();
// 		 Elements links = doc.select("a[href]");
// 		 for(Element link:links) {
// 			String str =  link.attr("href");
// 			if(str.startsWith("http")) {
// 				if(str.contains("google")==true) {
// 					continue;
// 				}
// 				System.out.println(str);
// 			}
//
// 		 }
// 		 retVal = query.query();
// 		 query.printResult();
 		 
 	
 	}
}