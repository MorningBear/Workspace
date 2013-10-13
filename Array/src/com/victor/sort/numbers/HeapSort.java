package com.victor.sort.numbers;

public class HeapSort extends Sort {
	
	private static void sink(int[] a, int lo, int hi) {
		// { lc, rc, mc } = { left, right, max }
		int N = a.length;
		int lc = 2*lo;
		if (lc > N) return; // no children
		int rc = lc + 1;
		
		int mc = (rc > N) ? lc : (less(a[rc-1], a[lc-1])) ? lc : rc;
		if (less(a[mc-1], a[lo-1])) return; // heap ordered
		
		swap(a, lo-1, mc-1);
		sink(a, mc, N);
	}
	
	// heap an array between the range
	private static void heap(int[] a, int lo, int hi) {
		int N = hi - lo + 1;
		for (int i = N/2; i > 0; i--) {
			sink(a, i, N);
			// i = 5, sink(a, 5, 10); swap(a, 5, 10); sink(a, 10, 10);
			// i = 4, sink(a, 4, 10); swap(a, 4, 8); sink(a, 8, 10);
			// i = 3, sink(a, 3, 10); swap(a, 3, 6); sink(a, 6, 10);
			// i = 2, sink(a, 2, 10); swap(a, 2, 4); sink(a, 4, 10); swap(a, 4, 8); sink(a, 8, 10);
			// i = 1, sink(a, 1, 10);
		}
	}
	
	private static void sort(int[] a) {
		int N = a.length;
		
		heap(a, 1, N);
		
		for (int i = 0; i < N; i++) {
			swap(a, 0, N-i-1);
			int[] aux = new int[N-i-1];
			for (int j = 0; j < aux.length; j++) {
				aux[j] = a[j];
			}
			sink(aux, 1, N-i-1);
			for (int k = 0; k < aux.length; k++) {
				a[k] = aux[k];
			}
		}
	}
	
	public static void main(String[] args) {
//		int[] array = RandomNumbers.generateRandomNumbers(1, 100, 10);
		int[] array = {74, 48, 45, 40, 36, 13, 19, 86, 37, 61};
		if (isSorted(array)) {
			System.out.println("The array is already sorted!");
		} else {
			sort(array);
			if (isSorted(array)) {
				System.out.println("The array is sorted");
			} else {
				System.out.println("The array is not sorted");
			}
		}
		show(array);
	}
	
}
