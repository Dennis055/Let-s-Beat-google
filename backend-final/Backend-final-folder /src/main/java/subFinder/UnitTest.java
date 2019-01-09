package subFinder;

import java.io.IOException;
import java.util.ArrayList;

public class UnitTest {
	public static void main(String[]args) throws IOException {
		String keyTest = "壽司";
		subFinder finder = new subFinder();
		GoogleQuery querier = new GoogleQuery(keyTest);
		ArrayList<String>rootlist = querier.queryForArr();
		ArrayList<String>titleList =querier.queryForTitle(); 
		//Setting for test
		int i = 0;
		Keyword keyword = new Keyword(keyTest, 1.1);
		ArrayList<Keyword>keywords = new ArrayList<Keyword>();
		keywords.add(keyword);
		ArrayList<Double>scoreList = new ArrayList<Double>();
		//end
		for(String rooturl:rootlist) {
			
			WebPage rootPage = new WebPage(rooturl,titleList.get(i));
			i++;
			WebTree tree = new WebTree(rootPage);
			System.out.println(rooturl);
			ArrayList<String>children  = finder.findSublinks(rooturl);
			for(String child:children) {
				tree.root.addChild(new WebNode(new WebPage(child ,"")));
			}
			tree.setRootScore(keywords);
			scoreList.add(tree.root.nodeScore);
			tree.printRoot(tree.root);
			//TODO 子網頁的分數累加到整個網頁  
			//tree.setPostOrderScore(keywords);
			//tree.printRoot(tree.root);
			//tree.printTree();

		//System.out.println(tree.root.nodeScore);
		}
		//上面括弧是最上層for迴圈結束
		
	}
}