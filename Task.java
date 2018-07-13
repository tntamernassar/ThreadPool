
abstract public class Task {

	public Task() {

	}
	
	abstract public boolean apply();
	abstract public void onSuccess();
	abstract public void onFail();
	
}
