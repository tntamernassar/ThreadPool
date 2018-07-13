
public class Test {

	
	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(3);
		pool.addTask(new Task() {
			
			@Override
			public boolean apply() {
				System.out.println("Task 1 ...");
				return true;
			}
		});
		
		
		pool.addTask(new Task() {
			
			@Override
			public boolean apply() {
				System.out.println("Task 2 ...");
				return true;
			}
		});
		
		pool.start();
	}
	
}
