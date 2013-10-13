package com.victor.sort.numbers;

public class Sort {
	
	protected static void show(int[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			System.out.println("array " + i + ": " + a[i]);
		}
	}
	
	protected static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	protected static boolean less(int v, int w) {
		return v < w;
	}
	
	protected static boolean isSorted(int[] a) {
		int N = a.length;
		for (int i = 0; i < N - 1; i++) {
			if (less(a[i+1], a[i])) return false;
		}
		return true;
	}
	
}
