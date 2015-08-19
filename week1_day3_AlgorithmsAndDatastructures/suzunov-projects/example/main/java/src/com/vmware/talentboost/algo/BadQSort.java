package com.vmware.talentboost.algo;



public class BadQSort {

   public static void sort(int[] arr) {
      quicksort(arr, 0, arr.length - 1);
   }

   private static void quicksort(int[] arr, int start, int end) {
      if (start >= end) {
         return;
      }
      int pivot = partition(arr, start, end);
      quicksort(arr, start, pivot);
      quicksort(arr, pivot + 1, end);
   }

   private static int partition(int[] arr, int start, int end) {
	      int pivot = arr[start];
	      int i = start - 1;
	      int j = end + 1;

	      while (true) {
	         do {
	            ++i;
	         } while (i < end && arr[i] < pivot);
	         do {
	            --j;
	         } while (j > start && arr[j] > pivot);

	         if (i < j) {
	            swap(arr, i, j);
	         } else {
	            return j;
	         }
	      }
	   }

   private static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

}
