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

		FIFO f2 = new FIFO();
		f2.add(1);
		f2.add(2);
		f2.add(3);

		System.out.println(f.equals(f2));

		/*
		 * System.out.println(f.first()); f.removeFirst();
		 * System.out.println(f.first()); f.removeFirst();
		 * System.out.println(f.first());
		 */
		System.out.println(f2.toString());
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
	public boolean equals(Object o) {

		// Check if o is NOT a queue and if the size is different.
		if (!(o instanceof FIFO) || this.fifo.size() != ((FIFO) o).size()) {
			return false;
		}

		// o is a queue with the same size. Check if the objects are equal.
		for (int i = 0; i < this.fifo.size(); i++) {
			if (!this.fifo.get(i).equals(((FIFO) o).get(i))) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String toString() {
		String result = "Queue: ";

		if (this.fifo.size() == 0) {
			return result;
		}

		// This adds every element within "()" without a space at the end. Take that lab
		// instructions!
		for (int i = 0; i < this.fifo.size() - 1; i++) {
			result += "(" + String.valueOf(this.fifo.get(i)) + ") ";
		}
		result += "(" + this.fifo.get(this.fifo.size() - 1) + ")";

		return result;
	}

}
