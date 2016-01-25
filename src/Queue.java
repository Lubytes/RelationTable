//Queue class that makes a generic queue. 
//This class works with a linked list to make the queue
public class Queue<T> {

	private LinkedList<T> list;
	int cursor;

	public Queue() {
		list = new LinkedList<T>();
		cursor = 0;
	}

	// add an item to the end of the list
	public void enqueue(T item) {
		list.addToEnd(item);
	}

	// remove an item from the front of the list
	public T dequeue() {
		return list.removeAt(0);
	}

	// displays the size of the list
	public int Getsize() {
		return list.size();
	}

	// boolean answer if it is empty
	public boolean isEmpty() {
		return list.isEmpty();
	}

	// empies the list
	public void clear() {
		list.clear();
	}

	// Look at the front node
	public T peek() {
		return list.getAt(0);
	}

	// gives the int position of an item. -1 if none
	public int positionOf(T item) {
		return list.indexOf(item);
	}

	// remove a specific item
	public void remove(T item) {
		list.remove(item);
	}

	// first and next use a cursor to navigate the queue
	public T first() {
		if (list.isEmpty())
			return null;
		cursor = 0;
		return list.getAt(0);

	}

	public T next() {
		if (cursor < 0 || cursor == list.size() - 1)
			return null;
		cursor++;
		return list.getAt(cursor);
	}

	// enumerate the queue
	public void stateItems() {
		list.enumerate();
	}
}