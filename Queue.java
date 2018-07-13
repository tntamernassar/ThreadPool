import java.util.LinkedList;

public class Queue<T> {
private LinkedList<T> data;
	
	public Queue() {
		data = new LinkedList<T>();
	}
	public void push(T t) {
		data.addLast(t);
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	public T pop() {
		if(isEmpty())
			return null;
		T t = data.get(0);
		data.remove(t);
		return t;
	}
	
	public int size() {
		return data.size();
	}
}
