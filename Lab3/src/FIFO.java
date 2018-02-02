import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO implements Queue {

	private ArrayList<Object> fifo;

	public FIFO() {
		this.fifo = new ArrayList<>();
	}

	public static void main(String[] args) {
		FIFO f = new FIFO();
		f.add(1);
		f.add(2);
		f.add(3);

		System.out.println(f.first());
		f.removeFirst();
		System.out.println(f.first());
		f.removeFirst();
		System.out.println(f.first());
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
	 * Two objects are equal if and only if they are both instances of {@link FIFO},
	 * and have the same elements in order.
	 */
	@Override
	public boolean equals(Object o) {
		if (this.fifo.size() != ((FIFO) o).size()) {
			return false;
		}

		for (int i = 0; i < this.fifo.size(); i++) {
			if (this.fifo.get(i) != ((FIFO) o).get(i)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String toString() {
		String result = "";

		for (Object o : this.fifo) {
			result += o.toString();
		}

		return result;
	}

}
