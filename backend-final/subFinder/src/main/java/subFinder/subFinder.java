package subFinder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.TrustAnchor;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class subFinder {
		
		public String rooturl;
//
//		public String searchKeyword;
		public String url;
		public String content;
		public subFinder(String url) {
			// TODO Auto-generated constructor stub
			this.url = url;
		}
		
//		public GoogleQuery(String searchKeyword) {
//			this.searchKeyword = searchKeyword;
//			this.url = "https://www.google.com.tw/search?q=" + searchKeyword + "&oe=utf8&num=100";
//		}
//		
		private String fetchContent() throws IOException {
			String retVal = "";
			URL urlStr = new URL(this.url);
			URLConnection connection = urlStr.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/5.0(Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
			connection.connect();
			InputStream inputStream = connection.getInputStream();
			InputStreamReader inReader = new InputStreamReader(inputStream, "UTF8");
			BufferedReader bf = new BufferedReader(inReader);
			
		
			String line = null;
			while((line = bf.readLine())!=null) {
				retVal += line;
			}
			return retVal;
		}
		
		//TODO method
		public ArrayList<String>findSublinks(String rootURL) throws IOException{
			ArrayList<String>imgurl = new ArrayList<String>();
			String url = rootURL;
			this.url = url;
			if(this.content==null) {
				this.content = fetchContent();
			}
			ArrayList<String>hreflist = new ArrayList<String>();
			Document document = Jsoup.parse(this.content);
			Element content = document.getElementById("content");
			Elements lin = content.getElementsByTag("a");//The content attribute gives the value associated with the http-equiv or name attribute.
			for (Element link : lin) {
			  String linkHref = link.attr("href");
			  if(linkHref.contains("http")!=true) {
				  linkHref = url + "/" + linkHref;//Adjust the content and add the http
			  }
			  hreflist.add(linkHref);
			  System.out.println(linkHref);
			}
			return hreflist;//root
		}
		
		
//		public static void main(String[]args) throws IOException {
//			ArrayList<String>imgurl = new ArrayList<String>(); 
//			String url = "http://www.home7-11.com.tw";
//			subFinder tester = new subFinder(url);
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
//
//		}
//		
		

}
