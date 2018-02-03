import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Robin Danielsson
 *
 */

public class GraphIO {
	
	/**
	 * Read nodes and edges to a graph.
	 * @param g The graph to store everything in.
	 * @param filename String with filename.
	 * @throws IOException
	 */
	public static void readFile(Graph g, String filename) throws IOException {
		Scanner scan;
		try {
			scan = new Scanner(new File(filename));
		} catch (IOException e) {
			throw new IOException("File not found!");
		}
		
		int lines = scan.nextInt();
		for (int i = 0; i < lines; i++) {
			g.addNode(scan.nextInt(), scan.nextInt(), scan.nextInt());
		}
		
		while(scan.hasNextLine()) {
			g.addEdge(scan.nextInt(), scan.nextInt(), scan.nextInt());
		}
		
		scan.close();
	}

}
