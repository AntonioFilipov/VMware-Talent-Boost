package Sort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Executor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] array = new double[] {
				4,2,4,7,8,5
		};
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(new MergeSort(array, 0, array.length-1));
		double[] copy = Arrays.copyOf(array, array.length);
		
		Arrays.sort(copy);
		System.out.println(Arrays.equals(array, copy));
	}

}
