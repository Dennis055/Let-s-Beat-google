import java.awt.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.xml.crypto.Data;

public class Sorter {
	
public ArrayList<String> getList(){

	String filePath = WriterOrReaderTxt.class.getResource("").getPath().replace("file:", "")

			+ "/test.txt"; // 文件和該類在同個目錄下

			BufferedReader reader = null;

			try {

			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8")); // 指定讀取文件的編碼格式，以免出現中文亂碼

			String str = null;
			
			ArrayList<String> list = new ArrayList<String>();

			while ((str = reader.readLine()) != null) {

			list.add(str);

			}
			
			 return list;

			} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;

			} catch (IOException e) {

			e.printStackTrace();
			return null;

			} finally {

			try {

			reader.close();

			} catch (IOException e) {

			e.printStackTrace();

			}}
          
			}
public void calculateScore() {
	  for(int i = 0; i<b.size(); i++) {
	   if(b.get(i).text.indexOf("keyword1")>0) {b.get(i).score*=1.1;}
	   if(b.get(i).text.indexOf("Keyword2")>0) {b.get(i).score*=1.1;}
	   if(b.get(i).text.indexOf("Keyword3")>0) {b.get(i).score*=1.1;}
	   
	  }
	  
	  for(int i=0;i<b.size();i++) {
	   if(b.get(i).text.indexOf("特選字1")>0) {b.get(i).score*=1.2;}
	   if(b.get(i).text.indexOf("特選字2")>0) {b.get(i).score*=1.3;}
	   if(b.get(i).text.indexOf("特選字3")>0) {b.get(i).score*=1.4;}
	   
	   
	  }
	  
	  
	 }




 public void setDataList() {
	 
	 
	 ArrayList<String> a = this.getList();
	 ArrayList<data> b = new ArrayList<>();	

	
 for(int i=0; i<a.size();i++) {
	 String c = a.get(i);
	b.add(new data(c));
	 
 }
 
 for(int i = 0;i<b.size();i++) {
	 System.out.print(b.get(i).text);
 }
 }

 
 
  public ArrayList<data> doQuickSort(ArrayList<data> li){
    if (li.size() < 2) return li;
    
    ArrayList<data> result = new ArrayList<>();
    
    int pivotIndex = li.size() / 2;
    data pivotKeyword = li.get(pivotIndex);
    
    ArrayList<data> lessList = new ArrayList<>();
    ArrayList<data> equalList = new ArrayList<>();
    ArrayList<data> greatList = new ArrayList<>();
    
    for(int i = 0; i<li.size(); i++) {
     data k = li.get(i);
     
     if (k.score > pivotKeyword.score) {
      greatList.add(k);
     }
     else if (k.score < pivotKeyword.score) {
      lessList.add(k);
     }
     else {
      equalList.add(k);
     }
    }
    
    result.addAll(doQuickSort(lessList));
    result.addAll(equalList);
    result.addAll(doQuickSort(greatList));
    return result;
   }
 
}