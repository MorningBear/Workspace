package com.victor.sort.numbers;

public class InsertionSort extends Sort {

	private static void sort(int[] a) {
		int N = a.length;
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j > 0; j--) {
				if (less(a[j],a[j-1])) {
					swap(a, j-1, j);
				} else {
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = RandomNumbers.generateRandomNumbers(1, 1000, 100);
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
