
public class Test {

	
	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(3);
		
		//this task returning true , so it will act like success task
		pool.addTask(new Task() {
			
			@Override
			public boolean apply() {
				System.out.println("Task 1 in progress ...");
				return true;
			}

			@Override
			public void onSuccess() {
				System.out.println("Task 1 successed");
				
			}

			@Override
			public void onFail() {
				System.out.println("Task 1 failed");
			}
		});
		
		//this task returning false , so it will act like failed T=task
		pool.addTask(new Task() {
			
			@Override
			public boolean apply() {
				System.out.println("Task 2 in progress ...");
				return false;
			}

			@Override
			public void onSuccess() {
				System.out.println("Task 2 successed");
			}

			@Override
			public void onFail() {
				System.out.println("Task 2 failed");
			}
		});
		
		pool.start();
	}
	
}
