package subFinder;

import java.util.ArrayList;

public class OfficialKey {
		private ArrayList<Keyword>keyBox = new ArrayList<Keyword>();
		
		public OfficialKey() {
			// TODO Auto-generated constructor stub
			setting();
		}
		
		public void add(Keyword keyword) {
			this.keyBox.add(keyword);
		}
		
		private void setting() {
			ArrayList<Keyword>keywords = new ArrayList<Keyword>();
			String init1 = "租屋";
	        String init2 = "學生";
	        String init3 = "低價";
	        String init4 = "車位";
	        String init5  = "傢俱";
	        Keyword k1 = new Keyword(init1, 4);
	        Keyword k2 = new Keyword(init2, 2.05);
	        Keyword k3 = new Keyword(init3, 2.05);
	        Keyword k4 = new Keyword(init4, 2.05);
	        Keyword k5 = new Keyword(init5, 2.05);
//	        
	        keywords.add(k1);
	        keywords.add(k2);
	        keywords.add(k3);
	        keywords.add(k4);
	        keywords.add(k5);
	        this.keyBox = keywords;
		}
		public ArrayList<Keyword>getKeyword(){
			return this.keyBox;
		}
		
		public void printKeywords() {
			for(int i = 0 ; i <this.keyBox.size();i++) {
				System.out.print(keyBox.get(i) + " , ");
			}
		}
		
		
}	
