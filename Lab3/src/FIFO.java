import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * 
 * @author Robin Danielsson
 *
 */

public class FIFO implements Queue {

	private ArrayList<Object> fifo;

	public FIFO() {
		this.fifo = new ArrayList<>();
	}

	public static void main(String[] args) {
		String[] file = {"graph.txt"};
		
		FIFOmain.main(file);
		
		BFTmain.main(file);
	}

	@Override
	public void add(Object arg0) {
		fifo.add(arg0);
	}

	@Override
	public Object first() throws NoSuchElementException {
		if (fifo.size() == 0) {
			throw new NoSuchElementException();
		}
		return fifo.get(0);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return fifo.size() == 0 ? true : false;
	}

	@Override
	public int maxSize() {
		// TODO Auto-generated method stub
		return 1000;
	}

	@Override
	public void removeFirst() throws NoSuchElementException {
		if (fifo.size() == 0) {
			throw new NoSuchElementException();
		}
		fifo.remove(0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return fifo.size();
	}

	public Object get(int i) {
		return this.fifo.get(i);
	}

	/**
	 * Two objects are equal if and only if they are both instances of {@link FIFO}
	 * and have the same elements in order.
	 */
	@Override
	public boolean equals(Object o) throws ClassCastException {
		boolean result = true;
		// o must be an instance of FIFO.
		if (!(o instanceof FIFO)) {
			throw new ClassCastException();
		}

		// Check if the size is different.
		if (this.fifo.size() != ((FIFO) o).size()) {
			return false;
		}

		// o is a queue with the same size. Check if the objects are equal.
		loop: for (int i = 0; i < this.fifo.size(); i++) {
			if (this.fifo.get(i) == null || ((FIFO)o).get(i) == null) {
				if (this.fifo.get(i) != ((FIFO)o).get(i)) {
					result = false;
					break loop;
				}
			} else if (!this.fifo.get(i).equals(((FIFO) o).get(i))) {
				result = false;
				break loop;
			}
		}

		return result;
	}

	@Override
	public String toString() {
		String result = "Queue: ";

		if (this.fifo.size() == 0) {
			return result;
		}
		
		for (Object o : this.fifo) {
			result += "(" + String.valueOf(o) + ") ";
		}

		return result;
	}

}
