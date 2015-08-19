
public class FinalTask {
	public long calculate(long n){
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i*i; j++) {
				result+=j;
			}
		}
		return result;
	}
	
}
