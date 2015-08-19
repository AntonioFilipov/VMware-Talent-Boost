
public class Fibonacci {
	public static long fibCacl(int n){
		if (n<=2) {
			return 1;
			
		}
		return fibCacl(n-1)+fibCacl(n-2);
	}
}
