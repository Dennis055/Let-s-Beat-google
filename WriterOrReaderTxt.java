import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class WriterOrReaderTxt {
	
	public void writerTxt() {

		//writer�b�o�̥Τ���  ���O��b�o�̥H�Ѧ�txt���ɮ׸��u
		BufferedWriter fw = null;

		try {

		File file = new File("C:\\Users\\user\\eclipse-workspace\\ReaderTxt\\bin\\test.txt");

		fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")); // ���I�s�X�榡�A�H�KŪ���ɤ���r�Ų��`
		fw.append("�ڼg�J�����e");

		fw.newLine();

		fw.append("�ڤS�g�J�����e");

		fw.flush(); // �����g�J�w�s�������e

		} catch (Exception e) {

		e.printStackTrace();

		} finally {

		if (fw != null) {

		try {

		fw.close();

		} catch (IOException e) {
			e.printStackTrace();

		}

		}

		}

		}

		 

		// Ū���
	
		public void readTxt() {

		String filePath = WriterOrReaderTxt.class.getResource("").getPath().replace("file:", "")

		+ "/test.txt"; // ���M�����b�P�ӥؿ��U

		BufferedReader reader = null;

		try {

		reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8")); // ���wŪ����󪺽s�X�榡�A�H�K�X�{����ýX

		String str = null;
		
		ArrayList<String> list = new ArrayList<String>();

		while ((str = reader.readLine()) != null) {

		list.add(str);

		}
		
		System.out.println(list);

		} catch (FileNotFoundException e) {

		e.printStackTrace();

		} catch (IOException e) {

		e.printStackTrace();

		} finally {

		try {

		reader.close();

		} catch (IOException e) {

		e.printStackTrace();

		}

		}

		}

}
