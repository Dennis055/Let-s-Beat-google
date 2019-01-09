package subFinder;

import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.RootPaneContainer;

public class Gardener {
	keywordHeap heap = new keywordHeap();
	ArrayList<WebTree>forest;

	
	public Gardener(ArrayList<WebTree>forest) {
		// TODO Auto-generated constructor stub
		this.forest = forest;
		plant();
	}
	
	private void plant() {
		int area = forest.size();
		for(int i=0 ; i < area; i++) {
			WebPage page = forest.get(i).root.webPage;
			String name = page.name;
			double score = page.score;
			Keyword keyword = new Keyword(name, score);
			heap.add(keyword);
		}
	}
	
	public void printResult() {
		heap.showPri();
	}
	
	
	
}
