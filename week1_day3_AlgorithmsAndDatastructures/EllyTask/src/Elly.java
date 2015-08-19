
public class Elly {
	
	
	public static long getMaxProfit(int[] initialPrice){
		int lAccess = 0;
		int rAccess = initialPrice.length-1;
		int maxProfit = 0;
		int k = 0;
		
		while (lAccess !=  rAccess) {
			if ((k+1)*initialPrice[lAccess] > (k+1)*initialPrice[rAccess]) {
				maxProfit += (k+1)*initialPrice[lAccess];
				lAccess++;
			}else if ((k+1)*initialPrice[lAccess] < (k+1)*initialPrice[rAccess]){
				maxProfit += (k+1)*initialPrice[rAccess];
				rAccess--;
			}
			k++;
		}
		return maxProfit;
	}
	
	
	public static void main(String[] args) {
		int[] array = {2,3,5,1,4};
		System.out.println(getMaxProfit(array));
	}
	
}
