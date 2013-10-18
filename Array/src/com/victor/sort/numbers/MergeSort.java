package com.victor.sort.numbers;

public class MergeSort {
	
	private static int[] temp_arr;
	
	// show each elements of the array
	public static void show(int[] arr) {
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}
	
	// check if the array is sorted by ascending order
	public static boolean isSorted(int[] arr) {
		int N = arr.length;
		for (int i = 1; i < N; i++) {
			if (arr[i] < arr[i-1]) return false;
		}
		
		return true;
	}
	
	// merge method
	private static void merge(int[] arr, int lo, int mid, int hi) {
		int left = lo;
		int right = mid+1;
		
		for (int i = lo; i <= hi; i++) {
			temp_arr[i] = arr[i];
		}
		
		for (int i = lo; i <= hi; i++) {
			if 		(left > mid) 						arr[i] = temp_arr[right++];
			else if (right > hi) 						arr[i] = temp_arr[left++];
			else if (temp_arr[right] < temp_arr[left])  arr[i] = temp_arr[right++];
			else										arr[i] = temp_arr[left++];
		}
	}
	
	// top-down merge sort algorithm, divide the array into 2 halves, sort each one and then merge
	private static void topDown(int[] arr, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi-lo)/2;
		topDown(arr, lo, mid);
		topDown(arr, mid+1, hi);
		merge(arr, lo, mid, hi);
	}
	
	// bottom-up merge sort algorithm, sort each pair of size, then merge
	private static void bottomUp(int[] arr) {
		int N = arr.length;
		temp_arr = new int[N];
		
		for (int size = 1; size < N; size = size*2) {
			for (int lo = 0; lo < N-size; lo += size*2) {
				merge(arr, lo, lo+size-1, Math.min(lo+size*2-1, N-1));
			}
		}
	}
	
	// call sort algorithm
	public static void sort(int[] arr, String method) {
		int N = arr.length;
		temp_arr = new int[N];
		if (method == "topdown") {
			topDown(arr, 0, N-1);
		} else if (method == "bottomup") {
			bottomUp(arr);
		} else {
			throw new IllegalArgumentException("The given method is not found!");
		}
	}
	
	public static void main(String[] args) {
		int N = 100;
		// general case test
		int[] random_array = RandomNumbers.generateRandomNumbers(1, 1000, N);
		// best case test
		int[] sorted_array = new int[N];
		// worst case test
		int[] reverse_sorted_array = new int[N];
		for (int i = 0; i < N; i++) {
			sorted_array[i] = i;
			reverse_sorted_array[i] = N - i;
		}
		
		int[][] array = new int[3][N];
		array[0] = random_array;
		array[1] = sorted_array;
		array[2] = reverse_sorted_array;
		boolean results = false;
		
		for (int[] test_array : array) {
			if (isSorted(test_array)) {
				System.out.println("The array is already sorted!");
				results = true;
			} else {
//				sort(test_array, "bottomup");	// bottomUp sort test
				sort(test_array, "topdown");	// topDown sort test
				if (isSorted(test_array)) {
					System.out.println("The array is sorted");
					results = true;
				} else {
					System.out.println("The array is not sorted");
					results = false;
				}
			}
//			show(test_array);
		}
		
		if (results) System.out.println("The algorithm works fine.");
	}
}
