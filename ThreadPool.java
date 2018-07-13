
public class ThreadPool {

	private int n;
	
	private boolean[] status;
	private Thread[] threads;
	
	private Queue<Task> q;
	
	public ThreadPool(int n) {
		this.n = n;
		q = new Queue<Task>();
		init();
		
	}
	
	private void init() {
		this.status = new boolean[n];
		this.threads = new Thread[n];

		int i;
		for(i=0;i<n;i++) {
			status[i] = false;
			threads[i] = null;
		}
		
	}
	
	public void start() {
		Wait();
	}
	
	private int getNextThread() {

			for(int i=0;i<n;i++) {
				if(status[i] == false)
					return i;
			}
			return -1;	

	}

	public void addTask(Task t) {
		q.push(t);
	}

	private void startPool(){
		Thread selector = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(!q.isEmpty()) {
					int[] nextThread = new int[1];
					nextThread[0] = getNextThread();
					while(nextThread[0] == -1) {
						nextThread[0] = getNextThread();
					}
					status[nextThread[0]] = true;
					Task t = q.pop();

					Thread Worker = new Thread(new Runnable() {
						
						@Override
						public void run() {
							System.out.println("Thread #"+nextThread[0]+" started a new Task ");
							t.apply();
							status[nextThread[0]] = false;
							System.out.println("Thread #"+nextThread[0]+" finished his Task ");
						}
					});
					
					threads[nextThread[0]] = Worker;
					Worker.start();
					
				}
				Wait();
			}
		});
		selector.start();
	}
	
	private void Wait() {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(q.isEmpty());
				
				startPool();
			}
		});
		t.start();
	}
	
	
}
