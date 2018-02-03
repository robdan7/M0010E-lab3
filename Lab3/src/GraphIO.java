import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GraphIO {
	
	public static void readFile(Graph g, String filename) throws IOException {
		Scanner scan;
		try {
			scan = new Scanner(new File("graph.txt"));
		} catch (FileNotFoundException e) {
			throw new IOException("File not found!");
		}
		
		int lines = scan.nextInt();
		for (int i = 0; i < lines; i++) {
			g.addNode(scan.nextInt(), scan.nextInt(), scan.nextInt());
		}
		
		for (int i = 0; i < lines; i++) {
			g.addEdge(scan.nextInt(), scan.nextInt(), scan.nextInt());
		}
	}

}
