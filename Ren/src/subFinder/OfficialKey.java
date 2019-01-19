package subFinder;

import java.awt.Stroke;
import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;

public class OfficialKey {
		private ArrayList<Keyword>keyBox = new ArrayList<Keyword>();
		String text = "" ;
		
		public OfficialKey() {
			// TODO Auto-generated constructor stub
			setting();
		}
		
		public void add(Keyword keyword) {
			this.keyBox.add(keyword);
			this.text  =  keyword.name + text;
		}
		
		private void setting() {
			ArrayList<Keyword>keywords = new ArrayList<Keyword>();
			String init1 = "租屋";
	        String init2 = "學生";
	        String init3 = "低價";
	        String init4 = "車位";
	        String init5  = "傢俱";
	        Keyword k1 = new Keyword(init1, 4);
	        Keyword k2 = new Keyword(init2, 3.55);
	        Keyword k3 = new Keyword(init3, 3);
	        Keyword k4 = new Keyword(init4, 2.05);
	        Keyword k5 = new Keyword(init5, 2.55);
	        
	      
	       this.text = init1 + init2 + init3 + init4 + init5;
	        
	        keywords.add(k5);
	        keywords.add(k4);
	        keywords.add(k3);
	        keywords.add(k2);
	        keywords.add(k1);
//	        for(int i = 0  ; i<5;i++) {
//	        	this.text =  "  " + text + keywords.get(i).name;
//	        }
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
		
		public String textPackage() {
			int size = keyBox.size();
			String packageString  = keyBox.get(size-1).name;
			packageString += keyBox.get(size-2).name; //租屋
			return packageString;
		}
		
		public static void main(String[]args) {
			OfficialKey officialKey = new OfficialKey();
			Keyword keyword  = new Keyword("oki", 4);
			officialKey.add(keyword);
			String keyString = officialKey.textPackage();
			System.out.println(keyString);
			System.out.println(officialKey.text);
			
		}
		
		
}	
