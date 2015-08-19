
public class TripleFor {
	public long calculate(long n){
		long result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				for (int j2 = (int) (n+i+j-3); j2 < n; j2++) {
					result += i;
				}
				
			}
			
		}
		return result;
	}
}
