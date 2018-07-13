
public class Test {

	
	public static void main(String[] args) {
		ThreadQueue q = new ThreadQueue();
		q.push(new Task() {
			
			@Override
			public boolean apply() {
				System.out.println("Task 1 ...");
				return true;
			}
		});
		
		
		q.push(new Task() {
			
			@Override
			public boolean apply() {
				System.out.println("Task 2 ...");
				return true;
			}
		});
	}
	
}
