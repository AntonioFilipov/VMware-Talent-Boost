package Sort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergeSort extends RecursiveAction {

	private double[] array;
	private int low;
	private int high;

	public double[] getArray(){
		return this.array;
	}
	public MergeSort(double[] array, int low, int high) {
		this.array = array;
		this.low = low;
		this.high = high;
	}

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		if ((high - low) <= 20) {
			insertionSort(array, low, high);
		}
		int mid = (low + high) / 2;
		invokeAll(new MergeSort(array, low, mid), new MergeSort(array, mid + 1,
				high));
		merge(array, low, mid, high);
	}

	private void merge(double[] array2, int low2, int mid, int high2) {
		// TODO Auto-generated method stub
		double[] helper = Arrays.copyOf(array, array.length);
		int l = low;
		int m = mid + 1;
		int k = low;

		while (l <= mid && m <= high) {
			if (helper[l] < helper[m]) {
				array[k++] = helper[l++];
			}
		}

		while (l <= mid) {
			array[k++] = helper[l++];
		}

		while (m <= high) {
			array[k++] = helper[m++];
		}
	}

	public void insertionSort(double[] array2, int low2, int high2) {
		// TODO Auto-generated method stub
		for (int i = low2 + 1; i < high2; i++) {
			double x = array2[i];
			int j = i;
			while (j > 0 && x < array2[j-1]) {
				array2[j] = array2[j - 1];
				j--;
			}
			array2[j] = x;
		}
	}

}
