package subFinder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			WebPage rootPage = new WebPage("http://soslab.nccu.edu.tw/Welcome.html", "Welcome");
			WebTree tree = new WebTree(rootPage);
			
			tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Welcome.html", "Project")));
			tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Publications.html", "Publication")));
			tree.root.children.get(1).addChild(new WebNode(
					new WebPage("https://scholar.google.com/citations?user=IpxUy-YAAAAJ&hl=en", "Google ")));
			tree.root.children.get(1).addChild(new WebNode(
					new WebPage("https://dblp.uni-trier.de/pers/hd/y/Yu:Fang.html", "DBLP")));
			tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Members.html", "Member")));
			tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Courses.html", "Courses")));
			
			Scanner sc = new Scanner(System.in);
			while(sc.hasNextLine()) {
				int NumOfKeywords = sc.nextInt();
				ArrayList<Keyword>keywords = new ArrayList<>();
				String init1 = "租屋";
				String init2 = "學生";
				String init3 = "低價";
				String init4 = "車位";
				String init5  = "傢俱";
				Keyword k1 = new Keyword(init1, 3);
				Keyword k2 = new Keyword(init2, 2.5);
				Keyword k3 = new Keyword(init3, 2);
				Keyword k4 = new Keyword(init4, 1.5);
				Keyword k5 = new Keyword(init5, 1.2);
				
				keywords.add(k1);
				keywords.add(k2);
				keywords.add(k3);
				keywords.add(k4);
				keywords.add(k5);
				
				for(int i=0;i<NumOfKeywords;i++) {
					String name = sc.next();
				
					Keyword k = new Keyword(name, 1.1);
					keywords.add(k);
				}
				tree.setPostOrderScore(keywords);
				tree.printTree();
			}
	}
}
