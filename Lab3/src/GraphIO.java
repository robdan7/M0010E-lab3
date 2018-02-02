import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GraphIO {
	
	public void readFile(Graph g, String filename) throws IOException {
		try {
			Scanner scan = new Scanner(new File(""));
		} catch (FileNotFoundException e) {
			throw new IOException("File not found!");
		}
	}

}
