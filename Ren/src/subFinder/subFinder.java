package subFinder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.TrustAnchor;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.net.ssl.SSLHandshakeException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class subFinder {
		
		public subFinder(String rootURL) {
			// TODO Auto-generated constructor stub
			this.url = rootURL;
		}
//		public String searchKeyword;
		public String url;
		public String content;

		private String fetchContent() throws IOException{
			//TODO 如何處理沒有https的網頁？以免出現 java.net.MalformedURLException:
//			if(this.url.contains("BBC")==true) {
//				this.url = "https://www.google.com"; //
//			}
			String NoContent = "";
			if(this.url.contains("http")!=true) {
				this.url  = "http://" + url;
			}
			try {
			URL url = new URL(this.url);
			URLConnection conn = url.openConnection();
			HttpURLConnection httpCon = (HttpURLConnection) conn;
			int code = httpCon.getResponseCode();
			if(code==HttpURLConnection.HTTP_OK) {
			InputStream in = conn.getInputStream();
			BufferedReader bReader = new BufferedReader(new InputStreamReader(in));
			
			String retVal = "";
			String line = null;
			
			while((line = bReader.readLine())!=null) { //while loop continue
				retVal = retVal + line + "\n";  
				}
			in.close();
			return retVal;
			}else {
				 System.out.println("Can not access the website");
				 
			}	
			}catch (MalformedURLException e) {
				System.out.println("Wrong URL!");
				// TODO: handle exception
			}catch (IOException e) {
				// TODO: handle exception
				System.out.println("Can not connect!");
			}
			return NoContent;
		}
		 
		//TODO method
//		public ArrayList<String>findSublinks() throws IOException{
//			String url = this.url;
//			if(this.content==null) {
//				this.content = fetchContent();
//			}
//			ArrayList<String>hreflist = new ArrayList<String>();
//			Document document = Jsoup.parse(this.content);
//			Element content = document.getElementById("content");
//			Elements lin = content.getElementsByTag("a");//The content attribute gives the value associated with the http-equiv or name attribute.
//			for (Element link : lin) {
//			  String linkHref = link.attr("href");
//			  if(linkHref.contains("http")!=true) {
//				  linkHref = url + "/" + linkHref;//Adjust the content and add the http
//			  }
//			  hreflist.add(linkHref);
//			}
//			return hreflist;//root
//		}
		//TODO連線使用
		public ArrayList<String>findSublinks() throws IOException{
			String url = this.url;
			ArrayList<String>hreflist = new ArrayList<String>();
			if(this.content==null) {
				this.content = fetchContent();
			}
			try {
					URL url1 = new URL(url);
					URLConnection conn = url1.openConnection();
					HttpURLConnection httpCon = (HttpURLConnection) conn;
					int code = httpCon.getResponseCode();
					if(code==HttpURLConnection.HTTP_OK) {
						 Document doc = Jsoup.connect(url).get();
				          Elements links = doc.select("a[href]");
				          for(Element link:links) {
				             String str =  link.attr("href");
				             if(str.startsWith("http")) {
				                hreflist.add(str);
				             }
				 
				             // System.out.println(link.select(""));
				          }
						
						return hreflist;
					}else {
						System.out.println("無法與網站子連結產生http連線！");
					}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("sublink url throws exception");
			}
			return hreflist;
		   
		}
		
		
		//For test main function
		public static void main(String[]args) throws IOException {
//			ArrayList<String>imgurl = new ArrayList<String>(); 
//			String url = "http://www.home7-11.com.tw";
//			subFinder tester = new subFinder();
//			if(tester.content==null) {
//				tester.content = tester.fetchContent();
//			}
//			ArrayList<String>hreflist = new ArrayList<String>();
//			Document document = Jsoup.parse(tester.content); 
//			Element content = document.getElementById("content");
//			Elements lin = content.getElementsByTag("a");
////			Elements pElements = document.select("a[href]");
////			System.out.println(pElements.html());
//			for (Element link : lin) {
//			  String linkHref = link.attr("href");
//			  if(linkHref.contains("http")!=true) {
//				  linkHref = url + "/" + linkHref;
//			  }
//			  hreflist.add(linkHref);
//			  System.out.println(linkHref);
//			}
//		//TODO method
				subFinder finder = new subFinder("https://www.sushiexpress.com.tw/sushi-express/Menu");
				ArrayList<String>test = finder.findSublinks();
				for(int  i = 0 ; i<test.size();i++) {
					System.out.println(test.get(i));
				}
		}
		
		

}
