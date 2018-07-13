import java.util.LinkedList;

public class ThreadQueue {

	
	private LinkedList<Task> data;
	private ThreadPool pool;
	public ThreadQueue() {
		data = new LinkedList<Task>();
		pool = new ThreadPool(70);
		pool.start();
	}
	
	
	public void push(Task t) {
		data.addLast(t);
		pool.addTask(t);
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	public Task pop() {
		if(isEmpty())
			return null;
		Task t = data.get(0);
		data.remove(t);
		return t;
	}
	
	public int size() {
		return data.size();
	}
	

}
