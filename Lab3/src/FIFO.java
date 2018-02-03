import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * 
 * @author Robin Danielsson
 *
 */

public class FIFO implements Queue {
	private int maxSize;

	private ArrayList<Object> fifo;

	public FIFO() {
		this.fifo = new ArrayList<>();
	}

	public static void main(String[] args) {
		String[] file = { "myGraph.txt" };

		FIFOmain.main(file);

		BFTmain.main(file);
	}

	/**
	 * Add an object at the end of the queue.
	 */
	@Override
	public void add(Object arg0) {
		fifo.add(arg0);
		this.maxSize = this.fifo.size() > this.maxSize ? this.fifo.size() : this.maxSize;
	}

	/**
	 * This method returns the first element in the queue.
	 * 
	 * @throws NoSuchElementException
	 *             This is thrown if the queue is empty.
	 */
	@Override
	public Object first() throws NoSuchElementException {
		if (fifo.size() == 0) {
			throw new NoSuchElementException();
		}
		return fifo.get(0);
	}

	/**
	 * <p>
	 * This method returns <b>true</b> if, and only if, the size of this queue is 0.
	 * Otherwise, <b>false</b> is returned.
	 * </p>
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return fifo.size() == 0 ? true : false;
	}

	/**
	 * @return The maximum size this queue has had since it was created.
	 */
	@Override
	public int maxSize() {
		return this.maxSize;
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
		return fifo.size();
	}

	public Object get(int i) {
		return this.fifo.get(i);
	}

	/**
	 * Two objects are equal if and only if they are both instances of {@link FIFO}
	 * and have the same elements in order.
	 * 
	 * @throws ClassCastException
	 *             This is thrown is o is not an instance of FIFO.
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
			if (this.fifo.get(i) == null || ((FIFO) o).get(i) == null) {
				if (this.fifo.get(i) != ((FIFO) o).get(i)) {
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

	/**
	 * <p>
	 * This method returns a string beginning with <b>"Queue: "</b> followed by the
	 * following, for each element in the queue.
	 * </p>
	 * 
	 * @return A string.
	 */
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
