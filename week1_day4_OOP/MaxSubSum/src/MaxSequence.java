
public class MaxSequence {
	
	public static int maxSumUpperBoundOn(int[] array) {
       int tempSum=array[0];
       int maxSum=array[0];
       for(int i=1;i<array.length;i++){
           tempSum=Math.max(tempSum+array[i],array[i]);
           maxSum= Math.max(maxSum, tempSum);
       }
       return maxSum;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {-2,-3,-3,1,2,3,-1,4,2,3,4};
		System.out.println(maxSumUpperBoundOn(array));
	}

}
