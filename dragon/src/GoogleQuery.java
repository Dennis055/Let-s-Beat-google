import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleQuery {
	public String searchKeyword;
	public String url;
	public String content;

	public GoogleQuery(String searchKeyword) {

		if (searchKeyword.contains("龍角")) {
			this.searchKeyword = searchKeyword;
		} else {
			this.searchKeyword = searchKeyword + "龍角";
		}
		this.url = "https://www.google.com.tw/search?q=" + this.searchKeyword + "&oe=utf8&num=15"
				+ "";
	}
	

	private String fetchContent() throws IOException {
		String retVal = "";
		URL urlStr = new URL(this.url);
		//TODO
		
		URLConnection connection = urlStr.openConnection();
		HttpsURLConnection httpcon = (HttpsURLConnection)connection;
		connection.setRequestProperty("User-Agent",
				"Mozilla/5.0(Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		connection.connect();
		if(httpcon.getResponseCode()==HttpURLConnection.HTTP_OK) {
			InputStream inputStream = connection.getInputStream();
			InputStreamReader inReader = new InputStreamReader(inputStream, "UTF8");
			BufferedReader bf = new BufferedReader(inReader);

			String line = null;
			while ((line = bf.readLine()) != null) {
				retVal += line;
			}
		}else {
			System.out.println("無法取得連線！");
		}
		return retVal;
	}

	public HashMap<String, String> query() throws IOException {
		if (this.content == null) {
			this.content = fetchContent();
		}
		HashMap<String, String> retVal = new HashMap<String, String>();
		Document document = Jsoup.parse(this.content);
		Elements lis = document.select("div.g");

		for (Element li : lis) {
			try {
				Element h3 = li.select("h3.r").get(0);
				String title = h3.text();

//				Element cite = li.getElementsByTag("a").first();
//				String citeUrl = "https://www.google.com.tw"+ cite.attr("href");
				
				Element cite = li.select("cite").get(0);
				String citeUrl = cite.text();
				// System.out.println(title + " " + citeUrl);
				retVal.put(title, citeUrl);
			} catch (IndexOutOfBoundsException e) {
				// Do nothing
			}
		}
		return retVal;
	}

}