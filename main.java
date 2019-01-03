
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String keyword = scanner.next();
			GoogleQuery googleQuery = new GoogleQuery(keyword);
			googleQuery.query();
		}
		scanner.close();

	}
}