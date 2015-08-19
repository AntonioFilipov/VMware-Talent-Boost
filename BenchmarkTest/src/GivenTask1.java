
public class GivenTask1 {
	public long calculate(int i){
		long result = 0;
		for (int j = 0; j < i; j++) {
			int t = j;
			while (t%2 == 0 && t > 0) {
				result+=t;
				t/=2;
			}
		}
		return result;
	}
}
